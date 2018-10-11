/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String[] keywords = {"no", "mother", "father", "sister", "brother", "dog", "cat", "Mr.", "Ms.", "Mrs."};
        
        String response = "";
        if( !(iWant(statement).equals("abc")) ){
            System.out.println("Would you like " + iWant(statement) + "?" );
        } else if(!(iLike(statement).equals("false string"))) {
            System.out.println("Why do you " + iLike(statement) + "me" + "?" );
        } else if ( keywordPrecedence(keywords, statement).equals("no") && keywordDetection(statement, keywordPrecedence(keywords, statement) ) ) {
            response = "Why so negative?";
        }else if ( (keywordPrecedence(keywords, statement).equals("mother") && (keywordDetection(statement, keywordPrecedence(keywords, statement))))
                || (keywordPrecedence(keywords, statement).equals("brother") && (keywordDetection(statement, keywordPrecedence(keywords, statement))))
                || (keywordPrecedence(keywords, statement).equals("sister") && (keywordDetection(statement, keywordPrecedence(keywords, statement))))
                || (keywordPrecedence(keywords, statement).equals("father") && (keywordDetection(statement, keywordPrecedence(keywords, statement)))))
        {
            System.out.println(keywordPrecedence(keywords, statement));
            System.out.println(keywordDetection(statement, keywordPrecedence(keywords, statement)));
            response = "Tell me more about your family.";
        } else if( (keywordPrecedence(keywords, statement).equals("dog") && keywordDetection(statement, keywordPrecedence(keywords, statement)))  || (keywordPrecedence(keywords, statement).equals("cat") && keywordDetection(statement, keywordPrecedence(keywords, statement)) ) ){
            response = "Tell me more about your pets.";
        } else if( keywordPrecedence(keywords, statement).equals("Mr.") && keywordDetection(statement,keywordPrecedence(keywords, statement)) ){
            response = "He sounds like a nice teacher.";
        } else if(  keywordPrecedence(keywords, statement).equals("Ms.") && keywordDetection(statement,  keywordPrecedence(keywords, statement)) ||  (keywordPrecedence(keywords, statement).equals("Mrs.") && keywordDetection(statement, keywordPrecedence(keywords, statement))) ){
            response = "She sounds like a nice teacher.";
        } 
        else {
            response = getRandomResponse();
        }

        return response;
    }
    
        
    public boolean keywordDetection(String statement, String keyword)
    {
        int firstLetter = statement.indexOf(keyword);
        
        
    if(firstLetter != -1){
        if( (firstLetter != 0) && (firstLetter != statement.length() - keyword.length()) && ((statement.substring(firstLetter - 1, firstLetter)).equals(" ") ) && ( (statement.substring(firstLetter + keyword.length(), firstLetter + keyword.length() + 1)).equals(" ") ) ){
            
            return true;
        } else if( (firstLetter == 0) && (firstLetter != statement.length() - keyword.length()) && (statement.substring(firstLetter + keyword.length(), firstLetter + keyword.length() + 1 ) ).equals(" ") ) {
            
            return true;
        }  else if( (firstLetter == statement.length() - keyword.length()) && !(statement.substring(firstLetter, firstLetter+1).equals(statement.substring(0,1))) && ( (statement.substring(firstLetter - 1, firstLetter) ).equals(" ") ) ) {

            return true;
        }  else if ( (firstLetter == statement.length() - keyword.length()) && (statement.substring(firstLetter, firstLetter+1).equals(statement.substring(0,1))) ){

            return true;
        } 
    }

    return false;
}
    
    public String keywordPrecedence(String[] arr, String statement){
        //returns the last keyword that occurs in string, as it makes the most sense out of the statement semantically
        
        int max;
        max = -1;
        String str = "";
        for(String string: arr){
            if( (statement.indexOf(string) > max) && (keywordDetection(statement, string)) ){
                max = statement.indexOf(string);
                str = string;
            }
        }
        
        
        if(max == -1){
            getRandomResponse();
            return str;
        } else {
           
            return statement.substring(max, max + str.length() );
        }
    }
    
    public String iWant(String statement){
        int ifPresent = statement.indexOf("I want");
        
        System.out.println(ifPresent + 6);
        
        if(ifPresent != -1){
            String strWant = statement.substring(ifPresent + 6);
            return strWant;
        } else {
            getRandomResponse();
            return "abc";
        }
    }
    
    public String iLike(String statement){
        int firstIndex = statement.indexOf("I");
        int secondIndex = statement.indexOf("you");
        if(firstIndex < secondIndex){
            String middleStr = statement.substring(firstIndex + 2, secondIndex );
            return middleStr;
        } else {
            return "false string";
        }
    }


    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 7;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        } else if(whichResponse == 4)
        {
            response = "no";
        } else if(whichResponse == 5)
        {
            response = "brother";
        } else if(whichResponse == 6)
        {
            response = "Intriguing...";
        }

        return response;
    }
}
