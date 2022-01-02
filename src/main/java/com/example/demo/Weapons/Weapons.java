package com.example.demo.Weapons;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Weapons {
    int Power ;
    public abstract void onAction();
    public void update(){
        Power+=20;
    }
    public int getPower(){
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
