package classesex;
import java.io.*;
//must be public
public class Student {
    //attributes height weight variable ect
    private String name;
    private int here;
    private int what;
    private int where;
    private int who;
    private static int numberOfStudents = 0;
    
    //methods - functions of class manipulate atributes
    //anything static is to class
    //anything non static pertains to an instance
    
        //cant have any return type to be a constructor
    public Student(String nameToBeSetInObject){ // constructor that exicutes at the time of instanciation must be same name as class
        numberOfStudents++;
        System.err.println("Constructor doing");
        name = nameToBeSetInObject;
        
    }
    
    //static method that is called by the class not an instance
    public static int GetNumStudents(){
        return numberOfStudents;
    }
    //****function overloading is creating methods with the same name but have different paramaters
    public void Overload(int num){
        System.out.println("you used an int");
    }
    public void Overload(String num){
        System.out.println("you used a String");
    } 
    public void Overload(double num){
        System.out.println("you used a double");
    }
    
    
    
    
    public void SetName(String nameToBeSetInObject) {
        name = nameToBeSetInObject;
    }
    
    public String GetName(){
        return name;    
    }
    
    public void MarkHere(String theDate)throws IOException{
        here = 1;
        LogStatus(theDate);
    }
    
    public void MarkAbs(String theDate)throws IOException{
        here = 0;
        LogStatus(theDate);
    }
    
    public String GetAtn(){
        if(here == 1)
            return "Presant";
        else
            return "Absent";
        
    }
    
    public void LogStatus(String theDate)throws  IOException{
        FileWriter attndFileWriter = new FileWriter(name + ".txt", true);
        PrintWriter attnPrintWriter = new PrintWriter(attndFileWriter);
        attnPrintWriter.println(theDate + "\n" + GetAtn());
        attnPrintWriter.close();
    }   

    /**
     * @return the what
     */
    public int getWhat() {
        return what;
    }

    /**
     * @param what the what to set
     */
    public void setWhat(int what) {
        this.what = what;
    }

    /**
     * @return the where
     */
    public int getWhere() {
        return where;
    }

    /**
     * @param where the where to set
     */
    public void setWhere(int where) {
        this.where = where;
    }

    /**
     * @return the who
     */
    public int getWho() {
        return who;
    }

    /**
     * @param who the who to set
     */
    public void setWho(int who) {
        this.who = who;
    }
    
    
}
