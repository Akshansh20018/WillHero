package com.example.demo.elements;

import com.example.demo.Weapons.Axe;
import com.example.demo.Weapons.Sword;
import com.example.demo.Weapons.Weapons;
import javafx.animation.TranslateTransition;

import java.util.Random;

import static java.util.Objects.requireNonNull;

public class Weapon_chest extends  Chest{
    private Weapons weapon;

    public Weapon_chest(){
        super();
        Random rand= new Random();
        int weapon_type= rand.nextInt(2);
        if(weapon_type==0)
            weapon=new Axe();
        if(weapon_type==1)
            weapon=new Sword();

    }
    public int hasCollided(Hero hero, TranslateTransition fall) {
        int temp= super.haveCollided(hero.getImg(), fall);
        if(temp==1) {
            hero.setWeapon( weapon);
            System.out.println(weapon.getClass());
        }
        return 1;
    }
}