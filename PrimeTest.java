import java.util.*;

public class PrimeTest
{

    static boolean isAPrime(int y){

      for(int i = 2; i < y; i++){
        if(y % i == 0){
          return false; //if something is divisible, exits with return val false
        }
      }

      return true; //if it runs all the way through without failure return true


    }

   public static void main(String[] args){

    //PART ONE: EVALUATING PRIMALITY

    System.out.println("Enter an integer to evaluate its primality.");

    Scanner myScanner = new Scanner(System.in);
    int primeScan = myScanner.nextInt();

    boolean returnVal = isAPrime(primeScan);

    if(returnVal && (primeScan != 1) ){ //Deals with the case of 1 being treated as a prime number
      System.out.println(primeScan + " is a prime number.");
      System.out.println("-----------------------------------");
    } else if( (primeScan == 1) || !(returnVal) ){
      System.out.println(primeScan + " is not a prime number");
      System.out.println("-----------------------------------");
    }


    //PART TWO: PRIMES UNDER 100


    int counter = 0;

    for(int i = 1; i <= 100; i++){
      for(int j = 1; j <= i; j++){
        if(i % j == 0){
          counter += 1;
        }
      }

      if(counter == 2){ //can only have two factors: 1 and the own number, and if there are more, then it isnt prime
        System.out.println(i);
        counter -= counter;
      } else {
        counter -= counter;
      }

    }

  }

}
