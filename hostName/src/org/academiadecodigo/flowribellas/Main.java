package org.academiadecodigo.flowribellas;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Gimme a host: ");
        String host = scanner.nextLine();

        try {
            boolean isReachable = InetAddress.getByName(host).isReachable(1000);

            /*String[] array = String.valueOf(InetAddress.getByName(host)).split("/");
            System.out.println(array[1]);*/

            System.out.println(InetAddress.getByName(host).getHostAddress());
            System.out.println(isReachable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}