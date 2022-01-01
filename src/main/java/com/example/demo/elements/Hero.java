package com.example.demo.elements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import static com.example.demo.CommonAnimation.vertical_jump;
import static java.util.Objects.requireNonNull;

public class Hero extends Character{
    //private helmet;
     private ImageView img;
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


}
