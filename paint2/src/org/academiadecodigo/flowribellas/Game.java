package org.academiadecodigo.flowribellas;

import java.util.PriorityQueue;

public class Game {

    private PositionTint positionTint;
    private Cursor cursor;
    private Field field;

    public Game (){
        positionTint = new PositionTint();
        cursor = new Cursor();
        field = new Field();

    }

}
