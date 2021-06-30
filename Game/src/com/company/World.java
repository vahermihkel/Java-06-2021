package com.company;

import com.company.character.Character;
import com.company.character.EnemyType;
import com.company.item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World {
    private int height;
    private int width;
    private List<Character> characters = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private Map<EnemyType, Integer> killCount = new HashMap<>();

    public World(int height, int width) { // new World(_,_)
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void addCharacter(Character character) {
        this.characters.add(character);
    }

    public Map<EnemyType, Integer> getKillCount() {
        return killCount;
    }

    public void addKilledEnemy(EnemyType enemyType) {
        if (killCount.containsKey(enemyType)) {
            killCount.put(enemyType, killCount.get(enemyType)+1);
        } else {
            killCount.put(enemyType, 1);
        }
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public List<Item> getItems() {
        return items;
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
                    symbol = getItemSymbol(y, x, symbol);
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
            if (c.getxCoord() == x && c.getyCoord() == y && c.isVisible())  {
                symbol = c.getSymbol();
                break;
            }
        }
        return symbol;
    }

    private char getItemSymbol(int y, int x, char symbol) {
        for (Item i: this.items) {
            if (i.getxCoord() == x && i.getyCoord() == y)  {
                symbol = i.getSymbol();
                break;
            }
        }
        return symbol;
    }
}
