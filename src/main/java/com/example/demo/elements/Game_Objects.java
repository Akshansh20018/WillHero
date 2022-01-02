package com.example.demo.elements;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Game_Objects {
    AnchorPane Image;

    protected void set_Image(AnchorPane Image ){
        this.Image = Image;
    }
    public AnchorPane get_Image(){
        return this.Image;
    }
    public void hasCollided(Hero hero, TranslateTransition hero_falling) throws InterruptedException {}
}
