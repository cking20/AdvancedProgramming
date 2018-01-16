package lab10;

import java.util.Scanner;
import java.io.*;

public class Lab10 {
    /**
     * Christopher King
     * Lab 10 Due: Nov. 19th
     * This program manages a bank log. It reads in from a transaction file
     * that is connected to the customer file. For each transaction in the 
     * file, the program modifies the balance in the customers account.
     * It utilizes 2 different classes working together to get the job done.
     */
   
    public static void main(String[] args) throws IOException {
        String customerFileName;
        customerFileName = GetFileName();
        Customer aCustomer = new Customer(customerFileName);
        Transaction aTransaction = new Transaction(aCustomer.GetTransFile());
        aCustomer.DisplayReportHeading();
        //transaction loop
        do { 
            aTransaction.LoadTransaction();
            aCustomer.DisplayTransactionLine(aTransaction);
            
        } while (aTransaction.HasMoreTransactions());
        //print final balance
        System.out.printf("Balance: %10.2f", aCustomer.GetBalance());
        //save
        aCustomer.Save();
    
    }
    public static String GetFileName(){
        Scanner kbd = new Scanner(System.in);
        System.out.println("what is the name of the customer File?");
        return kbd.nextLine();
    }
}
