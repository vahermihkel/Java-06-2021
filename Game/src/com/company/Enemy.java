package com.company;

public class Enemy extends Character {
    private EnemyType enemyType;
    private double health;

    public Enemy(World world) {
        super(world, 'Z');
    }
}
