package com.example.demo;

import com.example.demo.Weapons.Axe;
import com.example.demo.Weapons.Sword;
import com.example.demo.Weapons.Weapons;
import com.example.demo.elements.Game_Objects;
import com.example.demo.elements.Obstacle;
import com.example.demo.elements.Platform;
import com.example.demo.elements.Hero;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import static com.example.demo.Main.*;

import static com.example.demo.CommonAnimation.*;
import static java.util.Objects.requireNonNull;

public class PlayGamePageController implements Initializable{

    @FXML
    private ImageView cloud_1;

    @FXML
    private ImageView cloud_2;

    @FXML
    private ImageView cloud_3;

    @FXML
    private ImageView cloud_4;

    @FXML
    private AnchorPane hee;

    @FXML
    private Hero hero;

    @FXML
    private AnchorPane Anchor;

    @FXML
    private Button resume;

    @FXML
    private Button revive;

    @FXML
    private Button exit;

    @FXML
    private Button exit1;

    @FXML
    private AnchorPane pause_screen;

    @FXML
    private ImageView pause_image;

    @FXML
    private Text Score;

    @FXML
    private Text Coins;

    @FXML
    private AnchorPane death_screen;

    @FXML
    private Text message;

//    @FXML
//    private Rectangle end_check;

    private ArrayList<Obstacle> Obstacles = new ArrayList<Obstacle>();
    private double add_from_x = -40;
    private double add_from_y = -30;
    private Pane pane;
    private int score;
    private int coins;
    private boolean helper= false;

    private TranslateTransition hero_falling;
    private ArrayList<Game_Objects> obj_temp= new ArrayList<Game_Objects>();
    private Boolean boss_spawned=false;
    private Rectangle end_check;
    private int flag= 0;
    private int bonus_flag=0;
    private int bonus_loc;
    private Rectangle bonus_block;
    private Rectangle pseudo_bonus;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //vertical_jump(hero, -80, true, 800).play();

        Random rand= new Random();
        bonus_loc= 45+ rand.nextInt(5);
        bonus_loc= 2;

        hero= new Hero();
        hee =hero.get_Image();
//        Weapons axe = new Sword();
//        Weapons sword = new Axe();
//        hero.setWeapon1(sword);
//        hero.setWeapon2(axe);
        AnchorPane.setTopAnchor(hee, 180.0);
        AnchorPane.setLeftAnchor(hee, 65.0);
        Anchor.getChildren().add(hee);

        end_check= new Rectangle();
        end_check.setX(0);
        end_check.setY(550);
        end_check.setWidth(700);
        end_check.setHeight(5);
        end_check.setFill(Color.BLACK);
        Anchor.getChildren().add(end_check);

        score=0;
        coins= 0;

//        vertical_jump(hee,-80,true,700).play();
        hor_move(cloud_1, -900, 1000, false, 12000).play();
        hor_move(cloud_2, -1000, 5000, false, 12000).play();
        hor_move(cloud_3, -990, 1000, false, 12000).play();
        hor_move(cloud_4, -1100, 5000, false, 12000).play();
        //ver_move(hee,800, 150,false , 12000).play();
        //hero_drop(hee, 0, 22.8571428, 150).play();
        add_obstacle(0);
        add_obstacle(1);
     // add_obstacle(3);
        message.setVisible(false);

