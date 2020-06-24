package game;

import city.cs.engine.*;

/**
 * Doors in a game. When the actor collides with a door, if
 * the current level is complete the game is advanced to the
 * next level.
 */
public class Door extends StaticBody {

    /**
     * Initialise a new door.
     * @param world The world.
     */
    public Door(World world) {
        super(world, new PolygonShape(-0.029f,0.9f, -0.782f,0.125f, -0.007f,-0.643f, 0.848f,0.147f, 0.065f,0.878f));
        addImage(new BodyImage("data/portal.gif", 2.8f));
    }
}
