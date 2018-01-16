package lab.pkg04;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;
/**
 * @author Christopher King
 * Due: Oct 1st 2015
 * Lab 04 Mailing List with functions
 * This Program accepts graphical user input to create a mailing list. 
 * It utilizes while loops and the swing library to allow the user to perform
 * multiple actions while using functions that return and pass values.
 * 
 */
public class Lab04 {

    
    public static void main(String[] args) throws IOException{
        runMailingList();       
    }
    
    public static void runMailingList() throws IOException{
        boolean running;
        running = true;
        String choice;
        
        while(running){
            choice = getUserChoice();
            running = performUserChoice(choice); 
        }
        System.exit(0); 
        
    }
    
    public static String getUserChoice() {
        String userChoice;
        userChoice = JOptionPane.showInputDialog(
                   "---------------------Menu---------------------\n"
                           + "1: Add People \n"
                           + "2: Look Up Contact\n"
                           + "3: Print List \n"
                           + "4: Exit \n");
        return userChoice;
    }
    
    public static boolean performUserChoice(String userChoice) throws IOException{
        String fileName;
        fileName = "contactlist.txt";
        boolean running;
        running = true;
                
         //Add Contact Funciton
        if(userChoice.equalsIgnoreCase("Add") || 
                userChoice.equalsIgnoreCase("Add People") ||
                userChoice.equals("1")){
            addContact(fileName);
        }
        if(userChoice.equalsIgnoreCase("Look") || 
                userChoice.equalsIgnoreCase("Look Up Contact") ||
                userChoice.equals("2")){
            lookUpContact(fileName);
        }
        if(userChoice.equalsIgnoreCase("Print") || 
                   userChoice.equalsIgnoreCase("Print List") ||
                   userChoice.equals("3")){
            printList(fileName);
        }
        if(userChoice.equalsIgnoreCase("Exit") || userChoice.equals("4")){
            running = exitProgram();
           
             
        }
        return running;
    }
    
    public static void addContact(String fileName) throws IOException{
        
              
        PrintWriter outFilePrntWr;
        FileWriter outFileFW;
        String contactName;
        String contactAddr;
        String contactCSZ;
        contactName = JOptionPane.showInputDialog(""
                + "Enter Contact Name:");
        contactAddr = JOptionPane.showInputDialog(""
                       + "Enter Contact Address:");
        contactCSZ = JOptionPane.showInputDialog(""
                       + "Enter Contact City, State, Zip: ");
               
        outFileFW = new FileWriter(fileName, true); 
                                    //this should append the file
        outFilePrntWr = new  PrintWriter(outFileFW);
        outFilePrntWr.printf("%s\n%s\n%s\n", contactName, 
                       contactAddr, contactCSZ);
        outFilePrntWr.close(); 
        outFileFW.close();
       
    }
    
    public static void lookUpContact(String fileName) throws IOException{
     //Look up individuals Function
        File inFile;
        Scanner inFileScn; 
        String contactName;
        String readName;
        String readAddr;
        String readCSZ;
       
    
        inFile = new File(fileName);
        inFileScn = new Scanner(inFile);
               
        contactName = JOptionPane.showInputDialog(""
                + "Enter Contact to Look Up");
        while(inFileScn.hasNextLine()){
            readName = inFileScn.nextLine();
            if (readName.toLowerCase().contains(contactName.toLowerCase())) {
                readAddr = inFileScn.nextLine();
                readCSZ = inFileScn.nextLine();
                JOptionPane.showMessageDialog(null, "Name: " + readName
                        + "\nAddress: " + readAddr + "\nCity,State,Zip:"
                        + readCSZ + "\n");
                       
                   } else {
                       inFileScn.nextLine();
                       inFileScn.nextLine();
                   }
               }
               inFileScn.close(); 
              
    }
    
    public static void printList(String fileName) throws IOException{
         //Display Entire Lists
        File inFile;
        Scanner inFileScn;
        String entireList;
        String readName;
        String readAddr;
        String readCSZ;
        inFile = new File(fileName);
        inFileScn = new Scanner(inFile);
        entireList = "";
        while(inFileScn.hasNextLine()){
            readName = inFileScn.nextLine();
            readAddr = inFileScn.nextLine();
            readCSZ = inFileScn.nextLine();
            entireList = entireList + "\n" + readName + "\n" 
                    + readAddr + "\n" + readCSZ + "\n";
               
        }
        JOptionPane.showMessageDialog(null, entireList);
        inFileScn.close();  
            
    }
    
    public static boolean exitProgram() {
        JOptionPane.showMessageDialog(null, "Program Closing Down");
        return false;
    }
}
        
               
           
           
          
           
          
           
          
           
             
               
           
    

