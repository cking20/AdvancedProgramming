
package lab.pkg02;
import java.io.*;
import java.util.Scanner;



/**
 * @author Christopher King
 * Due: Sept 24th 2015
 * Lab 02 Shovel Invoice
 * This Program generates an invoice for a shovel shipping company after
 * reading in pricing information form a file and user input from the
 * console. It then generates an invoice and displays it to the screen
 * 
 */
public class Lab02 {

  
    public static void main(String[] args) throws IOException {

        File inFile;
        Scanner inFileScn;
        Scanner kbd;
        
        inFile = new File("sale.txt");
        inFileScn = new Scanner(inFile);
        kbd = new Scanner(System.in);
        
        
        //read from file in this order
        double shovelPrice;
        int exLrgCapacity;
        int lrgCapacity;
        int medCapacity;
        int smlCapacity;
        int exSmCapacity;
        double exLrgShippingPrice;
        double lrgShippingPrice;
        double medShippingPrice;
        double smlShippingPrice;
        double exSmShippingPrice;
        //User input
        String custName; 
        String custAddress; 
        String custCity;
        String custState;
        String custZip;
        int numShovels; 
        
        
        //calculated Values
        int remShovels;
        int numExLrgCases;       
        int numLrgCases;  
        int numMedCases;
        int numSmlCases;   
        int numExSmlCases;   
        
        double exLrgShippingCost; 
        double lrgShippingCost;
        double medShippingCost;
        double smlShippingCost;
        double exSmShippingCost; 
        double totalShipCost; 
                
        double exLrgProductCost; 
        double lrgProductCost; 
        double medProductCost; 
        double smlProductCost; 
        double exSmProductCost;
        double totalProductCost;
        double totalBillcost; 
        
        
    /*Generate Shovel Order
            Get Shipping Information 
            Read Customer Input 
            Calculate Cases Needed
            Calculate Totals
            Display Invoices
    */        

    //Get Shipping Information 
        shovelPrice = inFileScn.nextDouble();
        exLrgCapacity = inFileScn.nextInt();
        lrgCapacity = inFileScn.nextInt();
        medCapacity = inFileScn.nextInt();
        smlCapacity = inFileScn.nextInt();
        exSmCapacity = inFileScn.nextInt();
        exLrgShippingPrice = inFileScn.nextDouble();
        lrgShippingPrice = inFileScn.nextDouble();
        medShippingPrice = inFileScn.nextDouble();
        smlShippingPrice = inFileScn.nextDouble();
        exSmShippingPrice = inFileScn.nextDouble();
        inFileScn.close();
    //Read Customer Input 
        System.out.println("Customer: ");
        custName = kbd.nextLine();
        System.out.println("Address: ");
        custAddress  = kbd.nextLine();
        System.out.println("City: ");
        custCity = kbd.nextLine();
        System.out.println("State: ");
        custState = kbd.nextLine();
        System.out.println("Zip: ");
        custZip = kbd.nextLine();
        System.out.println("Number of Shovels: ");
        numShovels = kbd.nextInt();
        kbd.nextLine();
            
   // Calculate Cases Needed
         numExLrgCases = numShovels / exLrgCapacity;     
         remShovels = numShovels % exLrgCapacity;
         numLrgCases = remShovels / lrgCapacity;     
         remShovels = remShovels % lrgCapacity;
         numMedCases = remShovels / medCapacity;     
         remShovels = remShovels % medCapacity;
         numSmlCases = remShovels / smlCapacity;     
         remShovels = remShovels % smlCapacity;
         numExSmlCases = remShovels / exSmCapacity;     
        
    //Calculate Totals
        exLrgShippingCost = exLrgShippingPrice * numExLrgCases;
        lrgShippingCost = lrgShippingPrice * numLrgCases;
        medShippingCost = medShippingPrice * numMedCases;
        smlShippingCost = smlShippingPrice * numSmlCases;
        exSmShippingCost = exLrgShippingPrice * numExSmlCases;
        totalShipCost = exLrgShippingPrice + lrgShippingPrice + 
                medShippingPrice + smlShippingPrice + exSmShippingPrice; 
        exLrgProductCost = shovelPrice * numExLrgCases * exLrgCapacity;
        lrgProductCost = shovelPrice * numLrgCases * lrgCapacity;
        medProductCost = shovelPrice * numMedCases * medCapacity;
        smlProductCost = shovelPrice * numSmlCases * smlCapacity;
        exSmProductCost = shovelPrice * numExSmlCases * exSmCapacity;
        totalProductCost = exLrgProductCost  + lrgProductCost + 
                medProductCost + smlProductCost + exSmProductCost; 
        totalBillcost = totalProductCost  + totalShipCost;
    //Display Invoices
        System.out.println("The Best Snow Shovels (You Know It) Inc.");
        System.out.println("    East Somewhere\n");
        System.out.println("Shipping Invoice");
        System.out.println("CUSTOMER:");
        System.out.println(custName);
        System.out.println(custAddress);
        System.out.println("");
        System.out.printf("%s, %s %s\n",custCity,custState,custZip);
        System.out.printf("%-30s%8s%16s\n", "Items Shipped","Shipping",
                "Product Cost");
        System.out.printf("%-2d %-27s%8.2f%16.2f\n", numExLrgCases, 
                "Extra Large Case(s)", exLrgShippingCost, exLrgProductCost);
        System.out.printf("%-2d %-27s%8.2f%16.2f\n", numLrgCases, 
                "Large Case(s)", lrgShippingCost, lrgProductCost);
        System.out.printf("%-2d %-27s%8.2f%16.2f\n", numMedCases, 
                "Medium Case(s)", medShippingCost, medProductCost);
        System.out.printf("%-2d %-27s%8.2f%16.2f\n", numSmlCases, 
                "Small Case(s)", smlShippingCost, smlProductCost);
        System.out.printf("%-2d %-27s%8.2f%16.2f\n", numExLrgCases, 
                "Extra Small Case(s)", exLrgShippingCost, exLrgProductCost);
        System.out.println("");
        System.out.printf("%-30s%8.2f%16.2f\n", "Totals:", totalShipCost, 
                totalProductCost);
        System.out.printf("%-30s%24.2f\n", "Total Bill:",totalBillcost);

    }
    
}
