package org.academiadecodigo.flowribellas;

public class Game {
    private GameObject [] gameObjects;
    private SniperRifle sniperRifle;
    private int shotsFired;
    private int numberObjects;


    Game(int objNumber){
        this.numberObjects = objNumber;
    }


    public GameObject[] getGameObjects(){
        gameObjects = new GameObject[this.numberObjects];
        for (int i = 0; i < gameObjects.length ; i++) {
            gameObjects[i] = GameObject.getNewObject();



        }
        return gameObjects;
    }
    public void start(){
        getGameObjects();
        sniperRifle = new SniperRifle();

        for (int i = 0; i < gameObjects.length ; i++) {
            if (gameObjects[i] instanceof Tree){
                System.out.println(gameObjects[i].getMessage());
                continue;
            }
            System.out.println(gameObjects[i].getMessage());
            sniperRifle.shoot((Destroyable) gameObjects[i]);


        }



    }




}
