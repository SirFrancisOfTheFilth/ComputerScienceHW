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
import java.awt.Font;
import java.awt.FontMetrics;

public class MineSweeper {
    private JFrame frame;
    static int xCord;
    static int yCord;
    boolean[][] ifClicked = new boolean[8][8];


    public MineSweeper() {
        frame = new JFrame("Mine Sweeper");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(frame.getSize());
        frame.add(new MineDraw(frame.getSize()));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String... argv) {
        new MineSweeper();
    }

    public static class MineDraw extends JPanel  implements MouseListener {
        int startX = 10;
        int startY = 10;
        int side = 40;
        int turn = 0;
        int yPlace = 0;
        int[][] grid = new int[8][8];

        public MineDraw(Dimension dimension) {
            setSize(dimension);
            setPreferredSize(dimension);
            addMouseListener(this);
            randomAssign();

        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            Dimension d = getSize();
            startX = 0;
            startY = 0;
            //1) draw grid of squares
            //2) draw numbers in the squares
            /*
             * g2.setColor(Color.red);
            g2.setFont (new Font("TimesRoman", Font.PLAIN, 20));
            g2.drawString(""+grid[row][col] ,  x,y);
            3) assign -1 to mines. Randomly assign this to ten spots
             */
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    //grid[row][col]

                    g2.setColor(Color.black);
                    g2.drawRect(startX,startY,side,side);
                   
                  

                    startX += side;
                }
                startX = 0;
                startY += side;
            }
            
            
                 g2.drawString(""+grid[yCord][xCord], (xCord*side) + (side/2), (yCord*side) + (side/2) );
                 System.out.println(yCord);
                 System.out.println(xCord);
                 System.out.println("------------------------------");
                 surroundingNums(g2, xCord, yCord);
           
              

        }
        
        
        public void surroundingNums(Graphics g2, int xCord, int yCord){
            
            for(int row = (yCord - 2); row <= (yCord + 2); row+= 1){
                for(int col = xCord - 2; col <= xCord + 2; col+= 1){
                    
                    System.out.println(row);
                    System.out.println(col);
                    System.out.println("-----------------------------------");
                    
                    if( (((row <= grid.length - 1) && (row >= 0)) && ( (col >= 0) && (col <= grid.length - 1) )) && (grid[row][col] != -1) ){
                        
                       
                        g2.drawString(""+grid[row][col], (col * side) + (side/2), (row * side) + (side/2) );
                      
                  }
                  
          
           }
        }
    }
         
        
           

        public void randomAssign(){
           int rowRand = 0;
           int colRand = 0;
           int counter = 1;
           while(counter <= 10){
               rowRand = (int)(Math.random() * 7);
               colRand = (int)(Math.random() * 7);
               if(grid[rowRand][colRand] != -1){
                   grid[rowRand][colRand] = -1;
                }
                counter += 1;
            }
            
            assignNumbers();
        }
        
        public void assignNumbers(){
           int counter = 0; 
            for(int row = 0; row < grid.length; row++){
                for(int col = 0; col < grid[0].length; col++){
                    
                  if(grid[row][col] != -1){
                    if( (col + 1 <= grid.length - 1) && (grid[row][col + 1] == -1) ){
                        counter += 1;
                    }
                    
                    if( (col - 1 >= 0) && (grid[row][col - 1] == -1) ){
                        counter += 1;
                    }
                    
                    if( (row + 1 <= grid.length - 1) && (grid[row + 1][col] == -1)){
                        counter += 1;
                    }
                    
                    if( (row - 1 >= 0) && (grid[row - 1][col] == -1 )){
                        counter += 1;
                    }
                    
                    if( (row - 1 >= 0) && (col - 1 >= 0) && (grid[row - 1][col - 1] == -1) ){
                        counter += 1;
                    }
                    
                    if( (row + 1 <= grid.length - 1) && (col - 1 >= 0) && (grid[row + 1][col-1] == -1 ) ){
                        counter += 1;
                    }
                    
                    if( (row + 1 <= grid.length - 1) && (col + 1 <= grid.length - 1) && (grid[row + 1][col + 1] == -1)){
                        counter += 1;
                    }
                    
                    if ((row - 1 >= 0) && (col + 1 <= grid.length - 1) && (grid[row - 1][col + 1] == -1) ){
                        counter += 1;
                    }
                    
                    grid[row][col] = counter;
                    counter = 0;
                }
            }
            }
            
        }
        
        
        public void mousePressed(MouseEvent e) {
            int x = e.getX()/side;//column
            int y = e.getY()/side;//row
            xCord = x;
            yCord = y;
            // 

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
