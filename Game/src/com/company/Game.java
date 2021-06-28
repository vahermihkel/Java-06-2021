package com.company;

import java.util.Scanner;

public class Game {

    // DEBUGGIMINE
    // Streamid koos Itemitega (kasutuskorrad vähenevad, findfirst)
    // Interfaced - seome kokku sarnaste funktsionaalsustega klassid
    // Thread'd (kellaaeg jooksma - enam ei liigu kood alati ülevalt alla)
    // Map - list, mis omab võtit ja väärtust - tapetud vaenlased ja nende arv

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
        try {
            while (!input.equals("end")) {
                player.move(input, world);
                if (player.xCoord == enemy.xCoord && player.yCoord == enemy.yCoord && enemy.isVisible) {
                    GameController.getFightInput(world, player, enemy, scanner);
                }
                if (player.xCoord == questMaster.xCoord && player.yCoord == questMaster.yCoord) {
                    enemy.setVisible(true);
                }
                world.printMap();
                input = scanner.nextLine();
            }
        } catch (GameOverException e) {
            System.out.println("Sisestasid liiga palju valesti, mäng läbi!");
            input = "end";
        }
    }

}
