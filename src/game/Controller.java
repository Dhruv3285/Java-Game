package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Key handler to control a Walker.
 */
public class Controller extends KeyAdapter {

    private Game game;
    private World world;
    private Lander lander;
    private Walker body;
    private Vec2 upthrust=new Vec2(0f,240f);
    private Vec2 downthrust=new Vec2(0f,-240f);
    private Vec2 rightthrust=new Vec2(80f,0f);
    private Vec2 leftthrust=new Vec2(-80f,0f);





    public Controller(Walker body,World world,Game game) {
        this.body = body;
        this.game=game;
        this.world=world;

    }

    /**
     * Handle key press events for navigation and shooting.
     *
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);

        }
        if (code == KeyEvent.VK_W){
            // w = go up
            body.applyForce(upthrust);
        }
        else if(code==KeyEvent.VK_A){
            // a=go left
            body.applyForce(leftthrust);
        }
        else if (code==KeyEvent.VK_S){
// s = down
            body.applyForce(downthrust);
        }
        else if (code==KeyEvent.VK_D){
// Q = right
            body.applyForce(rightthrust);
        }
 //shoot bullet to right
        else if(code==KeyEvent.VK_P) {

            if (game.getLevel() == 3) {

                Bullet bullet = new Bullet(world);
                bullet.setPosition(new Vec2(body.getPosition().x + 1, body.getPosition().y));
                bullet.setBullet(true);
                bullet.setLinearVelocity(new Vec2(3, 0));
                bullet.addCollisionListener(new BulletPickup(((GameLevel) world).getFuel(), ((GameLevel) world).getPlayer()));
            }
        }




//shoot bullet to left
        else if(code==KeyEvent.VK_O) {
                if (game.getLevel() == 3) {
                    //  System.out.println("this is level 2");
                    Bullet bullet2 = new Bullet(world);
                    bullet2.setPosition(new Vec2(body.getPosition().x, body.getPosition().y));
                    bullet2.setBullet(true);
                    bullet2.setLinearVelocity(new Vec2(-3, 0));
                    bullet2.addCollisionListener(new BulletPickup(((GameLevel) world).getFuel(), ((GameLevel) world).getPlayer()));
                }
            }

    }








    public void KeyReleased(KeyEvent e){
        Vec2 noforce=new Vec2(0f,0f);
        int code=e.getKeyCode();
        if(code==KeyEvent.VK_A){
            body.applyForce(noforce);
        }
        else if(code==KeyEvent.VK_D){
            body.applyForce(noforce);
        }
        else if(code==KeyEvent.VK_W){
            body.applyForce(noforce);
        }
        else if(code==KeyEvent.VK_P){
        }
        else if(code==KeyEvent.VK_O){
        }


    }
    public void setBody(Walker body,World world) {
        this.body = body;
        this.world=world;
    }
}