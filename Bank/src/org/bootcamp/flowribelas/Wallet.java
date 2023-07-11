package org.bootcamp.flowribelas;

public class Wallet {

    private int balanceWallet;

    public Wallet(int amount){
        this.balanceWallet = amount;
    }

    public void putMoneyInTheWallet(int amount){
        balanceWallet = balanceWallet + amount;
        System.out.println("You have " + balanceWallet + "€ in your wallet");

    }
    public int takeMoneyFromWallet(int amount){
        if (amount > balanceWallet){
            int moneyLeft = balanceWallet;
            balanceWallet = 0;
            return moneyLeft;
        }
        return balanceWallet = balanceWallet - amount;
    }




}
