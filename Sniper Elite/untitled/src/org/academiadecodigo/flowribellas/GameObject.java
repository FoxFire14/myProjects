package org.academiadecodigo.flowribellas;

public abstract class  GameObject {
    public abstract String getMessage();

    public static GameObject getNewObject(){
        double random = Math.random();
        GameObject object;

        if (random < 0.2){
            return object = new Tree();
        }

        if (random > 0.2 && random < 0.4){
         return object = new Barrel() {};
        }
        return object = Enemy.getNewEnemy();

    }
}


