package org.academiadecodigo.flowribellas;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class PositionTint{
    private Tint tint;
    private LinkedList<Tint> tintLinkedList;


    public PositionTint(){
        tintLinkedList = new LinkedList<>();
    }



    public void paintRectangle(int x, int y) {
        tint = new Tint(x, y);
        tintLinkedList.add(tint);
    }

    public void eraseRectangle(Tint tint) {
        tint.erase();
        tintLinkedList.remove(tint);
    }

    public int size(){
         return tintLinkedList.size();
    }

    public Tint get(int i){
        return tintLinkedList.get(i);
    }

    public void textWriter(){
        String string = "";


        for (Tint t : tintLinkedList){
            string += t.getTintX() + ":" + t.getTintY() + " ";


        }
        try {

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resources/pain.txt"));
            bufferedWriter.write(string);
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
