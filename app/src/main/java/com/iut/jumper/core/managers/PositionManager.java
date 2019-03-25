package com.iut.jumper.core.managers;

import android.util.Log;
import android.view.Display;

import com.iut.jumper.interfaces.IUpdatable;
import com.iut.jumper.models.APlateform;
import com.iut.jumper.models.Jumper;
import com.iut.jumper.utils.Constants;
import com.iut.jumper.utils.Positioner;

import java.util.Random;

public class PositionManager implements IUpdatable {

    private final GameService gameService;
    private final InstanceManager instanceManager;

    private final Display display;

    private double currentJumpHeight;


    public PositionManager(GameService gameService) {
        this.gameService = gameService;

        this.instanceManager = gameService.getInstanceManager();

        this.display = this.gameService.getDisplay();

        this.currentJumpHeight = 0;

        this.initPlateforms();
    }

    public void update() {
        this.moveHorizontalJumper();
        this.moveVerticalJumper();
        this.spawnAndDeletePlateforms();
    }

    private void initPlateforms() {
        double totalHeight = this.display.getHeight();

        int minY = this.gameService.getDifficultyManager().getMinY();
        int maxY = this.gameService.getDifficultyManager().getMaxY();

        totalHeight -= (Constants.STARTING_X_PERCENTAGE * totalHeight);
        this.instanceManager.addPlateform(this.display.getWidth() / 2, totalHeight);

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

        int minY = this.gameService.getDifficultyManager().getMinY();
        int maxY = this.gameService.getDifficultyManager().getMaxY();

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
        if (this.currentJumpHeight >= jumper.getJumpHeight()) {

            jumper.setJumpDirection(false);
            this.moveJumperDown(jumper);

            return;
        }

        // Jumper at middle of the screen (move plateforms down)
        if (CollisionManager.isJumperAtMiddleScreen(jumper, this.display.getHeight())) {

            double reducer = this.calculateReducer(jumper);
            this.currentJumpHeight += (jumper.getJumpSpeed() * reducer);

            // smoother jump after moving plateforms down
            if (this.currentJumpHeight >= Constants.SMOOTH_JUMP_AT_MIDDLE_PERCENTAGE * jumper.getJumpHeight()) {
                this.movePlateformsDown((jumper.getJumpSpeed() * reducer) + Constants.SMOOTH_JUMP_AT_MIDDLE_MULTIPLIER);
            } else {
                this.movePlateformsDown(jumper.getJumpSpeed() * reducer);
            }

            this.updateScore(jumper.getJumpSpeed());

            return;
        }

        // default: move jumper  up
        this.moveJumperUp(jumper);

        if (this.gameService.getScore() < this.currentJumpHeight) {
            this.updateScore(this.currentJumpHeight);
        }
    }

    private void moveVerticalJumperDown(Jumper jumper) {

        // check collisions with plateforms
        for (APlateform p : this.instanceManager.getPlateforms()) {
            if (CollisionManager.checkJumperPlateformCollision(jumper, p)) {

                this.currentJumpHeight = 0;
                jumper.setJumpDirection(true);
                this.moveJumperUp(jumper);

                return;
            }
        }

        // Jumper outside of the screen - game over
        if (CollisionManager.isJumperOutsideScreenVertical(jumper, this.display.getHeight())) {
            this.gameService.handleDeath();
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
        double reducer = this.calculateReducer(jumper);

        this.currentJumpHeight -= (jumper.getJumpSpeed() * reducer);

        Positioner.setYTop(jumper, jumper.getPosY() + (jumper.getJumpSpeed() * reducer));
    }

    private void moveJumperUp(Jumper jumper) {
        double reducer = this.calculateReducer(jumper);

        this.currentJumpHeight += (jumper.getJumpSpeed() * reducer);
        Positioner.setYTop(jumper, jumper.getPosY() - (jumper.getJumpSpeed() * reducer));
    }

    private double calculateReducer(Jumper jumper) {
        double reducer = 1;

        // smoother jump (speed reduce when near max jump height)
        if (this.currentJumpHeight >= Constants.SMOOTH_JUMP_PERCENTAGE_3 * jumper.getJumpHeight()) {
            reducer = Constants.SMOOTH_JUMP_REDUCER_3;
        }
        else if (this.currentJumpHeight >= Constants.SMOOTH_JUMP_PERCENTAGE_2 * jumper.getJumpHeight()) {
            reducer = Constants.SMOOTH_JUMP_REDUCER_2;
        }
        else if (this.currentJumpHeight >= Constants.SMOOTH_JUMP_PERCENTAGE_1 * jumper.getJumpHeight()) {
            reducer = Constants.SMOOTH_JUMP_REDUCER_1;
        }

        return reducer;
    }

    private void updateScore(double score) {
        this.gameService.increaseScore((int)Math.round(score));
    }

    protected void updateJumperSpeed(double speed) {
        this.instanceManager.getJumper().setSpeed(speed);
    }

    protected void updateJumperDirection(boolean direction) {
        this.instanceManager.getJumper().setDirection(direction);
    }
}
