
/**
 * Write a description of class TempConverter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class TempConverter
{
    public static void main(String[] args){
        
     System.out.println("Enter 1 if you want to convert from Celsius to Fahrenheit or 2 to convert from Fahrenheit to Celsius:");
     boolean ifConvert = true;
       
       while(ifConvert = true){
        
        Scanner scanner = new Scanner(System.in);
        int scanInt = scanner.nextInt();
        
        if(scanInt == 1){
            System.out.println("Enter a temperature you would like to convert:");
            Scanner scan2 = new Scanner(System.in);
            double celsToFahr = scan2.nextDouble();
            
            System.out.println(celsToFahr + " degrees Celsius is : ");
            celsToFahr = ((9.0*(celsToFahr))/5) + 32;
            System.out.println( celsToFahr + " degrees fahrenheit. ");
            
        } else if(scanInt == 2){
            
           System.out.println("Enter a temperature you would like to convert:");
           Scanner scan3 = new Scanner(System.in);
           double fahrToCels = scan3.nextDouble();
           
           System.out.println(fahrToCels + " degrees fahrenheit is: ");
           fahrToCels = ((5 * (fahrToCels - 32))/9.0);
           System.out.println(fahrToCels + " degrees celsius. ");
           
        }
        
        System.out.println("Do you want to convert another temperature? Enter 1 to convert another temperature or 2 to terminate");
        
        Scanner finalScan = new Scanner(System.in);
        int determiningVal = finalScan.nextInt();
        
        if(determiningVal == 2){
            System.out.println("Program terminating....");
            break;
        } else if(determiningVal == 1){
            System.out.println("Enter 1 if you want to convert from Celsius to Fahrenheit or 2 to convert from Fahrenheit to Celsius:");
        }
     
    }
  }
}
