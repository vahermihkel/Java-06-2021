package com.company.character;

import com.company.World;

public class Enemy extends Character {
    private EnemyType enemyType;
    private double health;

    public Enemy(World world) {
        super(world, 'Z');
        health = 2.0;
        enemyType = EnemyType.getRandomEnemyType();
    }

    public void takeHealth() {
        this.health--;
    }

    public void resurrect() {
        this.health = 2;
    }

    public EnemyType getEnemyType() {
        return enemyType;
    }

    public double getHealth() {
        return health;
    }
}
