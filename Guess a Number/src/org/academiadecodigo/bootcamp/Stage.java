package org.academiadecodigo.bootcamp;

public class Stage {
    public static void main(String[] args){
        Game player1 = new Game();
        Game player2 = new Game();

        player1.setMynumber(Game.randomNumber());
        player2.setMynumber(Game.randomNumber());

        Game.letTheGamesBegin(player2, player1);
    }

}
