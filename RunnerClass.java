
/**
 * Write a description of class RunnerClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RunnerClass
{
    // instance variables - replace the example below with your own
    public static void main(String[] args){
        ObjectClass obj = new ObjectClass();
        String returnStr = obj.randomPasswordGenerator("abcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*?");
        System.out.println(returnStr);
    }
    
}
