package com.example.demo.elements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import static java.util.Objects.requireNonNull;

public class Chest extends Game_Objects{

    public Chest(){
        Image Weapon = new Image(requireNonNull(getClass().getResourceAsStream("Weapon_Chest.png")));
        ImageView img= new ImageView();
        img.setImage(Weapon);
        img.setFitWidth(65);
        img.setPreserveRatio(true);
        AnchorPane dadada= new AnchorPane();
        dadada.getChildren().add(img);
        set_Image(dadada);
    }

}
