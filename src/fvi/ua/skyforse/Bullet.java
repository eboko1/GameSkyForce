package fvi.ua.skyforse;

import java.awt.*;

/**
 * Created by Vika on 26.11.2016.
 */
public class Bullet {
   private  int x,y,speed;

    public Bullet(int x,int y){
        this.x=x;
        this.y=y;
        speed=10;
    }
    public void tick(){

        y=y-speed;
    }
    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }
    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x,y,6,10);
    }

}
