package fvi.ua.skyforse;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.dgc.Lease;

/**
 * Created by Vika on 26.11.2016.
 */
public class Player implements KeyListener {
    private int x;
    private int y;
    private boolean left,right;


    public  Player(int x, int y){
        this.x=x;
        this.y=y;

    }
    public void init(){
        Display.frame.addKeyListener(this);

    }

    //
    public void  tick(){
        if (left){
            x=x-1;
        }
        if (right){
            x=x+1;
        }

    }
    public  void render(Graphics gr){
        gr.setColor(Color.red);
        gr.fillRect(x,y,30,30);
    }
    public  void  keyPressed(KeyEvent e){
        int source = e.getKeyCode();
        if (source==KeyEvent.VK_LEFT){
            left=true;
        }
        if (source==KeyEvent.VK_RIGHT){
            right=true;
        }
    }
    public  void  keyReleased(KeyEvent e){
        int source = e.getKeyCode();
        if (source==KeyEvent.VK_LEFT){
            left=false;
        }
        if (source==KeyEvent.VK_RIGHT){
            right=false;
        }
    }
    public  void  keyTyped(KeyEvent e){}

}
