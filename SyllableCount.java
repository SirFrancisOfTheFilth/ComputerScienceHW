import java.util.*;

public class SyllableCount{
  /*
  Number of syllables is dependent on vowels
  */

  public static int[] syllableCounting(String[] words){
    int[] syllableCount = new int[words.length];
    int counterVar = 0;


    for(int i = 0; i < words.length; i++){

        String[] arr = words[i].split("(?!^)");

        int j = 0;


        while(j <= arr.length - 1){

            //Case where the final digit is a vowel
            if( (j == arr.length - 1) && ((arr[j].equals("a")) || (arr[j].equals("e")) || ((arr[j]).equals("i")) || (arr[j].equals("o")) || (arr[j].equals("u"))
              || (arr[j].equals("y"))) ) {

               counterVar += 1;
               break;

            //Case with compound vowels
             } else if( ((arr[j].equals("a"))||(arr[j].equals("e"))||(arr[j].equals("i"))||(arr[j].equals("o"))||(arr[j].equals("u"))||(arr[j].equals("y")))
               && (( arr[j + 1].equals("a") ) || (arr[j + 1].equals("e")) || (((arr[j + 1].equals("i")) || (arr[j+1].equals("o")) ||
               (arr[j + 1].equals("u")) || (arr[j+1].equals("y"))))) ){

                 counterVar += 1;
                 j += 2;

            //Case with one vowel within a word(doesn't account for silent vowels)
            } else if( ( ((arr[j].equals("a"))||(arr[j].equals("e"))||(arr[j].equals("i"))||(arr[j].equals("o"))||(arr[j].equals("u"))||(arr[j].equals("y")))
              && ( !(arr[j + 1].equals("a") ) || !(arr[j + 1].equals("e") ) || !(arr[j + 1].equals("i")) || !(arr[j+1].equals("o")) ||
              !(arr[j + 1].equals("u")) || !(arr[j+1].equals("y")))) ) {

                counterVar += 1;
                j += 1;


            } else {

              j += 1;

            }


        }

        syllableCount[i] = counterVar;
        System.out.println("Syllable : " + counterVar);
        counterVar = 0;
    }



    return syllableCount;
  }

  public static void main(String[] args){
    String[] words = {"cat", "hello", "world", "tennis", "episcopal", "count", "learn", "denise", "state","statement","fruit",
"calculation","spite","spiteful","reservation",
"late","lately","extreme","expensive"};

    int[] returnArr = new int[words.length];

    returnArr = syllableCounting(words);

  }


}
