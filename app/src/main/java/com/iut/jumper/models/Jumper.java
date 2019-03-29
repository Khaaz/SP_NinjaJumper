package com.iut.jumper.models;

import com.iut.jumper.R;
import com.iut.jumper.utils.Constants;

public class Jumper extends AEntity {

    private final int skin;
    private final int skinReverse;

    private final double jumpHeight;
    private final double jumpSpeed;
    private double jumpMultiplier;

    private boolean jumpDirection; // true = jumpe up | false = jump down
    private boolean direction; // true = move right | false = moveLeft

    public Jumper(int skin, int width, int height, double posX, double posY, double jumpHeight) {
        super(width, height, posX, posY);

        this.skin = skin;
        this.skinReverse = this.pickReversedSkin(skin);

        this.jumpSpeed = Constants.JUMP_SPEED;
        this.jumpHeight = jumpHeight;
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

    public int getSkin() {
        return skin;
    }

    public int getSkinReverse() {
        return skinReverse;
    }

    private int pickReversedSkin(int skin) {
        if (skin == R.drawable.ninjablanc_right) {
            return R.drawable.ninjablanc_left;
        }
        if (skin == R.drawable.ninjarouge_right) {
            return R.drawable.ninjarouge_left;
        }
        if (skin == R.drawable.ninjaviolet_right) {
            return R.drawable.ninjaviolet_left;
        }
        // default
        return R.drawable.ninjablanc_left;
    }
}
