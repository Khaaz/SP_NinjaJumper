package com.iut.jumper.core.managers.GameLoopManager;

import com.iut.jumper.core.managers.GameService;
import com.iut.jumper.interfaces.IService;
import com.iut.jumper.views.GameView;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameLoopService implements IService {

    private final GameLoopTask gameLoopTask;
    private final ScheduledExecutorService scheduler;

    public GameLoopService(GameService gameService, GameView gameView) {
        this.scheduler = Executors.newScheduledThreadPool(0);
        this.gameLoopTask = new GameLoopTask(scheduler, gameService, gameView);
        this.start();
    }


    @Override
    public void start() {
        this.gameLoopTask.start();
    }

    @Override
    public void resume() {
        this.gameLoopTask.resume();
    }

    @Override
    public void pause() {
        this.gameLoopTask.pause();
    }

    @Override
    public void stop() {
        this.gameLoopTask.pause();
        try {
            this.scheduler.awaitTermination(20, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
