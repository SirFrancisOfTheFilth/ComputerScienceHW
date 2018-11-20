
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
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


public class Player
{
    BufferedImage img;
    // instance variables - replace the example below with your own
    public int x;

    /**
     * Constructor for objects of class Player
     */
    
    
    public Player(Graphics g, int xCord)
    {
        this.x = xCord;
        drawPlayer(g, x);
        
    }
    
    
    
    public void drawPlayer(Graphics g, int xCord){
               try {
              img = ImageIO.read(this.getClass().getResource("player.png"));
            } catch (IOException e) {
               System.out.println("Image could not be read");
               // System.exit(1);
       }
            
      
       g.drawImage(img, 250 + xCord, 450, 15, 15, null);
           

    }
    
    
    
  
}
