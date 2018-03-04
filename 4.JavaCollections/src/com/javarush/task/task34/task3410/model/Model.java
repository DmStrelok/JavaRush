package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.nio.file.Paths;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get(getClass().getProtectionDomain().getCodeSource().getLocation().getPath().substring(1) +
            getClass().getPackage().getName().substring(0, getClass().getPackage().getName().length() - 5).replace(".","/") + "res/levels.txt"));

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel++;
        restart();
    }

    public void move(Direction direction) {
        Player player = getGameObjects().getPlayer();
        if (checkWallCollision(player, direction)) return;
        if (checkBoxCollisionAndMoveIfAvaliable(direction)) return;
        switch (direction) {
            case UP: player.move(0, - Model.FIELD_CELL_SIZE); break;
            case DOWN: player.move(0, Model.FIELD_CELL_SIZE); break;
            case LEFT: player.move(- Model.FIELD_CELL_SIZE, 0); break;
            case RIGHT: player.move(Model.FIELD_CELL_SIZE, 0); break;
        }
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (CollisionObject wall : getGameObjects().getWalls()) {
            if (gameObject.isCollision(wall, direction)) return true;
        }
        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction) {
        Player player = getGameObjects().getPlayer();
        CollisionObject boxMove = null;
        for (CollisionObject box : getGameObjects().getBoxes()) {
            if (player.isCollision(box, direction)) {
                if (checkWallCollision(box, direction)) return true;
                for (CollisionObject box2 : getGameObjects().getBoxes()) {
                    if (box.isCollision(box2, direction)) return true;
                }
                boxMove = box;
                break;
            }
        }
        if (boxMove == null) return false;
        switch (direction) {
            case UP: ((Box) boxMove).move(0, - Model.FIELD_CELL_SIZE); break;
            case DOWN: ((Box) boxMove).move(0, Model.FIELD_CELL_SIZE); break;
            case LEFT: ((Box) boxMove).move(- Model.FIELD_CELL_SIZE, 0); break;
            case RIGHT: ((Box) boxMove).move(Model.FIELD_CELL_SIZE, 0); break;
        }
        return false;
    }

    public void checkCompletion() {
        for (CollisionObject box : getGameObjects().getBoxes()) {
            boolean crossing = false;
            for (GameObject home : getGameObjects().getHomes()) {
                if (box.getX() == home.getX() && box.getY() == home.getY()) {
                    crossing = true;
                    break;
                }
            }
            if (!crossing) return;
        }
        eventListener.levelCompleted(currentLevel);
    }
}
