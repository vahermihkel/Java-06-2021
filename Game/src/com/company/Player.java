package com.company;

public class Player extends Character {
    private Direction direction;

    public Player(int xCoord, int yCoord) {
        super(xCoord, yCoord, 'X');
    }

    public void move(String input, int worldHeight, int worldWidth) {
        switch (input) {
            case "a":
                this.direction = Direction.LEFT;
                break;
            case "s":
                this.direction = Direction.DOWN;
                break;
            case "d":
                this.direction = Direction.RIGHT;
                break;
            case "w":
                this.direction = Direction.UP;
                break;
        }

        switch (this.direction) {
            case LEFT:
                if (xCoord > 1) {
                    xCoord--;
                }
                break;
            case DOWN:
                if (yCoord < worldHeight-1) {
                    yCoord++;
                }
                break;
            case RIGHT:
                if (xCoord < worldWidth-1) {
                    xCoord++;
                }
                break;
            case UP:
                if (yCoord > 1) {
                    yCoord--;
                }
                break;
        }
    }
}
