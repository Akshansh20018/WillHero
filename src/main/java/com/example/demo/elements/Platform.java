package com.example.demo.elements;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static com.example.demo.CommonAnimation.*;
import static java.util.Objects.requireNonNull;

public class Platform extends Game_Objects{

    private AnchorPane anchor_pane;
    private ImageView img;
    private Rectangle top;

    public Platform() throws IOException {

    //System.out.println("thisis plat");
       Random rand= new Random();
      int platform_type= rand.nextInt(2);
        get_platform_from_choice(platform_type);
    }

    public Platform(int choice){
        get_platform_from_choice(choice);
    }

    private void get_platform_from_choice(int platform_type ){
        if(platform_type>=4 || platform_type<0){
            System.out.println("invalid choice for platform");
            return;
        }

        if(platform_type==0){

            create_platform_0();
        }
        if(platform_type==1){
            create_platform_1();
        }
        if(platform_type==2){
            create_platform_2();
        }
    }

    private void create_platform_0(){
        anchor_pane=new AnchorPane();

        ImageView obj=new ImageView();
        Image plat=new Image(requireNonNull(getClass().getResourceAsStream("Platform1.png")));
        obj.setImage(plat);
        obj.setFitWidth(200);
        obj.setFitHeight(300);
        obj.setPreserveRatio(false);

        anchor_pane.getChildren().add(obj);
        set_Image(anchor_pane);

        top = new Rectangle();
        top.setX(17);
        top.setY(120);
        top.setWidth(140);
        top.setFill(Color.DARKBLUE);
        top.setHeight(2);
        anchor_pane.getChildren().add(top);
    }

    private void create_platform_1(){
        anchor_pane=new AnchorPane();

        ImageView obj=new ImageView();
        Image plat=new Image(requireNonNull(getClass().getResourceAsStream("Platform2.png")));
        obj.setImage(plat);
        obj.setFitWidth(500);
        obj.setFitHeight(300);
        obj.setPreserveRatio(false);

        anchor_pane.getChildren().add(obj);
        set_Image(anchor_pane);

        top = new Rectangle();
        top.setX(43);
        top.setY(135);
        top.setWidth(420);
        top.setFill(Color.DARKBLUE);
        top.setHeight(2);
        anchor_pane.getChildren().add(top);
    }
    private void create_platform_2(){
        anchor_pane=new AnchorPane();

        ImageView obj=new ImageView();
        Image plat=new Image(requireNonNull(getClass().getResourceAsStream("Platform3.png")));
        obj.setImage(plat);
        obj.setFitWidth(200);
        obj.setFitHeight(280);
        obj.setPreserveRatio(false);

        anchor_pane.getChildren().add(obj);
        set_Image(anchor_pane);

        top = new Rectangle();
        top.setX(13);
        top.setY(102);
        top.setWidth(170);
        top.setFill(Color.DARKBLUE);
        top.setHeight(2);
        anchor_pane.getChildren().add(top);
    }

    public Rectangle getTop() {
        return top;
    }
    public void hasCollided(ImageView img , TranslateTransition fall) throws InterruptedException {
        Rectangle rect = top;

        if(img.localToScreen(img.getBoundsInLocal()).intersects(rect.localToScreen(rect.getBoundsInLocal()))) {
            System.out.println("Platform collision found");
            fall.pause();
            //runTranslateTransition(hero.get_Image(),0,-50,200).play();
            //ver_move(img,800, 150,false , 12000).play();
            hero_jump(img).play();

        }
    }

}
