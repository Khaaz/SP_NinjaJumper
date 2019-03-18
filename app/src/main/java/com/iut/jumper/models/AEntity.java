package com.iut.jumper.models;

public abstract class AEntity {

    private double x;
    private double y;
    private double speed;

    private int skin;

    public AEntity(int skin) {
        this.skin = skin;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getSkin() {
        return skin;
    }
}
