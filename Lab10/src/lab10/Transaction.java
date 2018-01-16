
package lab10;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Christopher
 */
public class Transaction {
    private String date;
    private String description;
    private double amount;
    private char transactionCode;
    private String transactionFileName;
    private Scanner transactionFileScnr;
    
    public Transaction(String aTransactionFileName)throws IOException{
        File transFile = new File(aTransactionFileName);
        transactionFileScnr = new Scanner(transFile);
        transactionFileName = aTransactionFileName;
        
    }
    
    public void LoadTransaction(){
        date = transactionFileScnr.nextLine();
        //should be W,D,or something
        transactionCode = transactionFileScnr.nextLine().toUpperCase().charAt(0);
        amount = transactionFileScnr.nextDouble();
        transactionFileScnr.nextLine();
        description = transactionFileScnr.nextLine();
        
    }

    
    public String GetDate() {
        return date;
    }
    
    public String GetDescription() {
        return description;
    }
    
    public double GetAmount() {
        return amount;
    }
    
    public char GetTransactionCode() {
        return transactionCode;
    }
    
    public  boolean HasMoreTransactions() throws IOException{
        if (transactionFileScnr.hasNext()) {
            return true;
            
        } else {
            transactionFileScnr.close();
            //uncomment this to have the file cleared
            /*
            FileWriter rewriteFileWriter;
            rewriteFileWriter = new FileWriter(transactionFileName, false);
            */       
            return false;
        }
        
    }
    
    
    
    
}
