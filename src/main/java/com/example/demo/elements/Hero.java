package com.example.demo.elements;

import com.example.demo.Weapons.Weapons;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import static com.example.demo.CommonAnimation.vertical_jump;
import static java.util.Objects.requireNonNull;

public class Hero extends Character{
    //private helmet;
     private ImageView img;
     private int coins;
     private Weapons weapon1= null;
     private Weapons weapon2= null;

   public Hero(){
       Image hero=new Image(requireNonNull(getClass().getResourceAsStream("HERO.png")));
       img= new ImageView();
       img.setImage(hero);
       img.setFitWidth(40);
       img.setPreserveRatio(true);
       AnchorPane dadada= new AnchorPane();
       dadada.getChildren().add(img);
       set_Image(dadada);

//       vertical_jump(img,-80,true,700).play();
    }
    public ImageView getImg() {
       return img;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getCoins() {
        return coins;
    }

    public void setWeapon1(Weapons weapon) {
        this.weapon1 = weapon;
    }

    public Weapons getWeapon1() {
        return weapon1;
    }

    public void setWeapon2(Weapons weapon) {
        this.weapon2 = weapon;
    }

    public Weapons getWeapon2() {
        return weapon2;
    }
}
