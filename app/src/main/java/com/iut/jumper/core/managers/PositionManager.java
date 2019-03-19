package com.iut.jumper.core.managers;


import android.util.Log;
import android.view.Display;

import com.iut.jumper.interfaces.IUpdatable;
import com.iut.jumper.models.Jumper;
import com.iut.jumper.utils.Positioner;

public class PositionManager implements IUpdatable {

    private final GameService gameService;
    private final InstanceManager instanceManager;

    private final Display display;

    public PositionManager(GameService gameService) {
        this.gameService = gameService;

        this.instanceManager = gameService.getInstanceManager();

        this.display = this.gameService.getDisplay();
    }

    public void update() {
        this.moveJumper();
    }

    private void moveJumper() {
        Jumper jumper = this.instanceManager.getJumper();
        // move X
        if (CollisionManager.isJumperOutsideScreenHorizontal(jumper, this.display.getWidth())) {
            if (jumper.getDirection()) {
                Positioner.setXMiddle(jumper, 0);
            } else {
                Positioner.setXMiddle(jumper, this.display.getWidth());
            }
        } else {
            Positioner.setXMiddle(jumper, jumper.getPosX() + jumper.getSpeed());
            //Log.d("POSMANAGER", String.valueOf(this.instanceManager.getJumper().getPosX()));
        }

    }

    public void updateJumperSpeed(double speed) {
        this.instanceManager.getJumper().setSpeed(speed);
        Log.d("POSMANAGER", String.valueOf(this.instanceManager.getJumper().getSpeed()));
    }

    public void updateJumperDirection(boolean direction) {
        this.instanceManager.getJumper().setDirection(direction);
    }
}
