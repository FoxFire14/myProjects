package org.academiadecodigo.flowribellas;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Server {

    public static void main(String[] args) throws SocketException {

        try {

            //Server has a socket on the 8000 port
            //As we are working on the same machine, our client has to be created with a different port
            //Because our server sends data to the client, and if they have the same port he sends the message to himself
            DatagramSocket socket = new DatagramSocket(8000);
            InetAddress host = InetAddress.getByName("localhost");

            byte[] receiverBuffer = new byte[1024];
            byte[] senderBuffer;

            DatagramPacket receiverPacket = new DatagramPacket(receiverBuffer, receiverBuffer.length);
            socket.receive(receiverPacket);
            String clientMessage = new String(receiverPacket.getData(), 0, receiverPacket.getLength());
            //String clientMessage = new String(receiverPacket.getData(), StandardCharsets.UTF_8);

            System.out.println(receiverPacket.getLength());
            System.out.println(clientMessage.toUpperCase());

            senderBuffer = clientMessage.toUpperCase().getBytes(StandardCharsets.UTF_8);
            DatagramPacket senderPacket = new DatagramPacket(senderBuffer, senderBuffer.length, host, 8050);
            socket.send(senderPacket);


            socket.close();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
