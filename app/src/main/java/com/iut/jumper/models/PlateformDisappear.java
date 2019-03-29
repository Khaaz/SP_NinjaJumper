package com.iut.jumper.models;

import com.iut.jumper.utils.PlateformType;

public class PlateformDisappear extends APlateform {

    public PlateformDisappear(int width, int height, double posX, double posY) {
        super(PlateformType.ONE_JUMP ,width, height, posX, posY, false, false, 0);
    }
}
