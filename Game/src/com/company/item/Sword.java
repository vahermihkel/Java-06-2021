package com.company.item;

import com.company.World;

public class Sword extends Item implements FightWeapon {
    private static double strength = 3.0;

    public Sword(World world) {
        super(strength, 1, world);
    }

    @Override
    public double hit() {
        strength = getStrengthFromItemType(strength);
        setLevel(getLevel()+1);
        return strength;
    }
}
