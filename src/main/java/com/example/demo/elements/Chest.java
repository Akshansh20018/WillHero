package com.example.demo.elements;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import static java.util.Objects.requireNonNull;

public class Chest extends Game_Objects{

    Image Weapon;
    ImageView img;
    Image Weapon2;
    ImageView img2;
    AnchorPane dadada;

    public Chest(){
        dadada= new AnchorPane();
        set_Image(dadada);
        Weapon = new Image(requireNonNull(getClass().getResourceAsStream("Weapon_Chest.png")));
        img= new ImageView();
        img.setImage(Weapon);
        img.setFitWidth(65);
        img.setPreserveRatio(true);
        dadada.getChildren().add(img);

        Weapon2 = new Image(requireNonNull(getClass().getResourceAsStream("HERO.png")));
        img2= new ImageView();
        img2.setImage(Weapon);
        img2.setFitWidth(65);
        img2.setPreserveRatio(true);
    }

    public int haveCollided(ImageView hero, TranslateTransition fall) {
        if(hero.localToScreen(hero.getBoundsInLocal()).intersects(img.localToScreen(img.getBoundsInLocal()))) {
            System.out.println("Chest");
            dadada.getChildren().remove(0);
//            dadada.getChildren().add(img2);
            return 1;
        }
        return 0;
    }

}
