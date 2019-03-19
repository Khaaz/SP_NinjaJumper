package com.iut.jumper.models;

public class APlateform extends AEntity {

    private final boolean horizontalMove;
    private final boolean verticalMove;

    private final double plateformSpeed;

    public APlateform(int skin, int width, int height, boolean horizontalMove, boolean verticalMove, double plateformSpeed) {
        super(skin, width, height);
        this.horizontalMove = horizontalMove;
        this.verticalMove = verticalMove;
        this.plateformSpeed = plateformSpeed;
    }

    public boolean isHorizontalMove() {
        return horizontalMove;
    }

    public boolean isVerticalMove() {
        return verticalMove;
    }

    public double getPlateformSpeed() {
        return plateformSpeed;
    }
}
