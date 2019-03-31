package com.iut.jumper.core;

import android.util.Log;

import com.iut.jumper.core.exceptions.DatabaseException;
import com.iut.jumper.interfaces.IDataStore;
import com.iut.jumper.models.Score;

import java.util.ArrayList;
import java.util.List;

public class ScoreManager {

    private static IDataStore dataStore = new JsonStorage();

    public static void setJsonStoragePath(String path) {
        ((JsonStorage)dataStore).setPath(path);
    }

    public static List<Score> getScores() {
        try {
            List<Score> list = dataStore.getScoreList();
            return list;
        } catch (DatabaseException e) {
            return null;
        }
    }

    public static boolean saveScore(Score score){
        List<Score> list = ScoreManager.getScores();
        if (list == null) {
            Log.d("JSON MANAGER", "NULLLL");
            list = new ArrayList<>();
        }

        boolean changed = ScoreManager.addScore(score, list);

        if (!changed) {
            return false;
        }

        try {
            dataStore.saveScoreList(list);
            return true;
        } catch (DatabaseException e) {
            return false;
        }
    }

    private static boolean addScore(Score score, List<Score> list) {
        for (int i = 0; i < list.size(); i++) {
            if (score.getScore() > list.get(i).getScore()) {
                list.add(i ,score);

                if (list.size() > 10) {
                    list.remove(10);
                }
                return true;
            }
        }

        if (list.size() < 11) {
            list.add(score);
            return true;
        }

        return false;
    }
}
