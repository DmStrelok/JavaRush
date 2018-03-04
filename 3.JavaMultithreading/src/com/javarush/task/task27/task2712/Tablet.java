package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    private final int number;
    private Order order;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public Tablet(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }

    public Order getOrder() {
        return order;
    }

    public Order createOrder() {
        try {
            order = new Order(this);
            queue.add(order);
        } catch (IOException e) {
            order = null;
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        acceptOrder();
        return order;
    }

    private void acceptOrder() {
        ConsoleHelper.writeMessage(order.toString());
        if (!order.isEmpty()) {
            AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            try {
                advertisementManager.processVideos();
            } catch (Exception e) {
                logger.log(Level.INFO, "No video is available for the order " + order);
            }
        }
    }

    public void createTestOrder() {
        try {
            order = new TestOrder(this);
            queue.add(order);
        } catch (IOException e) {
            order = null;
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        acceptOrder();
    }
}
