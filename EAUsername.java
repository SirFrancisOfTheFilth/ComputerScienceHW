import java.util.*;

public class EAUsername{

  public static void main(String[] args){

  boolean decidingVal = true;
  while(decidingVal){

    String str1; //for first part of email with last name
    String str2;//for part of email with first name character;
    String str3; //for part of email with first letter of middle name character

    System.out.println("Enter your full name, or any full name (with spaces, since it is assumed that you are a normal human being who enters their full name with spaces.) ");
    Scanner scan1 = new Scanner(System.in);
    String scanStr = scan1.nextLine();

    System.out.println("Enter your graduation year: ");
    Scanner gradYear = new Scanner(System.in);
    String scanInt = gradYear.nextLine();

    int counter = 0;
    int space1 = 0;
    int space2 = 0;

    space1 = scanStr.indexOf(" ");
    counter += 1;

    String newScanStr = scanStr.substring(space1 + 1);

    if(newScanStr.indexOf(" ") != -1){
      space2 = newScanStr.indexOf(" ") + space1 + 1;
      counter += 1;
    }

    //Main part of program

    str2 = scanStr.substring(0,1);//for first name(universal value, since all will have the same first name

    if(counter == 2) {//Meaning that there has to be a middle name

      str3 = scanStr.substring(space1 + 1, space1 + 2);//for middle name

      if( (scanStr.length() - (space2 + 1)) >= 4){//dependent upon length of last name
        str1 = scanStr.substring(space2 + 1, space2 + 5); //4 first letters of last name
      } else {
        str1 = scanStr.substring(space2 + 1);
      }

      String finalStr = str1 + str2 + str3 + scanInt.substring(2,4) + "@episcopalacademy.org";
      System.out.println(finalStr.toLowerCase());

    } else if(counter == 1){//Meaning that there isnt a middle name

      if( (scanStr.length() - (space1 + 1)) >= 4){//dependent upon length of last name
        str1 = scanStr.substring(space1 + 1, space1 + 5); //4 first letters of last name
      } else {
        str1 = scanStr.substring(space1 + 1);
      }

      String finalStr = str1 + str2 + scanInt.substring(2,4) + "@episcopalacademy.org";
      System.out.println(finalStr.toLowerCase());
    }

    System.out.println("Do you want to determine another email? Press 1 to re-enter or press 2 to quit.");
    Scanner input = new Scanner(System.in);
    int inputNum = input.nextInt();
    if(inputNum == 2){
      break;
    }
  }
}
}
