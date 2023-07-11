package org.academiadecodigo.flowribellas;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.awt.*;

public class Cursor implements KeyboardHandler {
    private Keyboard keyboard;
    private PositionTint pos = new PositionTint();
    private Tint tint = new Tint(-100, -100);
    Rectangle rectangle;
    private boolean isPainted = false;
    private int x;
    private int y;

    public Cursor() {

        rectangle = new Rectangle(10, 10, 50, 50);
        this.x = rectangle.getX();
        this.y = rectangle.getY();

        rectangle.setColor(Color.GREEN);
        rectangle.fill();
        keyboard = new Keyboard(this);
        keyboardInit();

    }

    public void keyboardInit() {

        // Right key
        KeyboardEvent rightPress = new KeyboardEvent();
        rightPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightPress.setKey(KeyboardEvent.KEY_RIGHT);

        // Left key
        KeyboardEvent leftPress = new KeyboardEvent();
        leftPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftPress.setKey(KeyboardEvent.KEY_LEFT);

        // Up key
        KeyboardEvent upPress = new KeyboardEvent();
        upPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upPress.setKey(KeyboardEvent.KEY_UP);

        // Down Key
        KeyboardEvent downPress = new KeyboardEvent();
        downPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downPress.setKey(KeyboardEvent.KEY_DOWN);

        // Space key
        KeyboardEvent spacePress = new KeyboardEvent();
        spacePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spacePress.setKey(KeyboardEvent.KEY_SPACE);

        // P Write to a file
        KeyboardEvent p = new KeyboardEvent();
        p.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        p.setKey(KeyboardEvent.KEY_P);


        keyboard.addEventListener(p);
        keyboard.addEventListener(rightPress);
        keyboard.addEventListener(leftPress);
        keyboard.addEventListener(upPress);
        keyboard.addEventListener(downPress);
        keyboard.addEventListener(spacePress);


    }

    public void meOnTop() {
        rectangle.delete();
        rectangle.fill();
    }


    public int getMyX() {
        return x;
    }

    public int getMyY() {
        return y;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_RIGHT:
                rectangle.translate(50, 0);
                this.x = getMyX() + 50;
                checkLimits();
                break;

            case KeyboardEvent.KEY_LEFT:
                rectangle.translate(-50, 0);
                this.x = getMyX() - 50;
                checkLimits();
                break;

            case KeyboardEvent.KEY_UP:
                rectangle.translate(0, -50);
                this.y = getMyY() - 50;
                checkLimits();
                break;

            case KeyboardEvent.KEY_DOWN:
                rectangle.translate(0, 50);
                this.y = getMyY() + 50;
                checkLimits();
                break;

            case KeyboardEvent.KEY_SPACE:
                paintAndErase();
                rectangle.delete();
                rectangle.fill();
                break;
            case KeyboardEvent.KEY_P:
                pos.textWriter();
                break;

        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void checkLimits() {
        if (rectangle.getX() < 10) {
            rectangle.translate(50, 0);
            this.x = getMyX() + 50;
        }
        if (rectangle.getY() < 10) {
            rectangle.translate(0, 50);
            this.y = getMyY() + 50;
        }
        if (rectangle.getX() + rectangle.getWidth() > 1010) {
            rectangle.translate(-50, 0);
            this.x = getMyX() - 50;
        }
        if (rectangle.getY() + rectangle.getHeight() > 1010) {
            rectangle.translate(0, -50);
            this.y = getMyY() - 50;
        }
    }


    public void paintAndErase() {
        if (pos.size() > 0) {
            for (int i = 0; i < pos.size(); i++) {
                if (pos.get(i).getTintY() == getMyY()) {
                    if (pos.get(i).getTintX() == getMyX()) {
                       // Rectangle rectangle1 = new Rectangle(getMyX(),getMyY(),50,50);
                        //rectangle1.setColor(Color.BLACK);
                        //rectangle1.draw();
                        pos.eraseRectangle(pos.get(i));
                        return;

                    }
                }
            }

        }
        pos.paintRectangle(getMyX(), getMyY());


    }
}