       timer.start();
        try {
            PlaySound.PlayBackGround();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void add_obstacle(int choice)  {
        if(add_from_x>50*200){
            if(boss_spawned)
                return;
            else{
                choice=3;
                boss_spawned= true;
            }

        }
        Obstacle obstacle = null;
        if(choice==0){
        obstacle = new Obstacle(0, hero);}
        else if(choice==1){
            obstacle = new Obstacle(1, hero);
        }
        else if(choice ==3){


            add_from_x+=20;
            for(int i=0 ; i< 30 ; i++){

                obstacle = new Obstacle(3,hero);
                if(i==10){
                    obstacle=new Obstacle(101,hero);
                }
                pane =obstacle.getAnchor_pane();
                Obstacles.add(obstacle);
                for(Game_Objects obj : obstacle.getGameObjects())
                    obj_temp.add(obj);
                pane.setLayoutX(add_from_x);
                pane.setLayoutY(add_from_y +50);

                add_from_x+=30;

                //AnchorPane.setBottomAnchor(pane, 200.0);

                Anchor.getChildren().add(pane);
                hee.toFront();}
            return;
        }
        else {
            try {
                obstacle= new Obstacle(hero);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //plat = new Platform();

        pane =obstacle.getAnchor_pane();
        Obstacles.add(obstacle);
        for(Game_Objects obj : obstacle.getGameObjects())
        obj_temp.add(obj);


        //AnchorPane.setTopAnchor(pane, add_from_y);
        //AnchorPane.setLeftAnchor(pane, add_from_x);
        pane.setLayoutX(add_from_x);
        pane.setLayoutY(add_from_y);
        obstacle.setCoordinate(add_from_x);

        add_from_x+=obstacle.length;
        Random rand= new Random();
        add_from_x+= rand.nextInt(10)+10;

        //AnchorPane.setBottomAnchor(pane, 200.0);

        Anchor.getChildren().add(pane);
        hee.toFront();


    }

    public void pauseClicked() throws IOException {
        //pause func back button fade
//        Node temp= Anchor.getChildren().get(0);
//        Anchor.getChildren().remove(0);
//        Anchor.getChildren().add(temp);
        runTranslateTransition(pause_screen, 0, 377, 2000).play();
        pause_screen.toFront();
        System.out.println("hello mic test");
    }

    public void resumeClicked(ActionEvent event) throws IOException {
        //pause func back button fade
        runTranslateTransition(pause_screen, 0, -377, 2000).play();
    }

    public void exitClicked(ActionEvent event) throws IOException {
        //pause func back button fade
//        runTranslateTransition(pause_screen, 0, -377, 2000).play();
//        Main.LoadExitScreen();
        timer.stop();
        try {
            LoadExitScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void SaveGame(ActionEvent event) throws IOException {
        timer.stop();
        ObjectOutputStream out = null;
        /*try{

            out = new ObjectOutputStream(new FileOutputStream("out.txt"));
            out.writeObject(s1);
        }*/
    }

    public void reviveClicked(ActionEvent event) throws IOException {
        if(hero.getCoins()>=25 && flag==0) {
            hero.setCoins(hero.getCoins());
            coins= hero.getCoins();
            Coins.setText(Integer.toString(coins));
            runTranslateTransition(death_screen, 0, 377, 2000).play();
            hero.revive();
            delay(10).play();
            timer.start();
            flag++;
        }
        else {
            message.setVisible(true);
            timer.stop();
            delay(2000).play();
            try {
                LoadExitScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void Play(){

        helper= true;
        //runTranslateTransition(hee,0,-80,1).play();
        score++;

        Score.setText(Integer.toString(score));

        if(score==bonus_loc) {
            bonus_flag= 1;
            int a=30;
            bonus_block= new Rectangle();
            bonus_block.setHeight(50+a);
            bonus_block.setWidth(50);
            bonus_block.setFill(Color.PURPLE);
            bonus_block.setX(800);
            bonus_block.setY(60);
            Anchor.getChildren().add(bonus_block);

            pseudo_bonus= new Rectangle();
            pseudo_bonus.setHeight(50+a);
            pseudo_bonus.setWidth(50);
            pseudo_bonus.setFill(Color.BLACK);
            pseudo_bonus.setX(1400);
            pseudo_bonus.setY(60);
            pseudo_bonus.setVisible(false);
            Anchor.getChildren().add(pseudo_bonus);
        }

        if(score== bonus_loc+20) {
            hero.bonus_off();
        }

        if(bonus_flag==1) {
            runTranslateTransition(bonus_block, -200, 0, 100).play();
            runTranslateTransition(pseudo_bonus, -200, 0, 100).play();
        }

        int i;
        for( i=0 ; i< Obstacles.size() ; i++){

            Obstacle obstacle = Obstacles.get(i);

            obstacle.translate_obstacle(-200,0,100);
//            Bounds bound = obstacle.get_Top().localToScreen(obstacle.get_Top().getBoundsInLocal());

//            if(bound.getMaxX()<0)
//            {Obstacles.remove(obstacle);
//                }
        }
        add_obstacle(-1);
    }

    AnimationTimer timer= new AnimationTimer() {
        @Override
        public void handle(long l) {
            coins= hero.getCoins();
            Coins.setText(Integer.toString(coins));

            hero_falling = hero_drop(hero.get_Image(), 0, 42, 150);
            hero_falling.play();
            //int temp= Obstacles.size();


            checkBonusCollision();

            for (Game_Objects game_obj : obj_temp) {

                try {
                    int answer = game_obj.hasCollided(hero, hero_falling);
                    if(answer == 120)
                        gameOver();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(GameEnd_check()) {
                timer.stop();
                try {
                    gameOver();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private void checkBonusCollision() {
//        System.out.println(bonus_flag);
        if(bonus_flag==0) {
            return;
        }
        ImageView img= hero.getImg();
        if(img.localToScreen(img.getBoundsInLocal()).intersects(pseudo_bonus.localToScreen(pseudo_bonus.getBoundsInParent()))){
            hero.bonus_on();
        }
    }

    private void gameOver() throws IOException {
        //timer.stop();

        System.out.println("Game is over");
//        Main.LoadExitScreen();
        death_screen.toFront();
        runTranslateTransition(death_screen, 0, -377, 2000).play();
    }

    public boolean GameEnd_check() {
//        System.out.println("Hero Coordinates: "+ hero.get_Image().getTranslateY());
        ImageView img= hero.getImg();
//        System.out.println("Hero Coordinates: "+ hero.getImg().localToScreen(hero.getImg().getBoundsInLocal()));
//        System.out.println(img.getX());
//        System.out.println("Hero Coordinates: "+ img.localToParent(img.getX(), img.getY()));
        if(img.localToScreen(img.getBoundsInLocal()).intersects(end_check.getBoundsInParent())){
            System.out.println("Game Over");
            return true;
        }
        return false;
    }
}