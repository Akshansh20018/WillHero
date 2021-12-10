package com.example.demo;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.demo.CommonAnimation.*;
import static com.example.demo.HelloApplication.*;

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

    @FXML
    private Button ExitButton;

    @FXML
    private Button HighScore;

    @FXML
    private Button PlayButton;

    @FXML
    private Button LoadSavedGame;

    @FXML
    private Button NewGame;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Hero translation
        runTranslateTransition(PlayButton, 0,-207,3000).play();
        runTranslateTransition(HighScore, 0,-207,3000).play();
        runTranslateTransition(ExitButton, 0,-207,3000).play();
        vertical_jump(hero, -55, true, 550).play();
        vertical_jump(boss, -90, true, 900).play();
        hor_move(cloud_1, -900, 1000, false, 12000).play();
        hor_move(cloud_2, -1000, 5000, false, 12000).play();
        hor_move(cloud_3, -990, 1000, false, 12000).play();
        hor_move(cloud_4, -1100, 5000, false, 12000).play();
    }
    @FXML
    void ExitButtonClicked(MouseEvent event) throws Exception {
        LoadExitScreen();
    }

    @FXML
    void HighScoreClicked(MouseEvent event)throws Exception {
        ShowHighScore();
    }

    @FXML
    void PlayButtonClicked(MouseEvent event) {
        fade(PlayButton, 1, 0);
        PlayButton.setDisable(true);
//        PlayButton.setVisible(false);
        fade(ExitButton, 1, 0);
        ExitButton.setDisable(true);
//        ExitButton.setVisible(false);
        fade(HighScore, 1, 0);
        HighScore.setDisable(true);
//        HighScore.setVisible(false);

        LoadSavedGame.setDisable(false);
        LoadSavedGame.setVisible(true);
        fade(LoadSavedGame, 0, 1);
        NewGame.setDisable(false);
        NewGame.setVisible(true);
        fade(NewGame, 0, 1);
    }

    @FXML
    void New_Game(ActionEvent event) throws IOException {
//        play_game(event);
    }

    private void fade(Node node, int from, int to) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(2000));
        fadeTransition.setNode(node);
        fadeTransition.setFromValue(from);
        fadeTransition.setToValue(to);
        fadeTransition.play();
    }

}