package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

/**
 * Level 4 of the game
 */
public class Level4 extends GameLevel  {

    private static final int NUM_CARGO = 0;
    private Timer timer;









    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {




        super.populate(game);
        Shape groundShape = new BoxShape(13, 0.1f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));
        Body landingpad = new Landinpad(this);
        landingpad.setPosition(new Vec2(10, 10));
        landingpad.addCollisionListener(new Pickup(getPlayer()));






       Wall wall=new Wall(this);
       wall.setPosition(new Vec2(0,7));
        wall.setFillColor(Color.black);
        wall.addCollisionListener(new Pickup(getPlayer(),wall));




        Canon canon=new Canon(this);
        canon.setPosition(new Vec2(-8,-11));
        //canon.addCollisionListener(new Pickup(getPlayer(),getWall()));
        canon.addCollisionListener(new Pickup(getPlayer()));









        for (int i = 0; i < 3; i++) {
            Body key = new Key(this);
            Random ran = new Random();
            key.setPosition(new Vec2(ran.nextInt(5), 7 - i * 6));
            key.addCollisionListener(new Pickup(getPlayer()));
            key.addCollisionListener(new KeyGhost(getWall()));
            ((Key) key).setGravityScale(0f);


        }


    }




    @Override public ImageIcon levelBackground(){
        return new ImageIcon("data/background2.png"); }

    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-10, -9);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getCargoCount() == NUM_CARGO;
    }



}
