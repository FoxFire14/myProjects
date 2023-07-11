package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

public class Bobcat extends Car {
    public Bobcat(){
        super(CarType.Bobcat, new Position((int) Math.abs(Math.random() * Field.getHeight()), (int) Math.abs(Math.random() * Field.getWidth())));
    }


    @Override
    public String toString() {
        return "Z";
    }

    @Override
    public void callTheAmbulance(Car[] cars) {

    }
}
