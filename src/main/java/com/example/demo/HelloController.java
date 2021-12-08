package com.example.demo;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private ImageView hero;

    @FXML
    private ImageView boss;

    @FXML
    private ImageView cloud_1;

    @FXML
    private ImageView cloud_2;

    @FXML
    private ImageView cloud_3;

    @FXML
    private ImageView cloud_4;

    public void vertical_jump(Node node, int n, boolean rev, int time) {
        TranslateTransition t= new TranslateTransition();
        t.setNode(node);
        t.setByY(n);
        t.setAutoReverse(rev);
        t.setDuration(Duration.millis(time));
        t.setCycleCount(TranslateTransition.INDEFINITE);
        t.play();
    }

    public void hor_move(Node node, int n, int delay, boolean rev, int time) {
        TranslateTransition t= new TranslateTransition();
        t.setNode(node);
        t.setByX(n);
        t.setDelay(Duration.millis(delay));
        t.setAutoReverse(rev);
        t.setDuration(Duration.millis(time));
        t.setCycleCount(TranslateTransition.INDEFINITE);
        t.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Hero translation
        vertical_jump(hero, -55, true, 550);
        vertical_jump(boss, -90, true, 900);
        hor_move(cloud_1, -900, 1000, false, 12000);
        hor_move(cloud_2, -1000, 5000, false, 12000);
        hor_move(cloud_3, -990, 1000, false, 12000);
        hor_move(cloud_4, -1100, 5000, false, 12000);
    }
}