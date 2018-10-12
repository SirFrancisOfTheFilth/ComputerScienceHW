import java.util.*;

public class Advisory
{
    public static void main(String[] args){
        
        java.util.ArrayList<String> students = new java.util.ArrayList<>();
        students.add("Sameer");
        students.add("Praneeth");
        students.add("Robert");
        students.add("Nishant");
        students.add("Michael");
        students.add("PeterL");
        students.add("Evan");
        students.add("William");
        students.add("Raunaq");
        students.add("Rahul");
        students.add("Neil");
        students.add("PeterD");
        students.add("Jonathan");
        
        int size = students.size();
        
       String[] snackOrder = new String[students.size()];
       System.out.println(students.size());
        
       int randomNum;
        
        for(int i = 0; i < size; i++){
            randomNum = (int)(Math.random() * students.size());
            snackOrder[i] = students.get(randomNum);
            System.out.println(snackOrder[i]);
            students.remove(students.get(randomNum));
        }
       
        System.out.println("---------------------------");
    }

}
