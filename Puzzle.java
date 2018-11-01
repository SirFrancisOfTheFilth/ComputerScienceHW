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

public class Puzzle {
    private JFrame frame;

    public Puzzle() {
        frame = new JFrame("Photoshop Filter");
        frame.setSize(620, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(frame.getSize());
        frame.add(new PhotoPuz(frame.getSize()));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String... argv) {
        new Puzzle();
    }

    public static class PhotoPuz extends JPanel  implements MouseListener {


        int[][] red;
        int[][] green ;
        int[][] blue ;
        //Amount of Rows and Columns
        int pS = 5;
        //Array of images
        BufferedImage[][] puz = new BufferedImage[pS][pS];
        //Reveal original image
          boolean showFace = false;

        BufferedImage img;
        BufferedImage img2;
         //width and height of the image
         int width = 0;
         int height=0;

        public PhotoPuz(Dimension dimension) {//constructor

            setSize(dimension);
            setPreferredSize(dimension);
            addMouseListener(this);

            try {
                img = ImageIO.read(this.getClass().getResource("face.jpg"));
            } catch (IOException e) {
                System.out.println("Image could not be read");
                System.exit(1);
            }

            width  = img.getWidth();
            height  = img.getHeight();
            //get RGB of original image
            setArrays(width, height);
            //setup the puz array
            setImgArray(width, height);

        }

        public void setImgArray(int w, int h){

            int s = w/pS;
            int xStart = 0;
            int yStart = 0;
             //complete the method
            for(int i = 0; i < pS; i++){
                for(int j = 0; j < pS; j++){
                        puz[i][j] = imageChange(xStart, yStart, s, img);
                        xStart += s;
                    }
                    yStart += s;
                    xStart = 0;
                }




           //img2 = imageChange(xStart, yStart, s, img);

        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            Dimension d = getSize();


          int  s = width/pS;
          int yspace = 0;
          int xspace = 0;


          for(int x = 0; x < puz.length; x ++){
              for(int y = 0; y < puz.length; y ++){
                 g2.drawImage(puz[x][y], ((x * s) +  (xspace )), ((y * s) + (yspace ) ) ,s,s ,null);
                 yspace += 2;
              }
              yspace = 0;
              xspace += 2;
          }




          if(showFace == true){
          g2.drawImage(img,300,0,210,210 ,null);
        }




        }
        public void setArrays(int width, int height){
            red = new int[width][height];
            green = new int[width][height];
            blue = new int[width][height];
            int pCount=0;
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

                }
            }
        }

        public void mousePressed(MouseEvent e) {

            int x = e.getX();
            int y = e.getY();


            showFace=true;


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

        //this creates a new image

        public BufferedImage imageChange(int xStart, int yStart, int len,BufferedImage img4 )
        {


            //make changes below
            //System.out.println(xStart);
            //create new image using new values
            BufferedImage img3 = new BufferedImage(len, len, BufferedImage.TYPE_INT_RGB);
            int tx = 0;
            int ty = 0;
            //2) tweak for loop below
            //the actual headers need to by updated
            //make use of tx and ty variables?
            for (int x = xStart; x< xStart + len; x += 1){
                for (int y = yStart; y< yStart + len; y += 1){

                    int r = red[x][y];
                    int g = green[x][y];
                    int b = blue[x][y];
                    int col = (r << 16) | (g << 8) | b;
                    //want to tweak line below
                    img3.setRGB(ty,tx, col);


                    tx += 1;
                }
                tx = 0;
                ty += 1;
            }


            return img3;

        }
    }
}
