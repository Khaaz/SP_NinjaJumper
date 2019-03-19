package com.iut.jumper.models;

public abstract class AEntity {

    private double posX;
    private double posY;
    private double speed;

    private final int width;
    private final int height;

    private final int skin;

    public AEntity(int skin, int width, int height) {
        this.skin = skin;
        this.width = width;
        this.height = height;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
