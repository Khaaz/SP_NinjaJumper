package com.iut.jumper.models;

public class Score {

    private int score;
    private String user;

    public Score() {

    }

    public Score(int score, String user) {
        this.score = score;
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return this.user + " : " + String.valueOf(this.score);
    }
}
