package com.iut.jumper.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.iut.jumper.R;
import com.iut.jumper.activities.AActivity;
import com.iut.jumper.activities.GameActivity;
import com.iut.jumper.activities.OptionsActivity;
import com.iut.jumper.activities.ScoreActivity;

public class MainActivity extends AActivity {

    public static SharedPreferences options;
    public static SharedPreferences.Editor editor;

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
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void openOptions(View view){
        Log.d("JUMPER","openOptions");
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }
}
