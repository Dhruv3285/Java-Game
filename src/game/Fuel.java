package game;

import city.cs.engine.*;

public class Fuel extends StaticBody {
    private static final Shape shape = new PolygonShape(-0.875f,0.882f, -0.875f,-0.889f, 0.86f,-0.886f, 0.857f,0.9f, -0.835f,0.886f);

    private static final BodyImage image =new BodyImage("data/fuel.png",3f);
    /** Create a Fuel body
     * @param world The World
   */
    public Fuel(World world) {
        super(world, shape);
        addImage(image);


    }

}
