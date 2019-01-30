import java.util.Scanner;
public class Caesar
{

    Scanner scan = new Scanner(System.in);
    String str1 = scan.nextLine();
    Scanner scanner2 = new Scanner(System.in);
    int input = scanner2.nextInt();
    
    public Caesar()
    {
      

        String str = caesarCipher(str1, input);
        System.out.println(str);
        
        System.out.println("DO YOU WANT TO DECRYPT THE PHRASE WITH A GIVEN SHIFT AMOUNT?");
        
        Scanner anotherScan = new Scanner(System.in);
        String thescan = anotherScan.nextLine();
        
        String str2 = "";
        
        if(thescan.equals("yes") ){
            System.out.println("ENTER A SHIFT VALUE");
            
            Scanner NEXT = new Scanner(System.in);
            int number = NEXT.nextInt();
            
            str2 = caesarCipher(str, number);//TAKES IN PREVIOUSLY ENCRYPTED PHRASE
            System.out.println(str2);
            
             System.out.println("DO YOU WANT TO BRUTE FORCE THE PHRASE?");
             Scanner as = new Scanner(System.in);
             String at = as.nextLine();
             if(at.equals("yes")){
                 for(int i = 1; i <= 25; i++){
                     String str3 = caesarCipher(str2, i);
                     System.out.println(str3);
                  }
             }
        } 
           
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
