package fvi.ua.skyforse;

import javax.swing.*;

/**
 * Created by Vika on 24.11.2016.
 */
public class Display {
   private  String title;
    private int width;
    private int height;

    private JFrame frame;
    public Display(String title, int width, int height){
        this.title=title;
        this.width=width;
        this.height=height;
        createDisplay();
    }
 public  void createDisplay(){
     frame= new JFrame(title);
     frame.setSize(width,height);
     frame.setVisible(true);
     frame.setLocationRelativeTo(null);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }

}