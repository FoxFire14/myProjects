package org;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {
    private Rectangle rectangle;
    public static final int PADDLE = 10;
    public static final int width = 1000;
    public static final int height = 1000;
    public static final int RECTANGLE_SIZE = 50;





    public void drawField() {
        int fieldWidth = width + PADDLE;
        int fieldHeight = height + PADDLE;

        // Field size
        Rectangle rectangle = new Rectangle(PADDLE, PADDLE, width, height);
        rectangle.draw();

        // Draw lines
        for (int i = RECTANGLE_SIZE + PADDLE; i < fieldWidth; i += RECTANGLE_SIZE) {
            Line lineX = new Line(i, PADDLE, i, fieldHeight);
            Line lineY = new Line(PADDLE, i, fieldWidth, i);
            lineX.draw();
            lineY.draw();
        }
        border();
    }
  public void border(){

        Rectangle rectangle1 = new Rectangle(PADDLE, height + 11, width + 302,50);
        rectangle1.setColor(Color.WHITE);

        rectangle1.fill();
  }
}
