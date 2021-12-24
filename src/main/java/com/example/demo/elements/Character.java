package com.example.demo.elements;

import javafx.scene.image.ImageView;

import static com.example.demo.CommonAnimation.vertical_jump;


public class Character extends Game_Objects {

    int jump_speed;


    protected void set_Jump_speed(int speed ){this.jump_speed=speed;}

        public void jump(){

        vertical_jump(Image,-25,true,jump_speed).play();}


}