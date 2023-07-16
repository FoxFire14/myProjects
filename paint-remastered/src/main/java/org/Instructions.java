package org;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.ArrayList;
import java.util.List;

public class Instructions {

    private Color color = Color.WHITE;
    private int width = 300;
    private int height = Field.height;
    private int initPositionX = Field.width + Field.PADDLE + 10;


    public void buildInstructions() {
        Rectangle rectangle = new Rectangle(initPositionX, Field.PADDLE, width, height);
        rectangle.draw();

        Text intro = new Text(initPositionX + 20, Field.PADDLE, "Instructions");
        intro.grow(100, 30);
        intro.translate(initPositionX - (intro.getX() - Field.PADDLE), Field.PADDLE - intro.getY());
        intro.draw();

        Line line = new Line(initPositionX + 10, 67, initPositionX + 210, 67);
        line.draw();

        List<String> list = new ArrayList<>();

        list.add("Move ------ ArrowKeys");
        list.add("Paint ----- SpaceBar");
        list.add("Save ------ Press P");
        list.add("Load ------ Press L");
        list.add("Clear ----- Press C");
        list.add("Exit ------ Press ESC");

        int initY = 150;
        int y = initY;
        int lastY = y;
        int x = initPositionX + 10;


        for (String w : list) {

            Text text = new Text(x, y, w);

            text.draw();
            text.grow(80, 10);
            text.translate(x - text.getX(), y - text.getY());
            if (y == initY) {
                lastY = 60;
            }
            y += lastY;
            System.out.println(y);
            System.out.println("x" + x);

        }
        colorInstructions();


    }

    public void colorInstructions(){
        int y = 550;
        int x = 1030;
        List<String> list = new ArrayList<>();

        list.add("To change the color of");
        list.add("the block, press space");
        list.add("to paint and then: ");

        for(String w : list){
            Text text = new Text(x, y, w);
            text.grow(91, 10);
            text.translate(x - text.getX(), y - text.getY());
            text.draw();
            y += 30;
        }

        List<String> listOfColors = new ArrayList<>();
        listOfColors.add("Q");
        listOfColors.add("W");
        listOfColors.add("E");
        listOfColors.add("R");
        listOfColors.add("T");
        y +=50;
        int savedY = y;

        for(String w : listOfColors){
            Text text = new Text(x, y, w);
            text.grow(10, 10);
            text.translate(x - text.getX(), y - text.getY());
            text.draw();
            y += 60;
        }


        List<Color> listColors = new ArrayList<>();
        listColors.add(Color.BLACK);
        listColors.add(Color.BLUE);
        listColors.add(Color.GREEN);
        listColors.add(Color.RED);
        listColors.add(Color.MAGENTA);

        for (Color color : listColors){
            Rectangle rectangle = new Rectangle(x + 50, savedY +8, 20,20);
            rectangle.setColor(color);
            rectangle.fill();
            savedY+= 60;
        }









    }

}
