char letter;
char letter2;
boolean leftButton;
boolean rightButton;
String sym = "AAPL";
String words = "";
int wordLength = 0;
String lines = "";
ArrayList<DoubleType> stockList = new ArrayList<DoubleType>();

int count = 0;
int numCount = 0;
    

//int counter = 0;

void setup(){
  stockList.add(new DoubleType("", 0) );
  size(1440, 900);
  fill(255, 255,255);
  
  


}

void draw(){
  


  
background(0);
   
rect(10,70,100,40);
fill(255,0,0);
  
  
text("Current key: " + letter, 10, 40);
                
for(int i = 0; i < stockList.size(); i++){ 
  if(stockList.get(i).getNum() > 0){
    text("Stock : " + stockList.get(i).getNum(), 10 + ( 30  * wordLength * i) + (count ), 200);
    text("Name : " + stockList.get(i).getString(), ( 90 + ( 30 * wordLength * i)  +   (count ) ), 200);
    //text(" | ",  90 + (290 * i) + (
  }
}


//text("Comparative key: " + letter2, 250, 40); 

rect(10,70,100,40);
fill(255,255,255);


/*
rect(250, 70, 100, 40);
fill(255, 255, 255);
*/



if(numCount % 2 == 0){
  count += 10;
  delay(50);
if(count >= (1300 - (numCount * 100) )){
  count = 0;
}
}else if(numCount % 2 != 0){
  count -= 10;
  delay(50);  
  if(count <= -20 - (numCount * 10) ){
    count = 1300;
  }
}




}

// keyTyped
void keyTyped() {
  if ( ((key >= 'A' && key <= 'z') || key == ' ') && !leftButton ) {
    wordLength += 1;
    letter = key;
    letter = Character.toUpperCase(letter);
  }
  
  words = words + letter;
  
}

/*
void keyPressed() {
  if (keyCode == 32) {
     words = "";
} 
  if(keyCode == 37){
        words = words.substring(0,words.length()-1);
  }
}
*/


void mousePressed(){
   if(mouseX>10 && mouseX<110 && mouseY>70 && mouseY < 170){
        
        leftButton = true;
        sym = words;
        
     
        numCount += 1;
        read();
        leftButton = false;
        
     
   }


   
   
     
}


public void read(){
  
    String[] ll = loadStrings("https://financialmodelingprep.com/api/company/profile/" + sym);


    ll[0] = trim(ll[0].substring(ll[0].indexOf("{")));

    
    for(int i=0; i<ll.length; i++){
     lines += ll[i];
    }

 
    
    JSONObject jarr = JSONObject.parse(lines);
    JSONObject stock = jarr.getJSONObject(sym); 
    
    int price = stock.getInt("Price");
    String beta = stock.getString("Beta");
    String name = stock.getString("companyName");
    

     if(numCount == 1){
      stockList.set(0, new DoubleType(name, price));
    } else {
      stockList.add(new DoubleType(name, price));
    }
     
    
    
    println("Price of company's stock: " + price);
    println("Amount of company's beta: " + beta );
    println("Name of Company: " + name);
    


    System.out.println(words);
    words = "";
    sym = "";
    lines = "";
    
    


  }
  
  
  
  
  class DoubleType{
    String str;
    int num;
    public DoubleType(String str, int num){
      this.str = str;
      this.num = num;
    }
    
    public String getString(){
      return str;
    }
    
    public int getNum(){
      return num;
    }
      
    
  }
