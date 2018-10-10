
/**
 * Write a description of class Factorial here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Factorial
{
    //finds factorial of integer
    
    public static int factorial(int scanInt){
        if(scanInt > 1){
            return scanInt * factorial(scanInt - 1);
        } else {
            return 1;
        }
    }
    
    public static void main(String[] args){
        System.out.println("Enter a value to find the factorial of: ");
        Scanner newScan = new Scanner(System.in);
        int newInt = newScan.nextInt();
        int returnVal = factorial(newInt);
        System.out.println(returnVal);
    }
    
    
}
