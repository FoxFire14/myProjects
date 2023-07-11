package org.acadeniadecodigo.flowribellas;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {
    private Rectangle rectangle;
    private Ellipse ellipse;
    private boolean helper = false;
    public Field(){

        drawPicture();
        ellipse = new Ellipse(10,10,200,100);
        ellipse.setColor(Color.BLACK);
        ellipse.fill();
        ellipse.translate(80,80);

        Ellipse eye1 = new Ellipse(10, 10, 10, 10);
        eye1.setColor(Color.BLUE);
        eye1.fill();
        eye1.translate(120,120);

        Ellipse eye2 = new Ellipse(10,10,10,10);
        eye2.setColor(Color.BLUE);
        eye2.fill();
        eye2.translate(160,120);

        Text text = new Text(0,0,"Bom Bigode");
        text.grow(20,20);
        text.translate(30, 30);
        text.draw();



    }

    private Picture picture;
    private void drawPicture(){
       picture = new Picture(10,10,".idea/resources/img.png");
       picture.draw();
    }

}
