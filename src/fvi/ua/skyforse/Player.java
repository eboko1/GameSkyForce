package fvi.ua.skyforse;

import java.awt.*;

/**
 * Created by Vika on 26.11.2016.
 */
public class Player {
    private int x;
    private int y;


    public  Player(int x, int y){
        this.x=x;
        this.y=y;

    }
    public void init(){}
    public void  tick(){}
    public  void render(Graphics gr){
        gr.setColor(Color.red);
        gr.fillRect(x,y,30,30);
    }
}
