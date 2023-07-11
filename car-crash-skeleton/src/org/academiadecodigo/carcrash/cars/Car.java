package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

abstract  public class Car {

    /**
     * The position of the car on the grid
     */

    private Position pos;
    private CarType carType;
    private boolean isCrashed;

    public Car(CarType carType, Position position) {
        this.pos = position;
        this.carType = carType;
        isCrashed = false;

    }



    public void setPos(Position pos) {
        this.pos = pos;
    }

    public CarType getCarType() {
        return carType;
    }

    public Position getPos() {
        return pos;
    }

    public boolean isCrashed() {
        return isCrashed;
    }

    public void setCrashed(boolean crashed) {
        isCrashed = crashed;
    }


    @Override
    public String toString() {
        return "";
    }


    public void moveCars(int nmr) {

        if (pos.getRow() == 0) {
            pos.setRow(1);
            return;
        }
        if (pos.getRow() == Field.getHeight()) {
            pos.setRow(Field.getHeight() - 1);
            return;
        }


            if (pos.getCol() == 0) {
                pos.setCol(1);
                return;
            }
            if (pos.getCol() == Field.getWidth()) {
                pos.setCol(Field.getWidth() - 1);
                return;
            }


            if (nmr == 0) {
                pos.setRow(pos.getRow() + 1);
                return;
            }
            if (nmr == 1) {
                pos.setRow(pos.getRow() - 1);
                return;
            }
            if (nmr == 2) {
                pos.setCol(pos.getCol() + 1);
                return;
            }
            if (nmr == 3) {
                pos.setCol(pos.getCol() - 1);
                return;
            }
        }
        public void collisionCheck(Car[] everyCar, int carIndex){
            for (int i = 1; i < everyCar.length ; i++) {
                if (i == carIndex ){
                    return;
                }

                if(everyCar[i].getPos().equals(this.getPos())){

                    this.setCrashed(true);
                    everyCar[i].setCrashed(true);
                    if ((this.carType == CarType.Ambulance) || (everyCar[i].carType == CarType.Ambulance)){
                    this.setCrashed(false);
                    everyCar[i].setCrashed(false);
                    }
                    return;
                }


            }

        }
    public abstract void callTheAmbulance(Car[] cars);



    }








