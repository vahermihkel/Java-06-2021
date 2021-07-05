package com.company;

import com.company.character.Enemy;
import com.company.character.Player;
import com.company.character.QuestMaster;
import com.company.exception.GameOverException;
import com.company.item.*;

import java.util.Optional;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Game {

    static int interval  = 0;

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
        Teleporter teleporter = new Teleporter(world);
        world.addItem(teleporter);

//        world.setCharacters(Arrays.asList(player, enemy));

        world.printMap();

        Timer timer = new Timer();
        startTimer(timer);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            while (!input.equals("end")) {
                player.move(input, world);
                if (player.getxCoord() == enemy.getxCoord() && player.getyCoord() == enemy.getyCoord() && enemy.isVisible()) {
                    player.showItems();
                    System.out.println("VALI NUMBER MILLIST RELVA KASUTADA TAHAD: ");
                    input = scanner.nextLine();
                    Item chosenItem = null;
                    while (chosenItem == null) {
                        try {
                            chosenItem = player.getItems().get(Integer.parseInt(input)-1);
                            System.out.println("VALISID RELVA: " + chosenItem.getClass().getName());
                            Item finalChosenItem = chosenItem;
                            player.getItems().stream()
                                    .filter(e -> e.getClass().getName().equals(finalChosenItem.getClass().getName()))
                                    .findFirst()
                                    .ifPresent(Item::decreaseDurability);

                            if (finalChosenItem.getClass().getName().equals("Teleporter")) {
                                player.randomiseCoordinates(world);
                            } else {
                                GameController.getFightInput(world, player, enemy, scanner);
                            }
                        } catch (NumberFormatException e) {
                            input = printErrorAndAskAgain(player, scanner, "SISESTA NUMBER!");
                        } catch (IndexOutOfBoundsException e) {
                            input = printErrorAndAskAgain(player, scanner, "VALITUD NUMBRIGA RELVA EI LEITUD!");
                        }
                    }
                }
                if (player.getxCoord() == questMaster.getxCoord() && player.getyCoord() == questMaster.getyCoord()) {
                    enemy.setVisible(true);
                }
                checkIfPlayerCanGetItem(player,sword);
                checkIfPlayerCanGetItem(player,dagger);
                checkIfPlayerCanGetItem(player,hammer);
                checkIfPlayerCanGetItem(player,teleporter);

//                for (Item i:world.getItems()) {
//                    if (i.getxCoord() == player.getxCoord() && i.getyCoord() == player.getyCoord()) {
//                        i.increaseDurability();
//                        break;
//                    }
//                }
                if (enemy.getHealth() < 0) {
                    enemy.resurrect();
                }
                world.printMap();
                input = scanner.nextLine();
            }
        } catch (GameOverException e) {
            System.out.println("Tapetud vaenlasi");
            world.getKillCount().forEach((key, value) -> System.out.println("Tüüp " + key + " - " + value + " korda tapetud"));
            System.out.println("KULUNUD AEG KOKKU: " + interval);
            input = "end";
        }
    }

    private static String printErrorAndAskAgain(Player player, Scanner scanner, String error) {
        System.out.println(error);
        player.showItems();
        System.out.println("VALI NUMBER MILLIST RELVA KASUTADA TAHAD: ");
        return scanner.nextLine();
    }

    private static void startTimer(Timer timer) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                interval++;
            }
        }, 1000, 1000);
    }

    private static void checkIfPlayerCanGetItem(Player player, Item item) {
        if (player.getxCoord() == item.getxCoord() &&
                player.getyCoord() == item.getyCoord()) {
            player.addItem(item);
        }
    }
}
