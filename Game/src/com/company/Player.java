package com.company;

public class Player {
    private int xCoord;
    private int yCoord;
    private char symbol;

    public Player(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.symbol = 'X';
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
