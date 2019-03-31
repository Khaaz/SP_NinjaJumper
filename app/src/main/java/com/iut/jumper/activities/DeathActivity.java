package com.iut.jumper.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.iut.jumper.R;
import com.iut.jumper.core.ScoreManager;
import com.iut.jumper.models.Score;
import com.iut.jumper.utils.Constants;

public class DeathActivity extends AActivity {

    private int score;

    private SharedPreferences options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("JUMPER-Play", "onCreate");

        this.score = getIntent().getIntExtra("Score", 0);

        setContentView(R.layout.activity_death);
        TextView score = findViewById(R.id.score_scoreShow);
        score.setText(String.valueOf(this.score));

        this.options = getApplicationContext().getSharedPreferences(Constants.PREFERENCES_OPTIONS, 0);
        String name = this.options.getString(Constants.PREFERENCES_OPTIONS_NAME, "Name");
        TextView text = findViewById(R.id.score_pseudoEdit);
        text.setText(name);
    }


    public void replayButton(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        TextView textView = findViewById(R.id.score_pseudoEdit);
        String name = textView.getText().toString();

        this.options.edit().putString(Constants.PREFERENCES_OPTIONS_NAME, name).apply();

        ScoreManager.saveScore(new Score(this.score, name));
    }
}
