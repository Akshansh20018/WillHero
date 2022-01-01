package com.example.demo;

import com.example.demo.elements.Hero;
import javafx.animation.TranslateTransition;

import static com.example.demo.CommonAnimation.hero_jump;

public class MyThread extends Thread{
    MyThread(Hero hero, TranslateTransition t) {
        hero_jump(hero.getImg()).play();
        t.pause();
    }
}
