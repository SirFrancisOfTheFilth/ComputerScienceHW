public class ObjectClass
{

        String finalStr = "";
        String intermediateStr = "";

        int randomNum;
        int capitalizationNum;


    public ObjectClass()
    {
        //Empty constructor(unnecessary for this case)
    }


    public String randomPasswordGenerator(String input, int val){

        for(int i = 1; i <= val; i++){

           randomNum = (int)( (Math.random() * 44) ) + 1;
           capitalizationNum = (int)( (Math.random() * 8) + 1);
           intermediateStr = input.substring(randomNum, randomNum + 1);

           if( (capitalizationNum % 2 == 0) && (randomNum <= 25) ){
               String capitalStr;
               capitalStr = intermediateStr.toUpperCase();
               finalStr += capitalStr;
            } else {
               finalStr += intermediateStr;
            }

        }

        return finalStr;
    }
}
