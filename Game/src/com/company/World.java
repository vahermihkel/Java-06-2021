package com.company;

import java.util.ArrayList;
import java.util.List;

public class World {
    private int height;
    private int width;
    private List characters = new ArrayList();

    public World(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void setCharacters(List characters) {
        this.characters = characters;
    }

    public void printMap() {
        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= width; j++) {
                char symbol;
                if (j == 0 || j == width) {
                    symbol = '|';
                } else if (i == 0 || i == height) {
                    symbol = '-';
                } else {
                    symbol = ' ';
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
