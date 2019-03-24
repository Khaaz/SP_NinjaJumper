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
    static RadioButton skinB;
    static RadioButton skinV;
    static RadioButton skinR;


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
        skinB = (RadioButton)findViewById(R.id.skinblanc);
        skinV = (RadioButton)findViewById(R.id.skinviolet);
        skinR = (RadioButton)findViewById(R.id.skinrouge);


        musique.setChecked(options.getBoolean("musique", true));
        difficulty.setChecked(options.getBoolean("hardmode", false));

        skinB.setChecked(options.getBoolean("blanc", true));
        skinR.setChecked(options.getBoolean("rouge", false));
        skinV.setChecked(options.getBoolean("violet", false));

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
        editor.putBoolean("musique", mus);
        editor.apply();
    }

    private void changeValDiff(boolean dif){
        editor.putBoolean("hardmode", dif);
        editor.apply();
    }

    private void skinBlanc(boolean check){
        editor.putBoolean("blanc", check);
        editor.apply();
    }

    private void skinRouge(boolean check){
        editor.putBoolean("rouge", check);
        editor.apply();
    }

    private void skinViolet(boolean check){
        editor.putBoolean("violet", check);
        editor.apply();
    }

    public static int skinChecked(){
        if (skinB.isChecked()){
            return R.drawable.ninjablanc_left;
        }
        else if (skinR.isChecked()){
            return R.drawable.ninjarouge_left;
        }
        else return R.drawable.ninjaviolet_left;
    }

    public static boolean music(){
        return musique.isChecked();
    }

    public static boolean hardmode(){
        return hardmode.isChecked();
    }
}
