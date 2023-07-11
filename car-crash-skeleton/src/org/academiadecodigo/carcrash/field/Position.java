package org.academiadecodigo.carcrash.field;

import java.util.Objects;

public class Position {
    private int row;
    private int col;



    public Position(int width, int height){
        this.row = width;
        this.col = height;
    }

    public int getCol() {
        return col;
    }



    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && col == position.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }


}

