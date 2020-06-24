package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;
import city.cs.engine.Walker;

public class CometListiner implements CollisionListener {

   private Comet comet;

    public CometListiner(Comet comer) {
        this.comet=comer;
    }

    /**
     * Comet Listener
     * @param e when comet touche player destroy the comet.
     */

    public void collide(CollisionEvent e) {
        if (e.getReportingBody() instanceof StaticBody && e.getOtherBody() ==comet) {
        Comet.setCometSpeed(-Comet.getCometSpeed());

            ((Walker)e.getReportingBody()).startWalking(Comet.getCometSpeed());
        }
        }



    }

