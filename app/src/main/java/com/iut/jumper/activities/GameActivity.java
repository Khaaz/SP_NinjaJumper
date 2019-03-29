package com.iut.jumper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iut.jumper.R;
import com.iut.jumper.core.managers.GameService;
import com.iut.jumper.views.GameView;

public class GameActivity extends AActivity {

    private GameService gameService;
    private boolean paused;
    private boolean music;
    private boolean hardmode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("JUMPER-Play", "onCreate");

        //music = OptionsActivity.music();
        //hardmode = OptionsActivity.hardmode();

        Display display = getWindowManager().getDefaultDisplay();

        this.gameService = new GameService(this, display);

        setContentView(R.layout.activity_game);

        GameView gameView = findViewById(R.id.gameView);
        this.gameService.startGameloop(gameView);

        this.paused = false;
    }

    public GameService getGameService() {
        return gameService;
    }

    public void showMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        //this.gameService.start();
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (this.paused) {
            this.gameService.pause();
        }
    }

    @Override
    protected void onResume() {
        if (!this.paused) {
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

    public void updateScore(int score) {
        TextView scoreText = findViewById(R.id.textViewScore);
        scoreText.setText(String.valueOf(score));
    }

    public void pauseButton(View view) {
        if (!this.paused) {
            this.paused = true;
            this.gameService.pause();
            view.setVisibility(View.GONE);

            ImageView playButton = findViewById(R.id.imageViewPlay);
            playButton.setVisibility(View.VISIBLE);
        }
    }

    public void playButton(View view) {
        if (this.paused) {
            this.paused = false;
            this.gameService.resume();

            view.setVisibility(View.GONE);

            ImageView playButton = findViewById(R.id.imageViewPause);
            playButton.setVisibility(View.VISIBLE);
        }
    }
}
