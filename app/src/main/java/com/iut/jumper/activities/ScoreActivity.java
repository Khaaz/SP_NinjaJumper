package com.iut.jumper.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.iut.jumper.R;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("JUMPER-Score", "onCreate");
        setContentView(R.layout.activity_scores);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("JUMPER-Score", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("JUMPER-Score", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("JUMPER-Score", "onRestart");
    }

    @Override
    protected void onPause() {
        Log.d("JUMPER-Score", "onPause");
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d("JUMPER-Score", "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        Log.d("JUMPER-Score", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("JUMPER-Score", "onDestroy");
        super.onDestroy();
    }
}
