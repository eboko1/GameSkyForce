package fvi.ua.skyforse;

/**
 * Created by Vika on 25.11.2016.
 */
public class GameSetUp implements  Runnable {
    private String title;
    private int width;
    private int height;

    private  boolean running;

    private Thread thread;

    public GameSetUp(String title, int width, int height){
        this.title=title;
        this.width=width;
        this.height=height;
    }

    public synchronized void start(){
        if (thread==null) {
            thread = new Thread(this);
            thread.start();
        }
    }
    public synchronized  void  stop(){

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

    }
}
