
package lab.pkg12;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Christopher
 * This program keeps track of a list of contacts. All the contacts have name, 
 * number, and address. This program allows them to modify, add, search, display,
 * and delete contacts. 
 */
public class Lab12 {

    
    public static void main(String[] args) throws IOException{
       Contact[] contacts = new Contact[100];
       boolean running;
       int userChoice, numItems;
       numItems = 0;
       numItems = LoadContacts(contacts);
        
        do {           
            DisplayMenu();
            userChoice = GetChoice();
            numItems = PerformUserChoice(userChoice, contacts, numItems);
            
        } while (userChoice != 6);
        
        SaveContacts(contacts, numItems);
    }
    
    public static int LoadContacts(Contact[] contacts) throws IOException{
        File contactsFile = new File("contacts.txt");
        Scanner inContactFileScanner = new Scanner(contactsFile);
        int cnt, numItems;
        String name, number, office;
        
        cnt = 0;
        numItems = 0;
        while (inContactFileScanner.hasNext()) {
            name = inContactFileScanner.nextLine();
            number = inContactFileScanner.nextLine();
            office = inContactFileScanner.nextLine();
            contacts[cnt] = new Contact(name, number, office);
            cnt++;
            numItems++;
            
        }
        
        System.err.println("Done loading, " + cnt + " contacts loaded");
        if (cnt == 0) {
            System.err.println("Warning No Contacts Loaded");
        }
        inContactFileScanner.close();
        return numItems;
       
    }
    
    public static int GetChoice(){
        Scanner kbd = new Scanner(System.in);
        int choice;
        do { 
            choice = kbd.nextInt();
            
        } while (choice < 1 || choice > 6);
        
        return choice;
    }
    
    public static void DisplayMenu(){
        System.out.println("Contact List Menu");
        System.out.println("1: Add Contact");
        System.out.println("2: Modify Contact");
        System.out.println("3: Delete Contact");
        System.out.println("4: Look up Contact");
        System.out.println("5: Display All Contacts"); //sort by name or office
        System.out.println("6: Quit");
    }
    
    public static int PerformUserChoice(int choice, Contact[] contacts, int numItems){
        switch(choice){
            case 1:
                numItems = AddContact(contacts, numItems);
                return numItems;
            case 2:
                ModifyContact(contacts, numItems);
                return numItems;
            case 3:
                
                numItems = DeleteContact(contacts, numItems); 
                
                return numItems;
            case 4:
                LookUpContact(contacts, numItems);
                return numItems;
            case 5:
                DisplayAll(contacts, numItems);
                return numItems;
            default:
                
                return numItems;
                
                
        }
    }
    
    public static int SearchContact(Contact[] contacts, int numItems){
        int searchChoice, cnt;
        String search;
        
        //display options
        Scanner kbd = new Scanner(System.in);
        System.out.println("Search by:");
        System.out.println("1: Name");
        System.out.println("2: Number");
        System.out.println("3: Office");
        
        //get the choice
        do {
                searchChoice = kbd.nextInt();
                
        } while (searchChoice < 1 || searchChoice > 3);
        
        //perform the choice
        switch(searchChoice){
            case 1:
                
                System.out.println("Enter Name:");
                do {                    
                    search = kbd.nextLine(); 
                } while (search.isEmpty());
                
                cnt = 0;
                while(cnt<numItems && contacts[cnt].getName().compareTo(
                        search) > 0 || cnt<numItems && contacts[cnt].getName(
                        ).compareTo(search) < 0) { // i changed < to >
                    
                    cnt++;
                }
                
                break;
            case 2:
                System.out.println("Enter Number:");
                 do {                    
                    search = kbd.nextLine(); 
                } while (search.isEmpty());
                cnt = 0;
                while(cnt<numItems && contacts[cnt].getNumber().compareTo(
                        search) > 0 || cnt<numItems && contacts[cnt].getNumber(
                        ).compareTo(search) < 0) {
                    
                    cnt++;
                }
                break;
            case 3:
                System.out.println("Enter Office:");
                 do {                    
                    search = kbd.nextLine(); 
                } while (search.isEmpty());
                cnt = 0;
                while(cnt<numItems && contacts[cnt].getOffice().compareTo(
                        search) > 0 || cnt<numItems && contacts[cnt].getOffice(
                        ).compareTo(search) < 0) {
                    
                    cnt++;
                }
                break;
            default:
                //should never be reached because the input is validated
                cnt = 0;
                System.err.println("Invalid Input");
                break;
        }
        
        return cnt; // the contact that is being looked for 
                    //should be at this intex in the array
        
    }
    
    public static int AddContact(Contact[] contacts, int numItems){
        Contact newContact;
        newContact = new Contact();
        contacts[numItems] = newContact;
        numItems++;
        return numItems;
        
    }
    
