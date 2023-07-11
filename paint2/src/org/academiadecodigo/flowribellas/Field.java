package org.academiadecodigo.flowribellas;


import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class Field {
    private Rectangle rectangle;

    public Field(){
        drawField();


    }



    public void drawField(){
        // draw field
        rectangle = new Rectangle(10,10,1000,1000);
        rectangle.draw();
        // draw lines
        int x = 60;
        int limitX = 1010;
        int limitY = 1010;


        while (x < 1000){
            Line lineX = new Line(x,10,x,limitY);
            Line lineY = new Line(10,x,limitX,x);
            x = x + 50;
            lineX.draw();
            lineY.draw();
        }


    }
}
