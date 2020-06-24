package game;
import city.cs.engine.*;


import city.cs.engine.DynamicBody;


public class Landinpad extends StaticBody {
    private static final Shape shape=new PolygonShape(-2.137f,0.383f, -2.154f,-0.384f, 2.12f,-0.393f, 2.128f,0.4f, -2.042f,0.4f);
    private static  BodyImage image=new BodyImage("data/lp.png",0.8f);




    /** crate a landing pad where rocket drops the cargo
     * @param world The world
     */
    public Landinpad(World world){
        super(world,shape);
        addImage(image);



    }
}
