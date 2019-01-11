import java.util.*;

public class pyramid
{

    Scanner scan1 = new Scanner(System.in);
    Scanner scan2 = new Scanner(System.in);
    int row = scan1.nextInt();
    int col = scan2.nextInt();
    int[][] pascal = new int[row][col];
    
    //Enter 6 and 11 for 5 rows
    //Enter 7 and 13 for 6 rows
    //Enter 8 and 15 for 7 rows( etc, etc)
    
    
    public int countOnes(int start, int end, int rowNum, int[][] pascal){
        int counter = 0;
        for(int i = start; i <= end; i++){
            if(pascal[rowNum][i] == 0){
                counter += 1;
            }
        }
        return counter;
    }
    
    public void setOnes(int index1, int index2, int rowNum, int[][] pascal, int[] countOnes, double exp, int mid){
          //main function used
          int counter = 0;
          int firstindex = index1 + 1;
          pascal[2][5] = (int)(Math.pow(pascal[0][mid], 2)); //setting first real value (4) by multiplying nums on top for other cases
          
          //dynamically does other values(first iterator sets ends of pyramid to 2^the row value
          while(counter < (index2 - index1)/2 - 2){
              if( (firstindex == index1 + 1 || firstindex == index2 - 1) && (rowNum > 1) ){
              pascal[rowNum][firstindex] = (int)(Math.pow(2, countOnes[rowNum] - (int)(countOnes[rowNum]/2) ) );
              pascal[rowNum][index2 - 1] = (int)(Math.pow(2, countOnes[rowNum] - (int)(countOnes[rowNum]/2) ) );
              } 
              
              firstindex += 1;
              counter += 1;
          }
          
          //dyanically sets values based on exp(which is at first 1.5 and increases by 0.5 each time
          //valid pyramid pattern sine 16^1.5 = 64, 32^2=1024, 64^2.5 = 32768, etc(and only begins when rowNum >= 4
          
          for(int i = 1; i < rowNum - 2; i++){
               int num = pascal[rowNum][index1 + 1];

               
               if(rowNum >= 4){
                pascal[rowNum][index1 + i + 1] = (int)(Math.pow(num, exp - 1.5));
               }
              
          }
    
      }
       
    
 

    public pyramid()
    {
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                pascal[i][j] = 0;
            }
        }
      
        int mid = (int)(col/2);
        int counter = 0;
        System.out.println(mid);
        int multiplier = 0;
        int[] numOnes = new int[(int)(col/2) + 1];
        
        //makes "V" of 2's mathematically
        for(int i = mid; i >= 0; i--){
             pascal[mid - i][i] = 2;
             pascal[mid - i][i + multiplier] = 2;
             numOnes[counter] = countOnes(i, (i + multiplier), (mid - i), pascal);
             multiplier += 2;
             counter += 1;
             
        }

        int counter1 = 0;
        int determine = 0;
        ArrayList<Integer> twos = new ArrayList<Integer>();
       
        for(int i = 0; i < row; i++){
            for(int j = 0;j < col; j++){
                if(pascal[i][j] == 2){
                    counter1 = j;
                    twos.add(counter1);
                }
            }
        }
        int counter2 = 0;
        double exp = 1.5;
        for(int i = 1; i <= twos.size() - 2; i+= 2){
           counter2 += 1;
           setOnes(twos.get(i), twos.get(i+1), counter2, pascal, numOnes, exp, mid);
           exp += 0.5;
        }
        
        System.out.println("----------------------------------------");
        
         for(int i = 0; i < row; i++){
            for(int j = 0;j < col; j++){
               if(pascal[i][j] != 0){
               System.out.print(pascal[i][j]);
               System.out.print("|");
               }
               
               
               
            }
            System.out.println();
        }
         

    }
}
