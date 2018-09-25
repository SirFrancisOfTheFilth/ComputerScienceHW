import java.util.*;
public class RunnerClass
{
    // instance variables - replace the example below with your own
    public static void main(String[] args){
        ObjectClass obj;
        System.out.println("Entire a length that you would like your password to be");
        Scanner newScan = new Scanner(System.in);
        int scanVal = newScan.nextInt();
        for(int i = 0; i <= 19; i++){
        obj = new ObjectClass();
        String returnStr = obj.randomPasswordGenerator("abcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*?",scanVal );
        System.out.println(returnStr);
        }
    }

}
