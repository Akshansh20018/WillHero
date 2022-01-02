package com.example.demo.elements;

import com.example.demo.Weapons.Axe;
import com.example.demo.Weapons.Sword;
import com.example.demo.Weapons.Weapons;
import javafx.scene.layout.AnchorPane;

public class Helmet implements java.io.Serializable{
    private Weapons Weapon1;
    private Weapons Weapon2;
    Helmet(){
        Weapon1=new Axe();
        Weapon2=new Sword();
    }
}
