package com.iut.jumper.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.iut.jumper.R;
import com.iut.jumper.models.Score;

import java.util.Arrays;

import static com.iut.jumper.R.layout.activity_scores;
import static java.lang.Integer.parseInt;

public class ScoreActivity extends AActivity {

    SharedPreferences scoresPref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("JUMPER-Score", "onCreate");
        setContentView(activity_scores);

        ListView scores = (ListView)findViewById(R.id.scores);

        scoresPref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = scoresPref.edit();

        //Score s1 = new Score("name", 15521);
        //String test = s1.toString2();
        //String[] test2 = test.split(";");
        //Score s2 = new Score(test2[0], parseInt(test2[1]));
        //String test3 = s2.toString2();
        //Log.d("test", test3);

        Score[] lscores = new Score[]{};
        Arrays.sort(lscores);

        ArrayAdapter<Score> arrayAdapter = new ArrayAdapter<Score>(this, android.R.layout.simple_list_item_1, lscores);

        scores.setAdapter(arrayAdapter);
    }

}
