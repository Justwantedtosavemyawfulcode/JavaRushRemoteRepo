package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

    public Model() {
        resetGameTiles();
    }

    private void addTile() {
        List<List<Integer>> emptyTilesList = getEmptyTiles();

        if (!emptyTilesList.isEmpty()) {
            int randomY = (int) (emptyTilesList.size() * Math.random());
            int randomX = (int) (emptyTilesList.get(randomY).size() * Math.random());

            gameTiles[randomY][emptyTilesList.get(randomY).get(randomX)] = new Tile(Math.random() < 0.9 ? 2 : 4);
        }
    }

    private List<List<Integer>> getEmptyTiles() {
        List<List<Integer>> emptyTilesList = new ArrayList<List<Integer>>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    try {
                        emptyTilesList.get(i).add(j);
                    }
                    catch (IndexOutOfBoundsException e){
                        emptyTilesList.add(new ArrayList<Integer>(i));
                        emptyTilesList.get(i).add(j);
                    }
                }
            }
        }
        return emptyTilesList;
    }

    protected void resetGameTiles() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile(0);
            }
        }
        addTile();
        addTile();
//        for (int i = 0; i < gameTiles.length; i++) {
//            for (int j = 0; j < gameTiles[i].length; j++) {
//                System.out.print(gameTiles[i][j].getValue() + " ");
//            }
//            System.out.println();
//        }
    }
}
