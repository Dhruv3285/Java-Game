package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;
import java.util.Random;

public class Comet extends Walker implements StepListener {
    private static float COMET_SPEED=4f;
    private static final Shape shape=new CircleShape(0.177f);
    private static  BodyImage image=new BodyImage("data/astroid.gif",0.8f);




    /**
     * Initialise a comet
     * @param world The world.
     */


    public Comet(World world){
        super(world,shape);
        addImage(image);
        world.addStepListener(this);
        this.startWalking(COMET_SPEED);


    }

    /**
     * getters and setters for comet speed
     */
    public static float getCometSpeed() {
        return COMET_SPEED;
    }

    public static void setCometSpeed(float cometSpeed) {
        COMET_SPEED = cometSpeed;
    }

    /** Reverse the comet velocity if it goes to the edge.
     * @param stepEvent description of the prsStep*/
    @Override
    public void preStep(StepEvent stepEvent){

        if(this.getPosition().x>11){
            COMET_SPEED=-4f;
            this.startWalking(COMET_SPEED);
            removeAllImages();
            BodyImage image=new BodyImage("data/rotated.gif",0.8f);
            addImage(image);

        }
        else if(this.getPosition().x<-11){
            COMET_SPEED=4f;
            this.startWalking(COMET_SPEED);
           removeAllImages();
            BodyImage image=new BodyImage("data/astroid.gif",0.8f);
            addImage(image);
        }





    }
    @Override
    public void postStep(StepEvent stepEvent){

    }

}
