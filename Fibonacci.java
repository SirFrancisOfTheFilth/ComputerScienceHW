
public class Fibonacci
{
    // i ran it by running the constructor method now without the main method(Doesn't include first 0 and 1, though..)

    public Fibonacci()
    {
        fibonacci(0, 1);
    }

    public void fibonacci(int x, int y){
        int sum;
        sum = x + y;
        
        System.out.println(sum);
        
        if(sum <= 100){
            x = y;
            fibonacci(x, sum);
        }

        
    }
}
