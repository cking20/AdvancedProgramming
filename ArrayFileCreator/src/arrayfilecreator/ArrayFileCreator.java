
package arrayfilecreator;
import java.io.*;
import java.util.Random;
/**
 *
 * @author Christopher
 */
public class ArrayFileCreator {
    public static final int WIDTH = 30; //should be 30
    public static final int HEIGHT = 28; //should be 28
    
    public static void main(String[] args) throws IOException{
       int value[][];
       Random randomGenerator;
       FileWriter outFileWriter;
       PrintWriter outPrintWriter;
       String fileName;
       
       fileName = "11111111.txt"; //DDMMYYYY
       outFileWriter = new FileWriter(fileName,false); //true appends / false rewrites
       outPrintWriter = new PrintWriter(outFileWriter,true);
       
       randomGenerator = new Random();
       value = new int[WIDTH][HEIGHT];
       
       
       
       for (int row = 0; row < WIDTH; row++){
            for(int seat = 0; seat < HEIGHT; seat++){
                value[row][seat] = randomGenerator.nextInt(1);
                outPrintWriter.print(value[row][seat] + " ");
               
            } 
            outPrintWriter.println();
        } 
    }
    
}
