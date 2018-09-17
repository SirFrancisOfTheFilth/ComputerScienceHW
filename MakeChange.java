
import java.util.*;
public class MakeChange
{

  static int loopingCoinage(int coinNum, double moneyNum){

      int countNum = 0;
      while( (100 * moneyNum) % (coinNum * countNum) != (100 * moneyNum) ) {
        countNum += 1;
      }

      int returnNum = countNum - 1;
      return (returnNum);

  }



   public static void main(String[] args){

      int pennyVal = 0;
      int nickelVal = 0;
      int dimeVal = 0;
      int quarterVal = 0;

      double randomNum = ((int)(( 100 * ((Math.random() * 18) + 1) + 0.05)))/100.0;
      System.out.println(randomNum);
      double moneyNum =  ((int)(( 100 * (20.00 - randomNum) + 0.05)))/100.0; //rounding to hundredths
      System.out.println(moneyNum);


      quarterVal += loopingCoinage(25, moneyNum);
      moneyNum -=(Math.round(100.00 * ( (25.00 * quarterVal) )))/10000.00;

      //Deals with imprecision with subtraction when doing moneyNum -= (causing a string of 9's in some cases)
      String compareVar = Double.toString(moneyNum);
      if( (compareVar.length() >= 5) && (compareVar.charAt(5)) == '9' ){
        pennyVal += 1;
      }


       dimeVal += loopingCoinage(10, moneyNum );
       moneyNum -=(Math.round(100.00 * ( (10.00 * dimeVal) )))/10000.00;

       nickelVal += loopingCoinage(5, moneyNum);
       moneyNum -=(Math.round(100.00 * ( (5.00 * nickelVal))))/10000.00;


       pennyVal += loopingCoinage(1,  moneyNum );


       System.out.println("Number of quarters : " + quarterVal);
       System.out.println("Number of dimes : " + dimeVal);
       System.out.println("Number of nickels : " + nickelVal);
       System.out.println("Number of pennies : " + (pennyVal) );


   }


}    

