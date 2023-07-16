package org;

public class Game {
    private PositionTint positionTint;
    private Cursor cursor;
    private Field field;

    public Game (PositionTint positionTint, Cursor cursor, Field field){
        this.cursor = cursor;
        this.positionTint = positionTint;
        this.field = field;

    }

    public void init(){
        field.drawField();
        cursor.setupCursor();
    }
}
