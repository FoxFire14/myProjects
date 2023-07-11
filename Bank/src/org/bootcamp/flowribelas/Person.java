package org.bootcamp.flowribelas;

public class Person {
    private String name;

    private String profession;
    private Bank debitCard;
    private Wallet myWallet;


    public Person(String name, Bank bankName, Wallet amount){
        this.name = name;
        this.debitCard = bankName;
        this.myWallet = amount;
        this.profession = "";

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }



    public void deposit(int amount, int walletAmount){
        debitCard.deposit(amount);
        debitCard.deposit(myWallet.takeMoneyFromWallet(walletAmount));
    }

    public void withdraw(int amount){
       debitCard.withdraw(amount);
       myWallet.putMoneyInTheWallet(amount);

    }

    public void checkBalance(){
        debitCard.checkBalance();
    }






    }





