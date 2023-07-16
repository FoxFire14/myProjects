package org;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.strategyColors.*;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class PositionTint implements KeyboardHandler {
    private Tint tint;
    private Keyboard keyboard;
    private LinkedList<Tint> tintLinkedList = new LinkedList<>();
    private Map<Integer, ColorStrategy> colorStrategyMap;


    public PositionTint(){
        keyboard = new Keyboard(this);
        keyboardInit();
    }
    public void paintRectangle(int x, int y) {

        tint = new Tint(x, y);
        tintLinkedList.add(tint);
    }

    public void eraseRectangle(Tint tint) {
        tint.erase();
        tintLinkedList.remove(tint);
    }

    public Boolean isEmpty() {
        return tintLinkedList.isEmpty();
    }

    public int size() {
        return tintLinkedList.size();
    }

    public Tint get(int i) {
        return tintLinkedList.get(i);
    }

    public void savePositions() {
        StringBuilder string = new StringBuilder();


        for (Tint t : tintLinkedList) {
            string.append(t.getTintX()).append(":").append(t.getTintY()).append(" ");
        }
        try {

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("painted-tiles.txt"));
            bufferedWriter.write(string.toString());
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void loadPositions() {
        clearBoard();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("painted-tiles.txt"))) {
            String positions = bufferedReader.readLine();
            String[] arrayPositions = positions.split(" ");

            for (String arrayPosition : arrayPositions) {
                String[] arrayXY = arrayPosition.split(":");
                int x = Integer.parseInt(arrayXY[0]);
                int y = Integer.parseInt(arrayXY[1]);
                Tint tint = new Tint(x, y);
                tintLinkedList.add(tint);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void clearBoard() {
        if (!tintLinkedList.isEmpty()) {
            Iterator<Tint> iterator = tintLinkedList.iterator();
            while (iterator.hasNext()) {
                Tint t = iterator.next();
                t.erase();
                iterator.remove();
            }
        }

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        try {
            colorStrategyMap.get(keyboardEvent.getKey()).changeColor(tint);
    } catch (NullPointerException e){
            System.out.println("Simple-graphics Keyboard threads problems \nNothing to worry about");
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    private void keyboardInit() {
        colorStrategyMap = new HashMap<>();

        // Register strategies for each keyboard key
        colorStrategyMap.put(KeyboardEvent.KEY_Q, new BlackColorStrategy());
        colorStrategyMap.put(KeyboardEvent.KEY_W, new BlueColorStrategy());
        colorStrategyMap.put(KeyboardEvent.KEY_E, new GreenColorStrategy());
        colorStrategyMap.put(KeyboardEvent.KEY_R, new RedColorStrategy());
        colorStrategyMap.put(KeyboardEvent.KEY_T, new PinkColorStrategy());
        // Register other strategies for additional keys

        // Register the event listeners
        for (Integer key : colorStrategyMap.keySet()) {
            KeyboardEvent event = new KeyboardEvent();
            event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            event.setKey(key);
            keyboard.addEventListener(event);
        }
    }
}

