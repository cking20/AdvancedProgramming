
package lab.pkg09;


import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;
/**
 *
 * @author Christopher
 */
public class Lab09 {

    
    public static void main(String[] args) throws IOException{
        Order custOrder;
        int mealNum;
        int quant;
        char choice;
        
        custOrder = new Order();
        
        
        do {
            do{
                choice = GetChar();
                PerformChoice(choice, custOrder);
            } while (choice != 'F' && choice != 'Q');
            if(choice == 'F'){
            custOrder.DisplayReciept();
            custOrder = new Order();
            }
        } while (choice != 'Q');
               
        
    }
    
    public static char GetChar(){
        char choice;
        do {    
            //display menu
            choice = (JOptionPane.showInputDialog("Menu\n"
                    + "1: Add Item\n"
                    + "2: Remove Item\n"
                    + "3: Finish Order\n"
                    + "4: Quit").toUpperCase().charAt(0));
        } while (choice != 'A' && choice != 'R' 
                && choice != 'F' && choice != 'Q');
        
        return choice;
    }
    
    public static void PerformChoice(char choice, Order cusOrder){
       int item, quant;
       
        if (choice == 'A' || choice == 'R') {
            //error handle the input
            do {            
                item = Integer.parseInt(JOptionPane.showInputDialog("Item Number")); 
            } while (item < 0 || item > 9);
            //error handle the input
            do {            
                quant = Integer.parseInt(JOptionPane.showInputDialog("Quantity"));   
            } while (quant < 1 || quant > 100);
            
        
            if (choice == 'A')
                cusOrder.AddItem(quant, item);

            if (choice == 'R'){
             //returns false if there are not enough items in the current inv.
                if(cusOrder.RemoveItem(quant, item) == false)
                    System.err.println("Not enough Items in order to Remove");
            }  
            
        
        }
       
        
        
        
    }
    
}
