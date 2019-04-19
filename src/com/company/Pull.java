package com.company;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Pull implements Runnable {

    private static Random rand = new Random();

    private Coordinates coordinates;
    private double alpha;
    private int s;

    Pull(Coordinates coordinates, double alpha) {
        this.coordinates = coordinates;
        this.alpha = alpha;
        this.s = 1 + rand.nextInt(9);
    }

    @Override
    public void run() {
        for (; ; ) {
            coordinates.setX(coordinates.move(coordinates.getX(), alpha, s, true));      //  изменяем значение x
            coordinates.setY(coordinates.move(coordinates.getY(), alpha, s, false));     // изменяем значение y

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));  //животное "уходит в глубокий сон"
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
