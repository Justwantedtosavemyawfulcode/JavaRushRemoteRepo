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
                gameTiles[i][j] = new Tile(); // Return to 0 after testing
            }
        }
        addTile();
        addTile();
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean tilesWasChanged = false;

        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == 0) {
                int temp = tiles[i + 1].value;
                if (temp > 0) { // Нужно именно здесь, потому что метот переставляет нули в любом случае, но для игрока ряд не меняется.
                    tilesWasChanged = true;
                }
                tiles[i + 1].value = 0;
                tiles[i].value = temp;
            }
        }

        boolean zeroWasAlreadyFound = false;
        for (int i = 0; i < tiles.length; i++) { // Проверяем остались ли нули не с краю массива, если да, то вызываем метод заново.
            if (zeroWasAlreadyFound && tiles[i].value != 0) {
                tilesWasChanged = compressTiles(tiles);
            }
            if (tiles[i].value == 0 && !zeroWasAlreadyFound) {
                zeroWasAlreadyFound = true;
            }
        }
        return tilesWasChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean tilesWasChanged = false;

        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value && tiles[i].value != 0) {
                int mergeResult = tiles[i].value + tiles[i + 1].value;
                score += mergeResult;
                if (mergeResult > maxTile) maxTile = mergeResult;
                tiles[i].value = mergeResult;
                tiles[i + 1].value = 0;
                compressTiles(tiles);
                tilesWasChanged = true;
            }
        }
        return tilesWasChanged;
    }

    private void ninetyDegreeRotationOfTheBoard() {
        Tile[][] tempTileBoard = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tempTileBoard[i][j] = new Tile();
            }
        }

        for (int i = 0; i < gameTiles.length; i++) { // Row of original board
            for (int j = 0; j < gameTiles.length; j++) { // Column of original board
                tempTileBoard[i][FIELD_WIDTH - j - 1] = gameTiles[j][i];
            }
        }
        gameTiles = tempTileBoard;
    }

    public void left() {
        boolean boardChanged = false;
        for (Tile[] tiles : gameTiles) {
            if (compressTiles(tiles) | mergeTiles(tiles)) { // для каждой строки массива gameTiles вызывать методы compressTiles и mergeTiles и добавлять одну плитку с помощью метода addTile в том случае, если это необходимо.
                boardChanged = true;
            }
        }
        if (boardChanged) {
            addTile();
        }
    }

    public void right() {
        ninetyDegreeRotationOfTheBoard();
        ninetyDegreeRotationOfTheBoard();
        left();
        ninetyDegreeRotationOfTheBoard();
        ninetyDegreeRotationOfTheBoard();
    }

    public void down() {
        ninetyDegreeRotationOfTheBoard();
        left();
        ninetyDegreeRotationOfTheBoard();
        ninetyDegreeRotationOfTheBoard();
        ninetyDegreeRotationOfTheBoard();
    }

    public void up() {
        ninetyDegreeRotationOfTheBoard();
        ninetyDegreeRotationOfTheBoard();
        ninetyDegreeRotationOfTheBoard();
        left();
        ninetyDegreeRotationOfTheBoard();
    }

    public void printBoard() {
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                System.out.print(gameTiles[i][j].getValue() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
