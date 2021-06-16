package com.company;

public class Character {
    protected int xCoord;
    protected int yCoord;
    protected char symbol;

    public Character(int xCoord, int yCoord, char symbol) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.symbol = symbol;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public char getSymbol() {
        return symbol;
    }
}
