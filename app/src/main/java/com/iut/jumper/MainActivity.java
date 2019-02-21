package com.iut.jumper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.iut.jumper.activities.PlayActivity;
import com.iut.jumper.activities.ScoreActivity;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("JUMPER", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("JUMPER", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("JUMPER", "onRestart");
    }

    @Override
    protected void onPause() {
        Log.d("JUMPER", "onPause");
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d("JUMPER", "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        Log.d("JUMPER", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("JUMPER", "onDestroy");
        super.onDestroy();
    }
}
