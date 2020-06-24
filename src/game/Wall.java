package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Wall extends StaticBody   {
    private static final Shape shape=new BoxShape(13,0.3f);


        private  SolidFixture fixture1;
        private  GhostlyFixture fixture2;


    /**
     * Create a wall
     * @param world The world.
     */

    public Wall(World world){
        super(world);
        fixture1=new SolidFixture(this,shape,10);

    }

    /**
     * change the wall fixture from solid to ghostly.

     */
    public void setFixture2(){


        fixture1.destroy();
        fixture2=new GhostlyFixture(this,shape,10);
    }


    }


