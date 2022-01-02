package com.example.demo.elements;

import com.example.demo.Weapons.Weapons;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import static com.example.demo.CommonAnimation.*;
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
        ImageView obj = weapon.getImg();
        AnchorPane.setTopAnchor(obj, 0.0);
        AnchorPane.setLeftAnchor(obj, -10.0);
        this.get_Image().getChildren().add(obj);
        // rotate(weapon.getImg(),-30,false).play();
        this.weapon1 = weapon;
    }

    public Weapons getWeapon1() {
        return this.weapon1;
    }

    public void setWeapon2(Weapons weapon) {

        ImageView obj = weapon.getImg();
        AnchorPane.setTopAnchor(obj, 10.0);
        AnchorPane.setLeftAnchor(obj, 0.0);
        this.get_Image().getChildren().add(obj);
        this.weapon2 = weapon;
    }
    public void jump(){
       hero_jump(this.getImg()).play();
       if(weapon1!=null)
            hero_jump(weapon1.getImg()).play();
       if(weapon2!=null)
            hero_jump(weapon2.getImg()).play();
    }
    public Weapons getWeapon2() {
        return weapon2;
    }
}
