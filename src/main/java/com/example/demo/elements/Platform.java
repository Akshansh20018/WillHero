package com.example.demo.elements;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static com.example.demo.CommonAnimation.runTranslateTransition;
import static java.util.Objects.requireNonNull;

public class Platform {

    AnchorPane anchor_pane;

    private ImageView img;

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
        this.img=obj;

    }

    private void create_platform_1(){


        ImageView obj=new ImageView();
        Image plat=new Image(requireNonNull(getClass().getResourceAsStream("Platform2.png")));
        obj.setImage(plat);
        obj.setFitWidth(500);
        obj.setFitHeight(300);
        obj.setPreserveRatio(false);
        this.img=obj;





    }
    private void create_platform_2(){
        ImageView obj=new ImageView();
        Image plat=new Image(requireNonNull(getClass().getResourceAsStream("Platform3.png")));
        obj.setImage(plat);
        obj.setFitWidth(200);
        obj.setFitHeight(280);
        obj.setPreserveRatio(false);
        this.img=obj;

    }

    public ImageView getImage() {
        return img;
    }

}
