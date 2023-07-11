package org.academiadecodigo.flowribellas;

public class ArmouredEnemy extends Enemy{
    private int armor;


    public ArmouredEnemy(){
        armor = 90;
    }


    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public void hit(int damage) {

        while (armor > 0){
            System.out.println("I have " + armor + " armor");
            armor -= damage;
            return;
            }

            super.hit(damage);
        }

    @Override
    public String getMessage() {
        return "I'm a soldier with armor.";
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
