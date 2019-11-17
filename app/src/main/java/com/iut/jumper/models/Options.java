package com.iut.jumper.models;

import android.content.SharedPreferences;

import com.iut.jumper.R;
import com.iut.jumper.utils.Constants;

public class Options {
    private boolean music;

    private boolean ninjaW;
    private boolean ninjaP;
    private boolean ninjaR;

    private int ninja;

    public Options(SharedPreferences preferences) {
        this.music = preferences.getBoolean(Constants.PREFERENCES_OPTIONS_MUSIC, true);

        this.ninjaW = preferences.getBoolean(Constants.PREFERENCES_OPTIONS_NINJAW, true);
        this.ninjaP = preferences.getBoolean(Constants.PREFERENCES_OPTIONS_NINJAP, false);
        this.ninjaR = preferences.getBoolean(Constants.PREFERENCES_OPTIONS_NINJAR, false);

        if (this.ninjaR) {
            this.ninja = R.drawable.redninja_right;
        } else if (this.ninjaP) {
            this.ninja = R.drawable.purpleninja_right;
        } else {
            this.ninja = R.drawable.whiteninja_right;
        }
    }

    public boolean isMusic() {
        return music;
    }

    public int getNinja() {
        return ninja;
    }

    public boolean isNinjaW() {
        return ninjaW;
    }

    public boolean isNinjaP() {
        return ninjaP;
    }

    public boolean isNinjaR() {
        return ninjaR;
    }
}
