package com.company.character;

public enum EnemyType {
    RAT, CAT, DOG, LION, DRAGON;

    static EnemyType getRandomEnemyType() {
//        values() ----- [RAT, CAT, DOG, LION, DRAGON]
//        values()[0] RAT   values()[1]   CAT
//        (int)(Math.random() * (values().length-1)) ---- 0 kuni values().length
        return values()[(int)(Math.random() * (values().length-1))];
    }
}
