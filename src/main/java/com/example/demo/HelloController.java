package com.example.demo;

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
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.demo.CommonAnimation.*;
import static com.example.demo.HelloApplication.*;

public class HelloController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

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
        PlayButton.setDisable(true);
        PlayButton.setVisible(false);
        ExitButton.setDisable(true);
        ExitButton.setVisible(false);
        HighScore.setDisable(true);
        HighScore.setVisible(false);

        LoadSavedGame.setDisable(false);
        LoadSavedGame.setVisible(true);
        NewGame.setDisable(false);
        NewGame.setVisible(true);
    }

//    @FXML
//    void new_window(ActionEvent event) throws IOException {
//        root= FXMLLoader.load(getClass().getResource(src/main/resources/com/example/demo/PlayGamePage.fxml));
//        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    }
}