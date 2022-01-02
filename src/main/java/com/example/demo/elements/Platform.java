package com.example.demo.elements;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.Random;

import static com.example.demo.CommonAnimation.runTranslateTransition;
import static java.util.Objects.requireNonNull;

public class Platform extends Game_Objects{

    private AnchorPane anchor_pane;
    private ImageView img;
    private Rectangle top;
    private Rectangle base;


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
        if(platform_type>=3 || platform_type<0){
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

 /*   private void create_platform_3() {
        anchor_pane=new AnchorPane();
        Double x=0.0;
        Rectangle rect;
        for(int i=0 ; i< 10 ; i++) {
            rect = new Rectangle();
            rect.setX(10);
            rect.setY(20 + x);
            rect.setWidth(0);
            rect.setFill(Color.DARKBLUE);
            rect.setHeight(2);
            rect.setVisible(true);
            anchor_pane.getChildren().add(rect);
            x=x+10.02;
        }
    }
*/
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
        top.setY(132);
        top.setWidth(140);
        top.setFill(Color.DARKBLUE);
        top.setHeight(2);
        top.setVisible(false);
        anchor_pane.getChildren().add(top);

        base = new Rectangle();
        base.setX(17);
        base.setY(142);
        base.setWidth(140);
        base.setFill(Color.PINK);
        base.setHeight(2);
        base.setVisible(false);
        anchor_pane.getChildren().add(base);
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
        top.setY(145);
        top.setWidth(420);
        top.setFill(Color.DARKBLUE);
        top.setHeight(2);
        top.setVisible(false);
        anchor_pane.getChildren().add(top);

        base = new Rectangle();
        base.setX(43);
        base.setY(158);
        base.setWidth(420);
        base.setFill(Color.PINK);
        base.setHeight(2);
        base.setVisible(false);
        anchor_pane.getChildren().add(base);
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
        top.setY(112);
        top.setWidth(170);
        top.setFill(Color.DARKBLUE);
        top.setHeight(2);
        top.setVisible(false);
        anchor_pane.getChildren().add(top);

        base = new Rectangle();
        base.setX(13);
        base.setY(122);
        base.setWidth(170);
        base.setFill(Color.PINK);
        base.setHeight(2);
        base.setVisible(false);
        anchor_pane.getChildren().add(base);
    }

    private void falling_platform() {
        anchor_pane= new AnchorPane();

        Rectangle floor= new Rectangle();
        floor.setWidth(10);
        floor.setHeight(4);
        floor.setFill(Color.BLACK);
        anchor_pane.getChildren().add(floor);

//        top = new Rectangle();
//        top.setX(13);
//        top.setY(102);
//        top.setWidth(170);
//        top.setFill(Color.DARKBLUE);
//        top.setHeight(2);
////        top.setVisible(false);
//        anchor_pane.getChildren().add(top);
    }

    public Rectangle getTop() {
        return top;
    }

    public int hasCollided(Hero hero, TranslateTransition fall) throws InterruptedException {
        ImageView img = hero.getImg();
        Rectangle rect = top;
        //System.out.println("ggagagaga");
        if((img.localToScreen(img.getBoundsInLocal()).intersects(rect.localToScreen(rect.getBoundsInLocal()))) && (img.localToScreen(img.getBoundsInLocal()).intersects(base.localToScreen(base.getBoundsInLocal()))==false)) {
            fall.pause();

            //runTranslateTransition(hero.get_Image(),0,-50,200).play();
            //ver_move(img,800, 150,false , 12000).play();
            hero.jump();
            return 1;
        }
        return 0;




    }


}
