package com.example.demo.elements;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static java.util.Objects.requireNonNull;

public class Boss extends Orc{

    Boss(){
        Image Boss=new Image(requireNonNull(getClass().getResourceAsStream("RedOrc_1.png")));
        ImageView img= new ImageView();
        img.setImage(Boss);
        img.setFitWidth(120);
        img.setPreserveRatio(true);

        AnchorPane dadada= new AnchorPane();
        dadada.getChildren().add(img);
        set_Image(dadada);
        Rectangle bottom= new Rectangle();
        bottom.setX(0);
        bottom.setY(110);
        bottom.setWidth(123);
        bottom.setFill(Color.HOTPINK);
        bottom.setHeight(3);
       // bottom.setVisible(true);
        dadada.getChildren().add(bottom);

        Rectangle top= new Rectangle();
        top.setX(0);
        top.setY(0);
        top.setWidth(123);
        top.setFill(Color.HOTPINK);
        top.setHeight(2);
        dadada.getChildren().add(top);

        Rectangle left= new Rectangle();
        left.setX(0);
        left.setY(0);
        left.setHeight(110);
        left.setFill(Color.HOTPINK);
        left.setWidth(20);
        left.setVisible(true);
        dadada.getChildren().add(left);
        setBoundary(bottom,top,left);
        //speed range between 500 600
        set_Jump_speed(500);
        jump();
        setHitpoints(300);
        setCoins(30);
        set_movelef(50);
    }


    public void Die(){
        System.out.println("YOU WON");



    }

}
