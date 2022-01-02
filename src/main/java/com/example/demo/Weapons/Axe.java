package com.example.demo.Weapons;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static java.util.Objects.requireNonNull;

public class Axe extends  Weapons {

    private int damage;
    public Axe(){
        super(10);
        Image img=new Image(requireNonNull(getClass().getResourceAsStream("WeaponAxe.png")));;
        setImg(img,25);
        damage=100;
    }

    @Override
    public void onAction() {

    }
}
