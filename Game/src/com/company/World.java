package com.company;

import java.util.ArrayList;
import java.util.List;

public class World {
    private int height;
    private int width;
    private List<Character> characters = new ArrayList<>();

    public World(int height, int width) { // new World(_,_)
        this.height = height;
        this.width = width;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public void printMap() {
        for (int y = 0; y <= height; y++) {
            for (int x = 0; x <= width; x++) {
                char symbol;
                if (x == 0 || x == width) {
                    symbol = '|';
                } else if (y == 0 || y == height) {
                    symbol = '-';
                } else {
                    symbol = ' ';
                    symbol = getPlayerSymbol(y, x, symbol);
                }
                // List numbers = [1,2,5,4,5];
                // for (int n: numbers) {
            //}
//                for (int k = 0; k < this.characters.size(); k++) {
//                  Player p = this.characters.get(k);
//                  if (p.getxCoord() == j && p.getyCoord() == y)  {
//                      symbol = p.getSymbol();
//                  }
//                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private char getPlayerSymbol(int y, int x, char symbol) {
        for (Character c: this.characters) {
            if (c.getxCoord() == x && c.getyCoord() == y)  {
                symbol = c.getSymbol();
                break;
            }
        }
        return symbol;
    }
}
