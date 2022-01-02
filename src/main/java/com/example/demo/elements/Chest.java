package com.example.demo.elements;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import static java.util.Objects.requireNonNull;

public class Chest extends Game_Objects{

    Image Weapon;
    ImageView img;
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
    }

    public int haveCollided(ImageView hero, TranslateTransition fall) {
        if(hero.localToScreen(hero.getBoundsInLocal()).intersects(img.localToScreen(img.getBoundsInLocal()))) {
//            System.out.println("Chest");
            dadada.getChildren().remove(0);
            Weapon = new Image(requireNonNull(getClass().getResourceAsStream("ChestOpen.png")));
            img= new ImageView();
            img.setImage(Weapon);
            img.setFitWidth(75);
            img.setPreserveRatio(true);
            dadada.getChildren().add(img);
//            dadada.getChildren().add(img2);
            return 1;
        }
        return 0;
    }

    public AnchorPane getAnchorPane() {
        return dadada;
    }

    public void setAnchorPane(AnchorPane dadada) {
        this.dadada= dadada;
    }

}
