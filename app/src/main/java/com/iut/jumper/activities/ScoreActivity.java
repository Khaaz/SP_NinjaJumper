package com.iut.jumper.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.iut.jumper.R;
import com.iut.jumper.core.ScoreManager;
import com.iut.jumper.models.Score;

import java.util.ArrayList;
import java.util.List;

public class ScoreActivity extends AActivity {

    private List<Score> scoreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("JUMPER-Score", "onCreate");

        setContentView(R.layout.activity_scores);

        ListView scores = findViewById(R.id.scores);

        this.scoreList = ScoreManager.getScores();

        if (this.scoreList == null) {
            this.scoreList = new ArrayList<>();
        }

        ArrayAdapter<Score> arrayAdapter = new ArrayAdapter<Score>(this, android.R.layout.simple_list_item_1, this.scoreList);
        scores.setAdapter(arrayAdapter);
    }
}
