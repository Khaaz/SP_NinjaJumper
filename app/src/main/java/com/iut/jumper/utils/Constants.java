package com.iut.jumper.utils;

public class Constants {
    public static final long FRAME_REFRESH_INTERVAL = 16;
    public static final double SENSOR_SENSIBILITY = 0.5;
    public static final double SENSOR_TO_SPEED_MULTIPLIER = 10;
    public static final double JUMP_SPEED = 25;

    public static final int INIT_PROBA_ONE_JUMP = 50;
    public static final double ONE_JUMP_TRESHOLD = 3000;
    public static final int STEP_ONE_JUMP = 1000;

    public static final int STEP_MIN_Y = 2000;
    public static final int STEP_MAX_Y = 1000;

    public static final double STARTING_MIN_Y_MULTIPLIER = 0.1;
    public static final double STARTING_MAX_Y_MULTIPLIER = 0.25;

    public static final double MIN_Y_STEP_MULTIPLIER = 0.2;
    public static final double MAX_Y_STEP_MULTIPLIER = 0.3;


    public static final double STARTING_X_PERCENTAGE = 0.05;

    public static final double SMOOTH_JUMP_AT_MIDDLE_PERCENTAGE = 0.95;
    public static final double SMOOTH_JUMP_AT_MIDDLE_MULTIPLIER = 5;

    public static final double SMOOTH_JUMP_PERCENTAGE_1 = 0.82;
    public static final double SMOOTH_JUMP_REDUCER_1 = 0.6;

    public static final double SMOOTH_JUMP_PERCENTAGE_2 = 0.88;
    public static final double SMOOTH_JUMP_REDUCER_2 = 0.4;

    public static final double SMOOTH_JUMP_PERCENTAGE_3 = 0.95;
    public static final double SMOOTH_JUMP_REDUCER_3 = 0.2;

    public static final double SCALE_JUMPER_HEIGHT = 0.18;
    public static final double SCALE_JUMPER_WIDTH = 0.10;
    public static final double SCALE_JUMPER_JUMP = 0.30;
    public static final double SCALE_PLATEFORM_HEIGHT = 0.012;
    public static final double SCALE_PLATEFORM_WIDTH = 0.15;

    public static final String PREFERENCES_OPTIONS = "Options";
    public static final String PREFERENCES_OPTIONS_NAME = "name";
    public static final String PREFERENCES_OPTIONS_MUSIC = "music";
    public static final String PREFERENCES_OPTIONS_NINJAW = "ninja_white";
    public static final String PREFERENCES_OPTIONS_NINJAP = "ninja_purple";
    public static final String PREFERENCES_OPTIONS_NINJAR = "ninja_red";
}
