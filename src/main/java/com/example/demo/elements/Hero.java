package com.example.demo.elements;

import com.example.demo.Weapons.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import static com.example.demo.CommonAnimation.*;
import static java.util.Objects.requireNonNull;

public class Hero extends Character{
    //private helmet;
     private ImageView img;
     private int coins;
     private Weapons axe= null;
     private Weapons sword= null;
     ImageView weap1;
     ImageView weap2;
     private AnchorPane dadada;
     private int hasweapon=-1;
     /*has weapon = 0 -> sword
         has weapon = 1 -> axe
         has weapob =2 -> both
         -1 -> none
      */

   public Hero(){
       Image hero=new Image(requireNonNull(getClass().getResourceAsStream("HERO.png")));
       img= new ImageView();
       img.setImage(hero);
       img.setFitWidth(40);
       img.setPreserveRatio(true);
       dadada= new AnchorPane();
       dadada.getChildren().add(img);
       setImg(img);


       set_Image(dadada);

       Weapons temp = new Axe();
       weap1 = temp.getImg();

       weap1.setVisible(false);

       dadada.getChildren().add(weap1);

       temp=new Sword();
       weap2 = temp.getImg();
       weap2.setLayoutX(30);
       weap2.setLayoutY(-30);
       weap2.setVisible(false);
       dadada.getChildren().add(weap2);

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

    public void setWeapon(Weapons weapon){

        if(weapon instanceof  Axe)
            setWeapon((Axe)weapon);
        if(weapon instanceof  Sword)
            setWeapon((Sword)weapon);

    }

    public void setWeapon(Axe weapon){

       if(hasweapon >=1)
           axe.update();
       if(hasweapon==-1 || hasweapon == 0)
       {
           weap1.setVisible(true);
           axe = new Axe();
           hasweapon+=2;

       }


    }

    public void setWeapon(Sword weapon){

        if(hasweapon ==0 || hasweapon == 2)
            sword.update();
        if(hasweapon==-1 || hasweapon==1)
        {   weap2.setVisible(true);
            sword = new Sword();
            hasweapon++;
        }



    }

    public void movetheheroplease(double i){
        //runTranslateTransition(this.getImg(), i, 0, 200).play();
        runTranslateTransition(this.get_Image(), i, 0, 200).play();
       // runTranslateTransition(this.weap1, i, 0, 200).play();
       // runTranslateTransition(this.weap2, i, 0, 200).play();
    }

    public void jump(){

      // hero_jump(this.getImg()).play();
        hero_jump(this.get_Image()).play();
        hero_jump(this.getImg()).play();
       hero_jump(weap1).play();
       hero_jump(weap2).play();
        /*if(i.intValue()==1) {

            hero_jump(this.get_Image()).play();
            hero_jump(this.getImg()).play();
            hero_jump(weap1).play();
            hero_jump(weap2).play();
        }
        else{
            runTranslateTransition(this.getImg(), i, 0, 200).play();
            runTranslateTransition(this.get_Image(), i, 0, 200).play();
            runTranslateTransition(this.weap1, i, 0, 200).play();
            runTranslateTransition(this.weap2, i, 0, 200).play();
        }
         */
   }

    public void revive() {
        hero_revive(this.get_Image()).play();
        hero_revive(this.getImg()).play();
        hero_revive(weap1).play();
        hero_revive(weap2).play();
    }

    public int fight_orc(){
       if(hasweapon==-1){
           return  40;
       }
       else if(hasweapon == 1){
           return axe.getPower();
       }

       else if(hasweapon == 0)
           return sword.getPower();
       else
           return Integer.max(50+axe.getPower(),50+sword.getPower())-10;
    }

    public void setImg(ImageView img) {
       this.img= img;
    }

    public void bonus_on() {
       System.out.println("Reached here");
//        dadada.getChildren().remove(0);
//        Image Open = new Image(requireNonNull(getClass().getResourceAsStream("GreenOrc_1.png")));
//        img = new ImageView();
//        img.setImage(Open);
//        img.setFitWidth(75);
//        img.setPreserveRatio(true);
        hasweapon= -1;
    }

    public void bonus_off() {
    }
}
