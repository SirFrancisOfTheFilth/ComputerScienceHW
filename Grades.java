import java.util.*;

public class Grades{
  public static void main(String[] args){

    int[] gradeArr = new int[20];
    int lowestGrade = 100;
    int sumNum = 0;

    for(int i = 0; i < gradeArr.length; i++){
      gradeArr[i] = ((int)(Math.random() * 40)) + 60;
      if(lowestGrade > gradeArr[i]){
        lowestGrade = gradeArr[i];
      }
      sumNum += gradeArr[i];
      System.out.println("Grade " + (i + 1) + " : " + gradeArr[i]);
    }
    System.out.println("The average of the grades with the lowest grade is: " + sumNum/gradeArr.length + ".");
    System.out.println("The average of the grades without the lowest grade is: " + (sumNum - lowestGrade)/(gradeArr.length - 1) + ".");
    System.out.println("The lowest grade was " + lowestGrade + ".");

  }
}
