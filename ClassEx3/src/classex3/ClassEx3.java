
package classex3;

import java.util.Scanner;

public class ClassEx3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //key point of lecture: the extraction leaves white space behind that will fuck up the next nextline
        Scanner kbd = new Scanner(System.in);
        String name;
        int age;
        double weight;
        char middleInit;
        short IQ;
        System.out.println("Enter YOur NAme: ");
        name = kbd.nextLine();
        kbd.nextLine(); // to stop the user from entering shit ahead
        
        System.out.println("Enter your middle initial");
        middleInit = kbd.nextLine().charAt(0); 
        //because there is no nextChar command. we have to use the method of 
        //the string class to access the char at 0

        
        
        
        System.out.println("Enter Your IQ: ");
        IQ = kbd.nextShort();
        System.out.println("Sign?");
        kbd.nextLine(); // to throw away the return
        name = kbd.nextLine(); 
        System.out.print(name);
        
        
    
    }
}