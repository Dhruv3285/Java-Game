package game;

import city.cs.engine.*;

public class Ghost implements CollisionListener{

    private Lander lander;
    private Wall wall;
    private Landinpad landinpad;
    /**  Collisopn listener for bullet fired by the enemy canon in level 4
     * @param lander is a player body.
     * @param wall is a black solid wall in level 4.
     * @param landinpad a pad in level 4 where the rocket drops tge cargo.
     */

    public Ghost(Lander lander,Wall wall,Landinpad landinpad) {

        this.lander=lander;
        this.wall=wall;
        this.landinpad=landinpad;
    }
    /**
     * @param e description of the collide event (destroy bullets shot by the enemy canon if it has contact with anything).

     */
    public void collide(CollisionEvent e){
        //decrement player health
        if(e.getOtherBody()==lander){
            lander.decrementHealth();
            System.out.println(lander.getLivesCount());
            e.getReportingBody().destroy();


        }
        else if(e.getOtherBody() instanceof Wall){
            e.getReportingBody().destroy();

        }
        else if(e.getOtherBody() instanceof Landinpad){
            e.getReportingBody().destroy();

        }
        /** If the player's health is 0 exit the game

         */
        if(lander.getLivesCount()==0){
            //restart the game
           // game.getLevel();
            System.out.println("Game Lost");
           // new Game();
            System.exit(0);

/** If the player's fuel is 0 exit the game

 */
        }
        if(lander.getFuel()==0){
            //restart the game
            // game.getLevel();
            System.out.println("Game Lost");
            // new Game();
            System.exit(0);


        }


    }

}
