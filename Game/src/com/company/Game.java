package com.company;

import com.company.character.Enemy;
import com.company.character.Player;
import com.company.character.QuestMaster;
import com.company.exception.GameOverException;
import com.company.item.Dagger;
import com.company.item.Hammer;
import com.company.item.Item;
import com.company.item.Sword;

import java.util.Scanner;

public class Game {

    // Streamid koos Itemitega (kasutuskorrad vähenevad, findfirst)
    // Interfaced - seome kokku sarnaste funktsionaalsustega klassid
    // Thread'd (kellaaeg jooksma - enam ei liigu kood alati ülevalt alla)
    // Map - list, mis omab võtit ja väärtust - tapetud vaenlased ja nende arv

    public static void main(String[] args) {
        int worldHeight = 4;
        int worldWidth = 4;

        World world = new World(worldHeight, worldWidth); // constructor, uus instants


        Player player = new Player(world);
        world.addCharacter(player);
        Enemy enemy = new Enemy(world);
        world.addCharacter(enemy);
        QuestMaster questMaster = new QuestMaster(world);
        world.addCharacter(questMaster);

        Sword sword = new Sword(world);
        world.addItem(sword);
        Hammer hammer = new Hammer(world);
        world.addItem(hammer);
        Dagger dagger = new Dagger(world);
        world.addItem(dagger);

//        world.setCharacters(Arrays.asList(player, enemy));

        world.printMap();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            while (!input.equals("end")) {
                player.move(input, world);
                if (player.getxCoord() == enemy.getxCoord() && player.getyCoord() == enemy.getyCoord() && enemy.isVisible()) {
                    GameController.getFightInput(world, player, enemy, scanner);
                }
                if (player.getxCoord() == questMaster.getxCoord() && player.getyCoord() == questMaster.getyCoord()) {
                    enemy.setVisible(true);
                }
                world.getItems().stream()
                        .filter(item -> (item.getxCoord() == player.getxCoord() && item.getyCoord() == player.getyCoord()))
                        .findFirst()
                        .ifPresent(Item::increaseDurability);

                for (Item i:world.getItems()) {
                    if (i.getxCoord() == player.getxCoord() && i.getyCoord() == player.getyCoord()) {
                        i.increaseDurability();
                        break;
                    }
                }
                if (enemy.getHealth() < 0) {
                    enemy.resurrect();
                }
                world.printMap();
                input = scanner.nextLine();
            }
        } catch (GameOverException e) {
            System.out.println("Tapetud vaenlasi");
            world.getKillCount().forEach((key, value) -> System.out.println("Tüüp " + key + " - " + value + " korda tapetud"));
            input = "end";
        }
    }

}
