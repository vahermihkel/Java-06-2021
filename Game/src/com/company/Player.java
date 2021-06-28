package com.company;

public class Player extends Character {
    private Direction direction;
    private double health;

    public Player(World world) {
        super(world, 'X');
        this.health = 10.0;
    }

    public void move(String input, World world) {
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
                if (yCoord < world.getHeight()-1) {
                    yCoord++;
                }
                break;
            case RIGHT:
                if (xCoord < world.getWidth()-1) {
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

    public void takeHealth() {
        this.health--;
    }

    public double getHealth() {
        return health;
    }
}
