package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.Random;

public class Key extends Walker implements StepListener {
    Random ran=new Random();
    private   Vec2 SPEED=new Vec2(ran.nextInt(5),ran.nextInt(5));
    private static final Shape shape =new CircleShape(0.177f);
    private static BodyImage image =new BodyImage("data/star.png");
    /** Create Keys for level 4 which can be collected to unlock the wall
     * @param world The World.
     */
    public Key(World world){
        super(world,shape);
        addImage(image);
        world.addStepListener(this);
        this.setLinearVelocity(SPEED);
    }

    /**
     * getter and setter for speed

     */
    public Vec2 getSPEED() {
        return SPEED;
    }

    public void setSPEED(Vec2 SPEED) {
        this.SPEED = SPEED;
    }

    /** Set the keys in random pos and random velocity
     * @param stepEvent The description of the stepEvent
     */
    @Override
    public void preStep(StepEvent stepEvent){
        if(this.getPosition().x>11){
            SPEED=new Vec2(-3f,ran.nextInt(5));
            this.setLinearVelocity(SPEED);
        }
        else if(this.getPosition().x<-11){
            SPEED=new Vec2(3f,ran.nextInt(5));
            this.setLinearVelocity(SPEED);

        }

        if(this.getPosition().y>6){
            SPEED=new Vec2(ran.nextInt(5),-3);
            this.setLinearVelocity(SPEED);

        }
        else if(this.getPosition().y<-10){
            SPEED=new Vec2(ran.nextInt(5),3);
                    this.setLinearVelocity(SPEED);

            }


    }
    @Override
    public void postStep(StepEvent stepEvent) {
    }
    }

