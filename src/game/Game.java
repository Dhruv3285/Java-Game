package game;

import city.cs.engine.*;
import game.HighScoreWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.io.IOException;


/**
 * A world with some bodies.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel world;


    /** A graphical display of the world (a specialised JPanel). */
    private MyView view;
    public int level;


    private Controller controller;
    /** Initialise a new Game. */
    public Game() {



        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);








        final JFrame frame = new JFrame("Game");
        controller = new Controller(world.getPlayer(),world,this);
        frame.addKeyListener(controller);
        Container buttons = new ControlPanel(this);
        frame.add(((ControlPanel)buttons).getControlPanel(), BorderLayout.SOUTH);

        // make a view

       view = new MyView(world,world.getPlayer(), 500, 500);
        MyView.background=world.levelBackground().getImage();



        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        frame.requestFocus();
        view.addMouseListener(new GiveFocus(frame));


        // start!
        world.start();

    }
    /** The player in the current level. */
    public Lander getPlayer() {
        return world.getPlayer();
    }
    public Cargo getCargo(){return world.getCargo();}

    public Wall getWall(){return world.getWall();}
    /** Is the current level of the game finished? */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }
    public void Paused(){world.stop();}
    public void Resume(){world.start();}

    /** Store the stats of the instance when the game is paused  */
    public void levelStats(int level) {

        world.stop();
        try{
            HighScoreWriter writer=new HighScoreWriter("data/save.text");
            writer.writeHighScore("player",getPlayer().getCargoCount());
        }
        catch(IOException e) {
                e.printStackTrace();
                }
        this.level=level;
        Lander oldLander=world.getPlayer();

        if(level==1){
            world=new Level1();
            gameLevelStats(oldLander);
        }
        else if(level==2){
            world=new Level2();
            gameLevelStats(oldLander);
        }
        else if(level==3){
            world=new Level3();
            gameLevelStats(oldLander);
        }
        else if(level==4){
            world=new Level4();
            System.exit(0);
        }


        }
    /** Advance to the next level of the game. */
    public void levelUp() {
        world.stop();
        if (level == 4) {
            System.exit(0);
        } else if(level==1) {
            level++;
            // get a new world
            world = new Level2();
            world.populate(this);
            controller.setBody(world.getPlayer(),world);

            view.setWorld(world);
            MyView.background=(world.levelBackground().getImage());
            world.start();// fill it with bodies
        }else if(level==2) {
            level++;
            // get a new world
            world = new Level3();
            world.populate(this);
            controller.setBody(world.getPlayer(),world);

            view.setWorld(world);
            MyView.background=(world.levelBackground().getImage());
            world.start();// fill it with bodies
        }
        else if(level==3) {
            level++;
            // get a new world
            world = new Level4();
            world.populate(this);
            controller.setBody(world.getPlayer(),world);

            view.setWorld(world);
            MyView.background=(world.levelBackground().getImage());
            world.start();// fill it with bodies
        }

    }


    /** Run the demo. */
    public static void main(String[] args) {
        new Game();
    }
    public int getLevel(){
        return level;
    }

    public GameLevel getWorld(){return world;}
    /** Run the game when load button is pressed */
    public void gameLevelStats(Lander lander){
        world.populate(this);
        view.setWorld(world);
        MyView.background=world.levelBackground().getImage();
        controller.setBody(world.getPlayer(),world);
        world.getPlayer().setLivesCount(lander.getLivesCount());
        world.getPlayer().setFuel(lander.getFuel());
        world.getPlayer().setCargoCount(lander.getCargoCount());
        world.start();
    }
}

