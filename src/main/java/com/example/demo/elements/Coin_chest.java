package com.example.demo.elements;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Random;

import static java.util.Objects.requireNonNull;

public class Coin_chest extends Chest{
    private int coins;
    private Image poppingCoin_img;
    private ImageView poppingCoin_View;


    public Coin_chest(){

        super();
        AnchorPane dadada= super.getAnchorPane();

        Image coin_img= new Image(requireNonNull(getClass().getResourceAsStream("coins.png")));
        ImageView coin_imgView= new ImageView();
        coin_imgView.setImage(coin_img);
        coin_imgView.setX(10);
        coin_imgView.setY(9);
        coin_imgView.setFitWidth(35);
        coin_imgView.setPreserveRatio(true);
        dadada.getChildren().add(coin_imgView);

        super.setAnchorPane(dadada);

//        poppingCoin_img= new Image(requireNonNull(getClass().getResourceAsStream("popping_coin.png")));
//        poppingCoin_View= new ImageView();
//        poppingCoin_View.setImage(poppingCoin_img);
//        poppingCoin_View.setX(10);
//        poppingCoin_View.setY(9);
//        poppingCoin_View.setFitWidth(40);
//        poppingCoin_View.setPreserveRatio(true);
//        poppingCoin_View.setVisible(false);

        Random rand= new Random();
        coins= 2+rand.nextInt(3);
    }

    public int getCoins() {
        return this.coins;
    }

    public int hasCollided(Hero hero, TranslateTransition fall) {
        int temp= super.haveCollided(hero.getImg(), fall);
        if(temp==1) {
            hero.setCoins(hero.getCoins()+coins);
        }
        return 1;
    }
}
