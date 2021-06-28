package com.company;

import java.util.Scanner;

public class GameController {

    static void getFightInput(World world, Player player, Enemy enemy, Scanner scanner) throws GameOverException {
        System.out.println("Kohtusid vaenlasega!");
        int inputNumber;
        int totalTries = 3;
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            System.out.println("Ütle nr 1-3:");
            try {
                inputNumber = Integer.parseInt(scanner.nextLine());
                fightWithEnemy(world, player, enemy, inputNumber);
            } catch (NumberFormatException e) {
                totalTries--;
                System.out.println("Sisestasid tähe, palun sisesta number!");
                if (totalTries == 0) {
                    throw new GameOverException();
                }
            }
        }
    }

    private static void fightWithEnemy(World world, Player player, Enemy enemy, int inputNumber) {
        int fightNumber = (int) ((Math.random() * (3))+1);
        if (fightNumber == inputNumber) {
            enemy.takeHealth();
            System.out.println("Võtsid vaenlaselt elu, vaenlasel elusid: " + enemy.getHealth());
        } else {
            player.takeHealth();
            System.out.println("Kaotasid elu, elusid alles: " + player.getHealth());
        }
        if (enemy.getHealth() <= 0) {
            enemy.setVisible(false);
            enemy.randomiseCoordinates(world);
            System.out.println("VAENLANE SAI SURMA!");
        } else if (player.getHealth() <= 0) {
            System.out.println("SAID SURMA, MÄNG LÄBI!");
            // TODO: GAME OVER EXCEPTION
        }
    }
}
