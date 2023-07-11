package org.academiadecodigo.carcrash;

import org.academiadecodigo.carcrash.cars.Ambulance;
import org.academiadecodigo.carcrash.cars.Car;
import org.academiadecodigo.carcrash.cars.CarFactory;
import org.academiadecodigo.carcrash.cars.CarType;
import org.academiadecodigo.carcrash.field.Field;

public class Game {

    public static final int MANUFACTURED_CARS = 20;

    /** Container of Cars */
    private Car[] cars;


    /** Animation delay */
    private int delay;
    private int originalDelay;

    public Game(int cols, int rows, int delay) {

        Field.init(cols, rows);
        this.delay = delay;
        originalDelay = delay;

    }

    public int getDelay() {
        return delay;
    }

    private void setDelay(int delay) {
        this.delay = delay;
    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        cars = new Car[MANUFACTURED_CARS];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = CarFactory.getNewCar(i);
        }

        Field.draw(cars);

    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            // Move all cars
            moveAllCars();

            // Update screen
            Field.draw(cars);

        }

    }

    private void moveAllCars() {
        int randomNbr;
        for (int i = 0; i < cars.length; i++) {
            if (!cars[i].isCrashed()) {
                randomNbr = (int) Math.round(Math.random() * 3);



                cars[i].moveCars(randomNbr);
            }

                if (cars[i].getCarType() == CarType.Ambulance){
                    cars[i].callTheAmbulance(cars);

                } else {
                cars[i].collisionCheck(cars, i);
                }



        }

    }

}
