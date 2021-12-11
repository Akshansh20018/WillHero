package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;



import static java.util.Objects.*;

public class HelloApplication extends Application {

    public static Stage PrimaryStage;
    public static void LoadExitScreen() throws IOException {

           Parent root = FXMLLoader.load(HelloApplication.class.getResource("Exit-Screen.fxml"));
        Scene scene = new Scene(root, 700, 370);

        PrimaryStage.setScene(scene);

    }
    public static void LoadPause() throws IOException {

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("Pause.fxml"));
        Scene scene = new Scene(root, 700, 370);

        PrimaryStage.setScene(scene);

    }

    public static void ShowHighScore() throws IOException {
        //Insert code to setup HighScore fxml file;
            Parent root = FXMLLoader.load(HelloApplication.class.getResource("HighScore.fxml"));
        Scene scene = new Scene(root, 700, 370);

        PrimaryStage.setScene(scene);

    }
    public static void HomePage() throws IOException {
        //Insert code to setup HomePage fxml file;
          Parent root = FXMLLoader.load(HelloApplication.class.getResource("HomePage.fxml"));
          Scene scene = new Scene(root, 700, 370);

        PrimaryStage.setScene(scene);

    }
    public static void StartGame() throws IOException {
        //Insert code to setup PlayGame Application fxml file;
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("PlayGamePage.fxml"));
        PrimaryStage.getScene().setRoot(root);

    }


    @Override
    public void start(Stage stage) throws Exception {
        PrimaryStage = stage;

        //Scene scene = new Scene(root, 700, 370);
        PrimaryStage.setTitle("WillHero");

        PrimaryStage.setResizable(false);

    try{

        PrimaryStage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("Icon.png")));
    }
    catch(Exception e) {
            System.out.println("image not loaded..");
        }
        HomePage();
        PrimaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}