    public static void ModifyContact(Contact[] contacts, int numItems){
        int contactIndex, searchChoice;
        Scanner kbd = new Scanner(System.in);
        String search, modifiedAttributeValue;
        
        //find the contact to modify
        contactIndex = SearchContact(contacts, numItems);
        System.out.println("Found: " + contacts[contactIndex].getName());
        //ask what to modify /display options
        System.out.println("Modify:");
        System.out.println("1: Name");
        System.out.println("2: Number");
        System.out.println("3: Office");
        
        //get the choice
        do {            
            searchChoice = kbd.nextInt();
        } while (searchChoice < 1 || searchChoice > 3);
        
        //perform the choice
        switch(searchChoice){
            case 1:
                System.out.println("Enter the new Name:");
                do {
                    modifiedAttributeValue = kbd.nextLine();
                } while (modifiedAttributeValue.isEmpty());
                contacts[contactIndex].setName(modifiedAttributeValue);
                break;
            case 2:
                System.out.println("Enter the new Number:");
                do {
                    modifiedAttributeValue = kbd.nextLine();
                } while (modifiedAttributeValue.isEmpty());
                contacts[contactIndex].setNumber(modifiedAttributeValue);
                break;
            case 3:
                System.out.println("Enter the new Office:");
                do {
                    modifiedAttributeValue = kbd.nextLine();
                } while (modifiedAttributeValue.isEmpty());
                contacts[contactIndex].setOffice(modifiedAttributeValue);
                break;
             default:
                 System.err.println("Invalid Input");
                 break;
        }
        
    }
    
    public static int DeleteContact(Contact[] contacts, int numItems){
        int contactIndex;
        contactIndex = SearchContact(contacts, numItems);
        System.out.println("Deleting: " + contacts[contactIndex].getName());
        contacts[contactIndex] = contacts[numItems -1];
        numItems = numItems - 1;
        return numItems;
    }
    
    public static void LookUpContact(Contact[] contacts, int numItems){
        int contactIndex;
        contactIndex = SearchContact(contacts, numItems);
        System.out.printf("Name: %15s\n", contacts[contactIndex].getName());
        System.out.printf("Number: %15s\n", contacts[contactIndex].getNumber());
        System.out.printf("Office: %15s\n", contacts[contactIndex].getOffice());
    }
    
    public static void DisplayAll(Contact[] contacts, int numItems){
        Scanner kbd = new Scanner(System.in);
        int sortChoice;
        boolean sorted;
        Contact temporary;
        sorted = false;
        //display sorting options
        System.out.println("Select a sorting method:");
        System.out.println("1: Name");
        System.out.println("2: Office");

        //choose sorting method
        do {            
            sortChoice = kbd.nextInt();
        } while (sortChoice < 1 || sortChoice > 2);
         
        switch(sortChoice){
            case 1:
                //sort them 
                while (!sorted) {            
                    sorted = true;
                    for(int cnt = 0; cnt < numItems - 1; cnt++){
                        if(contacts[cnt].getName().compareTo(
                                contacts[cnt + 1].getName()) > 0){
                            //swap
                            temporary = contacts[cnt];
                            contacts[cnt] = contacts[cnt + 1];
                            contacts[cnt + 1] = temporary;
                            //set Flag
                            sorted = false;
                            
                        }
                    }
                }
                //display them
                for(int cnt = 0; cnt < numItems; cnt++){
                    System.out.printf("Name:   %15s\n", 
                            contacts[cnt].getName());
                    System.out.printf("Number: %15s\n", 
                            contacts[cnt].getNumber());
                    System.out.printf("Office: %15s\n\n", 
                            contacts[cnt].getOffice());
                    
                }
                break;
            case 2:
                while (!sorted) {            
                    sorted = true;
                    for(int cnt = 0; cnt < numItems - 1; cnt++){
                        if(contacts[cnt].getOffice().compareTo(
                                contacts[cnt + 1].getOffice()) > 0){
                            //swap
                            temporary = contacts[cnt];
                            contacts[cnt] = contacts[cnt + 1];
                            contacts[cnt + 1] = temporary;
                            //set Flag
                            sorted = false;
                        }
                    }
                }
                for(int cnt = 0; cnt < numItems; cnt++){
                    System.out.printf("Name:   %15s\n", 
                            contacts[cnt].getName());
                    System.out.printf("Number: %15s\n",
                            contacts[cnt].getNumber());
                    System.out.printf("Office: %15s\n\n", 
                            contacts[cnt].getOffice());
                }
                break;
        }
         
        
    }
    
    public static void SaveContacts(Contact[] contacts, int numItems) 
            throws IOException{
        File contactsFile = new File("contacts.txt");
        FileWriter outFileWriter = new FileWriter(contactsFile, false);
        PrintWriter outPrintWriter = new PrintWriter(outFileWriter, true);
        for(int cnt = 0; cnt < numItems; cnt++){
            outPrintWriter.println(contacts[cnt].getName());
            outPrintWriter.println(contacts[cnt].getNumber());
            outPrintWriter.println(contacts[cnt].getOffice());

        }
        outPrintWriter.close();
    }
}
