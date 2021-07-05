package com.company.item;

import com.company.World;
import com.company.WorldObject;

public class Item implements WorldObject {
    private double strength;
    private int durability;
    private char symbol;
    private int xCoord;
    private int yCoord;
    private ItemType itemType;
    private int level;

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

    public void setLevel(int level) {
        this.level = level;
        if (this.level < 3) {
            this.itemType = ItemType.SILVER;
        } else if (this.level < 5) {
            this.itemType = ItemType.GOLD;
        } else if (this.level < 7) {
            this.itemType = ItemType.PLATINUM;
        } else {
            this.itemType = ItemType.TITANIUM;
        }
    }

    public int getLevel() {
        return level;
    }

    public double getStrengthFromItemType(double strength) {
        switch (itemType) {
            case SILVER:
                strength *= 0.75;
                break;
            case GOLD:
                strength *= 1;
                break;
            case PLATINUM:
                strength *= 1.25;
                break;
            case TITANIUM:
                strength *= 1.5;
                break;
        }
        return strength;
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
