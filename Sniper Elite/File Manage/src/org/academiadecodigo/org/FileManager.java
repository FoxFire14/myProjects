package org.academiadecodigo.org;

import org.academiadecodigo.org.Exceptions.FileException;
import org.academiadecodigo.org.Exceptions.FileNotFoundException;
import org.academiadecodigo.org.Exceptions.NotEnoughPermissionsExceptions;
import org.academiadecodigo.org.Exceptions.NotEnoughSpaceException;

public class FileManager {
    private boolean isLogged;
    private File[] file = new File[14];

    FileManager() {
        isLogged = false;
    }

    public void login() throws FileException{
        System.out.println("Trying to login");
        if (isLogged == false){
        isLogged = true;
        System.out.println("Login Successful");
        return;
        }

        throw new NotEnoughPermissionsExceptions("You are logged already");
    }

    public void logout() throws FileException {
        System.out.println("Trying to logout");
        if (isLogged == true){
        isLogged = false;
        System.out.println("Logout Successful");
        return;
        }
        throw new NotEnoughPermissionsExceptions("You need to login first");
    }

    public void createFile(String fileName) throws FileException {
        if (isLogged == true) {
            for (int i = 0; i < file.length; i++) {
                if (file[i].equals(null)) {
                    file[i] = new File(fileName);
                }
                else {
                    throw new NotEnoughSpaceException("This library is full.");
                }
            }
        }
        if (isLogged == false){
            throw new NotEnoughPermissionsExceptions("You need to login to create files");
        }

    }

    public File getFile(String fileName) throws FileException {
        if (isLogged == false) {
            throw new NotEnoughPermissionsExceptions("You need to login to get files");
        }
        File myFile = null;
        if (isLogged == true) {

            myFile = null;
            for (int i = 0; i < file.length; i++) {
                if (file[i].getName().equals(fileName)) {
                    myFile = file[i];
                    return myFile;
                } else {
                    throw new FileNotFoundException("File not found");
                }
            }

        }
        return myFile;
    }
}
