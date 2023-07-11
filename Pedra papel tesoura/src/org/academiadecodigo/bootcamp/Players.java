package org.academiadecodigo.bootcamp;

public class Players {
    private String name;
    private Hand move;
    private int numbWins;


    public Players(String name) {
        this.name = name;
        this.numbWins = 0;
    }

    public String getName() {
        return name;
    }

    public Hand getMove() {
        return move;
    }

    public int getNumbWins() {
        return numbWins;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMove(Hand move) {
        this.move = move;
    }

    public void setNumbWins(int numbWins) {
        this.numbWins = numbWins;
    }

    public void playersMove() {
        Hand[] hands = Hand.values();
        this.move = hands[(int) Math.round(Math.random() * 2)];
    }

    public void win(){
        this.numbWins ++;
    }

    public void winsReset(){
        this.numbWins = 0;
    }

}
