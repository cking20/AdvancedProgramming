
package lab10;

import java.util.Scanner;
import java.io.*;

public class Customer {
    private String name;
    private String streetAddr;
    private String cityStateZip;
    private double balance;
    private String transactionFileName;
    private String customerFileName;
    
    public Customer(String aCustomerFileName)throws IOException{
        Scanner custFileScnr;
        File custFile = new File(aCustomerFileName);
        custFileScnr = new Scanner(custFile);
        customerFileName = aCustomerFileName;
        //read from file
        name = custFileScnr.nextLine();
        streetAddr = custFileScnr.nextLine();
        cityStateZip = custFileScnr.nextLine();
        balance = custFileScnr.nextDouble();
        custFileScnr.nextLine();
        transactionFileName = custFileScnr.nextLine();
        custFileScnr.close();
    }
    
    public void Customer(){
        
        Scanner kbd;
        Scanner custFileScnr;
        String aCustomerFileName;
        kbd = new Scanner(System.in);
        System.out.print("Enter a customer File Name: ");
        aCustomerFileName = kbd.nextLine();
        //Customer(aCustomerFileName); //if i csnt get that to work
        //                              just copy customer to this method
        custFileScnr = new Scanner(aCustomerFileName);
        customerFileName = aCustomerFileName;
        name = custFileScnr.nextLine();
        streetAddr = custFileScnr.nextLine();
        cityStateZip = custFileScnr.nextLine();
        balance = custFileScnr.nextDouble();
        custFileScnr.nextLine();
        transactionFileName = custFileScnr.nextLine();
    }
    
    public String GetTransFile(){
        return transactionFileName;
    }
    
    public double GetBalance(){
        return balance;
    }
    
    private void UpdateBalance(Transaction aTransaction){
        
        if (aTransaction.GetTransactionCode() == 'W') {
            balance -= aTransaction.GetAmount();
        } else if (aTransaction.GetTransactionCode() == 'D') {
            balance += aTransaction.GetAmount();
        }
        
    }
    
    public boolean Save() throws IOException{
        
        FileWriter custFileWriter;
        PrintWriter custPrintWriter;
        custFileWriter = new FileWriter(customerFileName,false);
        custPrintWriter = new PrintWriter(custFileWriter); 
        custPrintWriter.println(name);
        custPrintWriter.println(streetAddr);
        custPrintWriter.println(cityStateZip);
        custPrintWriter.println(balance);
        custPrintWriter.println(transactionFileName);
        custPrintWriter.close();
        
        return true;
    }
    
    public void DisplayReportHeading(){
        System.out.println(name);
        System.out.println(streetAddr);
        System.out.println(cityStateZip);
        System.out.println();
    }
    
    public void DisplayTransactionLine(Transaction aTransaction){
        UpdateBalance(aTransaction);        
        System.out.printf("Date: %10s\n", aTransaction.GetDate());
        System.out.printf("\tAmmount: %10.2f\n", aTransaction.GetAmount());
        System.out.printf("\tDescription: %-20s\n", aTransaction.GetDescription());
               
    }
}
