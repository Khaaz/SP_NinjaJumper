package com.iut.jumper.core.managers;

import android.util.Log;

public class GameLoop implements Runnable {

    private GameManager gameManager;
    private boolean running;

    public GameLoop(GameManager gameManager) {
        super();
        this.gameManager = gameManager;

        this.running = true;
    }

    public void pause() {
        this.running = false;
    }

    public void resume() {
        if (!this.running) {
            this.running = true;
            this.run();
        }
    }

    @Override
    public void run() {
        while (running) {
            try  {
                execute();
                Thread.sleep(16);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void execute() {
        Log.d("GAMELOOP", "beep");
    }
}
