import java.util.Scanner;
public class Caesar
{

    Scanner scan = new Scanner(System.in);
    String str1 = scan.nextLine();
    Scanner scan2 = new Scanner(System.in);
    int integer = scan2.nextInt();
    
    public Caesar()
    {
     
     caesarCipher(str1, integer);   
        
    }
    
    public String caesarCipher(String str1, int integer){
        String returnStr = "";
        char tentative = ' ';
        for(int i = 0; i < str1.length(); i++){
            tentative = str1.charAt(i);
            int num = ( ( (int)(tentative) + integer) % 91 );
            
            if(tentative != ' '){
                if(num != (int)(tentative) + integer){
                    num += 65;
                }
                returnStr += (char)(num);
            } else {
                returnStr += " ";
            }
              
            

          
        }
        return returnStr;
    }

}
