import java.util.Scanner;
public class Caesar
{

    Scanner scan = new Scanner(System.in);
    String str1 = scan.nextLine();
    Scanner scan2 = new Scanner(System.in);
    int integer = scan2.nextInt();
    
    public Caesar()
    {
        String returnStr = "";
        
        char tentative = ' ';
        for(int i = 0; i < str1.length(); i++){
            tentative = str1.charAt(i);
            System.out.println(tentative);
            
            if(tentative != ' '){
                returnStr += (char)( ( (((int)(tentative)) + integer) % 128) );
            } else {
                returnStr += " ";
            }
        }
        
        System.out.print(returnStr);
        
        
        
    }

}
