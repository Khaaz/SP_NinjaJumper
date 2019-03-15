package com.iut.jumper.models;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class Score implements Comparable<Score> {

    private String username;
    private Integer score;

    private boolean active;

    public Score(String username, Integer score, boolean active) {
        this.username = username;
        this.score = score;
        this.active = active;
    }

    public Score(String username, Integer score) {
        this.username = username;
        this.score = score;
        this.active = true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Score : " + username + "\nScore   : " + score;
    }

    @Override
    public int compareTo(@NonNull Score s) {
        return (this.score < s.score) ? 1 : ((this.score == s.score) ? 0 : -1);
    }
}
