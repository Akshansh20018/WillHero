package com.example.demo.Weapons;

import javafx.scene.image.Image;

import static java.util.Objects.requireNonNull;

public class Sword extends Weapons{



        private int damage;
        public Sword(){
            super(20);
            Image img=new Image(requireNonNull(getClass().getResourceAsStream("WeaponSword.png")));;


            setImg(img,15);
            damage=100;
        }


    @Override
    public void onAction() {

    }
}
