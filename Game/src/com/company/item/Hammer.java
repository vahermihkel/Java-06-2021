package com.company.item;

import com.company.World;

public class Hammer extends Item implements FightWeapon {
    private static double strength = 1.0;

    public Hammer(World world) {
        super(1.0, 5, world);
    }

    @Override
    public double hit() {
        strength = getStrengthFromItemType(strength);
        setLevel(getLevel()+1);
        strength *= randomiseStrength();
        return strength;
    }

    private double randomiseStrength() {
        return Math.random() * ( 2 );
    }
}
