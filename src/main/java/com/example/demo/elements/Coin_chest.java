package com.example.demo.elements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

import static java.util.Objects.requireNonNull;

public class Coin_chest extends Chest{
        private int coins;

        public Coin_chest(){

            super();
            Random rand= new Random();
            int coins= rand.nextInt(2);

        }

}
