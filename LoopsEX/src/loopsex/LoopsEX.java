
package loopsex;

import java.io.*;
import java.util.Scanner;
        

public class LoopsEX {

    
    public static void main(String[] args) throws IOException{
      Scanner inFileScn = new Scanner(new File("file.txt"));
      int num;
      int loopCounter;
      
      for( int count = 0; count < 5; count++){
         num = inFileScn.nextInt();
         System.out.println("Number" + count + " is " + num +".");
        
      }
      inFileScn.close();
      
      
      loopCounter = 0;
      inFileScn = new Scanner(new File("file.txt"));
      while(inFileScn.hasNext()){
          inFileScn.nextLine();
          loopCounter++;
      }
      System.out.println(loopCounter +" Lines in file");
      inFileScn.close();
        
    }
    
}
