package com.iut.jumper.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.iut.jumper.R;
import com.iut.jumper.models.Score;

import java.util.Arrays;

import static com.iut.jumper.R.layout.activity_scores;

public class ScoreActivity extends AActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("JUMPER-Score", "onCreate");
        setContentView(activity_scores);

        ListView scores = (ListView)findViewById(R.id.scores);

        Score clem = new Score("clement", 350214);
        System.out.println(clem.toString());
        Score lulu = new Score("lucas", 88);
        Score theo = new Score("theo", 846486, false);

        Score[] lscores = new Score[]{clem, theo, lulu};
        Arrays.sort(lscores);

        ArrayAdapter<Score> arrayAdapter = new ArrayAdapter<Score>(this, android.R.layout.simple_list_item_1, lscores);

        scores.setAdapter(arrayAdapter);
    }

}
