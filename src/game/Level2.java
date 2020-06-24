package game;



import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

/**
 * Level 2 of the game
 */
public class Level2 extends GameLevel {

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

        Fsm fsm=new Fsm(game,this);

        fsm.setPosition(new Vec2(-9,-11));

        fsm.setGravityScale(0f);
        fsm.addCollisionListener(new Pickup(getPlayer()));



        Shape lineShape = new BoxShape(10, 0.0001f);
        Body line = new StaticBody(this);
        Body line2=new StaticBody(this);
        GhostlyFixture lineFixture=new GhostlyFixture(line,lineShape,1);
        GhostlyFixture lineFixture2=new GhostlyFixture(line2,lineShape,1);
       line.setPosition(new Vec2(0,-5));
        line.setFillColor(Color.red);
        line2.setPosition(new Vec2(0,5));
        line.setLineColor(Color.red);
        line2.setLineColor(Color.red);

        Shape lineShape2 = new BoxShape(0.0001f, 5);
        Body line3 = new StaticBody(this);
        Body line4 = new StaticBody(this);
        GhostlyFixture lineFixture3=new GhostlyFixture(line3,lineShape2,1);
        GhostlyFixture lineFixture4=new GhostlyFixture(line4,lineShape2,1);
        line3.setPosition(new Vec2(10,0));
        line3.setLineColor(Color.red);
        line4.setPosition(new Vec2(-10,0));
        line4.setLineColor(Color.red);


        for (int i = 0; i < 2; i++) {
            Body cargo = new Cargo(this);
            cargo.setPosition(new Vec2(-1 + i * 10, -4 + i * 7));
            cargo.addCollisionListener(new Pickup(getPlayer()));

        }
    }



    @Override public ImageIcon levelBackground(){
        return new ImageIcon("data/b5.png"); }

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
        return getPlayer().getCargoCount()==4;
    }
}