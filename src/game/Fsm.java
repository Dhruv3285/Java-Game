package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class Fsm extends Walker implements StepListener {


    private boolean limit=false;
    private static final Shape shape = new PolygonShape(-1.48f,-1.43f, 1.48f,-1.47f, 1.45f,-0.78f, 0.0f,1.48f, -1.45f,-0.79f, -1.48f,-1.3f);

    private static final BodyImage image = new BodyImage("data/ufo.png", 3f);
    private enum State {
         STAND_STILL
    }
    private Game game;
    private State state;
    /** Create a FSM body
     * @param world The World
     * @param game The Game*/
    public Fsm(Game game,World world){
        super(world,shape);
        this.game=game;
        addImage(image);
        state=State.STAND_STILL;
        getWorld().addStepListener(this);

    }

    /**
     * @param e description of FSM chasing the player under particular conditions.
    */
    public void preStep(StepEvent e) {
        // condition to chase the player
        if(game.getPlayer().getPosition().y>-4&&game.getPlayer().getPosition().y<5&&game.getPlayer().getPosition().x<10&&game.getPlayer().getPosition().x>-10){
            limit=true; }
            else{
               limit=false;}
            // Setting the Velocity of teh FSM so that it goes towards towards the Player
        Vec2 dist=new Vec2(game.getPlayer().getPosition().sub(this.getPosition()));
        // if condition are true than the velocity of the FSM should be toward the player
        if(limit){
            this.setLinearVelocity(dist.mul(1)); }
              //else the Velocity of the FSM is zero
            else{ setLinearVelocity(new Vec2(0,0));
                        }

    }

    public void postStep(StepEvent e) {
    }
}
