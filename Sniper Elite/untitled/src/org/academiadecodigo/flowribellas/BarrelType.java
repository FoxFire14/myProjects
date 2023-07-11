package org.academiadecodigo.flowribellas;

public enum BarrelType {
    PLASTIC (30),
    WOOD(50),
    METAL (80);

    private int maxDamage;
    BarrelType(int maxDamage){
        this.maxDamage = maxDamage;
    }


    public int getMaxDamage() {
        return maxDamage;
    }
}


