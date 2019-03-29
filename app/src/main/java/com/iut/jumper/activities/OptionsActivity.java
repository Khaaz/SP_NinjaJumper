package com.iut.jumper.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;

import com.iut.jumper.R;
import com.iut.jumper.utils.Constants;

public class OptionsActivity extends AActivity{

    private SharedPreferences options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("JUMPER-Options", "onCreate");
        setContentView(R.layout.activity_options);

        this.options = getApplicationContext().getSharedPreferences(Constants.PREFERENCES_OPTIONS, 0);

        Switch  musique = (Switch)findViewById(R.id.musique);

        RadioButton skinB = (RadioButton)findViewById(R.id.skinblanc);
        RadioButton skinV = (RadioButton)findViewById(R.id.skinviolet);
        RadioButton skinR = (RadioButton)findViewById(R.id.skinrouge);


        musique.setChecked(options.getBoolean(Constants.PREFERENCES_OPTIONS_MUSIC, true));

        skinB.setChecked(options.getBoolean(Constants.PREFERENCES_OPTIONS_NINJAW, true));
        skinR.setChecked(options.getBoolean(Constants.PREFERENCES_OPTIONS_NINJAR, false));
        skinV.setChecked(options.getBoolean(Constants.PREFERENCES_OPTIONS_NINJAP, false));

        musique.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeValMusique(isChecked);
            }
        });

        skinB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                skinBlanc(isChecked);
            }
        });

        skinR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                skinRouge(isChecked);
            }
        });

        skinV.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                skinViolet(isChecked);
            }
        });

    }

    private void changeValMusique(boolean mus){
        this.options.edit().putBoolean(Constants.PREFERENCES_OPTIONS_MUSIC, mus).apply();
    }

    private void skinBlanc(boolean check){
        this.options.edit().putBoolean(Constants.PREFERENCES_OPTIONS_NINJAW, check).apply();
    }

    private void skinRouge(boolean check){
        this.options.edit().putBoolean(Constants.PREFERENCES_OPTIONS_NINJAR, check).apply();
    }

    private void skinViolet(boolean check){
        this.options.edit().putBoolean(Constants.PREFERENCES_OPTIONS_NINJAP, check).apply();
    }
}
