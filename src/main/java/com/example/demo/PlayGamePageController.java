package com.example.demo;

import com.example.demo.elements.Game_Objects;
import com.example.demo.elements.Obstacle;
import com.example.demo.elements.Platform;
import com.example.demo.elements.Hero;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

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
    private ImageView hee;

    @FXML
    private Hero hero;


    @FXML
    private AnchorPane Anchor;


    @FXML
    private Button resume;


    @FXML
    private AnchorPane pause_screen;



    @FXML
    private ImageView pause_image;

    @FXML
    private Text Score;
    private ArrayList<Obstacle> Obstacles = new ArrayList<Obstacle>();
    private double add_from_x = -40;
    private double add_from_y = -30;
    private Pane pane;
    private int score;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //vertical_jump(hero, -80, true, 800).play();
        hero= new Hero();
        hee =hero.get_Image();
        AnchorPane.setTopAnchor(hee, 180.0);
        AnchorPane.setLeftAnchor(hee, 65.0);
        Anchor.getChildren().add(hee);

        score=0;

        hor_move(cloud_1, -900, 1000, false, 12000).play();
        hor_move(cloud_2, -1000, 5000, false, 12000).play();
        hor_move(cloud_3, -990, 1000, false, 12000).play();
        hor_move(cloud_4, -1100, 5000, false, 12000).play();
        add_obstacle(0);
        add_obstacle(1);
        add_obstacle(-1);

    }

    public void add_obstacle(int choice)  {
        Obstacle obstacle = null;
        if(choice==0){
        obstacle = new Obstacle(0);}
        else if(choice==1){
            obstacle = new Obstacle(1);
        }
        else {
            try {
                obstacle= new Obstacle();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

            //plat = new Platform();

        pane =obstacle.getAnchor_pane();
        Obstacles.add(obstacle);


        //AnchorPane.setTopAnchor(pane, add_from_y);
        //AnchorPane.setLeftAnchor(pane, add_from_x);
        pane.setLayoutX(add_from_x);
        pane.setLayoutY(add_from_y);
        obstacle.setCoordinate(add_from_x);

        add_from_x+=obstacle.length;
        Random rand= new Random();
        add_from_x+= rand.nextInt(10)+10;

        //AnchorPane.setBottomAnchor(pane, 200.0);

        Anchor.getChildren().add(pane);
        hee.toFront();

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
        score++;
        Score.setText(Integer.toString(score));
        int i;
        for( i=0 ; i< Obstacles.size() ; i++){


            Obstacle obstacle = Obstacles.get(i);

            obstacle.translate_obstacle(-200,0,20);
            Bounds bound = obstacle.get_Top().localToScreen(obstacle.get_Top().getBoundsInLocal());

            if(bound.getMaxX()<0)
            {Obstacles.remove(obstacle);
                }








        }

        add_obstacle(-1);







    }
}
