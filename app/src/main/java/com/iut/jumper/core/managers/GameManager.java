package com.iut.jumper.core.managers;

import android.content.Context;
import android.util.Log;

public class GameManager {

    private SensorService sensorService;
    private GameLoopManager gameLoopManager;

    public GameManager(Context context) {
        this.sensorService = new SensorService(context);
        this.gameLoopManager = new GameLoopManager(this);
    }

    // CREATE - INSTANTIATE elements
    public void start() {
        this.sensorService.start();
        this.gameLoopManager.start();
        Log.d("GAMEMANAGER", "start)");
    }

    // start/resume call on all services
    public void resume() {
        this.sensorService.start();
        this.gameLoopManager.resume();
        Log.d("GAMEMANAGER", "resume)");
    }

    // pause all services
    public void pause() {
        this.sensorService.stop();
        this.gameLoopManager.pause();
        Log.d("GAMEMANAGER", "pause)");
    }

    // STOP -DESTROY elements
    public void stop() {
        this.sensorService.stop();
        this.gameLoopManager.stop();
        Log.d("GAMEMANAGER", "stop)");
    }
}
