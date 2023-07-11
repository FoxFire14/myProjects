package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.Game;
import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

public class CarFactory {


    public static Car getNewCar(int carType) {
        if (carType == 0){
            return new Ambulance();
        }
        if (carType %2 == 0){
            return new Renault();
        }
        return new Bobcat();

    }
}
