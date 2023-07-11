package org.academiadecodigo.flowribellas;

public abstract class Barrel extends GameObject implements Destroyable{

    private boolean destroyed;
    private BarrelType barrelType;
    private int currentDamage;
    public Barrel(){
        barrelType = BarrelType.values()[(int) Math.random() * BarrelType.values().length];
        destroyed = false;
        currentDamage = 0;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    @Override
    public void hit(int damage) {
        if (currentDamage == barrelType.getMaxDamage()){
            setDestroyed(true);
            System.out.println("Barrellllssss... DESTROYED");
        }
        currentDamage += damage;
        System.out.println("Barrel damaged");
    }


    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public String getMessage() {
        return "Im a barrel";
    }
}
