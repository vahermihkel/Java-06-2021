package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Character {
    protected int xCoord;
    protected int yCoord;
    protected char symbol;
    protected boolean isVisible;

    public Character(World world, char symbol) {
        // world-lt võtan listist kõik characterid
        // kontrollin neid
        randomiseCoordinates(world);
        this.symbol = symbol;
        this.isVisible = true;
    }

    public void randomiseCoordinates(World world) {
        this.xCoord = generateRandomCoordinates(world.getWidth());
        this.yCoord = generateRandomCoordinates(world.getHeight());
        checkUniqueCoordinaates(world);
    }

    private void checkUniqueCoordinaates(World world) {
        List<Character> characters = world.getCharacters();

        List<Character> allCharactersButMyself = characters.stream()
                        .filter(character->character.symbol != this.symbol)
                        .collect(Collectors.toList());

//        List<Character> allCharactersButMyself2 = new ArrayList<>();
//        for (int i = 0; i < characters.size(); i++) {
//            if (characters.get(i).symbol != this.symbol) {
//                allCharactersButMyself2.add(characters.get(i));
//            }
//        }
        for (Character character: allCharactersButMyself) {
            if (character.xCoord == this.xCoord && character.yCoord == this.yCoord) {
                randomiseCoordinates(world);
                break;
            }
        }
    }

    private int generateRandomCoordinates(int worldSize) {
        return (int) ((Math.random() * (worldSize-1))+1);
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public char getSymbol() {
        return symbol;
    }
}
