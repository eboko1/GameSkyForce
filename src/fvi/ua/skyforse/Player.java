package fvi.ua.skyforse;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Created by Vika on 26.11.2016.
 */
public class Player implements KeyListener {
    private int x;
    private int y;
    private boolean left,right,fire;

    private long current;//ток
    private long delay;
    private int health;


    public  Player(int x, int y){
        this.x=x;
        this.y=y;

    }
    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }

    public void setHealth(int health){
        this.health=health;

    }

    public void init(){
        Display.frame.addKeyListener(this);
        current=System.nanoTime();
        delay=100;
        health=3;
    }

    public void  tick() {
        if (!(health <= 0)) {
            if (left) {
                if (x >= 50) {
                    x = x - 4;
                }
            }
            if (right) {
                if (x <= 450 - 30) {
                    x = x + 4;
                }
            }
            if (fire) {
                long breaks = System.nanoTime() - current / 100000;
                if (breaks > delay) {
                    GameManager.bullet.add(new Bullet(x + 12, y));
                }
                current = System.nanoTime();
            }
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
        if (source==KeyEvent.VK_B){
            fire=true;
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
        if (source==KeyEvent.VK_B){
            fire=false;
        }

    }
    public  void  keyTyped(KeyEvent e){}

}
