package org.academiadecodigo.flowribellas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        boolean exit = false;

        ServerSocket serverSocket = new ServerSocket(8000);
        //server accepts client socket connection and saves his info
        Socket clientSocket = serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        while(exit == false) {


            String clientMessage = bufferedReader.readLine();

            System.out.println("Message from client: " + clientMessage);

            //objects comparison
            if(clientMessage.equals("exit")){
                exit = true;
                bufferedReader.close();
            }
        }

        serverSocket.close();

    }

}
