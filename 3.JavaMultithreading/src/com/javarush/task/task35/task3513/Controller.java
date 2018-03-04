package com.javarush.task.task35.task3513;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    private Model model;
    private View view;
    private static final int WINNING_TILE = 8192;

    public Controller(Model model) {
        this.model = model;
        view = new View(this);
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore() {
        return model.score;
    }

    public void resetGame() {
        model.score = 0;
        view.isGameLost = false;
        view.isGameWon = false;
        model.resetGameTiles();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!model.canMove()) view.isGameLost = true;
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) resetGame();
        if (!view.isGameLost && !view.isGameWon) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT: model.left(); break;
                case KeyEvent.VK_RIGHT: model.right(); break;
                case KeyEvent.VK_UP: model.up(); break;
                case KeyEvent.VK_DOWN: model.down(); break;
                case KeyEvent.VK_Z: model.rollback(); break;
                case KeyEvent.VK_R: model.randomMove(); break;
                case KeyEvent.VK_A: model.autoMove(); break;
            }
            if (model.maxTile == WINNING_TILE) view.isGameWon = true;
        }
        view.repaint();
        if (view.isGameWon) {
            JOptionPane.showMessageDialog(view, "You've won!");
        } else if(view.isGameLost) {
            JOptionPane.showMessageDialog(view, "You've lost :(");
        }
    }

    public View getView() {
        return view;
    }
}
