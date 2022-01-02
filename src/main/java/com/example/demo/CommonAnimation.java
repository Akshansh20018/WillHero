package com.example.demo;


import javafx.animation.*;
import javafx.scene.transform.Rotate;
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

    public static TranslateTransition hero_drop(Node obj ,double x , double y , double duration ){
        TranslateTransition load = new TranslateTransition();
        load.setNode(obj);
        load.setByY(y);
        load.setByX(x);
//        load.setDelay(Duration.millis(100));
        load.setDuration(Duration.millis(duration));
        return load;
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
    public static TranslateTransition ver_move(Node node, int n, int delay, boolean rev, int time) {
        TranslateTransition t= new TranslateTransition();
        t.setNode(node);
        t.setByY(n);
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

    public static TranslateTransition hero_jump(Node node) {
        TranslateTransition t= new TranslateTransition();
        t.setNode(node);
        t.setByY(-150);
        t.setAutoReverse(false);
        t.setDuration(Duration.millis(400));
        return t;
    }
    public static RotateTransition rotate(Node node , double Angle , boolean reverse){
        RotateTransition rotateTransition = new RotateTransition();

        rotateTransition.setDuration(Duration.millis(1000));
        rotateTransition.setNode(node);
        rotateTransition.setAxis(Rotate.X_AXIS);
        rotateTransition.setByAngle(Angle);
        //rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.setAutoReverse(reverse);
        return rotateTransition;
    }
    public static Timeline delay(double time){
        return new Timeline(new KeyFrame(Duration.millis(time),e ->{}));
    }
}
