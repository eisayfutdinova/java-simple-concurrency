package com.company;

public class Main {

    static double parseDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {

        double x = 0;
        double y = 0;

        // проверяем введенные данные
        if (args.length == 2) {
            x = parseDouble(args[0]);
            y = parseDouble(args[1]);
        }

        Coordinates coordinates = new Coordinates(x, y);    // объект координат

        Thread swan = new Thread(new Pull(coordinates, Math.toRadians(60.0)));  //поток лебедя
        Thread crayfish = new Thread(new Pull(coordinates, Math.toRadians(180.0)));   //поток рака
        Thread pike = new Thread(new Pull(coordinates, Math.toRadians(300.0)));   //поток щуки

        // чтобы созданные потоки закончились
        swan.setDaemon(true);
        crayfish.setDaemon(true);
        pike.setDaemon(true);

        swan.start();
        crayfish.start();
        pike.start();

        for (int i = 0; i < 25; i++) {
            try {
                Thread.sleep(1000);
                if (i % 2 == 0) {
                    System.out.println(String.format("x = %.2f, y = %.2f", coordinates.getX(), coordinates.getY()));  //вывод координат каждые 2 секунды
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
