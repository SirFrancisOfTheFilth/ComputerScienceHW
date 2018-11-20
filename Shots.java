import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
/**
 * Write a description of class Shots here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shots
{
    BufferedImage img3;
    // instance variables - replace the example below with your own
   public int xCord;
   public int cordBullet;
    /**
     * Constructor for objects of class Shots
     */
    public void paintComponent(Graphics g){
        shootBullet(g, xCord, cordBullet);
    }
    
    public Shots(Graphics g, int x, int bullet)
    {
        this.xCord = x;
        this.cordBullet = bullet;
        
        shootBullet(g, xCord, cordBullet);
    
    }
        
    

    public void shootBullet(Graphics g, int xCord, int cordBullet){
       try {
                img3 = ImageIO.read(this.getClass().getResource("pshot.png"));
       } catch (IOException e) {
           System.out.println("Image could not be read");
           // System.exit(1);
       }
       
       g.drawImage(img3, 255 + xCord, 450 - cordBullet, 4, 4, null);
    
    }
}
