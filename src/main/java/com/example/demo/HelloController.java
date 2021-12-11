package com.example.demo;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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

    @FXML
    private ImageView BackButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        IntroTransition();

    }
    public void IntroTransition(){
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
    public void BackButtonPressed(MouseEvent mouseEvent) throws Exception {
        HomePage();
    }
    private void DisableHomepage(){
        PlayButton.setDisable(true);
//        fade(PlayButton, 1, 0).play();
        PlayButton.setVisible(false);

        ExitButton.setDisable(true);
//        fade(ExitButton, 1, 0).play();
        ExitButton.setVisible(false);

        HighScore.setDisable(true);
//        fade(HighScore, 1, 0).play();
        HighScore.setVisible(false);


    }
    @FXML
    void PlayButtonClicked(MouseEvent event) {
        DisableHomepage();
        BackButton.setDisable(false);

        delay(1000);
        LoadSavedGame.setDisable(false);
        LoadSavedGame.setVisible(true);
          fade(LoadSavedGame, 0, 1).play();
        NewGame.setDisable(false);
        NewGame.setVisible(true);

         fade(NewGame, 0, 1).play();
        BackButton.setVisible(true);
        fade(BackButton,0,1).play();

    }

    public void StartPlaying(MouseEvent mouseEvent) throws Exception{
        StartGame();
    }


//    @FXML
//    void New_Game(MouseEvent event) throws IOException {
//        play_game(event);
//    }



}
