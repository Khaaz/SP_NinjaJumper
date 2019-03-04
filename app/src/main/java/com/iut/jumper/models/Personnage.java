package com.iut.jumper.models;

import android.graphics.Color;
import android.graphics.RectF;

public class Personnage {

    public static final int taille = 40;

    private float myX = 0;
    private float myY = 0;

    private float SpeedX = 0;

    private int couleur = Color.YELLOW;

    public static final float Vit_Max = 50.0f;

    private static final float compensateur = 15.0f;

    private RectF pos_base = null;

    public Personnage() {
    }

    public float getSpeedX() {
        return SpeedX;
    }

    public void setSpeedX(float speedX) {
        SpeedX = speedX;
    }

    public float getMyX() {
        return myX;
    }

    public void setMyX(float myX) {
        this.myX = myX;
    }

    public void setInitRect(RectF r){

    }
}
