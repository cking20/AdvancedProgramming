package files.notes;
import java.io.*;


public class FilesNotes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       //only use file writer when appending
       //write to file always needs a print writer
        PrintWriter outFilePrntWr;
        FileWriter outFileFW;
        outFilePrntWr = new PrintWriter("results.txt");
        outFilePrntWr.printf("WOO");
        outFilePrntWr.close();
        
        //appends a file
        outFileFW = new FileWriter("runningresults.txt", true); 
          //the true means open in append false means open new/overwrite
        outFilePrntWr = new  PrintWriter(outFileFW);
        outFilePrntWr.printf(" %d apples", 75);
        outFilePrntWr.close();
        
        
    }
    
}
