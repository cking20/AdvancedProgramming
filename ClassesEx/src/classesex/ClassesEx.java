
package classesex;
import java.io.IOException;
import java.util.Scanner;
public class ClassesEx {

    public static void main(String[] args)throws IOException{
       Student s1;
       Student s2;
       Student s3;
       Scanner kbd = new Scanner(System.in);
       String userName, date;
        
        System.out.println("Whats the Date");
        date = kbd.nextLine();
        System.out.println("Enter a name");
        userName = kbd.nextLine();
        s1 = new Student(userName);
       
        s2 = s1; //shallow copy: referance to same point in memory
                //not copying data
       
        //s1.SetName(userName);
        System.out.println(s1.GetName());
        s1.MarkHere(date);
        
        
        
        System.out.println("Enter a name");
        userName = kbd.nextLine();
        s3 = new Student(userName);
        
        s3.SetName(userName);
        System.out.println(s3.GetName());
        s3.MarkAbs(date);
        System.out.println("Number of students:" + Student.GetNumStudents());
        
        s3 = s1; //BAD ITS A MEMORY LEAK also it assigns s3 as a referance to s1 so they point to the same point
        
        //make an array of students
        Student [] students = new Student[5];
        int cnt;
        for(cnt = 0; cnt < students.length; cnt++){
            students[cnt] = new Student("Student" + cnt);
            Student.GetNumStudents();
        }
    }
    
}


