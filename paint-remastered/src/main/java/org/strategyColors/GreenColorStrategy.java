package org.strategyColors;

import org.Tint;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GreenColorStrategy implements ColorStrategy{
    @Override
    public void changeColor(Tint tint) {
        tint.setColor(Color.GREEN);

    }
}
