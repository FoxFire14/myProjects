package org.bootcamp.flowribelas;

public class PlayGround {
    public static void main(String[] args) {


        Person p1 = new Person("Ivo", new Bank("CGD", 500), new Wallet(0));
        p1.deposit(300,0);
        p1.checkBalance();
        p1.withdraw(100);



















    }
}
