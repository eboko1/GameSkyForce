package fvi.ua.skyforse;

import java.awt.*;

/**
 * Created by Vika on 26.11.2016.
 */
public class GameManager {
    private Player player;

    public GameManager(){

    }

    public void init(){
    player = new Player(GameSetUp.gameWidth/2,(GameSetUp.gameHeight-30)+50);

    }
    public void tick(){
        player.tick();

    }
    public void render(Graphics gr){
        player.render(gr);
        //gr.fillRect(0,0,80,80);

    }

}
