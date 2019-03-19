package com.iut.jumper.core.managers;

import android.view.Display;

import com.iut.jumper.models.AEntity;
import com.iut.jumper.models.APlateform;
import com.iut.jumper.models.Jumper;

import java.util.ArrayList;
import java.util.List;

public class InstanceManager {

    private List<APlateform> plateforms;

    private Jumper jumper;
    private final int screenWidth;
    private final int screenHeight;

    public InstanceManager(Display display) {
        this.screenWidth = display.getWidth();
        this.screenHeight = display.getHeight();

        this.plateforms = new ArrayList<>();

        this.jumper = new Jumper((int)Math.round(this.screenWidth * 0.15), (int)Math.round(this.screenWidth * 0.25));
    }

    public Jumper getJumper() {
        return jumper;
    }

    public List<APlateform> getPlateforms() {
        return plateforms;
    }
}
