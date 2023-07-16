package org.strategyColors;

import org.Tint;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class BlackColorStrategy implements ColorStrategy {

    @Override
    public void changeColor(Tint tint) {

        tint.setColor(Color.BLACK);
    }
}

