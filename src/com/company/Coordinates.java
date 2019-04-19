package com.company;

class Coordinates {
    private double x;
    private double y;

    Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    synchronized double move(double p, double alpha, int s, boolean isX) {
        return isX
                ? p + Math.cos(alpha) * s
                : p + Math.sin(alpha) * s;
    }

    double getX() {
        return x;
    }

    void setX(double x) {
        this.x = x;
    }

    double getY() {
        return y;
    }

    void setY(double y) {
        this.y = y;
    }
}
