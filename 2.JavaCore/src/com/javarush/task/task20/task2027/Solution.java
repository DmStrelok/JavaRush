package com.javarush.task.task20.task2027;


import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'a', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> lw =
        detectAllWords(crossword, "rr", "home", "same");
        lw.forEach(System.out::println);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    static int[][] crossword;
    static int n;
    static int m;
    public static class Wordp {
        public String text;
        public int sx;
        public int sy;
        public boolean b = false;

        public Wordp() {
        }

        public Wordp(String text, int sx, int sy) {
            this.text = text;
            this.sx = sx;
            this.sy = sy;
        }
    }

    static Wordp FFword (Wordp w, int dx, int dy) {
        Wordp word = w;
        String wo = w.text;
        if (wo.length() == 1) {word.b = true; return word;}
        wo = wo.substring(1);
        w.text = wo;
        int wn = wo.charAt(0);
        w.sx = w.sx + dx;
        w.sy = w.sy + dy;
        if (w.sx > -1 && w.sx < n && w.sy > -1 && w.sy < m && crossword[w.sx][w.sy] == wn) {
            word = FFword(w, dx, dy);
        }
        return word;
    }

    static List<Wordp> Fword (Wordp w){
        Wordp word = w;
        List<Wordp> lw = new ArrayList<>();
        String wo = w.text;
        if (wo.length() == 1) {word.b = true; lw.add(word); return lw;}
        wo = wo.substring(1);
        w.text = wo;
        int wn = wo.charAt(0);
        p1:
        {
            if (w.sx > 0) {
                if (w.sy > 0 && crossword[w.sx - 1][w.sy - 1] == wn) {
                    word = FFword(new Wordp(w.text, w.sx - 1, w.sy - 1), -1, -1);
                    if (word.b) {lw.add(word);}
                }
                if (crossword[w.sx - 1][w.sy] == wn) {
                    word = FFword(new Wordp(w.text, w.sx - 1, w.sy), -1, 0);
                    if (word.b) {lw.add(word);}
                }
                if (w.sy < m - 1 && crossword[w.sx - 1][w.sy + 1] == wn) {
                    word = FFword(new Wordp(w.text, w.sx - 1, w.sy + 1), -1, 1);
                    if (word.b) {lw.add(word);}
                }
            }

            if (w.sy > 0 && crossword[w.sx][w.sy - 1] == wn) {
                word = FFword(new Wordp(w.text, w.sx, w.sy - 1), 0, -1);
                if (word.b) {lw.add(word);}
            }

            if (w.sy < m - 1 && crossword[w.sx][w.sy + 1] == wn) {
                word = FFword(new Wordp(w.text, w.sx, w.sy + 1), 0, 1);
                if (word.b) {lw.add(word);}
            }

            if (w.sx < n - 1) {
                if (w.sy > 0 && crossword[w.sx + 1][w.sy - 1] == wn) {
                    word = FFword(new Wordp(w.text, w.sx + 1, w.sy - 1), 1, -1);
                    if (word.b) {lw.add(word);}
                }
                if (crossword[w.sx + 1][w.sy] == wn) {
                    word = FFword(new Wordp(w.text, w.sx + 1, w.sy), 1, 0);
                    if (word.b) {lw.add(word);}
                }
                if (w.sy < m - 1 && crossword[w.sx + 1][w.sy + 1] == wn) {
                    word = FFword(new Wordp(w.text, w.sx + 1, w.sy + 1), 1, 1);
                    if (word.b) {lw.add(word);}
                }
            }
        }
        return lw;
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> Lw = new ArrayList<>();
        Solution.crossword = crossword;
        n = crossword.length;
        m = crossword[0].length;
        List<Wordp> lw = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String wo = words[i];
            int wn = wo.charAt(0);
            p1: {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        if (crossword[j][k] == wn) {
                            lw = Fword(new Wordp(wo, j, k));
                            if (lw.size() > 0) {
                                for (int l = 0; l < lw.size(); l++) {
                                    Word word = new Word(wo);
                                    word.setStartPoint(k, j);
                                    word.setEndPoint(lw.get(l).sy, lw.get(l).sx);
                                    Lw.add(word);
                                }
                            }
                        }
                    }
                }
            }
        }
        return Lw;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
