
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.Color;
import java.io.IOException;


public class Cargo extends StaticBody {
    private static final Shape shape = new PolygonShape(-0.486f, 0.488f, -0.494f, -0.49f, 0.484f, -0.49f, 0.482f, 0.494f, -0.464f, 0.492f);

    private static final BodyImage image = new BodyImage("data/cargo.png", 1.4f);

    private static SoundClip cargosound;


    /**
     * Initialise a cargo
     * @param world The world.
     */

    public Cargo(World world) {
        super(world, shape);
        addImage(image);

    }
}


