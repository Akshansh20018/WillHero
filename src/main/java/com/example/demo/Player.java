package com.example.demo;

import java.io.Serializable;

public class Player implements Serializable {
    private int score;
    private int weapons;
    private int coins;
    Player(int score , int weapons , int coins){
        this.score = score;
        this.weapons=weapons;
        this.coins = coins;
    }
    Player(){
        this.score = 0;
        this.weapons = -1;
        this.coins = 0;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getWeapons() {
        return weapons;
    }

    public void setWeapons(int weapons) {
        this.weapons = weapons;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
