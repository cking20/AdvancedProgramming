
package lab.pkg07;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;


/** Christopher King
 * Lab 07 Due Oct 29
 * Selling Tickets
 * This program allows for a salesman, and I mean that in the most gender 
 * neutral way possible, to sell tickets for multiple events. They can also 
 * refund and look up the availability of a seat
 *
 * 
 */
public class Lab07 {

    public static void main(String[] args) throws IOException{
        double prices[][];
        int availability[][];
        
        availability = new int[30][28];
        
        prices = loadPrices();
        loadEvent(availability);
        performEachTask(availability, prices);
        saveEvent(availability);
              
        System.exit(0);
    }
    public static double[][] loadPrices() throws IOException{
        Scanner priceScanner;
        double [][] prices;
        File priceFile;
        priceFile = new File("prices.txt");
        priceScanner = new Scanner(priceFile);
        prices = new double[30][28];
        for (int row = 0; row < 30; row++){
            for(int seat = 0; seat < 28; seat++){
                prices[row][seat] = priceScanner.nextDouble();
            }  
        } 
        priceScanner.close();
        return prices;      
    }
    
    public static int [][] loadEvent(int [][] event) throws IOException{
        Scanner eventScanner;
        
        String eventDate;
        File eventFile;
        
        eventDate = JOptionPane.showInputDialog(
                "What is the Date of the Event(DDMMYYYY)?") + ".txt";
        eventFile = new File(eventDate);
        eventScanner = new Scanner(eventFile);
        
        
        for (int row = 0; row < 30; row++){
            for(int seat = 0; seat < 28; seat++){
                event[row][seat] = eventScanner.nextInt();
            }  
        } 
        eventScanner.close();
        return event;      
    }
    
    
    public static int [][] performEachTask(int avaliability[][], double price[][]) 
            throws IOException{
        String choice;
        do {
            choice = getChoice();
            avaliability = performChoice(choice, avaliability, price);
        } while (!choice.contains("Qu") && !choice.contains("5"));
        return avaliability;
    }
    
    public static String getChoice() {
        String choice;
        choice = JOptionPane.showInputDialog(
                  "       MENU\n"
                + "1: Switch Event\n"
                + "2: Look Up Availability\n"
                + "3: Sell Seats\n"
                + "4: Cancel a Sale\n"
                + "5: Quit");
        return choice;
    }
    
    public static int [][] performChoice(String choice, int avaliability[][], 
            double price[][]) throws IOException{
        
            if(choice.contains("Sw") || choice.contains("1"))
                avaliability = switchEvent(avaliability);
            if(choice.contains("Lo") || choice.contains("2"))
                lookUpAvail(avaliability, price);
            if(choice.contains("Se") || choice.contains("3"))
                avaliability = sellSeat(avaliability, price);
            if(choice.contains("Ca") || choice.contains("4"))
                avaliability = refundSeat(avaliability, price);
            
            return avaliability;
        
    }
    
    public static int [][] switchEvent(int [][] availability) throws IOException{
        saveEvent(availability);
        /*availability = */loadEvent(availability); 
        return availability;
    }
    
    public static void saveEvent(int [][] event)throws IOException{
        Scanner eventScanner;
        String eventDate;
        PrintWriter savePrintWriter;
        
        eventDate = JOptionPane.showInputDialog(
                "What is the Date of the Event To Be Saved(DDMMYYYY)?");
        savePrintWriter = new PrintWriter(eventDate + ".txt"); 
        
        for (int row = 0; row < 30; row++){
            for(int seat = 0; seat < 28; seat++){
               savePrintWriter.print(event[row][seat]);
               savePrintWriter.print(" ");
            } 
            savePrintWriter.print("\n");
        } 
        savePrintWriter.close();
    }
    
    public static void lookUpAvail(int [][] event, double [][] prices) {
        int seatNum, rowNum, seatToSearch;
        
        rowNum = Integer.parseInt(JOptionPane.showInputDialog(
                "Please Enter a Row Number"));
        seatNum = Integer.parseInt(JOptionPane.showInputDialog(
                "Please Enter a Seat Number"));
        seatToSearch = event[rowNum][seatNum];
        if (seatToSearch == 1)
            JOptionPane.showMessageDialog(null, "The Seat at Row " + rowNum +
                    " and Seat " + seatNum + " is already sold.\n"
                    + "It Costed : " + prices[rowNum][seatNum]);
        
        if (seatToSearch == 0)
            JOptionPane.showMessageDialog(null, "The Seat at Row " + rowNum + 
                    " and Seat " + seatNum + " is not yet sold.\n"
                    + "It Costs : " + prices[rowNum][seatNum]);
    }
    
    public static int [][] sellSeat(int [][] event, double [][] prices){
        int rowNum, seatNum, seatToSearch;
        rowNum = Integer.parseInt(JOptionPane.showInputDialog(
                "Please Enter a Row Number"));
        seatNum = Integer.parseInt(JOptionPane.showInputDialog(
                "Please Enter a Seat Number"));
        seatToSearch = event[rowNum][seatNum];
        if (seatToSearch == 1)
            JOptionPane.showMessageDialog(null, "The Seat at Row " + rowNum + 
                    " and Seat " + seatNum + " is already sold.\n"
                    + "It Costed : " + prices[rowNum][seatNum]);
        
        if (seatToSearch == 0){
            JOptionPane.showMessageDialog(null, "The Seat at Row " + rowNum + 
                    " and Seat " + seatNum + " is not yet sold.\n"
                    + "It Costs : " + prices[rowNum][seatNum]);
            if (JOptionPane.showConfirmDialog(null, "Would you like to buy it?") == 0)
                event[rowNum][seatNum] = 1;
        }
        
         return event;
    }
    
    public static int [][] refundSeat(int [][] event, double [][] prices){
        int rowNum, seatNum, seatToSearch;
        rowNum = Integer.parseInt(JOptionPane.showInputDialog(
                "Please Enter a Row Number"));
        seatNum = Integer.parseInt(JOptionPane.showInputDialog(
                "Please Enter a Seat Number"));
        seatToSearch = event[rowNum][seatNum];
        if (seatToSearch == 1){
            JOptionPane.showMessageDialog(null, "The Seat at Row " + rowNum +
                    " and Seat " + seatNum + " is already sold.\n"
                + "It Costed : " + prices[rowNum][seatNum]);
             if (JOptionPane.showConfirmDialog(null, "Would you like to refund it?") == 0)
                event[rowNum][seatNum] = 0;
        }
        if (seatToSearch == 0)
            JOptionPane.showMessageDialog(null, "The Seat at Row " + rowNum + 
                    " and Seat " + seatNum + " is not yet sold.\n"
                    + "It Costs : " + prices[rowNum][seatNum]);
           
        
        
         return event;
    }
}

