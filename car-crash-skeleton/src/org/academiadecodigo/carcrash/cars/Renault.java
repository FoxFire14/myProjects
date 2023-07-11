package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

public class Renault  extends Car {

    public Renault(){
        super(CarType.Renault, new Position((int) Math.abs(Math.random() * Field.getHeight()), (int) Math.abs(Math.random() * Field.getWidth())));

        };


    @Override
    public String toString() {
        return "O";
    }

    @Override
    public void callTheAmbulance(Car[] cars) {

    }
}
