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
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.awt.Font;
import java.awt.FontMetrics;

public class Photoshop {
    private JFrame frame;
    static int xCord = 0;
    static int yCord = 0;
    static int counter = 0;

    public Photoshop() {
        frame = new JFrame("Photoshop Filter");
        frame.setSize(620, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(frame.getSize());
        frame.add(new PhotoDraw(frame.getSize()));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String... argv) {
        new Photoshop();
    }

    public static class PhotoDraw extends JPanel  implements MouseListener {

        //int[][] alpha ;
        int[][] red;
        int[][] green ;
        int[][] blue ;
        BufferedImage img;
        BufferedImage img2;

        public PhotoDraw(Dimension dimension) {//constructor

            setSize(dimension);
            setPreferredSize(dimension);
            addMouseListener(this);

            try {
                img = ImageIO.read(this.getClass().getResource("img.jpg"));
                img2 = ImageIO.read(this.getClass().getResource("img.jpg"));
            } catch (IOException e) {
                System.out.println("Image could not be read");
                System.exit(1);
            }

            int width  = img.getWidth();
            int height  = img.getHeight();
            // System.out.println(width + " | " + height);
            setArrays(width, height);

        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            Dimension d = getSize();
            g2.drawImage(img,0,0,300,150 ,null);
            g2.drawImage(img2,310,0,300,150 ,null);
            g2.setFont (new Font("TimesRoman", Font.PLAIN, 20));
            
            
            
            g2.drawRect(0, 255, 150, 150);
           
            g2.drawString("INVERSION" ,  25 , 300);
            
            g2.drawRect(150, 255, 150, 150);
            
            g2.drawString("THRESHOLD", 175,  300); 
            
            g2.drawRect(300, 255, 150, 150);
            
            g2.drawString("RED FILTER", 325 , 300);
            
         


        }

        public void setArrays(int width, int height){

            red = new int[width][height];
            green = new int[width][height];
            blue = new int[width][height];

            for(int x=0; x< width; x++){
                for (int y=0;y< height;y++){

                    Color mycolor = new Color(img.getRGB(x, y));
                   
                      int r = mycolor.getRed();
                    int g = mycolor.getGreen();
                    int b = mycolor.getBlue();
                    /* */
                    red[x][y] = r;
                    green[x][y] = g;
                    blue[x][y] = b;

                }} 
        }

        public void mousePressed(MouseEvent e) {

            int x = e.getX();
            int y = e.getY();
       
            

            imageChange(x, y);
           

            repaint();
            
        }

        public boolean  checkForWinner(int x,int y, Color c){

            return false;
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) {
        }

        //this creates a new image

        public void imageChange(int xCord, int yCord)
        {
            
                    //make changes above

            //create new image using new values
            BufferedImage img3 = new BufferedImage(red.length, red[0].length, BufferedImage.TYPE_INT_RGB);
            
            
            for (int x = 0; x< red.length; x++){
                for (int y = 0; y< red[0].length; y++){

                    int r = red[x][y];
                    int g = green[x][y];
                    int b = blue[x][y];
                    int col = (r << 16) | (g << 8) | b;
                    //255, 255, 255
                    img3.setRGB(x, y, col);

                }
            }
            String fullName = "inverted";

            File f = new File(fullName + ".jpg");

            try{
                ImageIO.write(img3, "JPEG", f);
                img2 = img3;
                repaint();
                //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
                //ImgName = "inverted.jpg";
                //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
            } catch(Exception e){
                   System.out.println("Exception.");
            }
            
            //make some changes to the pixels

            for(int x=0; x< red.length-1; x++){
                for (int y=0;y < red[0].length-1;y++){
                    //luminance of the pixel   (0.2126*r) + (0.7152*g) + (0.0722*b);
                    double lum = (0.2126*red[x][y]) + (0.7152*green[x][y]) + (0.0722*blue[x][y]);
                /*    
                if(lum >= 255/2){
                        red[x][y] = 255;
                        green[x][y] = 255;
                        blue[x][y] = 255;
                    } else if (lum <= 255/2){
                        red[x][y] = 0;
                        green[x][y] = 0;
                        blue[x][y] = 0;
                    }
                
                */
               
                if( (xCord >= 0 && xCord <= 150) && (yCord >= 300) ){
                    
                   
                   int redNum = 0;
                   redNum += 255 - red[x][y];
                   red[x][y] = redNum;
                   int greenNum = 0;
                   greenNum += 255 - green[x][y];
                   green[x][y] = greenNum;
                   int blueNum = 0;
                   blueNum += 255 - blue[x][y];
                   blue[x][y] = blueNum;
                  
                  
                  
                } else if( (xCord >= 150 && xCord <= 300) && (yCord >= 300)  ){
                    int realRed = red[x][y];
                    int realBlue = blue[x][y];
                    int realGreen = green[x][y];
                    
                    
                    if(lum >= 255/2){
                        red[x][y] = 255;
                        green[x][y] = 255;
                        blue[x][y] = 255;
                    } else if (lum <= 255/2){
                        red[x][y] = 0;
                        green[x][y] = 0;
                        blue[x][y] = 0;
                    }
                    
                    
                } else if( (xCord >= 300 && xCord <= 450) && (yCord >= 300) ){
                    
                    
                    red[x][y] = 255;
                 
                } 
                
                
               
                
                    //red[x][y] = 255;
                    
                  

                   
                   
                }
            }

    

        }
    }
}
