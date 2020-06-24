package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class KeyGhost implements CollisionListener{

    private Wall wall;

    private Key key;
    /**
     * Collision Listener for keys/stars
     * If Key has contact with the wall reverse the Key's Velocity
     *
     * @param wall  black wall in the last laevel
     */

    public KeyGhost(Wall wall) {
        this.wall=wall;
        this.key=key;

    }
    /**
     * @param e description of the collisionEvent
     */
    public void collide(CollisionEvent e){

        if(e.getOtherBody() instanceof Wall&& e.getOtherBody()==key){
            key.setSPEED(new Vec2(3,-3));
        }




    }

}
