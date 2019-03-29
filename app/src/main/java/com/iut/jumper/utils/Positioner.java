package com.iut.jumper.utils;

import com.iut.jumper.models.AEntity;

/**
 * Set of utility methods to get a specific position
 * Get exactly the position using the imageView using the original position (top left of the object)
 */

public class Positioner {

    // GET Y
    public static double getYCenter(AEntity e) {
        return e.getPosY() + e.getHeight()/2;
    }

    public static double getYBottom(AEntity e) {
        return e.getPosY() + e.getHeight();
    }

    public static double getYTop(AEntity e) {
        return e.getPosY();
    }

    // GET X
    public static double getXCenter(AEntity e) {
        return e.getPosX() + e.getWidth()/2;
    }

    public static double getXRight(AEntity e) {
        return e.getPosX() + e.getWidth();
    }

    public static double getXLeft(AEntity e) {
        return e.getPosX();
    }

    // SET X (use middle value)
    public static void setXMiddle(AEntity e, double positionX) {
        e.setPosX(positionX - (e.getWidth()/2));
    }

    public static void setXLeft(AEntity e, double positionX) {
        e.setPosX(positionX);
    }

    public static void setXRight(AEntity e, double positionX) {
        e.setPosX(positionX - e.getWidth());
    }


    public static void setYMiddle(AEntity e, double positionY) {
        e.setPosY(positionY - (e.getHeight()/2));
    }

    public static void setYTop(AEntity e, double positionY) {
        e.setPosY(positionY);
    }

    public static void setYBottom(AEntity e, double positionY) {
        e.setPosY(positionY - e.getHeight());
    }
}
