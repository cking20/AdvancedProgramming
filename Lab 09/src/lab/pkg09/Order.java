
package lab.pkg09;

import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;
import java.text.DecimalFormat;
    
public class Order {
    private final int SIZE = 10;
    private int [] quantities;
    private String [] descriptions;
    private double [] prices;
    private double taxRate;
    private DecimalFormat output = new DecimalFormat("$###,###.##");
    
    
    public Order() throws IOException{
        quantities = new int[SIZE];
        descriptions = new String[SIZE];
        prices = new double[SIZE];
        taxRate = .0725;
        LoadProductInfo();
        
    }
    public void LoadProductInfo() throws IOException{
        int cnt;
        File menuFile = new File("menu.txt");
        Scanner menuFileScanner;
        menuFileScanner = new Scanner(menuFile);
        cnt = 0;
        while(cnt < quantities.length){
            descriptions[cnt] = menuFileScanner.nextLine();
            prices[cnt] = menuFileScanner.nextDouble();
            menuFileScanner.nextLine();
            cnt++;
        }
        menuFileScanner.close();
        
    }
    
    public void AddItem(int quantityToAdd, int ItemToAdd){
        quantities[ItemToAdd] += quantityToAdd;
    }
    
    public boolean RemoveItem(int quantityToRemove, int ItemToRemove){
        if(quantities[ItemToRemove] >= quantityToRemove){
            quantities[ItemToRemove] -= quantityToRemove;
            return true;
        } else {
            return false;}
    }
    
    private double CalculateSubTotal(){
        double subtotal;
        int cnt;
        subtotal = 0.0;
        for(cnt = 0; cnt < quantities.length; cnt++){
            subtotal += prices[cnt] * quantities[cnt];
        }
        return subtotal;
    }
    
    private double CalculateAmmountOfTax(){
        double subTotal, ammountOfTax;
        subTotal = CalculateSubTotal();
        ammountOfTax = subTotal * taxRate;
        
        return ammountOfTax; 
    }
    
    private double CalculateTotal(){
        double total;
        total  = CalculateSubTotal() + CalculateAmmountOfTax();
       
        return total;
    }
    
    public void DisplayReciept(){
        String orderList;
        int cnt;
        orderList = "";
        for(cnt = 0;cnt < quantities.length; cnt++){
            if(quantities[cnt] != 0){
                 orderList +=  quantities[cnt] + " " + descriptions[cnt] + " " 
                         + prices[cnt] + "\n";              
            }
            
        }
        
        JOptionPane.showMessageDialog(null, "Reciept\n"
                + orderList + "\nSubTotal: " + output.format(CalculateSubTotal()) + "\n"
                + "Tax:           " + output.format(CalculateAmmountOfTax()) + "\n"
                + "Total:         " + output.format(CalculateTotal()));
        

    }
}
