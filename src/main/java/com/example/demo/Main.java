package com.example.demo;


import com.example.demo.elements.Platform;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {

    public static Stage PrimaryStage;
    public static void LoadExitScreen() throws IOException {

           Parent root = FXMLLoader.load(Main.class.getResource("Exit-Screen.fxml"));
        Scene scene = new Scene(root, 700, 370);

        PrimaryStage.setScene(scene);

    }
    public static void LoadPause() throws IOException {

        Parent root = FXMLLoader.load(Main.class.getResource("Pause.fxml"));
        Scene scene = new Scene(root, 700, 370);

        PrimaryStage.setScene(scene);

    }

    public static void ShowHighScore() throws IOException {
        //Insert code to setup HighScore fxml file;
            Parent root = FXMLLoader.load(Main.class.getResource("HighScore.fxml"));
        Scene scene = new Scene(root, 700, 370);

        PrimaryStage.setScene(scene);

    }
    public static void HomePage() throws IOException {
        //Insert code to setup HomePage fxml file;
          Parent root = FXMLLoader.load(Main.class.getResource("HomePage.fxml"));
          Scene scene = new Scene(root, 700, 370);

        PrimaryStage.setScene(scene);

    }
    public static void StartGame() throws IOException {
        //Insert code to setup PlayGame Application fxml file;
        AnchorPane root = (AnchorPane) FXMLLoader.load(Main.class.getResource("PlayGamePage.fxml"));

/*
        Image orco = new Image(requireNonNull(HelloApplication.class.getResourceAsStream("images/exit.png")));
        ImageView img= new ImageView();
        img.setImage(orco);
        img.setFitWidth(100);
        img.setPreserveRatio(true);
//        img.setX(loc);
//        img.setY();*/


        /*VBox platform = new Platform();

        int temp= root.getChildren().size();
        root.getChildren().get(temp-2).toFront();
        vertical_jump(orc.get_Image(),-25,true,450).play();*/



        Scene scene = new Scene(root, 700, 370);

        PrimaryStage.setScene(scene);
    }
 public void add_platform(){

 }

    @Override
    public void start(Stage stage) throws Exception {
        PrimaryStage = stage;

        //Scene scene = new Scene(root, 700, 370);
        PrimaryStage.setTitle("WillHero");

        PrimaryStage.setResizable(false);

    try{

        PrimaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("Icon.png")));
    }
    catch(Exception e) {
            System.out.println("image not loaded..");
        }
        StartGame();
        //HomePage();
        PrimaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}