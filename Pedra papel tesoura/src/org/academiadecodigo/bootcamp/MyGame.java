package org.academiadecodigo.bootcamp;

public class MyGame {

    public static int rules(Hand player1, Hand player2){
        switch(player1){
            case Rock:
                if(player1 == player2){
                    System.out.println(player1 + " ---- " + player2 + "  DRAW");
                    return 0;
                }
                if (player2 == Hand.Paper){
                System.out.println(player1 + " ---- " + player2 + "  PLAYER 2 WINS");
                return 2;
                }
                else {
                System.out.println(player1 + " ---- " + player2 + "  PLAYER 1 WINS");
                return 1;
            }
            case Paper:
                if(player1 == player2){
                System.out.println(player1 + " ---- " + player2 + "  DRAW");
                return 0;
                }
                if (player2 == Hand.Scissor){
                System.out.println(player1 + " ---- " + player2 + "  PLAYER 2 WINS");
                return 2;
                }
                else {
                    System.out.println(player1 + " ---- " + player2 + "  PLAYER 1 WINS");
                    return 1;
                }
            case Scissor:
                if(player1 == player2){
                System.out.println(player1 + " ---- " + player2 + "  DRAW");
                return 0;
                }
                if (player2 == Hand.Paper) {
                    System.out.println(player1 + " ---- " + player2 + "  PLAYER 2 WINS");
                    return 2;
                }
                else {
                    System.out.println(player1 + " ---- " + player2 + "  PLAYER 1 WINS");
                    return 1;
                }
            default: return -1;

        }

    }

    public static void letTheGamesBegin(Players player1, Players player2){
        int result;


        while (player1.getNumbWins() != 2 && player2.getNumbWins() != 2){
            player1.playersMove();
            player2.playersMove();
            result = MyGame.rules(player1.getMove(), player2.getMove());
            if (result == 1){
                player1.win();
            } else if (result == 2) {
                player2.win();
            }
            System.out.println(((player1.getNumbWins() != 2) || (player2.getNumbWins() != 2)) + " " + player1.getNumbWins() + " " + player2.getNumbWins() );
        }
        player1.winsReset();
        player2.winsReset();
        }
    }


