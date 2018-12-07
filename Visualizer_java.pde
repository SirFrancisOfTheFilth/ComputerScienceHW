//Imports needed
import ddf.minim.analysis.*;
import ddf.minim.*;
import java.lang.Math;
//object needed to access microphone
AudioInput input;
int bands = 64;//class variable
int avg = 25;
//works with input to access microphone sound
Minim minim;
//needed analyze the sound
FFT fft;
float[] sum;
float smooth_factor = 0.2;

void setup()
{
    size(512, 480);
    minim = new Minim(this);
    input = minim.getLineIn();
    //input will be based on your computers input capabilities
    fft = new FFT(input.bufferSize(), input.sampleRate()); 
    sum = new float[fft.specSize()];
}

void draw()
{
  background(0);
  stroke(255);
  
  int w = width/bands;//divide up the screen
 
  fft.forward(input.mix);
  
  println(fft.specSize());
 
  for(int i = 0; i < fft.specSize(); i++){
    float amp = fft.getBand(i);
    sum[i] += (amp - sum[i]) * smooth_factor;
    //println(fft.getBand(i));
    float s = -fft.getBand(i) * 7.5;
    
    
    
    float r = ((float)Math.random()) * 255;
    float g = ((float)Math.random()) * 255;
    float b = ((float)Math.random())* 255;
    
    stroke(r, g, b);
    fill(r, g, b);
    
    
    
    
    if(fft.getBand(i) > 2){
      ellipse( (i) , height/2, 3 , (s) );
    }else {
      ellipse(i, height/2, 3, -s);
    }
    
  }
  
}
