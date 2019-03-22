package com.iut.jumper.models;

import com.iut.jumper.R;
import com.iut.jumper.utils.Constants;

public class Jumper extends AEntity {

    private final double jumpHeight;
    private final double jumpSpeed;
    private double jumpMultiplier;

    private boolean jumpDirection; // true = jumpe up | false = jump down
    private boolean direction; // true = move right | false = moveLeft

    public Jumper(int width, int height) {
        super(R.drawable.ninja, width, height);

        this.jumpSpeed = Constants.JUMP_SPEED;
        this.jumpHeight = Constants.JUMP_HEIGHT;
        this.jumpMultiplier = 0;

        this.direction = true;
        this.jumpDirection = true;
    }

    public double getJumpHeight() {
        return jumpHeight;
    }

    public double getJumpSpeed() {
        return jumpSpeed;
    }

    public double getJumpMultiplier() {
        return jumpMultiplier;
    }

    public boolean getDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public boolean getJumpDirection() {
        return jumpDirection;
    }

    public void setJumpDirection(boolean jumpDirection) {
        this.jumpDirection = jumpDirection;
    }
}
