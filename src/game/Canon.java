package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Timer;
import org.jbox2d.common.Vec2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





public class Canon extends Walker implements StepListener {

    private static final Shape shape=new PolygonShape(-0.027f,0.484f, -0.891f,-0.8f, -0.015f,-0.976f, 0.885f,-0.812f, 0.013f,0.464f);
    private static BodyImage image=new BodyImage("data/Canon5.png",2f);
    private static float SPEED=3;
    private int index=0;

    @Override
    public Vec2 getPosition() {
        return super.getPosition();
    }
    /**
     * Initialise a  enemy canon shooter
     * @param world The world.
     */


    public Canon(World world){

        super(world,shape);
        addImage(image);
        this.startWalking(SPEED);
        world.addStepListener(this);
        this.addCollisionListener((new Pickup(((GameLevel)getWorld()).getPlayer())));
    }

    public static float getSPEED() {
        return SPEED;
    }

    public static void setSPEED(float SPEED) {
        Canon.SPEED = SPEED;
    }

    /** Reverse the canon Velocity when it hits the edge.
     * @param stepEvent description of the Event.*/
    @Override
    public void preStep(StepEvent stepEvent) {
        index++;
        if(this.getPosition().x>9) {
            SPEED=-3;
            this.startWalking(SPEED);
        }
        else if(this.getPosition().x<-10){
            SPEED=3;
            this.startWalking(SPEED);
        }

        /** The Canon shoots a bullet every 2 seconds(Timer implementation).*/
        if (index%120==0) {
            Shape shape = new CircleShape(0.3f);
            DynamicBody bullet = new DynamicBody(getWorld(), shape);
            bullet.setPosition(new Vec2(getPosition().x, getPosition().y + 1));
            bullet.setBullet(true);
            bullet.setFillColor(Color.BLACK);
            bullet.setGravityScale(0);
            bullet.setLinearVelocity(new Vec2(0, 10));
            //The bullet shot by the canon gets destroyed if it has contact with literally anything.
            bullet.addCollisionListener(new Ghost(((GameLevel)getWorld()).getPlayer(),((GameLevel)getWorld()).getWall(),((GameLevel)getWorld()).getLandinpad()));

        }
    }



    @Override
    public void postStep(StepEvent stepEvent) {


    }

}
