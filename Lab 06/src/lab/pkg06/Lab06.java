
package lab.pkg06;

import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;

/**Christopher King
 * Lab 06 Due Oct 22 2015
 *This program reads from a file and puts that data into an array which
 * is then used by the program. After its done, it rewrites the file with
 * the changed data. It can also display the data from the file when
 * appropriate.
 * 
 */
public class Lab06 {

   
    public static void main(String[] args) throws IOException{
        double zone[];
        File listFile;
        String choice;
        
        zone = new double[7];
        listFile = new File("list.txt");
        choice = "";
        
        loadPrices(listFile, zone);
        while (!choice.equals("4")) {
            choice = getChoice();
            performChoice(choice, zone);   
        }
        
        rewriteFile(listFile, zone);
        System.exit(0);
        
    }
    public static void loadPrices(File listFile, double zone[]) throws IOException{
        Scanner inFileScanner;
        inFileScanner = new Scanner(listFile);
        
        int i;
        for(i = 0; i < 7; i++)
            zone[i] = inFileScanner.nextDouble();
        inFileScanner.close();
               
    }
    
    public static String getChoice(){
        String choice;
        do{
        choice = JOptionPane.showInputDialog(null,"Menu\n" +
                "1:Look Up Prices \n" +
                "2:Produce Shipping Label \n" +
                "3:Edit Price \n" +
                "4:Quit");
        
        } while (!choice.equals("1")&&!choice.equals("2")
                &&!choice.equals("3")&&!choice.equals("4"));
        
        return choice;
        
    }
    
    public static void performChoice(String choice, double zone[]){
         if(choice.equals("1"))
             lookUpPrices(zone);
         if(choice.equals("2"))
             produceShippingLabel(zone);
         if(choice.equals("3"))
             editPrice(zone);   
    }
    
    public static void lookUpPrices(double zone[]){
        int zoneToSearch;
        do{
        zoneToSearch = Integer.parseInt(JOptionPane.showInputDialog(""
                + "Please Enter a Zone Number(0-6)"));
        } while(zoneToSearch > 6 && zoneToSearch < 0);
        JOptionPane.showMessageDialog(null, "The Price for Zone " + 
                zoneToSearch + " is " + zone[zoneToSearch]);
    }
    
    public static void produceShippingLabel(double zone[]){
        String shipAddress, shipState, itemToShip;
        double itemPrice, itemWeight, totalPrice;
        int zoneToSearch;
        String returnAddress;
        
        returnAddress = "25036 Co Rt 189 Adams, NY";
        
        do{
        zoneToSearch = Integer.parseInt(JOptionPane.showInputDialog(""
                + "Please Enter a Zone Number(0-6)"));
        } while(zoneToSearch >6 && zoneToSearch < 0);
        
        shipAddress = JOptionPane.showInputDialog(null, 
                "What is the Address to Ship to?");
        shipState = JOptionPane.showInputDialog(null, 
                "What is the State?");
        itemToShip = JOptionPane.showInputDialog(null, 
                "What Item is being shipped?");
        itemPrice = Double.parseDouble(JOptionPane.showInputDialog(null,
                "What is the Price of the item?"));
        itemWeight = Double.parseDouble(JOptionPane.showInputDialog(null,
                "What is the Weight of the item?"));
        totalPrice = itemPrice + itemWeight * zone[zoneToSearch];
        
        JOptionPane.showConfirmDialog(null, "Ship to: " + shipAddress + ", " 
                + shipState + "\nZone:"+ zone[zoneToSearch] + "\nReturn Address:" 
                + returnAddress + "\n\nItem Shipped:" + itemToShip + "\nItem Weight: " 
                + itemWeight + "\n Item Price: " + itemPrice + "\nTotal: " 
                + totalPrice);
        

    }
    
    public static void editPrice(double zone[]){
        int zoneToEdit;
        double newPrice;
        zoneToEdit = Integer.parseInt(JOptionPane.showInputDialog(
                "Please Enter a Zone Number(0-6)"));
        newPrice = Double.parseDouble(JOptionPane.showInputDialog(null,
                "What it the new Price for Zone " + zoneToEdit + "?"));
        zone[zoneToEdit] = newPrice;
    }
    public static void rewriteFile(File listFile, double zone[]) throws IOException{
        FileWriter listfileWriter;
        PrintWriter listPrintWriter;
        int i;
        
        listfileWriter = new FileWriter(listFile, false);
        listPrintWriter = new PrintWriter(listfileWriter);

        for (i = 0; i < 7; i++){
            listPrintWriter.println(zone[i]);
        }
        listPrintWriter.close();
        
        
        
        
        
    }
}
