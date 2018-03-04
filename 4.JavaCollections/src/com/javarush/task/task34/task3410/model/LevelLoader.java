package com.javarush.task.task34.task3410.model;

import java.io.*;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        int length = Model.FIELD_CELL_SIZE;
        int length2 = Model.FIELD_CELL_SIZE / 2;
        Player player = null;
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();

        int lev = level % 60;
        if (lev == 0) lev = 60;
        String levs = String.valueOf(lev);
        try (BufferedReader br = new BufferedReader(new FileReader(levels.toFile()))) {
            String s;
            do {
                s = br.readLine();
                while (!s.contains("Maze")) {
                    s = br.readLine();
                }
            } while (!s.substring(6).equals(levs));
            br.readLine();
            int width = Integer.parseInt(br.readLine().substring(8));
            int height = Integer.parseInt(br.readLine().substring(8));
            br.readLine();
            br.readLine();
            br.readLine();
            for (int i = 0; i < height; i++) {
                s = br.readLine();
                for (int j = 0; j < width; j++) {
                    switch (s.charAt(j)) {
                        case 'X': walls.add(new Wall(length2 + j * length, length2 + i * length)); break;
                        case '*': boxes.add(new Box(length2 + j * length, length2 + i * length)); break;
                        case '.': homes.add(new Home(length2 + j * length, length2 + i * length)); break;
                        case '&': {
                            boxes.add(new Box(length2 + j * length, length2 + i * length));
                            homes.add(new Home(length2 + j * length, length2 + i * length));
                            break;
                        }
                        case '@': player = new Player(length2 + j * length, length2 + i * length); break;
                    }
                }
            }
        } catch (IOException ignored) {
        }
        return new GameObjects(walls, boxes, homes, player);
    }
}
