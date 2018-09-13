import java.util.*;
public class TempConverter
{
    public static void main(String[] args){

     System.out.println("Enter 1 if you want to convert from Celsius to Fahrenheit or 2 to convert from Fahrenheit to Celsius:");
     boolean ifConvert = true; //allows for program to run indefinitely until it "breaks" at the end dependent on the condition


       while(ifConvert){

        Scanner scanner = new Scanner(System.in);
        int scanInt = scanner.nextInt();

        if(scanInt == 1){ //converting from celsius to fahrenheit
            System.out.println("Enter a temperature you would like to convert:");
            Scanner scan2 = new Scanner(System.in);
            double celsToFahr = scan2.nextDouble();//takes in double value from user to convert

            System.out.println(celsToFahr + " degrees Celsius is : ");
            celsToFahr = ((9.0*(celsToFahr))/5) + 32;
            System.out.println( (((int)(100 * celsToFahr))/100.0) + " degrees fahrenheit. ");//printing out rounded value

        } else if(scanInt == 2){//converting from fahrenheit to celsius

           System.out.println("Enter a temperature you would like to convert:");
           Scanner scan3 = new Scanner(System.in);
           double fahrToCels = scan3.nextDouble();//takes in double value from user to convert

           System.out.println(fahrToCels + " degrees fahrenheit is: ");
           fahrToCels = ((5 * (fahrToCels - 32))/9.0);
           System.out.println( (((int)(100 * fahrToCels))/100.0) + " degrees celsius. ");//printing out rounded value

        }

        System.out.println("Do you want to convert another temperature? Enter 1 to convert another temperature or 2 to terminate");

        Scanner finalScan = new Scanner(System.in);
        int determiningVal = finalScan.nextInt();

        //determines if loop will continue running if either 1 or 2 is pressed
        if(determiningVal == 2){
            System.out.println("Program terminating....");
            break; //exits while loop
        } else if(determiningVal == 1){
            System.out.println("Enter 1 if you want to convert from Celsius to Fahrenheit or 2 to convert from Fahrenheit to Celsius:");
            //starts the loop over again
        }

    }
  }
}
