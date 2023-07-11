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
<<<<<<< HEAD:chat_server/src/org/academiadecodigo/webChat/ChatServer.java

=======
>>>>>>> 403cbb99eb68c1689425b5ada442b27c1e00d14f:chat_server/src/org/academiadecodigo/flowribellas/WebServer.java


    public void listen() {


        try {
            serverSocket = new ServerSocket(PORT);
            ExecutorService executorService = Executors.newCachedThreadPool();
<<<<<<< HEAD:chat_server/src/org/academiadecodigo/webChat/ChatServer.java
=======

>>>>>>> 403cbb99eb68c1689425b5ada442b27c1e00d14f:chat_server/src/org/academiadecodigo/flowribellas/WebServer.java

            while (true) {
                Socket clientSocket = serverSocket.accept();

                WorkerSlave workerSlave = new WorkerSlave(clientSocket);

                clientList.add(workerSlave);
<<<<<<< HEAD:chat_server/src/org/academiadecodigo/webChat/ChatServer.java

                //System.out.println(clientList.size());


=======
>>>>>>> 403cbb99eb68c1689425b5ada442b27c1e00d14f:chat_server/src/org/academiadecodigo/flowribellas/WebServer.java
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
<<<<<<< HEAD:chat_server/src/org/academiadecodigo/webChat/ChatServer.java

            try {

                sendMessage("\u001B[36mType your name:\u001B[0m");
                this.name = inputBufferedReader.readLine();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
=======
>>>>>>> 403cbb99eb68c1689425b5ada442b27c1e00d14f:chat_server/src/org/academiadecodigo/flowribellas/WebServer.java

            try {

                sendMessage("Type your name: ");
                this.name = inputBufferedReader.readLine();
               // System.out.println("WTF IS THIS -> " + name);

                while (true) {

                    line = inputBufferedReader.readLine();
                    broadcastMessage( line, this);

                    synchronized (this) {
                        if (line.equals("/exit")) {
<<<<<<< HEAD:chat_server/src/org/academiadecodigo/webChat/ChatServer.java
                            broadcastMessage( "\u001B[31mLeft the chat\u001B[0m", this);
                            sendMessage("\u001B[31mDisconnected\u001B[0m");
                            removeClient(this);
=======
                            broadcastMessage(name + " left the chat", this);
                            sendMessage("Disconnected");
                            //sendMessage("Press Enter 2x to leave");
>>>>>>> 403cbb99eb68c1689425b5ada442b27c1e00d14f:chat_server/src/org/academiadecodigo/flowribellas/WebServer.java
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
<<<<<<< HEAD:chat_server/src/org/academiadecodigo/webChat/ChatServer.java
            handleChatMessages();

=======
            chatStart();
>>>>>>> 403cbb99eb68c1689425b5ada442b27c1e00d14f:chat_server/src/org/academiadecodigo/flowribellas/WebServer.java
        }
    }
}

