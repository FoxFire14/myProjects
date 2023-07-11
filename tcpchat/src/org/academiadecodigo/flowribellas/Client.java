package org.academiadecodigo.flowribellas;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws UnknownHostException {

        String clientMessage;
        boolean exit = false;

        try {

            String host = InetAddress.getLocalHost().getHostName();
            Socket clientSocket = new Socket(host, 8000);

            PrintWriter outPut = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            while(exit == false) {

                System.out.println(" Write your message: ");
                clientMessage = bufferedReader.readLine();
                outPut.println(clientMessage);

                if(clientMessage.equals("exit")){
                    exit = true;
                    bufferedReader.close();
                }
            }

            clientSocket.close();
            outPut.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
