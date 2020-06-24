package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.io.CharArrayReader;

/**
 * Collision listener that allows the lander to interact with things .
 */
public class Pickup implements CollisionListener{
    private Lander lander;
    private Comet comet;
    private Landinpad landinpad;
    private Key key;
    private Bullet bullet;
private Wall wall;
private Canon canon;






    /** Pickup 1 for
     */
    public Pickup(Lander lander) {

this.lander=lander;
    }

    /** Pickup 2 for the bit in level 4 where the player
     * can go through the wall.
     */
    public Pickup(Lander lander, Wall wall) {

        this.lander=lander;
        this.wall=wall;
    }/** Interaction of the player
     * @param e description of collisionEvent.*/

    @Override
    public void collide(CollisionEvent e) {


        //pickup cargo
        if (e.getReportingBody() instanceof Cargo && e.getOtherBody() ==lander) {
            lander.incrementCargoCount();
            e.getReportingBody().destroy();
        }
        //destroy comet and decrease the player health
        else if (e.getReportingBody() instanceof Comet && e.getOtherBody() ==lander) {

            lander.decrementHealth();
            System.out.println("Life count=" + lander.getLivesCount());
            e.getReportingBody().destroy();
        }



        // drop cargo on the landing pad
        else if (e.getReportingBody() instanceof Landinpad && e.getOtherBody() == lander) {
            if(lander.getLinearVelocity().x==0&&lander.getLinearVelocity().y==0) {
                lander.setCargoCount(0);
                lander.drop();

            }

        }
        //pickup the keys
        else if (e.getReportingBody() instanceof Key && e.getOtherBody() ==lander) {
            lander.increamentKeyCount();
            e.getReportingBody().destroy();

        }
        //lower health when contact with FSM
        else if (e.getReportingBody() instanceof Fsm && e.getOtherBody() ==lander) {
            lander.decrementHealth();
        }

        //change canon's direction of motion when it touches player
       else if(e.getReportingBody() instanceof Canon && e.getOtherBody()==lander){
           System.out.println("collision");
           if(Canon.getSPEED()<0) {
               Canon.setSPEED(-Canon.getSPEED());
           }
            if(Canon.getSPEED()>0) {
                Canon.setSPEED(-Canon.getSPEED());
            }
            ((Walker)e.getReportingBody()).startWalking(Canon.getSPEED());
       }


//change the wall fixture from solid to ghostly so the player can go through it.
if (wall!=null){
    if(lander.getKeyCount()==3){

        lander.setKeyCount(3);
        wall.setFixture2();
    }
}
 if(lander.getLivesCount()==0){
            System.out.println("Game Lost");
            System.exit(0);
        }

    }

}