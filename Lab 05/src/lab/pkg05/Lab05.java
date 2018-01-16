
package lab.pkg05;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;

/**Christopher King
 * Lab 05 Manage Sales Log
 *
 * This program is for a group of salesmen who keep track of
 * their daily sales and who whish to compile the list into a report
 * It also allows for the deletion of the log at the starting of the 
 * new month
 * 
 */
public class Lab05 {

    
    public static void main(String[] args) throws IOException{
        String fileName;
        fileName = GetSalesPersonInfo() ;
        
        PerformAllTasks(fileName);
    }
    public static String GetSalesPersonInfo(){
        String name;
        name = JOptionPane.showInputDialog(null,"Enter Your Name:");
        return name;
    }
    public static void PerformAllTasks(String file) throws IOException{
        String choice;
        do {            
            choice = GetMenuChoice();
            PerformMenuChoice(choice,file);
        } while (!choice.toUpperCase().contains("Q") && !choice.contains("4"));
        
    }
    public static String GetMenuChoice(){
        String choice;
        choice = JOptionPane.showInputDialog(null,"Menu \n\n "
                + "1:Add to Sales Log \n"
                + "2:Generate Monthly Report \n"
                + "3:Start New Month \n"
                + "4:Quit");
        return choice;
    }
    public static void PerformMenuChoice(String choice, String file) 
            throws IOException{
        switch(choice.toUpperCase().charAt(0)){
            case 'A':
            case '1':
                AddToSalesLog(file);
                break;
            case 'G': 
            case '2':
                GenerateMonthlyReport(file);
                break;  
            case 'S':
            case '3':
                StartNewMonth(file);
                break;  
        }    
       
    }
    public static void AddToSalesLog(String fileName) throws IOException {
        
        PrintWriter filePrintWr;
        FileWriter fileFileWr;       
        String date,custName;
        double miles, gas, miscCharges;
        
        File file = new File(fileName + ".txt");
        
        //to append or not to append that is the file writers question
                                        //true means append
        fileFileWr = new FileWriter(file, true);
        //just throws to file without a filewriter in it
        filePrintWr = new PrintWriter(fileFileWr);
        
        //data input
        date = JOptionPane.showInputDialog(null, "Date:");
        custName = JOptionPane.showInputDialog(null, "Customer Name:");
        miles = Double.parseDouble(JOptionPane.showInputDialog(null, ""
                + "Miles Traveled(Decimal):"));
        gas = Double.parseDouble(JOptionPane.showInputDialog(null, ""
                + "Gas(Gallons):"));
        miscCharges = Double.parseDouble(JOptionPane.showInputDialog(null, ""
                + "Other Charges($):"));
        filePrintWr.printf("%s\n",date);
        filePrintWr.printf("%s\n",custName);
        filePrintWr.printf("%f\n",miles);
        filePrintWr.printf("%f\n",gas);
        filePrintWr.printf("%f\n",miscCharges);
        filePrintWr.close();
        
                
    }
    public static void GenerateMonthlyReport(String fileName) 
            throws IOException{
     File salesFile;  
     File monthlyReportFile;
     Scanner inFileScanner;
     PrintWriter monthlyPrintWr;
     FileWriter monthlyFileWr;
     String month,date,custName;
     double miles, gas, miscCharges;
     double runningMiles, runningGas, runningMiscCharges;
     
     month = JOptionPane.showInputDialog(null, "What is the Month:");
     runningMiles = 0;
     runningGas = 0;
     runningMiscCharges = 0;
     
     monthlyReportFile = new File(fileName + month + ".rpt");
     salesFile = new File(fileName + ".txt");
     monthlyFileWr = new FileWriter(monthlyReportFile, true);
     monthlyPrintWr = new PrintWriter(monthlyFileWr);
     inFileScanner = new Scanner(salesFile);
     
     //write to the file
     monthlyPrintWr.printf("Sales Person: %s\n", fileName);
     while(inFileScanner.hasNext()){
         //read then write +=runningtotals
         date = inFileScanner.nextLine();
         custName = inFileScanner.nextLine();
         miles = Double.parseDouble(inFileScanner.nextLine());
         gas = Double.parseDouble(inFileScanner.nextLine());
         miscCharges = Double.parseDouble(inFileScanner.nextLine());
         runningMiles = runningMiles + miles;
         runningGas = runningGas + gas;
         runningMiscCharges = runningMiscCharges + miscCharges;
         monthlyPrintWr.printf("Date: %s\n",date);
         monthlyPrintWr.printf("\tCustomer Name:   %s\n",custName);
         monthlyPrintWr.printf("\tMiles Travelled: %5.2f\n",miles);
         monthlyPrintWr.printf("\tGas Used:        %5.2f\n",gas);
         monthlyPrintWr.printf("\tMisc Charges:    %5.2f\n",miscCharges);
         
     }
         //write totals
     monthlyPrintWr.printf("Total Miles: %5.2f\n", runningMiles);
     monthlyPrintWr.printf("Total Gas: %5.2f\n", runningGas);
     monthlyPrintWr.printf("Total Miles: %5.2f\n", runningMiscCharges);
     
     monthlyPrintWr.close();
     
    }
    public static void StartNewMonth(String fileName) throws IOException{
        File salesFile;
        PrintWriter salesPrintWriter;
        FileWriter salesFileWriter;
        int sure;
        sure = JOptionPane.showConfirmDialog(null, 
                "Are you sure you want to erase last months sales?");
        if (sure == 0){
        salesFile = new File(fileName + ".txt");
        System.out.println(sure);
        salesFileWriter = new FileWriter(salesFile,false);
        salesPrintWriter = new PrintWriter(salesFileWriter);
        salesPrintWriter.close();
        }
    }
}
