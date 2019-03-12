package com.iut.jumper.utils;

/**
 * Set of utility methods to get a specific position
 * Get exactly the position using the imageView using the original position (top left of the object)
 */
/*
public class Positioner {

    // GET Y
    public static double getYCenter(AEntity e) {
        return e.body.getLayoutY() + e.body.getFitHeight()/2;
    }

    public static double getYBottom(AEntity e) {
        return e.body.getLayoutY() + e.body.getFitHeight();
    }

    public static double getYTop(AEntity e) {
        return e.body.getLayoutY();
    }

    // GET X
    public static double getXCenter(AEntity e) {
        return e.body.getLayoutX() + e.body.getFitWidth()/2;
    }

    public static double getXRight(AEntity e) {
        return e.body.getLayoutX() + e.body.getFitWidth();
    }

    public static double getXLeft(AEntity e) {
        return e.body.getLayoutX();
    }

    // SET X (use middle value)
    public static void setXMiddle(AEntity e, double positionX) {
        // Total window width * percentage -> position for top left
        // remove half body -> position for top middle
        //e.setLayoutX((SceneManager.getCurWidth() * percentX) + (e.body.getFitWidth()/2));
        e.body.setLayoutX(positionX - (e.body.getFitWidth()/2));
    }

    public static void setYMiddle(AEntity e, double positionY) {
        //e.setLayoutY((SceneManager.getCurHeight() * percentY) + (e.body.getFitHeight()/2));
        e.body.setLayoutY(positionY + (e.body.getFitHeight()/2));
    }

    public static void setYTop(AEntity e, double positionY) {
        //e.setLayoutY((SceneManager.getCurHeight() * percentY) + (e.body.getFitHeight()/2));
        e.body.setLayoutY(positionY - (e.body.getFitHeight()/2));
    }

    public static void setYBottom(AEntity e, double positionY) {
        //e.setLayoutY((SceneManager.getCurHeight() * percentY) + (e.body.getFitHeight()/2));
        e.body.setLayoutY(positionY);
    }
}
*/