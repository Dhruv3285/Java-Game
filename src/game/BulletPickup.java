package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class BulletPickup implements CollisionListener {

    private Bullet bullet;
    private Fuel fuel;
    private Lander lander;

    public BulletPickup(Fuel fuel, Lander lander) {
        this.fuel = fuel;
        this.lander = lander;
    }

    /** If the fired bullet has contact with the fuel bodies in level 3 the bullet as well as the fuel body is
     destroyed.
     @param e description of the Event.*/
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Fuel) {
            System.out.println("contact");
            lander.increamentFuelCount();
            // destroy both bullet and fuel
            e.getOtherBody().destroy();
            e.getReportingBody().destroy();

        }
        /** If all 6 fuel bodies have been shot the health bar and the fuel bar goes back to max.*/
        if (lander.getTarget() == 6) {
            lander.setFuel(480);
            lander.setLivesCount(4);
        }

    }
}
