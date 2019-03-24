package com.iut.jumper.core.managers;

import android.util.Log;
import android.view.Display;

import com.iut.jumper.interfaces.IUpdatable;
import com.iut.jumper.models.APlateform;
import com.iut.jumper.models.Jumper;
import com.iut.jumper.utils.Positioner;

import java.util.Random;

public class PositionManager implements IUpdatable {

    private final GameService gameService;
    private final InstanceManager instanceManager;

    private final Display display;


    private double currentJumpHeight;

    private double score;

    public PositionManager(GameService gameService) {
        this.gameService = gameService;

        this.instanceManager = gameService.getInstanceManager();

        this.display = this.gameService.getDisplay();

        this.currentJumpHeight = 0;
        this.score = 0;

        this.initPlateforms();
    }

    public void update() {
        this.moveHorizontalJumper();
        this.moveVerticalJumper();
        this.spawnAndDeletePlateforms();
    }

    private void initPlateforms() {
        int minY = 10;
        int maxY = (int)Math.round(this.instanceManager.getJumper().getJumpHeight());
        double totalHeight = this.display.getHeight();

        Random r = new Random();
        while (totalHeight > 0) {
            double y = r.nextInt(maxY - minY) + minY;
            double x = r.nextInt(this.display.getWidth());

            totalHeight -= y;
            this.instanceManager.addPlateform(x, totalHeight);
        }

        this.spawnNextPlateform();
    }

    private void spawnNextPlateform() {
        Random r = new Random();

        int minY = 10;
        int maxY = (int)Math.round(this.instanceManager.getJumper().getJumpHeight());

        double x = r.nextInt(this.display.getWidth());
        double y = r.nextInt(maxY - minY) + minY;

        double pos = this.instanceManager.getPosLastPlateform();
        this.instanceManager.addPlateform(x, pos - y);
    }

    // MOVE JUMPER X
    private void moveHorizontalJumper() {
        Jumper jumper = this.instanceManager.getJumper();

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

    // MOVE JUMPER Y
    private void moveVerticalJumper() {
        Jumper jumper = this.instanceManager.getJumper();

        if (jumper.getJumpDirection()) {
            this.moveVerticalJumperUp(jumper);
            return;

        } else {
            this.moveVerticalJumperDown(jumper);
            return;
        }
    }

    private void moveVerticalJumperUp(Jumper jumper) {
        // Jumper jump height
        if (this.currentJumpHeight > jumper.getJumpHeight()) {

            jumper.setJumpDirection(false);
            this.currentJumpHeight = 0;
            this.moveJumperDown(jumper);

            return;
        }

        // Jumper at middle of the screen (move plateforms down)
        if (CollisionManager.isJumperAtMiddleScreen(jumper, this.display.getHeight())) {

            this.currentJumpHeight += jumper.getJumpSpeed();
            this.movePlateformsDown(jumper.getJumpSpeed());
            this.updateScore(jumper.getJumpSpeed());

            return;
        }

        // default: move jumper  up
        this.currentJumpHeight += jumper.getJumpSpeed();
        this.moveJumperUp(jumper);
    }

    private void moveVerticalJumperDown(Jumper jumper) {

        // check collisions with plateforms
        for (APlateform p : this.instanceManager.getPlateforms()) {
            if (CollisionManager.checkJumperPlateformCollision(jumper, p)) {

                jumper.setJumpDirection(true);
                this.moveJumperUp(jumper);

                return;
            }
        }

        // Jumper outside of the screen - game over
        if (CollisionManager.isJumperOutsideScreenVertical(jumper, this.display.getHeight())) {

            Log.d("POSITION MANAGER", "RIP DEAD");
            jumper.setJumpDirection(true);
        }

        // default: move jumper down
        this.moveJumperDown(jumper);
    }

    private void spawnAndDeletePlateforms() {
        if (this.instanceManager.getPosLastPlateform() >= 0) {
            this.spawnNextPlateform();
        }

        if (this.instanceManager.getPosFirstPlateform() > this.display.getHeight()) {
            this.instanceManager.removePlateform();
        }
    }

    private void movePlateformsDown(double height) {
        for (APlateform p : this.instanceManager.getPlateforms()) {
            p.setPosY(p.getPosY() + height);
        }
    }

    private void moveJumperDown(Jumper jumper) {
        Positioner.setYTop(jumper, jumper.getPosY() + jumper.getJumpSpeed());
    }

    private void moveJumperUp(Jumper jumper) {
        Positioner.setYTop(jumper, jumper.getPosY() - jumper.getJumpSpeed());
    }

    private void updateScore(double score) {
        this.score += score;
        this.gameService.updateScore((int)Math.round(this.score));
    }

    protected void updateJumperSpeed(double speed) {
        this.instanceManager.getJumper().setSpeed(speed);
    }

    protected void updateJumperDirection(boolean direction) {
        this.instanceManager.getJumper().setDirection(direction);
    }
}
