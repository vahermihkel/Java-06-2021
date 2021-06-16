package com.company;

public class Enemy extends Character {
    private EnemyType enemyType;

    public Enemy(int xCoord, int yCoord) {
        super(xCoord, yCoord, 'Z');
    }
}
