
import java.util.*;

public class GuessingGame {
  public static void main(String[] args){

   System.out.println("This is a guessing game in which you guess any number from 1 to 10.");
   System.out.println("Guess three numbers successively: ");

   int counter = 1;

   //Allows for main part of program to run
   while(counter == 1){

       int myRand = (int)( (Math.random()*10) + 1 );
       int guessCounter = 0;

     while(guessCounter <= 2){

            //Takes input from user for guesses


          try{

            Scanner myScanner = new Scanner(System.in);
            int guessInt = myScanner.nextInt();


              if(guessInt > 10){//Exception for numbers larger than 10
                 System.out.println("Invalid input. The inputted integer must be less than 10 and greater than 0.");
                 System.out.println("Guess again");
              } else if(guessInt < 1){
                  System.out.println("Invalid input. The inputted integer must be less than 10 and greater than 0.");
                  System.out.println("Guess again");
              }

              if(myRand == guessInt){
               break; //exits loop if the random number myRand is guessed
             } else if( (myRand != guessInt) && (guessCounter < 2) ){
                 System.out.println("Guess again.");
             }

          } catch(Exception e){ //Exception thrown for invalid inputs

              System.out.println("Invalid input. Character or string inputs are invalid.");


          }


            guessCounter += 1;
        }

        if(guessCounter == 3){
            //if guessCounter is 3, then the program terminated without the right number
           System.out.println("Sorry, you didn't get the number: " + myRand);
        } else {
            //case can only run if guessCounter is less than 3(i.e. correct guess)
           System.out.println("Congratulations, you guessed correctly! The number was : " + myRand);
        }

        System.out.println("Press 1 to play again or press 2 to terminate. ");

        //Determines if user wants to replay
        Scanner myScanner = new Scanner(System.in);
        int finalInt = myScanner.nextInt();

       if(finalInt == 2){
           System.out.println("Program terminating...");
          break;
       } else if(finalInt == 1){
          //Restarts game
          System.out.println("This is a guessing game in which you guess any number from 1 to 10.");
          System.out.println("Guess three numbers successively : ");
        }



    }
  }
 }
