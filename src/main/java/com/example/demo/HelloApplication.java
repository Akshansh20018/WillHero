package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.transform.Scale;
public class HelloApplication extends Application {

    public static void LoadExitScreen() throws IOException {
        /*Insert code to setup Exit fxml file;

         */
    }

    public static void ShowHighScore() throws IOException {
        /*Insert code to setup HighScore fxml file;

         */
    }
    public static void StartGame() throws IOException {
        /*Insert code to setup PlayGame Application fxml file;

         */
    }
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("HomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 370);
        stage.setTitle("WillHero");
        stage.setScene(scene);
        stage.setResizable(false);


        Image icon= new Image("https://play-lh.googleusercontent.com/Y07T-_5gdE7aUVAgAegAKzeULKTOpXrt4cL9SlKnfnl2qKvBG5oUTNhSb69bEwiLQ4Y");
        stage.getIcons().add(icon);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}