package org.academiadecodigo.bootcamp;

public class Game {


    private int mynumber;


    public static void letTheGamesBegin(Game player1, Game player2) {
        int host = randomNumber();
        System.out.println("THE GUESS NUMBER IS: " + host);
        while ((host) != (player1.mynumber) || (host) != (player2.mynumber)) {
            player1.mynumber = randomNumber();
            player2.mynumber = randomNumber();
            System.out.println("");
            if (host == player1.mynumber) {
                System.out.println("Player 1 SAYS: " + player1.mynumber + '\n' + "AND THE WINNER IS PLAYER 1 🏆");
                break;
            } else if (host == player2.mynumber) {
                System.out.println("Player 1 SAYS: " + player1.mynumber + '\n' + "Player 2 SAYS: " + player2.mynumber+ '\n' + "AND THE WINNER IS PLAYER 2 🏆");
                break;
            }
            System.out.println("PLAYER 1 SAYS: " + player1.mynumber);
            System.out.println("PLAYER 2 SAYS: " + player2.mynumber);
        }
    }


    public static int randomNumber() {
        return (int) Math.round(Math.random() * 20);
    }


    public void setMynumber(int mynumber) {
        this.mynumber = mynumber;
    }

    public int getMynumber() {
        return this.mynumber;
    }

}



