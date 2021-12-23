package com.example.demo.elements;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static java.util.Objects.requireNonNull;

public class Platform {
    ArrayList<Orc> Orcs;
    AnchorPane anchor_pane;
    public Platform() throws IOException {

    //System.out.println("thisis plat");
       Random rand= new Random();
      int platform_type= rand.nextInt(2);
        //int platform_type=1;
        if(platform_type==0){

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

        }
        if(platform_type==1){

            try {
                anchor_pane=  FXMLLoader.load(getClass().getResource("Obstacle_2.fxml"));
            }catch(Exception e){
                System.out.println("image not loaded");
            }
            //System.out.println("Image loaded");
            /*ImageView img= new ImageView();
            img.setImage(plat);
            img.setFitWidth(100);
            img.setPreserveRatio(true);
            vBox.getChildren().add(img);*/

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
                AnchorPane.setTopAnchor(obj, 210.0);
                AnchorPane.setLeftAnchor(obj, x);
                AnchorPane.setRightAnchor(obj, 110.0);
                AnchorPane.setBottomAnchor(obj, 200.0);


                anchor_pane.getChildren().add(obj);
            }

        }

        //return  anchor_pane;
    }
    public AnchorPane get_Platform(){
        return  this.anchor_pane;
    }
}
