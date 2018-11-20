     
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


public class Board  extends JPanel implements Runnable, MouseListener
{
boolean ingame = false;
boolean wingame = false;
boolean losegame = false;
boolean shootBullet = false;
private Dimension d;
int BOARD_WIDTH=500;
int BOARD_HEIGHT=500;
int x = 0;

BufferedImage img;
BufferedImage img2;
BufferedImage img3;


private Thread animator;

int ax = 35;
int ay = 20;
int rVal = 0;
int cVal = 0;
int time = 0;

int xCord = 0;
int holeNum = 0;
int scoreMultiplier = 0;
int checkMultiplier = 0;
int determineMovement = 0;
String message = "PRESS DOWN ARROW TO BEGIN!";
String winMessage = "YOU HAVE DEFEATED ALL OF THE ALIENS!";
String mes1 = "PRESS DOWN ARROW IF YOU WANT TO PLAY AGAIN!";
String loseMessage = "YOU LOST! PRESS DOWN ARROW IF YOU WANT TO PLAY AGAIN!";




boolean erase = false;
boolean determineKey = false;
boolean isVis = false;



int bulletCord = 20;


int typeMovement = 1;




boolean[][] alienArr = new boolean[9][9];

  
  
       

 
    public Board()
    {
        
          for(int i = 0; i < alienArr.length; i++){
              for(int j = 0; j < alienArr[0].length; j++){
                  alienArr[i][j] = true;
                }
            }
        
        
          addKeyListener(new TAdapter());
          addMouseListener(this);
          setFocusable(true);
          d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
          setBackground(Color.black);
       
                   
             try {
                img = ImageIO.read(this.getClass().getResource("alien.png"));
            } catch (IOException e) {
                 System.out.println("Image could not be read");
            // System.exit(1);
            }
       
            
           
            if (animator == null || !ingame) {
            animator = new Thread(this);
            animator.start();
            }
                    
  
        setDoubleBuffered(true);
    }
    
