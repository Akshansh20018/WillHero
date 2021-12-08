package com.example.demo;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Hero translation
        TranslateTransition translate_hero = new TranslateTransition();
        translate_hero.setNode(hero);
        translate_hero.setByY(-55);
        translate_hero.setAutoReverse(true);
        translate_hero.setDuration(Duration.millis(400));
        translate_hero.setCycleCount(TranslateTransition.INDEFINITE);
        translate_hero.play();

        TranslateTransition translate_boss = new TranslateTransition();
        translate_boss.setNode(boss);
        translate_boss.setByY(-90);
        translate_boss.setAutoReverse(true);
        translate_boss.setDuration(Duration.millis(900));
        translate_boss.setCycleCount(TranslateTransition.INDEFINITE);
        translate_boss.play();
    }
}