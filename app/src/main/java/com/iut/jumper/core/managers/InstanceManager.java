package com.iut.jumper.core.managers;

import android.util.Log;
import android.view.Display;

import com.iut.jumper.models.AEntity;
import com.iut.jumper.models.APlateform;
import com.iut.jumper.models.Jumper;
import com.iut.jumper.utils.Positioner;

import java.util.ArrayList;
import java.util.List;

public class InstanceManager {

    private GameService gameService;

    private List<APlateform> plateforms;

    private Jumper jumper;
    private final int screenWidth;
    private final int screenHeight;

    public InstanceManager(GameService gameService) {

        this.gameService = gameService;
        this.screenWidth = this.gameService.getDisplay().getWidth();
        this.screenHeight = this.gameService.getDisplay().getHeight();

        this.plateforms = new ArrayList<>();

        this.jumper = new Jumper((int)Math.round(this.screenWidth * 0.15), (int)Math.round(this.screenWidth * 0.25));

        Positioner.setYBottom(this.jumper, this.screenHeight);

        Log.d("IMANAGER", String.valueOf(this.screenWidth));
        Log.d("IMANAGER", String.valueOf(this.screenHeight));
        Log.d("IMANAGER", "=======");
        Log.d("IMANAGER", String.valueOf(this.jumper.getDirection()));
        Log.d("IMANAGER", String.valueOf(this.jumper.getSpeed()));
        Log.d("IMANAGER", String.valueOf(this.jumper.getPosX()));
        Log.d("IMANAGER", String.valueOf(this.jumper.getPosY()));
        Log.d("IMANAGER", String.valueOf(this.jumper.getHeight()));
        Log.d("IMANAGER", String.valueOf(this.jumper.getWidth()));


    }

    public Jumper getJumper() {
        return jumper;
    }

    public List<APlateform> getPlateforms() {
        return plateforms;
    }
}
