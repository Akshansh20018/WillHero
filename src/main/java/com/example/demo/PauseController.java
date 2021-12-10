package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.demo.CommonAnimation.vertical_jump;

public class PauseController implements Initializable {

    @FXML
    private Button exit;

    @FXML
    private ImageView pause_hero;

    @FXML
    private Button restart;

    @FXML
    private Button resume;

    @FXML
    private Button save;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vertical_jump(pause_hero, -10, true, 550).play();
    }
}
