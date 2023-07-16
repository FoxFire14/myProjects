package org;

public class Main {
    public static void main(String[] args) {
        Cursor cursor = new Cursor();
        Field field = new Field();
        PositionTint positionTint= new PositionTint();
        Game game = new Game(positionTint, cursor, field);
        Instructions instructions = new Instructions();
        instructions.buildInstructions();
        game.init();

    }
}
