package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

public class Ambulance extends Car {
    public Ambulance() {
        super(CarType.Ambulance, new Position((int) Math.abs(Math.random() * Field.getHeight()), (int) Math.abs(Math.random() * Field.getWidth())));
    }

    @Override
    public String toString() {
        return "Amb";
    }

    @Override
    public void callTheAmbulance(Car[] cars) {

        for (int j = 1; j < cars.length; j++) {
            if (cars[j].getPos().equals(this.getPos()))
                cars[j].setCrashed(false);
        }


    }
}
