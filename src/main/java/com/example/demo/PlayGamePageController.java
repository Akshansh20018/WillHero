package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.demo.CommonAnimation.*;
import static com.example.demo.HelloApplication.*;

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
    private ImageView plat_1;

    @FXML
    private ImageView plat_2;

    @FXML
    private ImageView plat_12;

    @FXML
    private Button pause_button;

    @FXML
    private Button resume;

    @FXML
    private ImageView orc;

    @FXML
    private AnchorPane pause_screen;

    @FXML
    private ImageView chest;

    @FXML
    private ImageView pause_image;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vertical_jump(hero, -55, true, 550).play();
        hor_move(cloud_1, -900, 1000, false, 12000).play();
        hor_move(cloud_2, -1000, 5000, false, 12000).play();
        hor_move(cloud_3, -990, 1000, false, 12000).play();
        hor_move(cloud_4, -1100, 5000, false, 12000).play();
        vertical_jump(plat_2,-15,true,3000).play();
        vertical_jump(orc,-25,true,450).play();
    }

    public void pauseClicked(ActionEvent event) throws IOException {
        //pause func back button fade
        runTranslateTransition(pause_screen, 0, 377, 2000).play();
//        System.out.println("hello mic test");
    }

    public void resumeClicked(ActionEvent event) throws IOException {
        //pause func back button fade
        runTranslateTransition(pause_screen, 0, -377, 2000).play();
//        System.out.println("hello mic test");
    }
}
