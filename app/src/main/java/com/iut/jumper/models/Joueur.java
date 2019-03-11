package com.iut.jumper.models;

import java.io.Serializable;

public class Joueur {

    private String username;
    private Integer score;

    private boolean active;

    public Joueur(String username, Integer score, boolean active) {
        this.username = username;
        this.score = score;
        this.active = active;
    }

    public Joueur(String username, Integer score) {
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
        return "Joueur : " + username + "\n" +
                "Score   : " + score;
    }
}
