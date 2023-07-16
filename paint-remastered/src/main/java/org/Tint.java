package org;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.strategyColors.*;

import java.util.HashMap;
import java.util.Map;

public class Tint {

    private Rectangle rectangle;
    private int x;
    private int y;
    private Color color = Color.BLACK;
    private final int width = Field.RECTANGLE_SIZE - 1;
    private final int height = Field.RECTANGLE_SIZE - 1;



    public Tint(int x, int y) {
        paint(x, y);
        this.x = x;
        this.y = y;

    }


    public void paint(int x, int y) {
        rectangle = new Rectangle(x, y, width, height);
        rectangle.setColor(color);

        rectangle.fill();

    }


    public int getTintX() {
        return x;
    }

    public int getTintY() {
        return y;
    }

    public void erase() {
        rectangle.delete();
    }

    public void setColor(Color color) {
        this.color = color;
        rectangle.setColor(color);
        rectangle.fill();
    }



}


