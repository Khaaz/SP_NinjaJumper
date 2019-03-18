package com.iut.jumper.core.managers;


import android.util.Log;

import com.iut.jumper.interfaces.IUpdatable;

public class PositionManager implements IUpdatable {

    private final GameService gameService;
    private final InstanceManager instanceManager;
    private final CollisionManager collisionManager;

    public PositionManager(GameService gameService) {
        this.gameService = gameService;
        this.instanceManager = gameService.getInstanceManager();
        this.collisionManager = gameService.getCollisionManager();
    }

    public void update() {
        Log.d("POSITION-MANAGER", "update)");
    }

    public void updateJumperSpeed() {

    }
}
