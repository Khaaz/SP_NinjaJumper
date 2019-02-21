package com.iut.jumper.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.iut.jumper.R;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("JUMPER-Play", "onCreate");
        setContentView(R.layout.activity_play);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("JUMPER-Play", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("JUMPER-Play", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("JUMPER-Play", "onRestart");
    }

    @Override
    protected void onPause() {
        Log.d("JUMPER-Play", "onPause");
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d("JUMPER-Play", "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        Log.d("JUMPER-Play", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("JUMPER-Play", "onDestroy");
        super.onDestroy();
    }
}
