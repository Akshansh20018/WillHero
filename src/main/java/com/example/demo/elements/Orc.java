package com.example.demo.elements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

import static java.util.Objects.requireNonNull;


public class Orc extends Character {

    private Rectangle bottom;
    private Rectangle left;

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

        AnchorPane dadada= new AnchorPane();
        dadada.getChildren().add(img);
        set_Image(dadada);

        bottom= new Rectangle();
        bottom.setX(0);
        bottom.setY(45);
        bottom.setWidth(50);
        bottom.setFill(Color.HOTPINK);
        bottom.setHeight(2);
        dadada.getChildren().add(bottom);

        left= new Rectangle();
        left.setX(0);
        left.setY(0);
        left.setHeight(45);
        left.setFill(Color.BROWN);
        left.setWidth(2);
        dadada.getChildren().add(left);

        //speed range between 500 600
        set_Jump_speed(rand.nextInt(100)+500);
        jump();
    }
}