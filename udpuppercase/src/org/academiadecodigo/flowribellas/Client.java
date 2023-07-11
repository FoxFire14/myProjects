package org.academiadecodigo.flowribellas;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws UnknownHostException {

        StringBuilder myMessage = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.println("tell me the portNumber you want to connect: ");
        int portNumber = scanner.nextInt();
        scanner.skip("\n");
        // System.out.println("portNumber: " + portNumber);
        System.out.println("Write the message: ");

        myMessage.append(scanner.nextLine());

       // System.out.println(myMessage + " did this work?");

        try {

            InetAddress host = InetAddress.getByName("localhost");

            byte[] senderBuffer;
            byte[] receiverBuffer = new byte[1024];

            DatagramSocket socket = new DatagramSocket(8050);


            senderBuffer = myMessage.toString().getBytes();
            DatagramPacket sendPacket = new DatagramPacket(senderBuffer, senderBuffer.length, host, portNumber);
            socket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiverBuffer, receiverBuffer.length);
            socket.receive(receivePacket);
            String uppercasedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            //String uppercasedMessage = new String(receivePacket.getData(), StandardCharsets.UTF_8);

            System.out.println(uppercasedMessage + " ------ my message uppercased");

            socket.close();


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
