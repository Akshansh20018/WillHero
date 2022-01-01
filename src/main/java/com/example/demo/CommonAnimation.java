package com.example.demo;


import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.scene.Node;
public class CommonAnimation {

    public static TranslateTransition runTranslateTransition(Node obj ,double x , double y , double duration ){
        TranslateTransition load = new TranslateTransition();
        load.setNode(obj);
        load.setByY(y);
        load.setByX(x);
        load.setDuration(Duration.millis(duration));

        return load;
    }

    public static TranslateTransition vertical_jump(Node node, int n, boolean rev, int time) {
        TranslateTransition t= new TranslateTransition();
        t.setNode(node);
        t.setByY(n);
        t.setAutoReverse(rev);
        t.setDuration(Duration.millis(time));
        t.setCycleCount(TranslateTransition.INDEFINITE);
        return t;
    }

    public static TranslateTransition hero_jump(Node node, int n, boolean rev, int time) {
        TranslateTransition t= new TranslateTransition();
        t.setNode(node);
        t.setByY(n);
        t.setAutoReverse(rev);
        t.setDuration(Duration.millis(time));
        return t;
    }
    public static TranslateTransition hero_drop(Node node, int n, boolean rev, int time) {
        TranslateTransition t= new TranslateTransition();
        t.setNode(node);
        t.setByY(n);
        t.setAutoReverse(rev);
        t.setDuration(Duration.millis(time));
        t.setCycleCount(TranslateTransition.INDEFINITE);
        return t;
    }

    public static TranslateTransition hor_move(Node node, int n, int delay, boolean rev, int time) {
        TranslateTransition t= new TranslateTransition();
        t.setNode(node);
        t.setByX(n);
        t.setDelay(Duration.millis(delay));
        t.setAutoReverse(rev);
        t.setDuration(Duration.millis(time));
        t.setCycleCount(TranslateTransition.INDEFINITE);
        return t;
    }
    public static FadeTransition fade(Node node, int from, int to) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(2000));
        fadeTransition.setNode(node);
        fadeTransition.setFromValue(from);
        fadeTransition.setToValue(to);
        return fadeTransition;
    }
    public static Timeline delay(double time){

        return new Timeline(new KeyFrame(Duration.millis(time),e ->{}));
    }
}
