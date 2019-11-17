package com.iut.jumper.core;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.iut.jumper.core.exceptions.DatabaseException;
import com.iut.jumper.interfaces.IDataStore;
import com.iut.jumper.models.Score;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class uses a minimalistic caching behavior to prevent getting the list from the JSON file every time.
 */
public class JsonStorage implements IDataStore {

    private Gson gson;

    private String path;

    private final Type TYPE = new TypeToken<List<Score>>() {}.getType();

    private List<Score> scoreList;

    public JsonStorage() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        this.scoreList = null;
    }

    public void setPath(String path) {
        this.path = path + "/scores.json";
    }

    @Override
    public void saveScoreList(List<Score> list) throws DatabaseException {
        this.scoreList = list;
        Log.d("JSON STORAGE", "SAVE");

        try {
            FileWriter writer = new FileWriter(this.path);
            this.gson.toJson(list, writer);
            writer.close();

        } catch (FileNotFoundException err) {
            this.createDefaultFile();

        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException("JSON-SAVE-ERROR", e);
        }
    }

    @Override
    public List<Score> getScoreList() throws DatabaseException {
        Log.d("JSON STORAGE", "GET");
        if (this.scoreList != null) {
            return this.scoreList;
        }
        try {
            FileReader reader = new FileReader(this.path);
            this.scoreList = this.gson.fromJson(reader, this.TYPE);
            reader.close();
            return this.scoreList;

        } catch (FileNotFoundException err) {
            this.createDefaultFile();
            return this.scoreList;

        } catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException("JSON-SAVE-ERROR", e);
        }
    }

    private void createDefaultFile() throws DatabaseException {
        this.scoreList = new ArrayList<>();

        try {
            File file = new File(this.path);
            file.createNewFile();

            FileReader reader = new FileReader(this.path);
            this.scoreList = this.gson.fromJson(reader, this.TYPE);
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException("JSON-SAVE-ERROR", e);
        }
    }
}
