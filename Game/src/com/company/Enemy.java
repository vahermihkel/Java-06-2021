package com.company;

public class Enemy extends Character {
    private EnemyType enemyType;
    private double health;

    public Enemy(World world) {
        super(world, 'Z');
        health = 2.0;
    }

    public void takeHealth() {
        // TODO: viska error ja püüa Game-s kinni
        this.health--;
//        throw new Exception("Exception");
    }

    public double getHealth() {
        return health;
    }
}
