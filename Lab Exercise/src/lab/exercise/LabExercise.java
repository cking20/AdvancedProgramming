
package lab.exercise;
import java.util.Scanner;
import java.text.DecimalFormat;


/**
 
 * @author cking0505
 */
public class LabExercise {

   
    public static void main(String[] args) {
        
        final double BOTTLE_DEPOSIT = 0.05;
        final double TAX_RATE = 0.0775;
        
        //usser supplied info
        String productName;
        int ozPerBottle, bottlesPerUnit, unitsPerPackage, numberOfPackages;
        double pricePerPackage;
        
        //computed information
        int totalBottles;
        double subTotal, tax, total, costPerBottle, costPerOz;
        
        Scanner keyboard = new Scanner(System.in);
        DecimalFormat dollarFormat = new DecimalFormat("#0.00");
        
        //get prodsuct information
        System.out.println("Enter the name of the product.");
        productName = keyboard.nextLine();
        System.out.println("Enter the ounces per bottle.");
        ozPerBottle = keyboard.nextInt();
        System.out.println("Enter the number of bottles in each"
                + " unit.");
        bottlesPerUnit = keyboard.nextInt();
        System.out.println("Enter the number of units in each"
                + " package.");
        unitsPerPackage = keyboard.nextInt();
        System.out.println("Enter the price per package.");
        pricePerPackage = keyboard.nextDouble();
        System.out.println("Enter the number of packages purchased.");
        numberOfPackages = keyboard.nextInt();
        
        //Compute number of bottles
        totalBottles = numberOfPackages * unitsPerPackage * bottlesPerUnit;
        
        //compute subtotal
        subTotal = numberOfPackages * pricePerPackage;
        
        //compute tax
        tax = subTotal * TAX_RATE;
        
        //compute total
        total = subTotal + tax + totalBottles * BOTTLE_DEPOSIT;
        
        //compute Cost Per Bottle
        costPerBottle = total / totalBottles;
        
        //compute cost per oz
        costPerOz = total/ (totalBottles * ozPerBottle);
        
        //display cost summery
        System.out.println("Product:   " + productName);
        System.out.println("Bottles in each unit:   " + bottlesPerUnit);
        System.out.println("Units per package:   " + unitsPerPackage);
        System.out.println("Number of packages:   " + numberOfPackages);
        System.out.println("Ounces per bottle:   " + ozPerBottle);
        System.out.println("Subtotal:   $" + dollarFormat.format(subTotal));
        System.out.println("Tax:   $" + dollarFormat.format(tax));
        System.out.println("Total:   $" + dollarFormat.format(total));
        System.out.println("Cost per Bottle:   $" 
                + dollarFormat.format(costPerBottle));
        System.out.println("Cost per ounce:   $" 
                + dollarFormat.format(costPerOz));
        
        
        
        // TODO code application logic here
    }
    
}
