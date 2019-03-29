package com.iut.jumper.core.managers;

import android.content.Context;
import android.util.Log;
import android.view.Display;

import com.iut.jumper.activities.GameActivity;
import com.iut.jumper.core.managers.GameLoopManager.GameLoopService;
import com.iut.jumper.interfaces.IService;
import com.iut.jumper.views.GameView;

public class GameService implements IService {

    private final GameActivity activity;

    private final SensorService sensorService;
    private GameLoopService gameLoopService;

    private final InstanceManager instanceManager;
    private final PositionManager positionManager;

    private final DifficultyManager difficultyManager;

    private final SoundManager soundManager;

    private final Display display;

    private int score;


    // CREATE - INSTANTIATE elements
    public GameService(Context context, Display display) {
        Log.d("GAMEMANAGER", "create)");

        this.score = 0;

        this.activity = (GameActivity)context;

        this.display = display;
        this.instanceManager = new InstanceManager(this);

        this.difficultyManager = new DifficultyManager(this.instanceManager.getJumper().getJumpHeight());

        this.positionManager = new PositionManager(this);

        this.sensorService = new SensorService(context, this);

        this.soundManager = new SoundManager(context, true);
        this.soundManager.playMusic();
    }

    public InstanceManager getInstanceManager() {
        return instanceManager;
    }

    public PositionManager getPositionManager() {
        return positionManager;
    }

    public DifficultyManager getDifficultyManager() {
        return difficultyManager;
    }

    public Display getDisplay() {
        return display;
    }

    public void startGameloop(GameView gameView) {
        this.gameLoopService = new GameLoopService(this, gameView);
    }

    @Override
    public void start() {
        Log.d("GAMEMANAGER", "start)");
    }

    @Override
    public void resume() {
        this.sensorService.start();
        this.gameLoopService.start();
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

    public void onJump() {
        this.soundManager.playJumpSound();
    }

    public void updateScore() {
        final GameActivity activity = this.activity;
        final int score = this.score;
        this.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                activity.updateScore(score);
            }
        });
    }

    protected void increaseScore(int score) {
        this.score += score/10;

        this.difficultyManager.checkScoreStep(this.score);
    }

    public int getScore() {
        return score;
    }

    public void handleDeath() {
        this.stop();
        this.activity.showMenu();
    }
}
