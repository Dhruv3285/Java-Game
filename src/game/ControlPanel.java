package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * implementation of buttons
 */
public class ControlPanel extends javax.swing.JPanel  {
    private Game game;
    private JPanel mainPanel;
    public JPanel controlPanel;
    private JButton saveButton;
    private JButton pauseButton;
    private JButton quitButton;
    private JButton nextLevelButton;
    private JButton loadButton;
    private JComboBox saveBox;
    private JComboBox loadBox;


    public ControlPanel(Game game) {
        this.game = game;

/**
 * pause buttons
 */
        pauseButton.addActionListener(new ActionListener() {
            Boolean isPause=false;
            @Override
            public void actionPerformed(ActionEvent e) {
              if(!isPause){
                  game.Paused();
                  pauseButton.setText("Resume");
              }
              else{
                  game.Resume();
                  pauseButton.setText("Pause");
              }
              isPause=!isPause;
            }
        });

        /**
         * save drop down box
         */
        saveBox.addActionListener(new ActionListener() {
            @Override
            /**
             * Three game states can be saved
             */
            public void actionPerformed(ActionEvent e) {
                try {
                  if(saveBox.getSelectedIndex()==1) {
                      Save save=new Save("data/save1.txt",game);
                      save.writeSave();
                  }
                    if(saveBox.getSelectedIndex()==2) {
                        Save save=new Save("data/save2.txt",game);
                        save.writeSave();
                    }
                    if(saveBox.getSelectedIndex()==3) {
                        Save save=new Save("data/save3.txt",game);
                        save.writeSave();
                    }
                  }
                  catch (IOException ex){
                    ex.printStackTrace();
                }

            }
        });
        /**
         * load drop down box
         */
        loadBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                 if(loadBox.getSelectedIndex()==1){
                     Load load=new Load("data/save1.txt",game);
                    load.readSave();
                 }
                    if(loadBox.getSelectedIndex()==2){
                        Load load=new Load("data/save2.txt",game);
                        load.readSave();
                    }
                    if(loadBox.getSelectedIndex()==3){
                        Load load=new Load("data/save3.txt",game);
                        load.readSave();
                    }


                }
                catch (GameLoadException ex){
                    ex.printStackTrace();
                }

            }
        });
        /**
         * quit button
         */

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exiting");
                System.exit(0);

            }
        });
        /**
         * next level button
         */
        nextLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               game.getLevel();
               game.levelUp();

            }
        });







    }
    public JPanel getControlPanel(){
        return mainPanel;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}








