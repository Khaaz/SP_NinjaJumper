package com.iut.jumper.core.managers;

import com.iut.jumper.models.AEntity;
import com.iut.jumper.utils.Positioner;

public class CollisionManager {

    public static Boolean checkJumperPlateformCollision(AEntity jumper, AEntity plateform) {
        return (
                Positioner.getYBottom(jumper) >= Positioner.getYTop(plateform)
                && Positioner.getYBottom(jumper) <= Positioner.getYBottom(plateform)
                && Positioner.getXRight(jumper) > Positioner.getXLeft(plateform)
                && Positioner.getXLeft(jumper) < Positioner.getXRight(plateform)
        );
    }

    public static Boolean checkCollision(AEntity a, AEntity b) {
        return (
                Positioner.getXRight(a) > Positioner.getXLeft(b)
                && Positioner.getXLeft(a) < Positioner.getXRight(b)
                && Positioner.getYBottom(a) > Positioner.getYTop(b)
                && Positioner.getYTop(a) < Positioner.getYBottom(b)
        );
    }

    public static boolean isOutsideScreenHorizontal(AEntity a, int screenWidth) {
        return (
                Positioner.getXLeft(a) < 0 || Positioner.getXRight(a) > screenWidth
        );
    }

    public static Boolean isOutsideScreenVertical(AEntity a, int screenHeight) {
        return (
                Positioner.getYTop(a) < 0 || Positioner.getYBottom(a) > screenHeight
        );

    }

    public static boolean isJumperOutsideScreenHorizontal(AEntity a, int screenWidth) {
        return (
                Positioner.getXCenter(a) < 0 || Positioner.getXCenter(a) > screenWidth
        );
    }

    public static boolean isJumperOutsideScreenVertical(AEntity a, int screenHeight) {
        return (
                Positioner.getYTop(a) > screenHeight
        );
    }

    public static boolean isJumperAtMiddleScreen(AEntity a, int screenHeight) {
        return (
                Positioner.getYCenter(a) <= (screenHeight/2)
        );
    }
}
