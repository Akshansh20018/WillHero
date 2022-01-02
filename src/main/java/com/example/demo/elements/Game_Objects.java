package com.example.demo.elements;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Game_Objects implements java.io.Serializable{
    AnchorPane Image;
    ImageView Img;
    protected void set_Image(AnchorPane Image ){
        this.Image = Image;
    }
    public AnchorPane get_Image(){
        return this.Image;
    }
    protected void setImg(ImageView Image ){
        this.Img = Image;
    }
    public ImageView getImg(){
        return this.Img;
    }

    public int hasCollided(Hero hero, TranslateTransition hero_falling) throws InterruptedException {return 1;}
}