package game;

import org.jbox2d.common.Vec2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/** Class for loading the game

 */

public class Load {
    private Game game;
    private String fileName;
    private GameLevel world;

    public Load(String fileName,Game game){
        this.fileName=fileName;
        this.game=game;

    }
    public void readSave() throws GameLoadException{
        FileReader fr=null;
        BufferedReader reader=null;
        try{
            System.out.println("Reading"+ fileName+" ...");
            fr=new FileReader(fileName);
            reader=new BufferedReader(fr);
            String line=reader.readLine();
            if(line!=null){
                String[] strings=line.split(",");
                int level=1;
                float posX=0;
                float posY=0;
                int livesCount=0;
                int cargoCount=0;
                int fuel=0;
/**
 read from the saved file
 */
                try{
                    level=Integer.parseInt(strings[0]);
                    posX=Float.parseFloat(strings[1]);
                    posY=Float.parseFloat(strings[2]);
                    livesCount=Integer.parseInt(strings[3]);
                    fuel=Integer.parseInt(strings[4]);
                    cargoCount=Integer.parseInt(strings[5]);


                }
                catch (NumberFormatException e){
                    game.levelStats(1);
                    throw new GameLoadException("error loading player into game");
                }
                /**
                 set stats according to the stats when the game was saved.
                 */
                game.levelStats(level);
                world=game.getWorld();
                game.getPlayer().setPosition(new Vec2(posX,posY));
                game.getPlayer().setCargoCount(cargoCount);
                game.getPlayer().setFuel(fuel);
                game.getPlayer().setLivesCount(livesCount);
                System.out.println("...done.");

            }
        } catch (FileNotFoundException e){
            throw new GameLoadException("file does not exist");

        } catch (IOException e){
            throw  new GameLoadException("problem reading file");
        }
    }
}
