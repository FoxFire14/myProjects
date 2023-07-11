package org.academiadecodigo.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    private Socket socket;
    private PrintWriter printWriter;
    private boolean isTerminating = false;

    public Client() {
        try {
            String host = InetAddress.getLocalHost().getHostAddress();
            socket = new Socket(host, 8000);
           // System.out.println("Connected to the server: " + host);

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initWriter() {
        try {
            printWriter = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void start() {
        initWriter();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new ServerReader());
        executorService.execute(new ConsoleReader());
        executorService.shutdown();
    }

    private class ServerReader implements Runnable {
        private BufferedReader serverReader;

        @Override
        public void run() {
            try {
                serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line;
                while (!isTerminating && (line = serverReader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                if (!isTerminating) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private class ConsoleReader implements Runnable {
        private BufferedReader consoleReader;

        @Override
        public void run() {
            try {
                consoleReader = new BufferedReader(new InputStreamReader(System.in));
                String line;
                while (!isTerminating && (line = consoleReader.readLine()) != null) {
                    printWriter.println(line);
                    if (line.equals("/exit")) {
                        isTerminating = true;
                        close();
                        break;
                    }
                }
            } catch (IOException e) {
                if (!isTerminating) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void close() {
        try {

            printWriter.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
}
