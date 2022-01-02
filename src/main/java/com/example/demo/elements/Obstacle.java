package com.example.demo.elements;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import static com.example.demo.CommonAnimation.runTranslateTransition;

import static java.util.Objects.requireNonNull;

public class Obstacle {
    private ArrayList<Game_Objects> content=new ArrayList<Game_Objects>();
//    Rectangle top;
    AnchorPane anchor_pane;
    public double length;
    public double coordinate;
    private Hero hero;
    private Platform plat;


    public Obstacle(Hero hero) throws IOException {

        //System.out.println("thisis plat");
        Random rand= new Random();
        int obstacle_type= rand.nextInt(3);
//        obstacle_type= 2;
        get_obstacle_from_choice(obstacle_type);
//        obs_timer.start();
        this.hero= hero;
    }

    public Obstacle(int choice, Hero hero){
        get_obstacle_from_choice(choice);
//        obs_timer.start();
        this.hero= hero;
    }

    private void get_obstacle_from_choice(int obstacle_type ){
        if(obstacle_type>=3 || obstacle_type<0){
            System.out.println("invalid choice for platform");
            return;
        }

        if(obstacle_type==0){
            create_obstacle_0();
        }
        if(obstacle_type==1){
            create_obstacle_1();
        }
        if(obstacle_type==2){
            create_obstacle_2();
        }
    }

    private void create_obstacle_0(){
        anchor_pane=new AnchorPane();

        AnchorPane obj=new AnchorPane();
        plat = new Platform(0);
        obj = plat.get_Image();
        AnchorPane.setTopAnchor(obj, 115.0);
        AnchorPane.setLeftAnchor(obj, 65.0);
        anchor_pane.getChildren().add(obj);
        this.length=140;
    }

    private void create_obstacle_1(){
        Random rand= new Random();

        anchor_pane=new AnchorPane();
        double x = 10;
        int choice=2;
             /*0->Chest
               1-> Orc
               2-> Orc*/

        AnchorPane obj=new AnchorPane();
        plat = new Platform(1);
        obj = plat.get_Image();
        AnchorPane.setTopAnchor(obj, 100.0);
        AnchorPane.setLeftAnchor(obj, 65.0);
        anchor_pane.getChildren().add(obj);
        this.length=420;
        boolean chest_found = false;

        for(int i=0 ; i<4 ; i++) {
            x=x+100;
            choice= rand.nextInt(3);
            if(choice==0&&chest_found){
                choice=1+ rand.nextInt(2);

            }
//Adding here
            choice= 0;
            if (choice == 0) {

                chest_found=true;
                Chest chest = null;

                choice=rand.nextInt(2);
//                choice= 1;
                if(choice==1){
                    chest = new Weapon_chest();
                }
                else if(choice==0){
                    chest = new Coin_chest();
                }
                obj = chest.get_Image();
                content.add(chest);
            }

            else if (choice == 1) {
                Orc orc = new Orc();
                obj = orc.get_Image();
                content.add(orc);
            }

            else if (choice == 2) {
                Orc orc = new Orc();
                obj = orc.get_Image();
                content.add(orc);
            }

            AnchorPane.setTopAnchor(obj, 200.0);
            AnchorPane.setLeftAnchor(obj, x);



            anchor_pane.getChildren().add(obj);

        }

    }

    private void create_obstacle_2(){
        anchor_pane=new AnchorPane();

        AnchorPane obj=new AnchorPane();
        plat = new Platform(2);
        obj = plat.get_Image();
        AnchorPane.setTopAnchor(obj, 135.0);
        AnchorPane.setLeftAnchor(obj, 65.0);
        anchor_pane.getChildren().add(obj);
        this.length=170;

    }

//    public Rectangle get_Top() {
//        return top ;
//    }

    public void setCoordinate(double coordinate) {
        this.coordinate = coordinate;
    }

    public double getCoordinate() {
        return coordinate;
    }

    public void translate_obstacle(double x , double y ,double duration){

        runTranslateTransition(anchor_pane,x,y,duration).play();
    }

    public Pane getAnchor_pane() {
        return this.anchor_pane;
    }

//    AnimationTimer obs_timer= new AnimationTimer() {
//        @Override
//        public void handle(long l) {
//            System.out.println("hello");
////            hasCollided(hero.getImg(), plat.getTop());
//        }
//    };

    public Platform getPlat() {
        return this.plat;
    }

    public ArrayList<Game_Objects> getGameObjects() {
        return content;
    }
}
