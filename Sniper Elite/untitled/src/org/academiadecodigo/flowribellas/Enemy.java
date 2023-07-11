package org.academiadecodigo.flowribellas;

public abstract class Enemy extends GameObject implements Destroyable {
    private int healthBar;
    private boolean isDead;
    private boolean isDestroyed;

    public Enemy(){
        healthBar = 100;
        isDead = false;
        isDestroyed = false;
    }

    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    public int getHealthBar() {
        return healthBar;
    }

    public void setHealthBar(int healthBar) {
        this.healthBar = healthBar;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public static Enemy getNewEnemy(){
        double random = Math.random();
        Enemy enemy;
        if (random < 0.5){
            return enemy = new ArmouredEnemy();
        }
        return enemy = new SoldierEnemy();
    }

    public void hit (int damage){
        while (!isDead){
            healthBar = healthBar - damage;
            if (healthBar <= 0){
                healthBar = 0;
                System.out.println("Enemy dead");
                setDead(true);
                setDestroyed(true);
                return;
            }
            System.out.println("Your enemy has " + healthBar + " health");
            return;

        }


    }

}
