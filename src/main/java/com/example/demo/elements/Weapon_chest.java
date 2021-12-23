package com.example.demo.elements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

import static java.util.Objects.requireNonNull;

public class Weapon_chest extends  Game_Objects{
    public Weapon_chest(){

        Image Weapon = new Image(requireNonNull(getClass().getResourceAsStream("Weapon_Chest.png")));


        ImageView img= new ImageView();
        img.setImage(Weapon);
        img.setFitWidth(65);
        img.setPreserveRatio(true);
        set_Image(img);
        //speed range between 500 600

    }
}
