package com.example.demo.elements;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static com.example.demo.CommonAnimation.runTranslateTransition;
import static java.util.Objects.requireNonNull;

public class Platform {
    ArrayList<ImageView> content=new ArrayList<ImageView>();
    AnchorPane anchor_pane;
    public double length;
    public double coordinate;

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
    }
    private void create_platform_0(){
        try {
            anchor_pane=  FXMLLoader.load(getClass().getResource("Obstacle_1.fxml"));
        }catch(Exception e){
            System.out.println("image not loaded");
        }

        //System.out.println("Image loaded");
            /*ImageView img= new ImageView();
            img.setImage(plat);
            img.setFitWidth(100);
            img.setPreserveRatio(true);
            vBox.getChildren().add(img);
            Orc orc= new Orc();

            anchor_pane.getChildren().add(orc.get_Image());*/
        this.length = 115;
    }

    private void create_platform_1(){
        Random rand= new Random();
        try {
            anchor_pane=  FXMLLoader.load(getClass().getResource("Obstacle_2.fxml"));
        }catch(Exception e){
            System.out.println("image not loaded");
        }


        double x = 0;
        int choice=2;
             /*0->nothing
               1-> Orc
               2-> Chest*/

        ImageView obj=null;
        for(int i=0 ; i<4 ; i++) {
            x=x+100;
            choice= rand.nextInt(3);

            if (choice == 0) {
                continue;
            }
            if (choice == 1) {
                Orc orc = new Orc();
                obj = orc.get_Image();
            }
            if (choice == 2) {
                Weapon_chest chest = new Weapon_chest();
                obj = chest.get_Image();
            }
            content.add(obj);
            AnchorPane.setTopAnchor(obj, 197.0);
            AnchorPane.setLeftAnchor(obj, x);
            AnchorPane.setRightAnchor(obj, 110.0);
            AnchorPane.setBottomAnchor(obj, 200.0);


            anchor_pane.getChildren().add(obj);
            this.length=400;
        }

    }
    public AnchorPane get_Platform(){
        return  this.anchor_pane;
    }
    public void setCoordinate(double x){
        coordinate=x;
    }
    public double getCoordinate(){
        return coordinate;
    }
    public void translate_platform(double x , double y ,double duration){

        runTranslateTransition(anchor_pane,x,y,duration).play();
    }

}
