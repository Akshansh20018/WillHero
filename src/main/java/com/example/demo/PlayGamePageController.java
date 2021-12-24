package com.example.demo;

import com.example.demo.elements.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import static com.example.demo.CommonAnimation.*;

public class PlayGamePageController implements Initializable {

    @FXML
    private ImageView cloud_1;

    @FXML
    private ImageView cloud_2;

    @FXML
    private ImageView cloud_3;

    @FXML
    private ImageView cloud_4;

    @FXML
    private ImageView hero;


    @FXML
    private AnchorPane Anchor;


    @FXML
    private Button resume;


    @FXML
    private AnchorPane pause_screen;



    @FXML
    private ImageView pause_image;

    private ArrayList<Platform> Obstacles = new ArrayList<Platform>();
    private double add_from_x = -40;
    private double add_from_y = -30;
    private Pane pane;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vertical_jump(hero, -55, true, 550).play();
        hor_move(cloud_1, -900, 1000, false, 12000).play();
        hor_move(cloud_2, -1000, 5000, false, 12000).play();
        hor_move(cloud_3, -990, 1000, false, 12000).play();
        hor_move(cloud_4, -1100, 5000, false, 12000).play();
        add_platform(0);
        add_platform(1);
        add_platform(-1);
    }

    public void add_platform(int choice)  {
        Platform plat = null;
        if(choice==0){
        plat = new Platform(0);}
        else if(choice==1){
            plat = new Platform(1);
        }
        else {
            try {
                plat = new Platform();
                System.out.println("Hello");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

            //plat = new Platform();

        pane = plat.get_Platform();
        Obstacles.add(plat);
        plat.setCoordinate(add_from_x);
        AnchorPane.setTopAnchor(pane, add_from_y);
        AnchorPane.setLeftAnchor(pane, add_from_x);
        add_from_x+=plat.length;
        Random rand= new Random();
        add_from_x+= rand.nextInt(10)+10;

        //AnchorPane.setBottomAnchor(pane, 200.0);

        Anchor.getChildren().add(pane);

    }
    public void pauseClicked(ActionEvent event) throws IOException {
        //pause func back button fade
        runTranslateTransition(pause_screen, 0, 377, 2000).play();
//        System.out.println("hello mic test");
    }

    public void resumeClicked(ActionEvent event) throws IOException {
        //pause func back button fade
        runTranslateTransition(pause_screen, 0, -377, 2000).play();
//
    }
    public void Play(){
        //runTranslateTransition(hero, 100, 0, 20).play();

        for(Platform plat : Obstacles){
            plat.translate_platform(-100,0,20);
            plat.setCoordinate(plat.getCoordinate()-100);
           // System.out.println(plat.getCoordinate());
            /*if(plat.getCoordinate()+plat.length< -300){
               System.out.println("delete this");
               Obstacles.remove(plat);
               add_platform(-1);
            }*/
        }
        add_platform(-1);

    }
}
