package com.example.demo.elements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

import static java.util.Objects.requireNonNull;


public class Orc extends Character {
    //coin,
    public Orc(){
        Random rand= new Random();
        int orc_type= rand.nextInt(4);
        Image orco=new Image(requireNonNull(getClass().getResourceAsStream("GreenOrc_1.png")));;
        if(orc_type==0)
        orco = new Image(requireNonNull(getClass().getResourceAsStream("GreenOrc_1.png")));
        if(orc_type==1)
            orco = new Image(requireNonNull(getClass().getResourceAsStream("RedOrc_1.png")));
        if(orc_type==2)
            orco = new Image(requireNonNull(getClass().getResourceAsStream("GreenOrc_2.png")));
        if(orc_type==3)
            orco = new Image(requireNonNull(getClass().getResourceAsStream("RedOrc_2.png")));


        ImageView img= new ImageView();
        img.setImage(orco);
        img.setFitWidth(50);
        img.setPreserveRatio(true);
        set_Image(img);
        //speed range between 500 600
        set_Jump_speed(rand.nextInt(100)+500);
        jump();
    }
}