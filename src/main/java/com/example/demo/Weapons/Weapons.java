package com.example.demo.Weapons;
import com.example.demo.CommonAnimation;

import javafx.animation.RotateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Weapons implements java.io.Serializable{
    int Power ;
    public  void onAction(){
     // CommonAnimation.rotate(img,180,true);

            }
    public void update(){
        Power+=20;
    }
    public int getPower(){

        onAction();
        return this.Power;
    }
    private ImageView img ;
    Weapons(int pow) {
        this.Power = pow;
    }

    public void setImg(Image image , int size) {
        ImageView img = new ImageView();
        img.setImage(image);
        img.setFitWidth(size);
        img.setPreserveRatio(true);
        this.img = img;
    }

    public ImageView getImg() {
        return img;
    }

}
