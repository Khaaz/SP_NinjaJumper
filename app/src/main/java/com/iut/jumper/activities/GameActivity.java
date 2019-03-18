package com.iut.jumper.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.iut.jumper.R;
import com.iut.jumper.core.managers.GameService;
import com.iut.jumper.views.GameView;

public class GameActivity extends AActivity {

    private GameService gameService;
    private boolean paused;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("JUMPER-Play", "onCreate");

        setContentView(R.layout.activity_game);

        GameView gameView = findViewById(R.id.gameView);
        this.gameService = new GameService(this, gameView);
    }

    public GameService getGameService() {
        return gameService;
    }

    @Override
    protected void onStart() {
        this.paused = false;
        this.gameService.start();
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (!this.paused) {
            this.paused = true;
            this.gameService.pause();
        }
    }

    @Override
    protected void onResume() {
        if (this.paused) {
            this.paused = false;
            this.gameService.resume();
        }
        super.onResume();
    }

    @Override
    protected void onStop() {
        this.gameService.stop();
        // SAVE GAMEMANAGER STATE
        super.onStop();
    }


    @Override
    protected void onRestart() {
        // RESTORE GAMEMANAGER (instances + points etc)
        super.onRestart();
    }

    public void pauseButton(View view) {
        if (this.paused) {
            this.paused = false;
            this.gameService.resume();
        } else {
            this.paused = true;
            this.gameService.pause();
        }
    }
}
