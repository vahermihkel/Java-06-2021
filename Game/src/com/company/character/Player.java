package com.company.character;

import com.company.World;
import com.company.item.Item;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class Player extends Character {
    private Direction direction;
    private double health;
    private List<Item> items = new ArrayList<>();

    public Player(World world) {
        super(world, 'X');
        this.health = 10.0;
    }

    public List<Item> getItems() {
        return items.stream()
                .filter(item -> item.getDurability() > 0)
                .collect(Collectors.toList());
    }

    public void showItems() {
        this.items = getItems();
        for (int i = 0; i < items.size(); i++) {
            System.out.println(
                    i+1 + ": " + items.get(i).getClass().getName() +
                            ", tugevusega: " + items.get(i).getStrength() +
                            ", kasutuskordi: " + items.get(i).getDurability());
        }
    }

    public void addItem(Item item) {
        if (items.contains(item)) {
            this.items.stream()
                    .filter(i -> i.getStrength() == item.getStrength())
                    .findFirst()
                    .ifPresent(Item::increaseDurability);
        } else {
            this.items.add(item);
        }
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
