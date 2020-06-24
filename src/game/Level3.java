package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

/**
 * Level 3 of the game
 */
public class Level3 extends GameLevel {

    private static final int NUM_FUEL=480;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);


        Shape groundShape = new BoxShape(13, 0.1f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));
        for(int i=0;i<3;i++) {
            Body fuel = new Fuel(this);
            fuel.setPosition(new Vec2(8, -2+5*i));
            //    fuel.addCollisionListener(new Pickup(getPlayer()));
        }
        for(int i=0;i<3;i++) {
            Body fuel = new Fuel(this);
            fuel.setPosition(new Vec2(-8, -3+5*i));

        }





    }



    @Override public ImageIcon levelBackground(){
        return new ImageIcon("data/background3.png"); }

    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(10.4f, 9.6f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getTarget()==6;
    }
}
