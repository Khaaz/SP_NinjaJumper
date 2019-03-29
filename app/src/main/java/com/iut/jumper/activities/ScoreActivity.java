package com.iut.jumper.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.iut.jumper.R;
import com.iut.jumper.models.Score;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.iut.jumper.R.layout.activity_scores;
import static java.lang.Integer.parseInt;

public class ScoreActivity extends AActivity {

    static SharedPreferences scoresPref;
    static SharedPreferences.Editor editor;
    static List<Score> lscores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("JUMPER-Score", "onCreate");
        setContentView(activity_scores);

        ListView scores = (ListView)findViewById(R.id.scores);

        scoresPref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = scoresPref.edit();

        lscores = chargerScores();

        Score s = new Score("theo", 54864);
        lscores = ajouterScore(lscores, s);

        //lscores = enleverScoreNull(lscores);

        lscores = sortList(lscores);
        ArrayAdapter<Score> arrayAdapter = new ArrayAdapter<Score>(this, android.R.layout.simple_list_item_1, lscores);

        scores.setAdapter(arrayAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Jumper-Score", "onDestroy");
        sauvegarderScores(lscores);
    }

    void sauvegarderScores(List<Score> scores){
        int size = scores.size();
        for (int i = 0; i < size; i++){
            String s = scores.get(i).toString2();
            editor.putString("score" + i,s);
            Log.d("test", "score" + i);
        }
        if (size < 10){
            for ( int j = size; j < 10; j++){
                editor.putString("score" + j,"inconnue;0");
            }
        }
        editor.apply();
    }

    private List<Score> chargerScores(){
      List<Score> tabs = new ArrayList<>();
      for (int i =0; i < 10; i++){
          String s = scoresPref.getString("score" + i, "inconnue;0" );
          String[] tab = s.split(";");
          Score sco = new Score(tab[0], parseInt(tab[1]));
          tabs.add(sco);
      }
      return tabs;
    };

    private static List<Score> sortList(List<Score> lscores){
        int indmax;
        List<Score> sortList = new ArrayList<>();
        int size = lscores.size();
        for (int i = 0; i< size; i++){
            indmax = getIndMax(lscores);
            sortList.add(lscores.get(indmax));
            lscores.remove(indmax);
        }
        return sortList;
    }

    private static int getIndMax(List<Score> lscores){
        int max = 0;
        int ind = 0;
        for (int i =0; i<lscores.size(); i++){
            if (lscores.get(i).getScore() > max){
                max = lscores.get(i).getScore();
                ind = i;
            }
        }
        return ind;
    }

    static List<Score> ajouterScore(List<Score> ls, Score s){
        int taille = ls.size();
        if (s.getScore() > ls.get(taille-1).getScore()){
            ls.remove(taille-1);
            ls.add(s);
            ls = sortList(ls);
        }
        return ls;
    }

    private List<Score> enleverScoreNull(List<Score> ls){
        int size = ls.size();
        for ( int i = 0; i < size; i++){
            if (ls.get(i).getScore() == 0){
                ls.remove(i);
            }
        }
        return ls;
    }
}
