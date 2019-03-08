package com.iut.jumper.core.managers;

import android.content.Context;
import android.util.Log;

public class GameManager {

    private SensorService sensorService;

    public GameManager(Context context) {
        this.sensorService = new SensorService(context);
    }

    // CREATE - INSTANTIATE elements
    public void start() {
        this.sensorService.start();
        Log.d("GAMEMANAGER", "start)");
    }

    // start/resume call on all services
    public void resume() {
        this.sensorService.start();
        Log.d("GAMEMANAGER", "resume)");
    }

    // pause all services
    public void pause() {
        this.sensorService.stop();
        Log.d("GAMEMANAGER", "pause)");
    }

    // STOP -DESTROY elements
    public void stop() {
        this.sensorService.stop();
        Log.d("GAMEMANAGER", "stop)");
    }
}
