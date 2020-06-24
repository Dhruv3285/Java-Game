
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
/** My view for graphics
 *
 */
public class MyView extends UserView {
private Lander lander;
private int X;
private int cargo;
private int fuel;

    static Image background;
    private static final Image icon=new ImageIcon("data/cube5.png").getImage();



    MyView(World world,Lander lander, int height, int width) {
        super(world, width, height);
        this.lander=lander;


    }
    /** Set background of the game
     *
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, 500, 500, this);
    }
    /** Set foreground icons in the game
     *
     */

    @Override
    protected void paintForeground(Graphics2D g) {
        cargo=lander.getCargoCount();
        fuel=lander.getFuel();
        g.setColor(Color.WHITE);
        g.setFont(new Font("Font",Font.PLAIN,16));
        //g.drawString("Cargo:"+lander.getCargoCount(),100,100);
        g.drawString("Health",55,80);
        g.drawString("Cargo",55,55);

        /** health bar
         */

        g.setColor(Color.RED);
        g.draw3DRect(110,66,80,15,true);
        if(lander.getLivesCount()==0){
            X=0;

        }
        else if(lander.getLivesCount()==1){
          X=20;

        }
        else if(lander.getLivesCount()==2){
            X=40;

        }
        else if(lander.getLivesCount()==3){
            X=60;

        }
        else if(lander.getLivesCount()<=4){
            X=80;

        }

        g.fill3DRect(110,66,X,15,true);
        g.setColor(Color.GREEN);
        g.draw3DRect(12,484,480,13,true);
        /** fuel bar
         */
        g.fill3DRect(12,484,fuel,13,true);
        g.setColor(Color.RED);
        g.setFont(new Font("Font",Font.BOLD,14));
        g.drawString("Fuel",240,496);

        /** cube icons for cargo collected
         */
        for(int i=0;i<cargo;i++) {
            g.drawImage(icon, 100+30*i, 35, 30, 30, this);
        }


    }

}