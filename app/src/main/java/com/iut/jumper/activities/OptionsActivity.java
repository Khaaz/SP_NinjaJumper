package com.iut.jumper.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.iut.jumper.R;

public class OptionsActivity extends AActivity{

    SharedPreferences options;
    SharedPreferences.Editor editor;

    Switch musique;
    Switch difficulty;

    RadioGroup skins;
    RadioButton skinB;
    RadioButton skinM;
    RadioButton skinN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("JUMPER-Options", "onCreate");
        setContentView(R.layout.activity_options);

        options = PreferenceManager.getDefaultSharedPreferences(this);
        editor = options.edit();

        musique = (Switch)findViewById(R.id.musique);
        difficulty = (Switch)findViewById(R.id.difficulty);

        skins = (RadioGroup)findViewById(R.id.skin);
        skinB = (RadioButton)findViewById(R.id.skinBase);
        skinM = (RadioButton)findViewById(R.id.skinMomie);
        skinN = (RadioButton)findViewById(R.id.skinNoel);


        musique.setChecked(options.getBoolean("musique", true));
        difficulty.setChecked(options.getBoolean("hardmode", false));

        skinB.setChecked(options.getBoolean("base", true));
        skinM.setChecked(options.getBoolean("momie", false));
        skinN.setChecked(options.getBoolean("noel", false));



        musique.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeValMusique(isChecked);
            }
        });

        difficulty.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeValDiff(isChecked);
            }
        });

        skinB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                skinBase(isChecked);
            }
        });

        skinM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                skinMomie(isChecked);
            }
        });

        skinN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                skinNoel(isChecked);
            }
        });

    }

    private void changeValMusique(boolean mus){
        editor.putBoolean("musique", mus);
        editor.apply();
    }

    private void changeValDiff(boolean dif){
        editor.putBoolean("hardmode", dif);
        editor.apply();
    }

    private void skinBase(boolean check){
        editor.putBoolean("base", check);
        editor.apply();
    }

    private void skinMomie(boolean check){
        editor.putBoolean("momie", check);
        editor.apply();
    }

    private void skinNoel(boolean check){
        editor.putBoolean("noel", check);
        editor.apply();
    }

}
