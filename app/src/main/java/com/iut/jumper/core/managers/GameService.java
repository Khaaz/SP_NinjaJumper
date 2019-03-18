package com.iut.jumper.core.managers;

import android.content.Context;
import android.util.Log;

import com.iut.jumper.core.managers.GameLoopManager.GameLoopService;
import com.iut.jumper.interfaces.IService;
import com.iut.jumper.views.GameView;

public class GameService implements IService {

    private final SensorService sensorService;
    private final GameLoopService gameLoopService;

    private final InstanceManager instanceManager;
    private final PositionManager positionManager;
    private final CollisionManager collisionManager;


    // CREATE - INSTANTIATE elements
    public GameService(Context context, GameView gameView) {
        Log.d("GAMEMANAGER", "create)");

        this.instanceManager = new InstanceManager();
        this.collisionManager = new CollisionManager();
        this.positionManager = new PositionManager(this);

        this.sensorService = new SensorService(context, this);
        this.gameLoopService = new GameLoopService(this, gameView);
    }

    public InstanceManager getInstanceManager() {
        return instanceManager;
    }

    public CollisionManager getCollisionManager() {
        return collisionManager;
    }

    public PositionManager getPositionManager() {
        return positionManager;
    }


    // START ELEMENTS
    @Override
    public void start() {
        this.sensorService.start();
        this.gameLoopService.start();
        Log.d("GAMEMANAGER", "start)");
    }

    // resume call on all services
    @Override
    public void resume() {
        this.sensorService.start();
        this.gameLoopService.resume();
        Log.d("GAMEMANAGER", "resume)");
    }

    // pause all services
    @Override
    public void pause() {
        this.sensorService.stop();
        this.gameLoopService.pause();
        Log.d("GAMEMANAGER", "pause)");
    }

    // STOP elements
    @Override
    public void stop() {
        this.sensorService.stop();
        this.gameLoopService.stop();
        Log.d("GAMEMANAGER", "stop)");
    }
}
