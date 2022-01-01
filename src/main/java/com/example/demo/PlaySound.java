package com.example.demo;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URISyntaxException;

import static java.util.Objects.requireNonNull;

public class PlaySound {


    public static void PlayBackGround() throws URISyntaxException {
        /**/
        Media sound = null;
        try {
            sound = new Media(PlaySound.class.getResource("Game_BackGround.wav").toURI().toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        mediaPlayer.play();

    }



}

