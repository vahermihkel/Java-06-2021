package com.company;

import java.util.Arrays;

public class Game {

    public static void main(String[] args) {
        int height = 10;
        int width = 20;

        World world = new World(height, width);
        world.printMap();

        Player player = new Player(5,5);

        world.setCharacters(Arrays.asList(player));
    }
}
