package com.example.demo.elements;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

import static java.util.Objects.requireNonNull;

public class Coin_chest extends Chest{
    private int coins;

    public Coin_chest(){

        super();
        Random rand= new Random();
        coins= rand.nextInt(5);
    }

    public int getCoins() {
        return this.coins;
    }

    public void hasCollided(Hero hero, TranslateTransition fall) {
        int temp= super.haveCollided(hero.getImg(), fall);
        if(temp==1) {
            hero.setCoins(hero.getCoins()+coins);
        }
    }
}
