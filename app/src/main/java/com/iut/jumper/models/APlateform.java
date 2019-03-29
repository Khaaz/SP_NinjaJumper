package com.iut.jumper.models;

import com.iut.jumper.utils.PlateformType;

public class APlateform extends AEntity {

    private final PlateformType type;

    private final boolean horizontalMove;
    private final boolean verticalMove;

    private final double plateformSpeed;

    public APlateform(PlateformType type, int width, int height, double posX, double posY, boolean horizontalMove, boolean verticalMove, double plateformSpeed) {
        super(width, height, posX, posY);

        this.type = type;
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

    public PlateformType getType() {
        return type;
    }
}
