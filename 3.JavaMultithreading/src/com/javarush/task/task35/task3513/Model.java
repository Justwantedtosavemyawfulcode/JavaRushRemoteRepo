package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    protected int score;
    protected int maxTile;

    public Model() {
        resetGameTiles();
    }

    private void addTile() {
        List<Tile> emptyTilesList = getEmptyTiles();

        if (!emptyTilesList.isEmpty()) {
            int random = (int) (emptyTilesList.size() * Math.random());
            Tile emptyTile = emptyTilesList.get(random);
            emptyTile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTilesList = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    emptyTilesList.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTilesList;
    }

    protected void resetGameTiles() {
        score = 0;
        maxTile = 0;

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (j % 2 == 0) {
                    gameTiles[i][j] = new Tile(2);
                }
                else gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
//        compressTiles(gameTiles[0]);
//        compressTiles(gameTiles[1]);
//        compressTiles(gameTiles[2]);
//        compressTiles(gameTiles[3]);
//        mergeTiles(gameTiles[0]);
//        mergeTiles(gameTiles[1]);
//        mergeTiles(gameTiles[2]);
//        mergeTiles(gameTiles[3]);
//        for (int i = 0; i < gameTiles.length; i++) {
//            for (int j = 0; j < gameTiles[i].length; j++) {
//                System.out.print(gameTiles[i][j].getValue() + " ");
//            }
//            System.out.println();
//        }
    }

    private void compressTiles(Tile[] tiles) {
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == 0) {
                int temp = tiles[i + 1].value;
                tiles[i + 1].value = 0;
                tiles[i].value = temp;
            }
        }

        boolean zeroWasAlreadyFound = false;
        for (int i = 0; i < tiles.length; i++) { // Проверяем остались ли нули не с краю массива, если да, то вызываем метод заново.
            if (zeroWasAlreadyFound && tiles[i].value != 0) {
                compressTiles(tiles);
            }
            if (tiles[i].value == 0 && !zeroWasAlreadyFound) {
                zeroWasAlreadyFound = true;
            }
        }
    }

    private void mergeTiles(Tile[] tiles) {
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value) {
                int mergeResult = tiles[i].value + tiles[i + 1].value;
                score += mergeResult;
                if (mergeResult > maxTile) maxTile = mergeResult;
                tiles[i].value = mergeResult;
                tiles[i + 1].value = 0;
                compressTiles(tiles);
            }
        }
    }
}
