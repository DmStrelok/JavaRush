package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    @Override
    public String toString() {
        return String.format("%s is displaying... %d, %d", name, amountPerOneDisplaying, (int) (amountPerOneDisplaying * 1.0 / duration * 1000));
    }

    public int getHits() {
        return hits;
    }

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        if (hits != 0) amountPerOneDisplaying = initialAmount/hits;
        else amountPerOneDisplaying = -1;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate() {
        if (hits <= 0) throw new UnsupportedOperationException();
        else hits--;
    }
}
