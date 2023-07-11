package org.academiadecodigo.org;

import org.academiadecodigo.org.Exceptions.FileException;
import org.academiadecodigo.org.Exceptions.NotEnoughPermissionsExceptions;

public class Main {
    public static void main(String[] args) {


        FileManager fileManager = new FileManager();

        try {
            fileManager.login();
        } catch (NotEnoughPermissionsExceptions ex){
            System.out.println(ex.getMessage());
        } catch (FileException e) {
        }

        System.out.println("----------------------");

        try {
            fileManager.login();
        } catch (NotEnoughPermissionsExceptions ex){
            System.out.println(ex.getMessage());
        } catch (FileException e) {
        }








    }
}
