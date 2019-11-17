package com.iut.jumper.core.managers;

import com.iut.jumper.utils.Constants;

public class DifficultyManager {

    private double jumpHeight;
    private int maxHeight;

    private boolean isMaxYSet;
    private boolean isMinYSet;

    private int step;

    private int minY;
    private int maxY;

    private double minYMultiplier;
    private double maxYMultiplier;

    private boolean oneJumpPlateform;
    private int oneJumpStep;
    private int oneJumpProbability;

    public DifficultyManager(double jumpHeight) {
        this.jumpHeight = jumpHeight;
        this.maxHeight = (int) Math.round(jumpHeight * 0.9);
        this.isMaxYSet = false;
        this.isMinYSet = false;

        this.step = 0;

        this.oneJumpPlateform = false;
        this.oneJumpProbability = Constants.INIT_PROBA_ONE_JUMP;
        this.oneJumpStep = 0;

        this.minYMultiplier = Constants.STARTING_MIN_Y_MULTIPLIER;
        this.maxYMultiplier = Constants.STARTING_MAX_Y_MULTIPLIER;
        this.minY = (int) Math.round(this.jumpHeight * this.minYMultiplier);
        this.maxY = (int) Math.round(this.jumpHeight * this.maxYMultiplier);
    }

    protected void checkScoreStep(int score) {
        if (this.isMinYSet) {
            return;
        }

        if (!this.oneJumpPlateform && score > Constants.ONE_JUMP_TRESHOLD) {
            this.oneJumpPlateform = true;
        }
        if (this.oneJumpPlateform && this.oneJumpProbability > 1) {
            int oneJumpStep = score - (score % Constants.STEP_ONE_JUMP);
            if (oneJumpStep > this.oneJumpStep) {
                this.oneJumpStep = oneJumpStep;
                this.oneJumpProbability -= Constants.ONE_JUMP_DECREASE;
                if (this.oneJumpProbability < 1) {
                    this.oneJumpProbability = 1;
                }
            }
        }

        if (this.isMaxYSet) {

            int stepMin = score - (score % Constants.STEP_MIN_Y);
            if (stepMin > this.step) {
                this.step = stepMin;
                this.increaseDifficultyMin();
            }

        } else {

            int stepMax = score - (score % Constants.STEP_MAX_Y);
            if (stepMax > this.step) {
                this.step = stepMax;
                this.increaseDifficultyMax();
            }

        }
    }

    private void increaseDifficultyMin() {
        this.minYMultiplier = this.minYMultiplier + ((double) Math.round(this.minYMultiplier * Constants.MIN_Y_STEP_MULTIPLIER * 100) / 100);
        this.minY = (int)Math.round(this.jumpHeight * this.minYMultiplier);

        if (this.minY > this.maxHeight) {
            this.minY = this.maxHeight - 1;
            this.isMinYSet = true;
        }
    }

    private void increaseDifficultyMax() {
        this.maxYMultiplier = this.maxYMultiplier + ((double) Math.round(this.maxYMultiplier * Constants.MAX_Y_STEP_MULTIPLIER * 100) / 100);
        this.maxY = (int)Math.round(this.jumpHeight * this.maxYMultiplier);

        if (this.maxY > this.maxHeight) {
            this.maxY = maxHeight;
            this.isMaxYSet = true;
        }
    }

    protected int getMinY() {
        return minY;
    }

    protected int getMaxY() {
        return maxY;
    }

    public boolean isOneJumpPlateform() {
        return oneJumpPlateform;
    }

    public int getOneJumpProbability() {
        return oneJumpProbability;
    }

    public void setOneJumpProbability(int oneJumpProbability) {
        this.oneJumpProbability = oneJumpProbability;
    }
}
