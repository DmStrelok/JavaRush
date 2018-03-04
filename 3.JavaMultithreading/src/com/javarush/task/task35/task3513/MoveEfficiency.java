package com.javarush.task.task35.task3513;

public class MoveEfficiency implements Comparable<MoveEfficiency> {
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.move = move;
        this.score = score;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency o) {
        if (Integer.compare(numberOfEmptyTiles, o.numberOfEmptyTiles) != 0) return Integer.compare(numberOfEmptyTiles, o.numberOfEmptyTiles);
        else if (Integer.compare(score,o.score) != 0) return Integer.compare(score,o.score);
        else return 0;
    }
}
