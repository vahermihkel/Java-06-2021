package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        int worldHeight = 6;
        int worldWidth = 10;

        World world = new World(worldHeight, worldWidth); // constructor, uus instants


        Player player = new Player(5,5);
        Enemy enemy = new Enemy(3,3);

        world.setCharacters(Arrays.asList(player, enemy));

        world.printMap();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            player.move(input, worldHeight, worldWidth);
            world.printMap();
            input = scanner.nextLine();
        }
    }
}
