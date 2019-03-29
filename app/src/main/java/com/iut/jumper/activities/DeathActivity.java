package com.iut.jumper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.iut.jumper.R;

public class DeathActivity extends AActivity {

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("JUMPER-Play", "onCreate");

        this.score = getIntent().getIntExtra("Score", 0);

        setContentView(R.layout.activity_death);
        TextView score = findViewById(R.id.score_scoreShow);
        score.setText(String.valueOf(this.score));
    }


    public void replayButton(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
