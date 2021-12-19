package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.Random;


import static com.example.demo.CommonAnimation.vertical_jump;
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
        AnchorPane root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("PlayGamePage.fxml"));
        Random rand= new Random();
        int loc= rand.nextInt(500);
        Image orco= new Image(HelloApplication.class.getResourceAsStream("green_orc.png"));
        ImageView img= new ImageView();
        img.setImage(orco);
        img.setFitHeight(250);
        img.setFitWidth(166);
//        img.setX(loc);
//        img.setY();
        root.getChildren().add(img);
        int temp= root.getChildren().size();
        root.getChildren().get(temp-2).toFront();
        vertical_jump(img,-25,true,450).play();
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