package com.iut.jumper.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class AActivity extends AppCompatActivity {

    private String logTag = "JUMPER-" + this.getClass().getName();

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(logTag, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(logTag, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(logTag, "onRestart");
    }

    @Override
    protected void onPause() {
        Log.d(logTag, "onPause");
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(logTag, "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        Log.d(logTag, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(logTag, "onDestroy");
        super.onDestroy();
    }
}
