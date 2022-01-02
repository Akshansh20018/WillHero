package com.example.demo.elements;

import com.example.demo.Weapons.Weapons;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

import static java.util.Objects.requireNonNull;

public class Weapon_chest extends  Chest{
    private Weapons weapon;

    public Weapon_chest(){
        super();
        /*Random rand= new Random();
        int weapon_type= rand.nextInt(2);*/
    }
    public void hasCollided(Hero hero, TranslateTransition fall) {
        int temp= super.haveCollided(hero.getImg(), fall);
        if(temp==1) {
            if(hero.getWeapon1()==null) {
                hero.setWeapon1(weapon);
            }
            else if(hero.getWeapon2()==null) {
                hero.setWeapon2(weapon);
            }
        }
    }
}

