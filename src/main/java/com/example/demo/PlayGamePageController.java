package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

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
    private ImageView plat_11;

    @FXML
    private ImageView plat_12;

    @FXML
    private ImageView pause_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vertical_jump(hero, -55, true, 550).play();
        hor_move(cloud_1, -900, 1000, false, 12000).play();
        hor_move(cloud_2, -1000, 5000, false, 12000).play();
        hor_move(cloud_3, -990, 1000, false, 12000).play();
        hor_move(cloud_4, -1100, 5000, false, 12000).play();

    }
}
