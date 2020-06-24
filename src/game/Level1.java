package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel {
    private static final int NUM_CARGO = 2;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);


        Shape groundShape = new BoxShape(13, 0.1f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));

        for (int i = 0; i < 2; i++) {
            Shape portShape = new BoxShape(1.5f, 0.1f);
            Body port = new StaticBody(this, portShape);
            port.setPosition(new Vec2(-1 + i * 10, -4 + i * 7));


        }
        for (int i = 0; i < 2; i++) {
            Body cargo = new Cargo(this);
            cargo.setPosition(new Vec2(-1 + i * 10, -3 + i * 7));
            cargo.addCollisionListener(new Pickup(getPlayer()));

        }


        for (int i = 0; i < 3; i++) {
            Body comet = new Comet(this);
            Random ran = new Random();
            comet.setPosition(new Vec2(ran.nextInt(5), 7 - i * 6));
            comet.addCollisionListener(new Pickup(getPlayer()));
            comet.addCollisionListener(new game.CometListiner(getComet()));

            ((Comet) comet).setGravityScale(0f);

        }








    }

    @Override public ImageIcon levelBackground(){
        return new ImageIcon("data/background.png"); }

        @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-10.4f, -9.6f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getCargoCount() == NUM_CARGO;
    }


}
