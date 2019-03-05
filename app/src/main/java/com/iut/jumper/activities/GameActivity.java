package com.iut.jumper.activities;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;

import com.iut.jumper.R;
import com.iut.jumper.core.managers.SensorService;
import com.iut.jumper.views.GameView;

public class GameActivity extends AActivity {

    SensorService sensorService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("JUMPER-Play", "onCreate");

        this.sensorService = new SensorService(this);
        //this.sensorService.start(); // called in onResume

        //GameView gameView = new GameView(this);
        //setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
        //setContentView(gameView);

        setContentView(R.layout.activity_play);
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.sensorService.stop();
    }

    @Override
    protected void onResume() {
        this.sensorService.start();
        super.onResume();
    }
}
