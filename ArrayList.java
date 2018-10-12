import java.util.*;



public class ArrayList{

  public static void main(String[] args){

    java.util.ArrayList<Integer> ageList = new java.util.ArrayList<Integer>();

    int max = 0;
    int min = 0;
    int avg = 0;


    System.out.println("Enter an age:");
    Scanner bScan = new Scanner(System.in);
    int scanInt = bScan.nextInt();
    min = scanInt;
    
    avg += scanInt;
    
    if(scanInt >= 0){
        ageList.add(scanInt);
    } else {
        System.out.println("Invalid input");
    }
    
    int counter = 1;
    while( (true && scanInt > 0) || counter <= 6){
        
      System.out.println("Enter an age:");
      Scanner secondScan = new Scanner(System.in);
      int secondInt = secondScan.nextInt();
        
       if(secondInt < 0){
           break;
        }

      if( (min > secondInt) && (min >= 0) ){
        min = secondInt;
      }

      if( (max < secondInt) && (max >= 0) ){
        max = secondInt;
      }


      if(secondInt >= 0){
        ageList.add(secondInt);
        avg += secondInt;
      } 


  }
  
  System.out.println(avg);
  System.out.println(min);
  System.out.println(max);

  System.out.println("The size of the arrayList is " +  ageList.size());
  System.out.println("The average is " + (int)(10 * (avg/ageList.size()) + 0.5)/10.0 );

  System.out.println("The new size after the extremes are removed of the arrayList is " + (ageList.size() - 2) );
  System.out.println("The new average after the extremes are removed of the arrayList is now " + (int)(10 * ((((avg - min - max)/(ageList.size() - 2 )))) + 0.5)/10.0 );



  }
}