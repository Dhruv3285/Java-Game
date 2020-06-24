/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.util.Random;

/**
 * Abstract GameLevel class
 */
public abstract class GameLevel extends World {
    private Lander lander;
   private Wall wall;
   private Bullet bullet;
   private Cargo cargo;
   private Comet comet;
   private Landinpad landinpad;
    private Fuel fuel;
    //code for calling bodies in when pickup is implemented.
    public  Lander getPlayer(){return lander;}
    public Fuel getFuel(){return fuel;}
    public Cargo getCargo(){return cargo;}
    public Comet getComet(){return comet;}

    public Wall getWall(){return  wall;}
    public Landinpad getLandinpad(){return landinpad;}


    /** Create bodies which will be presents in all 4 levels.
     * @param game The Game
     */

   public void populate(Game game){
        lander=new Lander(this);


        getPlayer().setPosition(startPosition());
       getPlayer().setPosition(new Vec2(8, -10));
       getPlayer().setGravityScale(0f);
       getPlayer().getDist();



        Door door=new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));



   }

    /** The initial position of the player. */
    public abstract Vec2 startPosition();

    /** The position of the exit door. */
    public abstract Vec2 doorPosition();

    /** Is this level complete? */
    public abstract boolean isCompleted();
    /**Set different background in different
     *  levels */
    public abstract ImageIcon levelBackground();
}


















