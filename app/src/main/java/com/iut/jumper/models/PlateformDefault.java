package com.iut.jumper.models;

import com.iut.jumper.utils.PlateformType;

public class PlateformDefault extends APlateform {
    public PlateformDefault(int width, int height, double posX, double posY) {
        super(PlateformType.DEFAULT ,width, height, posX, posY, false, false, 0);
    }
}
