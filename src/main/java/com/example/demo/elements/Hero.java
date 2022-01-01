package com.example.demo.elements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static com.example.demo.CommonAnimation.vertical_jump;
import static java.util.Objects.requireNonNull;

public class Hero extends Character{
    //private helmet;
   public Hero(){
       Image hero=new Image(requireNonNull(getClass().getResourceAsStream("HERO.png")));
       ImageView img= new ImageView();
       img.setImage(hero);
       img.setFitWidth(40);
       img.setPreserveRatio(true);
       set_Image(img);

       vertical_jump(img,-80,true,700).play();
    }

}
