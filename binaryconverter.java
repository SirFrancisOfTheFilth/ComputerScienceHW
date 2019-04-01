//matthew habtezgi
import java.util.Scanner;
import java.util.*;
public class binary
{
    // instance variables - replace the example below with your own
  
    /**
     * Constructor for objects of class binary
     */

    
    public binary(){
        Scanner scan = new Scanner(System.in);
        int scanner = scan.nextInt();
        String val = decToBinary(scanner);
        System.out.println(val);
        
        
        //will just convert converted binary back to its decimal value
        int num = binaryToDec(val);
        System.out.println(num);
         
    }
    
    
    
    String decToBinary(int num){
        ArrayList<Integer> values = new ArrayList<Integer>();
        String finalBinary = "";
        while(num != 1){
            values.add(num);
            num /= 2;
        }
        values.add(1);
        for(int i = values.size() - 1; i >= 0; i--){
            if(values.get(i) % 2 == 0){
                finalBinary += '0';
            } else if(values.get(i) % 2 != 0){
                finalBinary += '1';
            }
        }
        return finalBinary;
    }
    
    int binaryToDec(String str){
        int num = 0;
        
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '1' ){
                num += Math.pow(2, (str.length() - 1) - i);
            } 
        }
        return num;
    }
    

}
