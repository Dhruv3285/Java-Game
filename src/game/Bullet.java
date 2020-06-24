package game;
import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/** Bullet fired by player in level 3 class.*/
public class Bullet extends Walker {

    private static final Shape shape=new PolygonShape(-0.008f,0.3f, -0.126f,-0.163f, -0.126f,-0.292f, 0.124f,-0.294f, 0.12f,-0.163f, -0.001f,0.299f);
    private static  BodyImage image=new BodyImage("data/canon.png",0.6f);
    private static SoundClip bulletsound;

    public Bullet(World world){
        super(world,shape);
        addImage(image);
        this.setGravityScale(0f);
        this.addCollisionListener(new BulletPickup(((GameLevel)getWorld()).getFuel(),((GameLevel)getWorld()).getPlayer()));
        bulletsound.play();
    }
    /** Sound when bullet is fired*/
    static {
        try {
            bulletsound = new SoundClip("data/explosion.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

}

