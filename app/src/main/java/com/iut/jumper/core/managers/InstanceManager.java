package com.iut.jumper.core.managers;

import com.iut.jumper.R;
import com.iut.jumper.models.APlateform;
import com.iut.jumper.models.Jumper;
import com.iut.jumper.models.PlateformDefault;
import com.iut.jumper.utils.Constants;
import com.iut.jumper.utils.Positioner;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.LinkedBlockingDeque;

public class InstanceManager {

    private GameService gameService;

    private LinkedBlockingDeque<APlateform> plateforms;

    private Jumper jumper;
    private final int screenWidth;
    private final int screenHeight;

    public InstanceManager(GameService gameService) {

        this.gameService = gameService;
        this.screenWidth = this.gameService.getDisplay().getWidth();
        this.screenHeight = this.gameService.getDisplay().getHeight();

        this.plateforms = new LinkedBlockingDeque<>();

        this.jumper = new Jumper(R.drawable.ninjablanc_right, (int)Math.round(this.screenWidth * Constants.SCALE_JUMPER_WIDTH), (int)Math.round(this.screenWidth * Constants.SCALE_JUMPER_HEIGHT), 0, 0, this.screenHeight * Constants.SCALE_JUMPER_JUMP);

        Positioner.setYBottom(this.jumper, this.screenHeight);
    }

    public Jumper getJumper() {
        return jumper;
    }


    protected double getPosLastPlateform() {
        return this.plateforms.peekLast().getPosY();
    }

    protected double getPosFirstPlateform() {
        return this.plateforms.peekFirst().getPosY();
    }

    public Collection<APlateform> getPlateforms() {
        return Collections.unmodifiableCollection(this.plateforms);
    }

    protected void removePlateform() {
        this.plateforms.remove();
    }

    protected void addPlateform(double x, double y) {
        int width =(int)(Math.round(this.screenWidth * Constants.SCALE_PLATEFORM_WIDTH));
        int height = (int)(Math.round(this.screenHeight * Constants.SCALE_PLATEFORM_HEIGHT));

        this.plateforms.add(new PlateformDefault(width, height, x > (this.screenWidth - width) ? x - width : x, y));
    }
}
