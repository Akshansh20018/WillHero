package com.example.demo;

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

}