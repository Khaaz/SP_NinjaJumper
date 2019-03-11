package com.iut.jumper.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.iut.jumper.R;
import com.iut.jumper.models.Joueur;

import static com.iut.jumper.R.layout.activity_scores;

public class ScoreActivity extends AActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("JUMPER-Score", "onCreate");
        setContentView(activity_scores);

        ListView scores = (ListView)findViewById(R.id.scores);

        Joueur clem = new Joueur("clement", 350214);
        System.out.println(clem.toString());
        Joueur lulu = new Joueur("lucas", 88);
        Joueur theo = new Joueur("theo", 846486, false);

        Joueur[] joueurs = new Joueur[]{clem, theo, lulu};

        ArrayAdapter<Joueur> arrayAdapter = new ArrayAdapter<Joueur>(this, android.R.layout.simple_list_item_1, joueurs);

        scores.setAdapter(arrayAdapter);
    }

}
