package com.company.item;

import com.company.World;

public class Dagger extends Item implements FightWeapon {
    private static double strength = 2.0;

    public Dagger(World world) {
        super(strength, 3, world);
    }

    @Override
    public double hit() {
        strength = getStrengthFromItemType(strength);
        setLevel(getLevel()+1);
        return strength;
    }
}
