package com.example.demo.elements;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

import static com.example.demo.CommonAnimation.hero_jump;
import static com.example.demo.CommonAnimation.runTranslateTransition;
import static java.util.Objects.requireNonNull;


public class Orc extends Character {

    private Rectangle bottom;
    private Rectangle left;
    private Rectangle top;
    private ImageView img;
    private int coins;
    private int hitpoints;
    private double Moveleft=100;

    public Orc(){
        hitpoints= 500;
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

        coins= rand.nextInt(10);

        img= new ImageView();
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

        top= new Rectangle();
        top.setX(0);
        top.setY(0);
        top.setWidth(50);
        top.setFill(Color.HOTPINK);
        top.setHeight(2);
        dadada.getChildren().add(top);

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
    public void setHitpoints(int hitpoints){
       this.hitpoints=hitpoints;
    }
    public void setCoins(int coins){
        this.coins=coins;
    }

    public void setBoundary(Rectangle bottom , Rectangle top , Rectangle left) {
        this.bottom = bottom;
        this.top = top;
        this.left = left;
    }
    public void set_movelef(int move){
        Moveleft = move;
    }
    public void hasCollided(Hero hero, TranslateTransition fall) {


        if(hero.getImg().localToScreen(hero.getImg().getBoundsInLocal()).intersects(bottom.localToScreen(bottom.getBoundsInLocal()))) {
            //Game Over
        }

        if(hero.getImg().localToScreen(hero.getImg().getBoundsInLocal()).intersects(left.localToScreen(left.getBoundsInLocal()))) {

            runTranslateTransition(this.get_Image(), Moveleft, 0, 200).play();
           // runTranslateTransition(this.get_Image(), Moveleft, 0, 200).play();

            hitpoints -= hero.fight_orc();
        }

        if(hero.getImg().localToScreen(hero.getImg().getBoundsInLocal()).intersects(top.localToScreen(top.getBoundsInLocal()))) {
            fall.pause();
            hero.jump();
        }
        if(hitpoints<0)
            Die();
    }
    private void Die(){

        runTranslateTransition(this.get_Image(), +900, 0, 200).play();
        runTranslateTransition(this.get_Image(), 0, -300, 200).play();

    }
    public int getCoins() {
        return coins;
    }
}