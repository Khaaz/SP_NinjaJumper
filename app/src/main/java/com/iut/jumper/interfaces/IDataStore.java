package com.iut.jumper.interfaces;

import com.iut.jumper.core.exceptions.DatabaseException;
import com.iut.jumper.models.Score;

import java.util.List;

public interface IDataStore {

    void saveScoreList(List<Score> list) throws DatabaseException;

    List<Score> getScoreList() throws DatabaseException;

}
