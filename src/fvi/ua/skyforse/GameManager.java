package fvi.ua.skyforse;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Vika on 26.11.2016.
 */
public class GameManager {
    private Player player;

    public static ArrayList<Bullet> bullet;

    public GameManager(){

    }

    public void init(){
    player = new Player(GameSetUp.gameWidth/2,(GameSetUp.gameHeight-30)+50);
    player.init();
        bullet=new ArrayList<Bullet>();
    }
    public void tick(){
        player.tick();
        for (int i=0; i<bullet.size();i++){
            bullet.get(i).tick();
        }
    }
    public void render(Graphics gr){
        player.render(gr);
        for (int i=0; i<bullet.size();i++){
            bullet.get(i).render(gr);
        }

        //gr.fillRect(0,0,80,80);

    }

}
