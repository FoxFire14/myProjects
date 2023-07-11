package org.academiadecodigo.flowribellas;

public class SoldierEnemy extends Enemy{

    @Override
    public void hit(int damage) {
        super.hit(damage);
    }

    @Override
    public String getMessage() {
        return "I'm a soldier.";
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean isDestroyed() {
        return isDead();
    }
}
