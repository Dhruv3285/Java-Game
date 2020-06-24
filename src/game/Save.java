package game;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
    /** Class for saving the game

     */
    private String fileName;
    private Game game;
    public Save(String fileName,Game game){
        this.fileName=fileName;
        this.game=game;

    }

    public void writeSave() throws IOException{
        FileWriter writer=null;
        /**
         Save the stats o# the instance when the game is saved
         */
        try{
            writer=new FileWriter(fileName);
            writer.write(game.getLevel() + ","+ game.getPlayer().getPosition().x+","+game.getPlayer().getPosition().y +
            ","+ game.getPlayer().getLivesCount()+ ","+ game.getPlayer().getFuel()+ ","+ game.getPlayer().getCargoCount());
        }
        finally {
            if(writer!=null){
                writer.close();
            }
        }


    }


}
