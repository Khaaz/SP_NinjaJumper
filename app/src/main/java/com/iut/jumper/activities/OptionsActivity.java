package com.iut.jumper.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.iut.jumper.R;
import com.iut.jumper.models.Joueur;

public class OptionsActivity extends AActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("JUMPER-Options", "onCreate");
        setContentView(R.layout.activity_options);


    }


}
