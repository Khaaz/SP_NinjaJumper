package com.iut.jumper;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.iut.jumper.activities.AActivity;
import com.iut.jumper.activities.PlayActivity;
import com.iut.jumper.activities.ScoreActivity;

public class MainActivity extends AActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("JUMPER", "onCreate");

        setContentView(R.layout.activity_main);
    }

    public void openScore(View view) {
        Log.d("JUMPER", "openScore");
        Intent intent = new Intent(this, ScoreActivity.class);
        startActivity(intent);
    }

    public void openPlay(View view) {
        Log.d("JUMPER", "openPlay");
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }
}
