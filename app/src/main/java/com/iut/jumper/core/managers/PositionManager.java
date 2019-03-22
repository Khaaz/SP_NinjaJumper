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


    private double currentJumpHeight;
    private boolean middleScreen;

    private double score;

    public PositionManager(GameService gameService) {
        this.gameService = gameService;

        this.instanceManager = gameService.getInstanceManager();

        this.display = this.gameService.getDisplay();

        this.middleScreen = false;
        this.currentJumpHeight = 0;
        this.score = 0;
    }

    public void update() {
        this.moveHorizontalJumper();
        this.moveVerticalJumper();
    }

    private void moveHorizontalJumper() {
        Jumper jumper = this.instanceManager.getJumper();
        // move X
        if (CollisionManager.isJumperOutsideScreenHorizontal(jumper, this.display.getWidth())) {
            if (jumper.getDirection()) {
                Positioner.setXMiddle(jumper, 0);
            } else {
                Positioner.setXMiddle(jumper, this.display.getWidth());
            }
        } else {
            if (jumper.getDirection()) {
                Positioner.setXLeft(jumper, jumper.getPosX() + jumper.getSpeed());
            } else {
                Positioner.setXLeft(jumper, jumper.getPosX() - jumper.getSpeed());
            }
        }
    }

    private void moveVerticalJumper() {
        Jumper jumper = this.instanceManager.getJumper();
        // move Y

        if (jumper.getJumpDirection()) {
            if (this.currentJumpHeight > jumper.getJumpHeight()) {
                jumper.setJumpDirection(false);
                this.moveJumperDown(jumper);
            }
            if (CollisionManager.isJumperAtMiddleScreen(jumper, this.display.getHeight())) {
                this.middleScreen = true;
                this.currentJumpHeight += jumper.getJumpSpeed();
                this.movePlateformsDown(jumper.getJumpSpeed());
                this.score += jumper.getJumpSpeed();
            }
            this.moveJumperUp(jumper);
        } else {
            // if Collision with plateform
            /*
            if (CollisionManager. withPlateform) {
                jumper.setJumpDirection(true);
                this.moveJumperUp(jumper);
            }*/

            if (CollisionManager.isJumperOutsideScreenVertical(jumper, this.display.getHeight())) {
                Log.d("POSITION MANAGER", "RIP DEAD");
            }
            this.moveJumperDown(jumper);
        }
    }

    private void movePlateformsDown(double height) {
        //
    }

    private void moveJumperDown(Jumper jumper) {
        Positioner.setYTop(jumper, jumper.getPosY() + jumper.getJumpSpeed());
    }

    private void moveJumperUp(Jumper jumper) {
        Positioner.setYTop(jumper, jumper.getPosY() - jumper.getJumpSpeed());
    }

    public void updateJumperSpeed(double speed) {
        this.instanceManager.getJumper().setSpeed(speed);
    }

    public void updateJumperDirection(boolean direction) {
        this.instanceManager.getJumper().setDirection(direction);
    }
}
