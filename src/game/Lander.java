package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;


/**
 * Lander/Rocket/player character
 */
public class Lander extends Walker implements StepListener {


    private Wall wall;
   private  Vec2 stepDist;
    private Vec2 oldDist;
   private  Vec2 newDist;
     private static float dist=0;
    private static int fuel=480;
    private static SoundClip cometsound;
    private static SoundClip cargosound;
    private static int target=0;
    private static int livesCount=4;
    private static final Shape shape = new PolygonShape(
            -0.048f,1.085f, -0.466f,0.194f, -0.574f,-1.093f, 0.564f,-1.093f, 0.465f,0.194f, 0.038f,1.089f);

    private static final BodyImage image =
            new BodyImage("data/rocket.png", 2.25f);

    /**
     * Sound clips if player has contact with comet, bullet or cargo
     */
    static {
        try {
            cometsound = new SoundClip("data/blast.wav");
            //find another sound foe this
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    static {
        try {
            cargosound = new SoundClip("data/cargo.wav");
            //find another sound foe this
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }


    private static int keyCount;
    private static int cargoCount;

    public Lander(World world) {
        super(world, shape);
        addImage(image);
        world.addStepListener(this);


    }




    /**
     * Methods in the Player class
     */

//getter and setters
    public int getCargoCount(){return cargoCount;}
    public int getLivesCount(){return livesCount;}
    public int getTarget(){return target;}
    public int getFuel(){return fuel;}
   public void setFuel(int fuelcnt){fuel=fuelcnt;}
    public  int getKeyCount(){return keyCount;}
    public  void setKeyCount(int cnt){keyCount=cnt;}
    public void setLivesCount(int lifecnt){livesCount=lifecnt;}
    public void setCargoCount(int cnt){
        cargoCount=cnt;
    }

   //increase the fuel
    public void increamentFuelCount(){ target++; }
    //increase the cargo
    public void incrementCargoCount(){ cargoCount++;System.out.println("Cargo collected=" +cargoCount);cargosound.play(); }
    //increase the key/star
    public void increamentKeyCount(){ keyCount++;System.out.println("Key collected="+keyCount);cargosound.play(); }
    //for health lost
    public void decrementHealth(){ livesCount--;System.out.println("LifeLost!"); cometsound.play(); }
    //create the cargo body
    public void drop(){ Body cargo = new Cargo(getWorld());cargo.setPosition(new Vec2(11 , 11 )); }
    public void getDist(){
        System.out.println(dist);

    }
















    @Override
    public void preStep(StepEvent stepEvent) {
        oldDist=this.getPosition();

        if(fuel<=0){
            System.exit(0);

        }
    }

    /**
     * Code for fuel implementation
     */
    @Override
    public void postStep(StepEvent stepEvent) {
        newDist=this.getPosition();
        stepDist=newDist.sub(oldDist);

        dist=5*stepDist.length();
        fuel=(fuel-(Math.round(dist)));




    }
}
