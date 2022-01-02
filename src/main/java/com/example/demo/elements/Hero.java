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
     ImageView weap1;
     ImageView weap2;

   public Hero(){
       Image hero=new Image(requireNonNull(getClass().getResourceAsStream("HERO.png")));
       img= new ImageView();
       img.setImage(hero);
       img.setFitWidth(40);
       img.setPreserveRatio(true);
       AnchorPane dadada= new AnchorPane();
       dadada.getChildren().add(img);
       set_Image(dadada);
       weap1= new ImageView();
       AnchorPane.setTopAnchor(weap1, 10.0);
       AnchorPane.setLeftAnchor(weap1, 0.0);
       this.get_Image().getChildren().add(weap1);
       weap2= new ImageView();
       AnchorPane.setTopAnchor(weap2, 10.0);
       AnchorPane.setLeftAnchor(weap2, 0.0);
       this.get_Image().getChildren().add(weap2);


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
         weap1 = weapon.getImg();
        // rotate(weapon.getImg(),-30,false).play();
        this.weapon1 = weapon;
    }

    public Weapons getWeapon1() {
        return this.weapon1;
    }
    public void setWeapon(Weapons weapon){
       if(weapon1==null){
           setWeapon1(weapon);
           System.out.println("setting new weapon");
       }
       else if(weapon2==null){
           setWeapon2(weapon);
           System.out.println("setting new weapon 2");
       }
       else if(weapon1.getClass()==weapon.getClass() )
           weapon1.update();
       else if(weapon2.getClass()==weapon.getClass() )
            weapon2.update();
       else
           System.out.println("Handle in weapon");
    }

    public void setWeapon2(Weapons weapon) {
        weap1 = weapon.getImg();
        this.weapon2 = weapon;
    }
    public void jump(){
       /*
       hero_jump(this.getImg()).play();


        */
        hero_jump(this.get_Image()).play();
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
