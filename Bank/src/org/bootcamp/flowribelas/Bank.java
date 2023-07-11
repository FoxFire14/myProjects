package org.bootcamp.flowribelas;

public class Bank {
    private int balance = 0;
    private String name;


    public Bank(String name, int firstDeposit){
        this.name = name;
        this.balance = firstDeposit;
    }
    public int getBalance() {return balance;}

    public void setBalance(int balance) {this.balance = balance;}



    public void deposit(int amount){
        balance =+ amount ;
    }

    public void withdraw(int amount){
        if( amount > balance ){
            System.out.println("Insufficient balance");
        }
        balance =- amount;

    }


    public void checkBalance(){
        System.out.println("Your current balance is: " + balance + "€");
    }





}
