package com.iut.jumper.core.managers;

import com.iut.jumper.interfaces.IService;

public class GameLoopManager implements IService {

    private GameManager gameManager;

    private Thread currentThread;
    private GameLoop gameLoop;

    public GameLoopManager(GameManager gameManager) {
        this.gameManager = gameManager;
        this.start();
    }


    @Override
    public void start() {
        this.gameLoop = new GameLoop(this.gameManager);
        this.currentThread = new Thread(this.gameLoop);
        this.currentThread.start();
    }

    @Override
    public void resume() {
        this.gameLoop.resume();
    }

    @Override
    public void pause() {
        this.gameLoop.pause();
    }

    @Override
    public void stop() {
        this.currentThread.interrupt();
    }
}
