package com.company.item;

import com.company.World;
import com.company.WorldObject;

public class Item implements WorldObject {
    private double strength;
    private int durability;
    private char symbol;
    private int xCoord;
    private int yCoord;

    public Item(double strength, int durability, World world) {
        this.strength = strength;
        this.durability = durability;
        this.symbol = 'I';
        this.xCoord = generateRandomCoordinates(world.getHeight());
        this.yCoord = generateRandomCoordinates(world.getWidth());
    }

    public void randomiseCoordinates(World world) {
        this.xCoord = generateRandomCoordinates(world.getWidth());
        this.yCoord = generateRandomCoordinates(world.getHeight());
    }

    private int generateRandomCoordinates(int worldSize) {
        return (int) ((Math.random() * (worldSize-1))+1);
    }

    public double getStrength() {
        return strength;
    }

    public int getDurability() {
        return durability;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void increaseDurability() {
        this.durability++;
    }

    public void decreaseDurability() {
        this.durability--;
    }
}
