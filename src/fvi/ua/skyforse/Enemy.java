package fvi.ua.skyforse;

import java.awt.*;

/**
 * Created by Vika on 26.11.2016.
 */
public class Enemy {
    private int x,y;
    public Enemy(int x,int y){
        this.x=x;
        this.y=y;

    }
public void tick(){
    y=y+1;

}
public void render (Graphics g){
    g.setColor(Color.black);
    g.fillOval(x,y,25,25);
}
  public int getX(){
      return x;
  }
    public int getY(){
     return y;
    }
}
