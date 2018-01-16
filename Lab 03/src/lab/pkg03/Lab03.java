
package lab.pkg03;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;
/**
 * @author Christopher King
 * Due: Oct 1st 2015
 * Lab 03 Mailing List
 * This Program accepts graphical user input to create a mailing list. 
 * It utilizes while loops and the swing library to allow the user to perform
 * multiple actions 
 * 
 */
public class Lab03 {

    
    public static void main(String[] args) throws IOException{
       boolean running;
       running = true;
       
       String fileName;
       fileName = "contactlist.txt";
       
       PrintWriter outFilePrntWr;
       FileWriter outFileFW; 
       
       File inFile;
       Scanner inFileScn;
       
       //vars from graphical input
       String userChoice;
       String contactName;
       String contactAddr;
       String contactCSZ;
       
       //vars from contact file
       String readName;
       String readAddr;
       String readCSZ;
       String entireList;
       
       
       while(running){
           
           userChoice = JOptionPane.showInputDialog(
                   "---------------------Menu---------------------\n"
                           + "1: Add People \n"
                           + "2: Look Up Contact\n"
                           + "3: Print List \n"
                           + "4: Exit \n");
           //Add Contact Funciton
           if(userChoice.equalsIgnoreCase("Add") || 
                   userChoice.equalsIgnoreCase("Add People") ||
                   userChoice.equals("1")){
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
           
           //Look up individuals Function
           if(userChoice.equalsIgnoreCase("Look") || 
                   userChoice.equalsIgnoreCase("Look Up Contact") ||
                   userChoice.equals("2")){
               inFile = new File(fileName);
               inFileScn = new Scanner(inFile);
               
               contactName = JOptionPane.showInputDialog(""
                       + "Enter Contact to Look Up");
               while(inFileScn.hasNextLine()){
                   readName = inFileScn.nextLine();
                   if (readName.equalsIgnoreCase(contactName)) {
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
           
           //Display Entire Lists
            if(userChoice.equalsIgnoreCase("Print") || 
                   userChoice.equalsIgnoreCase("Print List") ||
                   userChoice.equals("3")){
                
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
           
           //exits the while loop
           if(userChoice.equalsIgnoreCase("Exit") || userChoice.equals("4")){
              JOptionPane.showMessageDialog(null, "Program Closing Down");
               running = false;
           }
               
       }
       System.exit(0);
               
    }
    
}
