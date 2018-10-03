    import javax.swing.JFrame;
    import javax.swing.JPanel;
    import javax.swing.WindowConstants;
    import java.awt.Dimension;
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import java.awt.Point;
    
    public class DrawCircle {
        private JFrame frame;
    
        public DrawCircle() {
            frame = new JFrame("Circle Pattern");
            frame.setSize(1440, 900);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setPreferredSize(frame.getSize());
            frame.add(new DrawShapes(frame.getSize()));
            frame.pack();
            frame.setVisible(true);
        }
    
        public static void main(String... argv) {
            new DrawCircle();
        }
    
        public static class DrawShapes extends JPanel {
            int startX = 100;
            int startY = 400;
            int startSide = 300;
            public DrawShapes(Dimension dimension) {
                setSize(dimension);
                setPreferredSize(dimension);
            }
    
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D)g;
                Dimension d = getSize();
                
                drawCircle(g2, startX, startY, (startSide) );


            }

        private void drawCircle(Graphics2D g, int x, int y, int side) {
            
            
            g.drawOval( (x+(side)), (y-(side)) , side, side);
            g.drawOval( (x), (y - (side) ), side, side);
            g.drawOval( (x + (side/2) ), (y - (side/8) ), side, side);
           
            
            
            
           side /= 2;
            
            
            
            if(side >= 25){
                drawCircle(g, (x), (y), (side) );
                drawCircle(g, (x + 2*side), y, (side) );
                drawCircle(g, (x + (side/2) ), (y - (side/8)), (side) );
                
            }
            
            
            
            
           
           
            
            

        }
    }

}