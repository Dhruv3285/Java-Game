package game;

import city.cs.engine.*;

/**
 * Listener for collision with a door.  When the player collides with a door,
 * if the current level is complete the game is advanced to the next level.
 */
public class DoorListener implements CollisionListener {
    private Game game;

    public DoorListener(Game game) {
        this.game = game;
    }

    /** When player touches the door it goes to the next level
     * @param e description of going next level.*/
    @Override
    public void collide(CollisionEvent e) {
        Lander lander = game.getPlayer();
        if (e.getOtherBody() == lander && game.isCurrentLevelCompleted()) {
            System.out.println("Going to next level...");
            game.levelUp();
        }
    }
}
