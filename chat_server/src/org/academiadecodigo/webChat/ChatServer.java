package org.academiadecodigo.webChat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

    private final int PORT = 8014;
    private ServerSocket serverSocket = null;
    private List<WorkerSlave> clientList = new CopyOnWriteArrayList<>();



    public void listen() {


        try {
            serverSocket = new ServerSocket(PORT);
            ExecutorService executorService = Executors.newCachedThreadPool();


            while (true) {
                Socket clientSocket = serverSocket.accept();

                WorkerSlave workerSlave = new WorkerSlave(clientSocket);

                clientList.add(workerSlave);


                //System.out.println(clientList.size());


                executorService.submit(workerSlave);

                //System.out.println(clientList.size());

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void broadcastMessage(String message, WorkerSlave sender) {
        for (WorkerSlave worker : clientList) {
            if (worker != sender) {
                worker.sendMessage("\u001B[32m" + sender.name + ":\u001B[0m " + message);
            }
        }

    }

    public void removeClient(WorkerSlave workerSlave) {
        clientList.remove(workerSlave);
    }

    // ************************************************************* MAIN **********************************************************************
    public static void main(String[] args) {
        ChatServer webServer = new ChatServer();
        webServer.listen();
    }

    //*********************************************************** MINIMUM WAGE WORKER CLASS *******************************************************************
    public class WorkerSlave implements Runnable{

        private Socket clientSocket;
        private BufferedReader inputBufferedReader;
        private PrintWriter writeMessage;
        private String name;


        public WorkerSlave(Socket clientSocket) {
            this.clientSocket = clientSocket;

        }

        public void sendMessage(String message) {
            writeMessage.println(message);
        }


        public void setupBuffer() {
            try {

                inputBufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                writeMessage = new PrintWriter(clientSocket.getOutputStream(), true);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


        public void handleChatMessages() {
            String line;
            setupBuffer();


            try {

                sendMessage("\u001B[36mType your name:\u001B[0m");
                this.name = inputBufferedReader.readLine();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {

                sendMessage("Type your name: ");
                this.name = inputBufferedReader.readLine();
               // System.out.println("WTF IS THIS -> " + name);

                while (true) {

                    line = inputBufferedReader.readLine();
                    broadcastMessage( line, this);

                    synchronized (this) {
                        if (line.equals("/exit")) {

                            broadcastMessage( "\u001B[31mLeft the chat\u001B[0m", this);
                            sendMessage("\u001B[31mDisconnected\u001B[0m");

                            broadcastMessage(name + " left the chat", this);
                            sendMessage("Disconnected");
                            //sendMessage("Press Enter 2x to leave");
                            break;
                        }
                    }


                }

                clientSocket.close();
                inputBufferedReader.close();
                writeMessage.close();
                // System.out.println(clientList.size());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        @Override
        public void run() {
            handleChatMessages();

        }
    }
}

