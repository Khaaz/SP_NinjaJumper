package com.iut.jumper.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.iut.jumper.R;
import com.iut.jumper.core.managers.GameManager;

public class GameActivity extends AActivity {


    private GameManager gameManager;
    private boolean paused;

    public boolean test = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("JUMPER-Play", "onCreate");

        this.paused = false;
        this.gameManager = new GameManager(this);
        this.gameManager.start();

        setContentView(R.layout.activity_game);
    }

    @Override
    protected void onPause() {
        this.paused = true;
        super.onPause();
        this.gameManager.pause();
    }

    @Override
    protected void onResume() {
        this.paused = false;
        this.gameManager.resume();
        super.onResume();
    }

    @Override
    protected void onStop() {
        this.paused = false;
        this.gameManager.stop();
        super.onStop();
    }

    public void pauseButton(View view) {
        if (this.paused) {
            this.paused = false;
            this.gameManager.resume();
        } else {
            this.paused = true;
            this.gameManager.pause();
        }
    }
}
