//Connect Four Algorithm: APCS


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DrawGrid {
    private JFrame frame;
    static int xCord = 0;
    static int yCord = 0;

    public DrawGrid() {
        frame = new JFrame("DrawGrid");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(frame.getSize());
        frame.add(new MultiDraw(frame.getSize()));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String... argv) {
        new DrawGrid();
    }

    public static class MultiDraw extends JPanel  implements MouseListener {
        int startX = 0;
        int startY = 0;
        int side = 200;

        Color[][] grid = new Color[8][8];

        public MultiDraw(Dimension dimension) {
            setSize(dimension);
            setPreferredSize(dimension);
            addMouseListener(this);
            
            int x = 0;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                   if( (col % 2 == 0) && (row % 2 != 0) ){
                       grid[row][col] = Color.black;
                    } else if(  (col % 2 != 0) && (row % 2 == 0) ){
                        grid[row][col] = Color.black;
                    } else {
                        grid[row][col] = Color.white;
                    }
          
                }
      
            }
        }
        
        int xCord;
        int[] maxPositionArr = {7, 7, 7, 7, 7, 7, 7, 7};
        int colorDetermining = 1;
        int counter = 1;
        

        

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            Dimension d = getSize();
            startX = 0;
            startY = 0;
            
            for(int row = 0; row < grid.length; row++){
                for(int col = 0; col < grid[0].length; col++){
                    g2.setColor(grid[row][col]);
                    g2.fillRect(row * (side/8), col * (side/8), side/8, side/8);
                }
 
            }
            
            
                
                  
                  if(colorDetermining % 2 == 0){
                  Color color1 = Color.blue;
                  if(winDeterminer(color1, xCord, yCord, grid)){
                      System.out.println("Blue wins!");
                  }
                } else if(colorDetermining % 2 != 0){
                    Color color1 = Color.red;
                    if(winDeterminer(color1, xCord, yCord, grid)){
                       System.out.println("Red wins!");
                    }
               }
            
           
               
            
            
                   
                    
            
            

        }
        
        
        
        
        
        

        
        
   
       
        
        public boolean winDeterminer(Color color1, int x, int y, Color[][] grid){
                
               
               System.out.println(color1);
               System.out.println((maxPositionArr[x/(side/8)]) + 1);
               System.out.println((x/(side/8)) );
               System.out.println("------------------------------------------------------------------");
               
            
               
               
               int firstNum = 1;//horizontal east
               int secondNum = 1;//horizontal west
               int thirdNum = 1;//vertical north
               int fourthNum = 1;//vertical south
               int fifthNum = 1;//diagonal northeast
               int sixthNum = 1;///diagonal northwest
               int seventhNum = 1;//diagonal southeast
               int eighthNum = 1;//diagonal southwest
             
               
               
                
                 
                
                 
                
                
                      
            
                  
               
             
             while( ((x/(side/8)) + firstNum <= 7) && grid[maxPositionArr[x/(side/8)] + 1][x/(side/8) + firstNum] == color1){
                 
                     
                     System.out.println((maxPositionArr[x/(side/8)]) + 1);
                     System.out.println(x/(side/8) + firstNum );

                     firstNum += 1;
                     System.out.println("FIRST NUM: " + firstNum);
                     
                     
              }
              
              System.out.println((maxPositionArr[x/(side/8)]) + 1);
               System.out.println(x/(side/8) + firstNum );
               //System.out.println(grid[maxPositionArr[x/(side/8)] + 1][x/(side/8) + firstNum]);
               System.out.println("------------------------------------------------------------------");
              
                
               
                
          
              
         
                //REPLACE FOR LOOP WITH WHILE LOOP FOR EVERY INSTANCE
                while( (x/(side/8) - secondNum >= 0) && (grid[(maxPositionArr[x/(side/8)]) + 1][x/(side/8) - secondNum] == color1) ){
                      
                      System.out.println((maxPositionArr[x/(side/8)]) + 1);
                      System.out.println(x/(side/8) - secondNum);
                      
                      secondNum += 1;
                      System.out.println("SECOND NUM: " + firstNum);
                }
                
                
                System.out.println((maxPositionArr[x/(side/8)]) + 1);
                System.out.println(x/(side/8) - secondNum);
                //System.out.println(grid[maxPositionArr[x/(side/8)] + 1][x/(side/8) - secondNum]);
                System.out.println("------------------------------------------------------------------");
               
     
                
                  
              while( (maxPositionArr[x/(side/8)] + 1 - thirdNum >= 0) && (grid[(maxPositionArr[x/(side/8)]) + 1 - thirdNum][x/(side/8)] == color1) ){
                
                      
                      System.out.println((maxPositionArr[x/(side/8)]) + 1 - thirdNum);
                      System.out.println(x/(side/8));
                      
                      thirdNum += 1;
                      System.out.println("THIRD NUM: " + thirdNum);
                
                
                }
                
                
                 System.out.println(maxPositionArr[x/(side/8)] + 1 - thirdNum);
                System.out.println(x/(side/8));
                //System.out.println(grid[maxPositionArr[x/(side/8)] + 1 - thirdNum][x/(side/8)]);
                System.out.println("------------------------------------------------------------------");
                
           
                
                while( (maxPositionArr[x/(side/8)] + 1 + fourthNum <= 7)  && (grid[(maxPositionArr[x/(side/8)]) + 1+ fourthNum][x/(side/8)] == color1) ){
                  
            
                      
                      System.out.println((maxPositionArr[x/(side/8)]) + 1+ fourthNum);
                      System.out.println(x/(side/8));

                      
                      
                      fourthNum += 1;
                      System.out.println("FOURTH NUM: " + fourthNum);
                
                 
                }
                
                System.out.println((maxPositionArr[x/(side/8)] + 1 + fourthNum));
                System.out.println(x/(side/8));
                //System.out.println(grid[maxPositionArr[x/(side/8)] + 1 + fourthNum][x/(side/8)]);
                
                
                      
                  

                while( ((maxPositionArr[x/(side/8)] + 1 - fifthNum >= 0) && (x/(side/8) + fifthNum <= 7)) && (grid[(maxPositionArr[x/(side/8)]) + 1- fifthNum][x/(side/8) + fifthNum] == color1)  ){
                
                      
                      System.out.println((maxPositionArr[x/(side/8)]) + 1- fifthNum);
                      System.out.println(x/(side/8) + fifthNum);
                      
                      fifthNum += 1;
                      System.out.println("FIFTH NUM: " + fifthNum);
                  
                  
                 
                }
                
                System.out.println((maxPositionArr[x/(side/8)]) + 1- fifthNum);
                 System.out.println(x/(side/8) + fifthNum);
                 //System.out.println(grid[maxPositionArr[x/(side/8)] + 1 - fifthNum][x/(side/8) + fifthNum]);
                 System.out.println("------------------------------------------------------------------");
                 
                
           
                
                while( ((x/(side/8) - sixthNum >= 0) && (maxPositionArr[x/(side/8)] + 1 - sixthNum >= 0)) && (grid[(maxPositionArr[x/(side/8)]) + 1- sixthNum][x/(side/8) - sixthNum] == color1)){
                
                      System.out.println(maxPositionArr[x/(side/8)] + 1 - sixthNum);
                      System.out.println(x/(side/8) - sixthNum);
                      
                      sixthNum += 1;
                      System.out.println("SIXTH NUM: " + sixthNum);
                
                 
                }
                
                System.out.println(maxPositionArr[x/(side/8)] + 1 - sixthNum);
                System.out.println(x/(side/8) - sixthNum);
                //System.out.println(grid[maxPositionArr[x/(side/8)] + 1 - sixthNum][x/(side/8) - sixthNum]);
                System.out.println("------------------------------------------------------------------");
                
                
                
                while( ((maxPositionArr[x/(side/8)] + 1 + seventhNum <= 7) && (x/(side/8) + seventhNum <= 7) ) && (grid[(maxPositionArr[x/(side/8)]) + 1+ seventhNum][x/(side/8) + seventhNum] == color1)) {
            
                      
                      System.out.println((maxPositionArr[x/(side/8)]) + 1+ seventhNum);
                      System.out.println(x/(side/8) + seventhNum);
                      
                      seventhNum += 1;
                      System.out.println("SEVENTH NUM: " + seventhNum);
                
                   
                }
                
                System.out.println((maxPositionArr[x/(side/8)]) + 1+ seventhNum);
                System.out.println(x/(side/8) + seventhNum);
                //System.out.println(grid[maxPositionArr[x/(side/8)] + 1 + seventhNum][x/(side/8) + seventhNum]);
                System.out.println("------------------------------------------------------------------");
                 
                
                 
                
                while( (( maxPositionArr[x/(side/8)] + 1 + eighthNum <= 7) && (x/(side/8) - eighthNum >= 0) ) && (grid[(maxPositionArr[x/(side/8)]) + 1 + eighthNum][x/(side/8) - eighthNum] == color1)){

                       System.out.println((maxPositionArr[x/(side/8)]) + 1 + eighthNum);
                       System.out.println(x/(side/8) - eighthNum);
                       
                       eighthNum += 1;
                       System.out.println("EIGHTH NUM: " + eighthNum);
        
             
                }
                
                 System.out.println((maxPositionArr[x/(side/8)]) + 1 + eighthNum);
                 System.out.println(x/(side/8) - eighthNum);
                 //  System.out.println(grid[maxPositionArr[x/(side/8)] + 1 + eighthNum][x/(side/8) - eighthNum]);
                 System.out.println("------------------------------------------------------------------");
                
                
                 
                
                if( (firstNum + secondNum >= 4) || (thirdNum + fourthNum >= 4) || (fifthNum + sixthNum >= 4) || (seventhNum + eighthNum >= 4) ){
                    System.out.println("true");
                    return true;
                } else {
         
                    return false;
                }
                
            }
        
        
        
              
        
       
        
          public void mousePressed(MouseEvent e){
    
               int x = e.getX();
               xCord = e.getX();
               int y = e.getY();
               yCord = e.getY();

                
               if( (grid[x/(side/8)][maxPositionArr[x/(side/8)]] != Color.red) || (grid[x/(side/8)][maxPositionArr[x/(side/8)]] != Color.blue) ){
                   if( (colorDetermining % 2 == 0) ){
                       grid[x/(side/8)][maxPositionArr[x/(side/8)]] = Color.red;
                       colorDetermining += 1;
                       //System.out.println(colorDetermining);
                   } else {
                       grid[x/(side/8)][maxPositionArr[x/(side/8)]] = Color.blue;
                       colorDetermining += 1;
                      // System.out.println(colorDetermining);
                    }
                    
                   maxPositionArr[x/(side/8)] = maxPositionArr[x/(side/8)] - 1;
                }
        
            
           
                
                    repaint();

            
               
                
                
                  
              
                    
               
              
               
           
           
        }
    
     
    public void mouseReleased(MouseEvent e) {
       
    }
     
    public void mouseEntered(MouseEvent e) {
       
    }
     
    public void mouseExited(MouseEvent e) {
       
    }
     
    public void mouseClicked(MouseEvent e) {
        
    }
  }
} 
