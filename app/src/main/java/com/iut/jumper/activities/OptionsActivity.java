package com.iut.jumper.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.iut.jumper.R;

public class OptionsActivity extends AActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("JUMPER-Options", "onCreate");
        setContentView(R.layout.activity_options);

        Switch musique = (Switch)findViewById(R.id.musique);
        Switch difficulty = (Switch)findViewById(R.id.difficulty);

        RadioGroup skins = (RadioGroup)findViewById(R.id.skin);
        RadioButton skinB = (RadioButton)findViewById(R.id.skinBase);
        RadioButton skinM = (RadioButton)findViewById(R.id.skinMomie);
        RadioButton skinN = (RadioButton)findViewById(R.id.skinNoel);




    }


}
