package org.academiadecodigo.flowribellas;

public class SniperRifle {
    private int bulletDamage;
    private int bulletsUsed;

    public SniperRifle(){
        bulletDamage = 30;
        bulletsUsed = 0;
    }

    public int getBulletsUsed() {
        return bulletsUsed;
    }


    public void shoot (Destroyable enemy) {
        double random;
        int dmg;

        while (!enemy.isDestroyed()) {
            random = Math.random();
            dmg = bulletDamage;

            if (random < 0.2) {
                dmg += 30;
                enemy.hit(dmg);
                bulletsUsed ++;
                continue;
            }
            if (random > 0.2 && random < 0.7) {
                enemy.hit(dmg);
                bulletsUsed ++;
                continue;
                }

            if (random > 0.8) {
                dmg = 0;
                enemy.hit(dmg);
                bulletsUsed ++;

            }

        }

    }

}
