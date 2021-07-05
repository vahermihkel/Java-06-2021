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
        enemyType = EnemyType.getRandomEnemyType();
        this.healthbyCharacterType();
    }

    private void healthbyCharacterType() {
        switch (enemyType) {
            case RAT:
                health = (int) (Math.random() * ( 2 ) + 1 );
                break;
            case CAT:
                health = (int) (Math.random() * ( 3 ) + 1 );
                break;
            case DOG:
                health = (int) (Math.random() * ( 4 ) + 1 );
                break;
            case LION:
                health = (int) (Math.random() * ( 5 ) + 1 );
                break;
            case ORC:
                health = (int) (Math.random() * ( 6 ) + 1 );
                break;
            case WIZARD:
                health = (int) (Math.random() * ( 7 ) + 1 );
                break;
            case DRAGON:
                health = (int) (Math.random() * ( 8 ) + 1 );
                break;
        }
    }

    public EnemyType getEnemyType() {
        return enemyType;
    }

    public double getHealth() {
        return health;
    }
}
