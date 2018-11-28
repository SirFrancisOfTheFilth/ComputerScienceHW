
ArrayList<Bub> b = new ArrayList<Bub>();
int[] negative = new int[2];
int randNumX;
int randNumY;


boolean press = false;//you will want to use this

void setup(){
  negative[0] = -1;
  negative[1] = 1;
  size(1490, 900);
}

void draw()
{
  background(255);
  //randomize number of bubbles generated
   int bubblesGenerated = (int)(random(5,12));
   
   
   for(int i = 0; i < bubblesGenerated; i++){
     
     if(press){
       addBubbles();
     } 
     
     for(int j = 0; j<b.size(); j++){

      Bub cir = b.get(j);
    
    
    
   
      
      colorEllipse(cir, cir.x, cir.y, cir.r);
      cir.x += negative[randNumX] * cir.sx;
      cir.y += negative[randNumX] * cir.sy;
      
    
    
    
  
    
    //how can you move the bubbles - do that here
    
    
  }

}



 
  
 
  
}

public void colorEllipse(Bub cir, int x, int y, int r){
      
   
      fill(cir.c);//how can you make this dynamic
      ellipse(x , y , 10 * r, 10 * r);

}

//everytime you need to create a new bubble 
//call this method
public void addBubbles(){
    
    randNumX = (int)(Math.random() * 2);
    randNumY = (int)(Math.random() * 2);
    
   
  
    float sx = negative[randNumX] * (int)(random(2, 6));
    float sy = negative[randNumY] * (int)(random(2, 6));
    
    

    
    int randR = (int)(Math.random() * 12);
    
    int rand1 = (int)(Math.random() * 255);
    int rand2 = (int)(Math.random() * 255);
    int rand3 = (int)(Math.random() * 255);
    color c = color(rand1, rand2, rand3);
    
    
     Bub bb = new Bub(mouseX, mouseY, randR, sx, sy, c);
     b.add(bb);
}

void mousePressed(){
  //addBubbles();
  
  press = true;
  
  

}

void mouseReleased(){
  press = false;
  
}

public class Bub{
  int x;
  int y;
  int r;
  float sx;//speed
  float sy;
  color c;
  
  
  public Bub(int x, int y, int r, float sx, float sy, color c){
    this.x = x;
    this.y = y;
    this.r = r;
    this.sx = sx;
    this.sy = sy;
    this.c = c;
     
  } 
}
