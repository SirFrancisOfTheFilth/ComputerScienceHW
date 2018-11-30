  int startX = 500;
     int startY = 500;
     ArrayList<Integer> coordinates;
     int rand1, rand2, rand3;
     int counter = 0;
     int side = 30;
     boolean create = false;
     int[] negative = new int[2];
     int randNumX;
     int randNumY;
     
     int tempX;
     int tempY;
     
     void setup(){
       negative[0] = -1;
       negative[1] = 1;
       size(1440, 1000);
       frameRate(900);
       background(0);
     }
     
     void draw(){
       
      
       
       rand1 = (int)(random(0, 255));
       rand2 = (int)(random(0, 255));
       rand3 = (int)(random(0, 255));
      
       
         
        ellipse( (startX +(side)), (startY -(side)) , side, side);
        //stroke(color(255, 255, 0));
        fill(color(rand1, rand2, rand3) );
        ellipse( (startX ), ( startY - (side) ), side, side);
        //stroke(color(0, 255, 255));
        fill(color(rand2, rand1, rand3) );
        ellipse( (startX + (side/2) ), (startY- (side/8) ), side, side);
        fill(color(rand3, rand1 , rand2) );
        
          
        startX += negative[randNumX] * (int)(random(3,9));
        startY += negative[randNumY] * (int)(random(3,9));
        
        
        side +=  (int)(random(3, 9));
        
        
        if(create == false){
          side = 30;
          background(0);
        }
       
        
           
     }
     
     void mousePressed(){
       
     create = true;
       
      randNumX = (int)(Math.random() * 2);
      randNumY = (int)(Math.random() * 2);
    
   
      startX = mouseX;
      startY = mouseY;
      
      
      /*
      coordinates.set(counter, startX);
      coordinates.set(counter + 1, startY);
       
       */
       
       
       
       
      counter += 1;
      
     }
     
     void mouseReleased(){
       create = false;
     }
     
   
     