    public void paint(Graphics g)
{
super.paint(g);

g.setColor(Color.blue);
g.fillRect(0, 0, d.width, d.height);
//g.fillOval(x,y,r,r);


        //For determination of game beginning
       Font small = new Font("Helvetica", Font.BOLD, 10);
       FontMetrics metr = this.getFontMetrics(small);
       g.setColor(Color.black);
       g.setFont(small);
       
       //Using GUI to display score
       Font scoringFont = new Font("Helvetica", Font.BOLD, 10);
       FontMetrics scoringMetric = this.getFontMetrics(scoringFont);
       g.setColor(Color.black);
       g.setFont(scoringFont);
       
     
       
       
       
       
       
       
       
       
       if (!ingame && checkMultiplier == alienArr.length * alienArr[0].length) {
           
           
           for(int i = 0; i < alienArr.length; i++){
              for(int j = 0; j < alienArr[0].length; j++){
                  alienArr[i][j] = true;
                }
           }
           
           rVal = 0;
           cVal = 0;
           
           
           Font winFont = new Font("Helvetica", Font.BOLD, 10);
           FontMetrics winMetric = this.getFontMetrics(winFont);
           g.setColor(Color.black);
           g.setFont(winFont);
           
           
           
           g.drawString(winMessage, 120, d.height-250);
           g.drawString(mes1, 100, d.height - 225);
           
        } else if (losegame && !ingame){
            
              for(int i = 0; i < alienArr.length; i++){
              for(int j = 0; j < alienArr[0].length; j++){
                  alienArr[i][j] = true;
                }
           }
           
           Font winFont = new Font("Helvetica", Font.BOLD, 10);
           FontMetrics winMetric = this.getFontMetrics(winFont);
           g.setColor(Color.black);
           g.setFont(winFont);
           
           
           
           
           rVal = 0;
           cVal = 0;
           time = 0;
           
           g.drawString(loseMessage, 80, d.height - 250);
           
            
        }else if (!ingame){
       
           g.drawString(message, 175, d.height-250);
            
        }else if(ingame){   
        
            time += 1;
       
       
       
        animate(g, bulletCord, xCord, rVal, cVal);
        
        
        String scoreMessage = "SCORE : " + 10 *scoreMultiplier;
        checkMultiplier = scoreMultiplier;
        
        g.drawString(scoreMessage, 25, d.height - 480);
        scoreMultiplier = 0;

        
          
        
        
        
       if(determineKey){  
        bulletCord += 20;
        repaint();
          
        
      } else if(isVis == false){
          bulletCord = 20;
          repaint();
      }
         
     
      
        Player player = new Player(g, xCord);
        
      
        
        //eraseAlien(g, bulletCord, xCord, rVal, cVal);
        
        //g.drawImage(img3, 250 + xCord, 450 - 20, 15, 15, null);
        
            
        Shots shot = new Shots(g, xCord, bulletCord);
          //shootBullet(g, 250 + xCord, 450 - bulletCord);
          
          int animationDelay2 = 50 ;
          long time2 = 
          System.currentTimeMillis();
      
     
    
      
      
      try {
        time2 += animationDelay2;
        Thread.sleep(Math.max(0,time2 - 
          System.currentTimeMillis()));
       }catch (InterruptedException e) {
         System.out.println(e);
       }//end catch
       
       
       if(checkMultiplier == alienArr.length * alienArr[0].length ){
          
      
           ingame = false;
           
           
       
        }
        
     
       
      
    }
    
    
  
      
     
    
        
            
        
     

      
        
    
     
    
   

    
 
    
    
Toolkit.getDefaultToolkit().sync();
g.dispose();
}

public int animate(Graphics g, int bulletCord, int xCord, int rVal, int cVal ){
    
    for(int r = rVal; r < alienArr.length + rVal; r++){
        for(int c = cVal; c < alienArr[0].length +cVal; c++){
            
           
            eraseAlien(bulletCord, xCord, r, c, rVal, cVal);
              
            
           
            
            //alienArr[r][c] = new Aliens(ax * r, ay * c);
            
        }
        
    }
    
    
    for(int r = rVal; r < alienArr.length + rVal; r++){
        for(int c = cVal; c < alienArr[0].length +cVal; c++){
            
           
            if(alienArr[r - rVal][c- cVal] ){
                g.drawImage(img, ax*r, ay*c, 15, 15, null);
                
                
            }else {
                scoreMultiplier += 1;
                
            }
            
            
            
            
            
            
            
        }
        
    }
    
    
    
    
    
    
    
    return scoreMultiplier;
    
    
    
    
    
    
  
}

   
public void eraseAlien(int bulletCord, int xCord, int r, int c, int rVal, int cVal){

            if( (( ( 250 + xCord >= (ax * r) - 15 ) &&  (250 + xCord <= (ax * r ) + 15) ) && ( (450 - bulletCord >= (ay * c) - 15) && (450 - bulletCord <= (ay * c) + 15) ))   ){
               
               
               isVis = false;
               alienArr[r - rVal][c - cVal] = isVis;
              
               
               
            }
            
            /*
            isVis = true;
            alienArr[r - rVal][c - cVal] = isVis;
            return isVis;
            */
            
}
        
    


   




private class TAdapter extends KeyAdapter {
    


public void keyReleased(KeyEvent e) {
     int key = e.getKeyCode();
     
}

public void keyPressed(KeyEvent e) {
//System.out.println( e.getKeyCode());
   // message = "Key Pressed: " + e.getKeyCode();
    int key = e.getKeyCode();
        
        if(key == 40){
            ingame = true;
        }
    
        if(key==39 ){
          xCord += 10;
          
        
         //bulletCord += 20;
        } 
        
        if(key == 37 ){
           xCord -= 10;
            
        
            
            //bulletCord += 20;
        }
        
         if(key == 32){

            determineKey = true;
            
            
        
        } else if(key != 32){
            
            determineKey = false;
            
        }
        
      
        
        
        
        
        
        
        //erase = false;
        
        
        
        
        
        
        
       

}

}




public void mousePressed(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    System.out.println(x);
    System.out.println(y);
     

}

public void mouseReleased(MouseEvent e) {

}

public void mouseEntered(MouseEvent e) {

}

public void mouseExited(MouseEvent e) {

}

public void mouseClicked(MouseEvent e) {

}

public void run( ) {



long beforeTime, timeDiff, sleep;

beforeTime = System.currentTimeMillis();
int animationDelay1 = 900;


 
 long time1 = 
            System.currentTimeMillis();
            

 
            

 
    while (true) {//infinite loop
      //spriteManager.update();
      
      if( (35 * (alienArr.length + (rVal + 1) ) > 500 || (35 * (rVal) < -5)) ){
          cVal += 1;
          typeMovement += 1;
          
      }
        
      if(typeMovement % 2 != 0 ) {
          rVal += 1;
      } 
      
      if( (typeMovement % 2 == 0)){
          rVal -= 1;
      }
      
      
      
      
       
      
      
     
      
      repaint();
      try {
        time1 += animationDelay1;
        Thread.sleep(Math.max(0,time1 - 
          System.currentTimeMillis()));
      }catch (InterruptedException e) {
        System.out.println(e);
      }//end catch
      
     
    }//end while loop
    
     
   
   
      
     

    


}//end of run



}
