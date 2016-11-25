package fvi.ua.skyforse;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Vika on 25.11.2016.
 */
public class GameSetUp implements  Runnable {
    private String title;
    private int width;
    private int height;

    private  boolean running;

    private BufferStrategy buffer;
    private Graphics gr;
    private int y;


    private Thread thread;
    private Display display;

    public GameSetUp(String title, int width, int height){
        this.title=title;
        this.width=width;
        this.height=height;
    }

    public  void init(){
        display = new Display(title,width,height);

    }

    public synchronized void start(){
        if (running) return;
        running = true;
        if (thread==null) {
            thread = new Thread(this);
            thread.start();
        }
    }
    public synchronized  void  stop(){
        if (!(running)) return;
         running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public  void tick(){
        y=y+1;

    }
    public void render(){
      buffer = display.getCanvas().getBufferStrategy();
        if (buffer==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        gr = buffer.getDrawGraphics();
        gr.clearRect(0,0,width,height);

        //draw
        gr.fillRect(33,y,44,44);
        //end of draw

        buffer.show();
        gr.dispose();
    }

    @Override
    public void run() {
        init();
        int fps = 50;
        double timePerTick=1000000000/fps;
        double delta =0;
        long current =System.nanoTime();


        while (running){
            delta=delta+(System.nanoTime()-current)/timePerTick;
            current=System.nanoTime();
            if(delta>=1){
                tick();
                render();
                delta--;
            }
      }
    }
}
