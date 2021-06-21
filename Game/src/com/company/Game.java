package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        int worldHeight = 4;
        int worldWidth = 4;

        World world = new World(worldHeight, worldWidth); // constructor, uus instants


        Player player = new Player(world);
        // maailm lisa player
        world.addCharacter(player);
        Enemy enemy = new Enemy(world);
        // maailm lisa enemy
        world.addCharacter(enemy);

        QuestMaster questMaster = new QuestMaster(world);
        world.addCharacter(questMaster);

//        world.setCharacters(Arrays.asList(player, enemy));

        world.printMap();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            player.move(input, world);
            if (player.xCoord == enemy.xCoord && player.yCoord == enemy.yCoord) {
                enemy.setVisible(false);
                enemy.randomiseCoordinates(world);
            }
            if (player.xCoord == questMaster.xCoord && player.yCoord == questMaster.yCoord) {
                enemy.setVisible(true);
            }
            world.printMap();
            input = scanner.nextLine();
        }
    }
}
