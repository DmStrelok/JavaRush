package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;
    private Stack<Tile[][]> previousStates;
    private Stack<Integer> previousScores;
    private boolean isSaveNeeded = true;

    public Model() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        resetGameTiles();
        previousStates = new Stack<>();
        previousScores = new Stack<>();
    }

    private void addTile() {
        List<Tile> list = getEmptyTiles();
        if (list.size() > 0)
            list.get((int) (Math.random() * list.size())).value = Math.random() < 0.9 ? 2 : 4;
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].isEmpty()) list.add(gameTiles[i][j]);
            }
        }
        return list;
    }

    protected void resetGameTiles() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
        score = 0;
        maxTile = 2;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean res = false;
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            if (tiles[i].isEmpty() && !tiles[i + 1].isEmpty()) {
                tiles[i].value = tiles[i + 1].value;
                tiles[i + 1].value = 0;
                compressTiles(tiles);
                res = true;
            }
        }
        return res;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean res = false;
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            if (!tiles[i].isEmpty() && tiles[i].value == tiles[i + 1].value) {
                tiles[i].value *= 2;
                tiles[i + 1].value = 0;
                score += tiles[i].value;
                if (tiles[i].value > maxTile) maxTile = tiles[i].value;
                res = true;
            }
        }
        compressTiles(tiles);
        return res;
    }

    private void turn() {
        Tile[][] tt = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tt[FIELD_WIDTH - 1 - j][i] = gameTiles[i][j];
            }
        }
        gameTiles = tt;
    }

    public void left() {
        if (isSaveNeeded) saveState(gameTiles);
        boolean res = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            res = res | compressTiles(gameTiles[i]);
            res = res | mergeTiles(gameTiles[i]);
        }
        if (res) addTile();
        isSaveNeeded = true;
    }

    public void right() {
        saveState(gameTiles);
        turn();
        turn();
        left();
        turn();
        turn();
    }

    public void up() {
        saveState(gameTiles);
        turn();
        left();
        turn();
        turn();
        turn();
    }

    public void down() {
        saveState(gameTiles);
        turn();
        turn();
        turn();
        left();
        turn();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        if (getEmptyTiles().size() > 0) return true;
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            for (int j = 0; j < FIELD_WIDTH - 1; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j + 1].value || gameTiles[i][j].value == gameTiles[i + 1][j].value) return true;
            }
            if (gameTiles[i][FIELD_WIDTH - 1].value == gameTiles[i +1][FIELD_WIDTH - 1].value) return true;
        }
        for (int j = 0; j < FIELD_WIDTH - 1; j++) {
            if (gameTiles[FIELD_WIDTH - 1][j].value == gameTiles[FIELD_WIDTH - 1][j + 1].value) return true;
        }
        return false;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] tt = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tt[i][j] = new Tile(gameTiles[i][j].value);
            }
        }
        previousStates.push(tt);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.empty() && !previousScores.empty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0: left(); break;
            case 1: right(); break;
            case 2: up(); break;
            case 3: down(); break;
        }
    }

    private boolean hasBoardChanged() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (previousStates.peek()[i][j].value != gameTiles[i][j].value) return true;
            }
        }
        return false;
    }

    private MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        MoveEfficiency moveEfficiency;
        if (hasBoardChanged()) moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        else moveEfficiency = new MoveEfficiency(-1, 0, move);
        rollback();
        return moveEfficiency;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());
        priorityQueue.add(getMoveEfficiency(() -> left()));
        priorityQueue.add(getMoveEfficiency(() -> right()));
        priorityQueue.add(getMoveEfficiency(() -> up()));
        priorityQueue.add(getMoveEfficiency(() -> down()));
        priorityQueue.poll().getMove().move();
    }
}
