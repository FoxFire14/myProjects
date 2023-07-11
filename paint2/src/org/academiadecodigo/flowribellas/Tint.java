package org.academiadecodigo.flowribellas;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Tint {
    private Rectangle rectangle;

    private int x;
    private int y;


    public Tint(int x, int y){
        paint(x,y);
        this.x = x;
        this.y = y;

    }



    public void paint(int x, int y){
            rectangle = new Rectangle(x,y, 50,50);
            rectangle.setColor(Color.BLACK);
            rectangle.fill();


    }

    public int getTintX() {
        return x;
    }

    public int getTintY() {
        return y;
    }
    public void erase(){
        rectangle.delete();
    }
}
