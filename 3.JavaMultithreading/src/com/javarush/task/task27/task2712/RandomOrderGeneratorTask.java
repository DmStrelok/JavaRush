package com.javarush.task.task27.task2712;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets;
    private int ORDER_CREATING_INTERVAL;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.ORDER_CREATING_INTERVAL = interval;
    }

    @Override
    public void run() {
        while (true) {
            int n = (int) (Math.random() * tablets.size());
            tablets.get(n).createTestOrder();
            try {
                Thread.sleep(ORDER_CREATING_INTERVAL);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
