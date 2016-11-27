package fvi.ua.skyforse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Vika on 26.11.2016.
 */
public class GameManager {
    private Player player;

    public static ArrayList<Bullet> bullet;
    public static ArrayList<Enemy> enemies;

    private long current;
    private long delay;

    public GameManager(){

    }

    public void init(){
    player = new Player(GameSetUp.gameWidth/2,(GameSetUp.gameHeight-30)+50);
    player.init();
        bullet=new ArrayList<Bullet>();
        enemies=new ArrayList<Enemy>();
        current=System.nanoTime();
        delay=800;
    }
    public void tick(){
        player.tick();
        for (int i=0; i<bullet.size();i++){
            bullet.get(i).tick();
        }

        //enemies
        for (int i=0;i<enemies.size();i++){
                           enemies.get(i).tick();
        }
    }
    public void render(Graphics gr){
        player.render(gr);
        for (int i=0; i<bullet.size();i++){
            bullet.get(i).render(gr);
        }
        for (int i=0;i<bullet.size();i++){
            if (bullet.get(i).getY()<=50){
                bullet.remove(i);
                i--;
            }
        }
        long breaks=(System.nanoTime()-current)/1000000;
        if(breaks>delay){

        for (int i=0;i<2;i++){
            Random rand=new Random();
            int randX=rand.nextInt(450);
            int randY=rand.nextInt(450);
            enemies.add(new Enemy(randX,-randY));
        }
        current=System.nanoTime();//pause of time
        }
        //enemies
        for(int i=0;i<enemies.size();i++){
            if (!(enemies.get(i).getX()<=50 || enemies.get(i).getX()>=450-25 || enemies.get(i).getY()>=450-25)) {
                if (enemies.get(i).getY()>=50){
            enemies.get(i).render(gr);}}
        }

        //gr.fillRect(0,0,80,80);

        //collision of enemy and player r1=enemies   r2 = bullet
       for (int i=0;i<enemies.size();i++){
           int eX=enemies.get(i).getX();
           int eY=enemies.get(i).getY();

           for (int j=0;j<bullet.size();j++){
               int bX=bullet.get(j).getX();
               int bY=bullet.get(j).getY();

               if (eX<bX+6 && eX+25>bX && eY<bY+6 && eY+25>bY){
                   enemies.remove(i);
                   i--;
                   bullet.remove(j);
                   j--;
               }
           }

       }
    }

}
