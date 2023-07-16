package org;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Cursor implements KeyboardHandler {
    private Keyboard keyboard;
    private PositionTint pos = new PositionTint();

    Rectangle rectangle;
    private int rectangleSize = Field.RECTANGLE_SIZE;
    private Color color = Color.GRAY;
    private int x;
    private int y;

    public Cursor() {
        keyboard = new Keyboard(this);
        keyboardInit();

    }

    public void setupCursor() {
        rectangle = new Rectangle(Field.PADDLE +1, Field.PADDLE+1, Field.RECTANGLE_SIZE -1, Field.RECTANGLE_SIZE-1);
        this.x = rectangle.getX();
        this.y = rectangle.getY();

        rectangle.setColor(color);
        rectangle.fill();
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

        // L Load board
        KeyboardEvent l = new KeyboardEvent();
        l.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        l.setKey(KeyboardEvent.KEY_L);

        // C Clear the fild
        KeyboardEvent c = new KeyboardEvent();
        c.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        c.setKey(KeyboardEvent.KEY_C);

        // ESC exit
        KeyboardEvent esc = new KeyboardEvent();
        esc.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        esc.setKey(KeyboardEvent.KEY_ESC);

        keyboard.addEventListener(p);
        keyboard.addEventListener(rightPress);
        keyboard.addEventListener(leftPress);
        keyboard.addEventListener(upPress);
        keyboard.addEventListener(downPress);
        keyboard.addEventListener(spacePress);
        keyboard.addEventListener(l);
        keyboard.addEventListener(c);
        keyboard.addEventListener(esc);


    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_RIGHT:
                rectangle.translate(rectangleSize, 0);
                this.x = getMyX() + rectangleSize;
                checkLimits();
                meOnTop();
                break;

            case KeyboardEvent.KEY_LEFT:
                rectangle.translate(-rectangleSize, 0);
                this.x = getMyX() - rectangleSize;
                checkLimits();
                meOnTop();
                break;

            case KeyboardEvent.KEY_UP:
                rectangle.translate(0, -rectangleSize);
                this.y = getMyY() - rectangleSize;
                checkLimits();
                meOnTop();
                break;

            case KeyboardEvent.KEY_DOWN:
                rectangle.translate(0, rectangleSize);
                this.y = getMyY() + rectangleSize;
                checkLimits();
                meOnTop();
                break;

            case KeyboardEvent.KEY_SPACE:
                paintAndErase();
                meOnTop();
                break;

            case KeyboardEvent.KEY_P:
                pos.savePositions();
                break;

            case KeyboardEvent.KEY_L:
                pos.loadPositions();
                meOnTop();
                break;

            case KeyboardEvent.KEY_C:
                pos.clearBoard();
                break;

            case KeyboardEvent.KEY_ESC:
                System.exit(1);

        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void checkLimits() {
        if (rectangle.getX() < Field.PADDLE) {
            rectangle.translate(rectangleSize, 0);
            this.x = getMyX() + rectangleSize;
        }
        if (rectangle.getY() < Field.PADDLE) {
            rectangle.translate(0, rectangleSize);
            this.y = getMyY() + rectangleSize;
        }
        if (rectangle.getX() + rectangle.getWidth() > Field.width + Field.PADDLE) {
            rectangle.translate(-rectangleSize, 0);
            this.x = getMyX() - rectangleSize;
        }
        if (rectangle.getY() + rectangle.getHeight() > Field.height + Field.PADDLE) {
            rectangle.translate(0, -rectangleSize);
            this.y = getMyY() - rectangleSize;
        }
    }


    public void paintAndErase() {
        int myX = getMyX();
        int myY = getMyY();

        if (!pos.isEmpty()) {
            for (int i = 0; i < pos.size(); i++) {
                Tint tint = pos.get(i);
                if (tint.getTintY() == myY && tint.getTintX() == myX) {
                    pos.eraseRectangle(tint);
                    return;
                }
            }
        }

        pos.paintRectangle(myX, myY);
    }

    public void meOnTop() {
        int myX = getMyX();
        int myY = getMyY();

        if (!pos.isEmpty()) {
            for (int i = 0; i < pos.size(); i++) {
                Tint tint = pos.get(i);
                if (tint.getTintY() == myY && tint.getTintX() == myX) {
                    rectangle.setColor(Color.DARK_GRAY); // Change the color of the cursor
                    rectangle.delete();
                    rectangle.fill();
                    return;
                }
            }
        }

        rectangle.setColor(color); // Set the default color of the cursor

        rectangle.delete();
        rectangle.fill();
    }
    public int getMyX() {
        return x;
    }

    public int getMyY() {
        return y;
    }
}
