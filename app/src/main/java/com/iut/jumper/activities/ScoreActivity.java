package com.iut.jumper.activities;

import android.os.Bundle;
import android.util.Log;

import com.iut.jumper.R;

public class ScoreActivity extends AActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("JUMPER-Score", "onCreate");
        setContentView(R.layout.activity_scores);
    }

}
