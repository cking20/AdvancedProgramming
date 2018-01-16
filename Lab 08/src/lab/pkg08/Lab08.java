
package lab.pkg08;
import java.util.Scanner;
import java.io.*;

/**
 * @author Christopher King
 * This program utilizes parallel sub arrays to hold all the data while the 
 * running. Its intended use is by a body Shop clerk who orders and sells parts
 * Users can add, delete,search, or display parts in the list.
 */
public class Lab08 {

    public final static int SIZE = 70;
    public static void main(String[] args) throws IOException{
        int numParts;
        int [] partIDList, partQuantList;
        String [] partDescList, partLocList;
        double [] partCostList, partPriceList, partWeightList;
        numParts = 0;
        partIDList = new int[SIZE];
        partQuantList = new int[SIZE]; 
        partDescList = new String[SIZE];
        partLocList = new String[SIZE];
        partCostList = new double[SIZE]; 
        partPriceList = new double[SIZE]; 
        partWeightList = new double[SIZE];
        
        
        
        numParts = loadPartList(partIDList, partQuantList, 
                partDescList, partLocList, partCostList, partPriceList, 
                partWeightList);
        numParts = performEachTask(numParts, partIDList, partQuantList, 
                partDescList, partLocList, partCostList, partPriceList, 
                partWeightList);
        savePartList(numParts, partIDList, partQuantList, 
                partDescList, partLocList, partCostList, partPriceList, 
                partWeightList);
                
    }
    public static int loadPartList( int [] partIDList, 
            int [] partQuantList, String [] partDescList, String [] partLocList,
            double [] partCostList, double [] partPriceList, 
            double [] partWeightList) throws IOException{
        int numParts;
        Scanner partFileScanner;
        File partFile;
        partFile = new File("parts.txt");
        partFileScanner = new Scanner(partFile);
        
        numParts = 0;
        
        while(partFileScanner.hasNext() && numParts < partIDList.length){
            
            //assign each value to the appropriat array
            partIDList[numParts] = partFileScanner.nextInt();
            partFileScanner.nextLine();
            partDescList[numParts] = partFileScanner.nextLine();
            partCostList[numParts] = partFileScanner.nextDouble();
            partPriceList[numParts] = partFileScanner.nextDouble();
            partWeightList[numParts] = partFileScanner.nextDouble();
            partFileScanner.nextLine();
            partLocList[numParts] = partFileScanner.nextLine();
            partQuantList[numParts] = partFileScanner.nextInt();
            //incrament numParts
            numParts = numParts + 1;
            
        }
        
        
        partFileScanner.close();
        
        return numParts;
    }
    
    public static int savePartList(int numParts, int [] partIDList, 
            int [] partQuantList, String [] partDescList, String [] partLocList,
            double [] partCostList, double [] partPriceList, 
            double [] partWeightList) throws IOException{
        
        PrintWriter savePrintWriter;
     
        savePrintWriter = new PrintWriter("parts.txt"); 
        
        for (int cnt = 0; cnt < numParts ; cnt++){
            savePrintWriter.println(partIDList[cnt]);
            savePrintWriter.println(partDescList[cnt]);
            savePrintWriter.print(partCostList[cnt] + " ");
            savePrintWriter.print(partPriceList[cnt] + " ");
            savePrintWriter.println(partWeightList[cnt]);
            savePrintWriter.println(partLocList[cnt]);
            savePrintWriter.println(partQuantList[cnt]);
            
            
        } 
        savePrintWriter.close(); 
        return numParts;
    }
    
    public static int performEachTask(int numParts, int [] partIDList, 
            int [] partQuantList, String [] partDescList, String [] partLocList,
            double [] partCostList, double [] partPriceList, 
            double [] partWeightList) {
        int userChoice;
        
        do{
        userChoice = getUserChoice();
        numParts = performUserChoice(userChoice,numParts, partIDList, partQuantList,
                partDescList, partLocList, partCostList, partPriceList, 
                partWeightList);
        } while (userChoice != 7);
        return numParts;
    }
    
    public static int getUserChoice(){
        Scanner kbd;
        int userChoice;
        kbd = new Scanner(System.in);
        
        System.out.println("\n\nMenu");
        System.out.println("1: Look Up Part");
        System.out.println("2: Add New Part");
        System.out.println("3: Delete Part");
        System.out.println("4: Print Sales Slip");
        System.out.println("5: Receive A Shipment");
        System.out.println("6: Print Entire Inventory");
        System.out.println("7: Quit");
        System.out.print(">");
        userChoice = kbd.nextInt();
        
        
        return userChoice;
    }
   
    public static int performUserChoice(int userChoice, int numParts, int [] partIDList, 
            int [] partQuantList, String [] partDescList, String [] partLocList,
            double [] partCostList, double [] partPriceList, 
            double [] partWeightList){
        switch(userChoice){
            case 1:
                lookUpPart( numParts, partIDList,                        
                        partQuantList, partDescList, partLocList, partCostList, 
                        partPriceList, partWeightList);
                break;
            case 2:
                numParts = addNewPart(numParts, partIDList, 
                        partQuantList, partDescList, partLocList, partCostList, 
                        partPriceList, partWeightList);
                break;
            case 3:
                numParts = deletePart(numParts, partIDList, 
                        partQuantList, partDescList, partLocList, partCostList, 
                        partPriceList, partWeightList);
                break;
            case 4:
                printSalesSlip(numParts, partIDList, 
                        partQuantList, partDescList, partLocList, partCostList, 
                        partPriceList, partWeightList);
                break;
            case 5:
                recieveShipment(numParts, partIDList, 
                        partQuantList, partDescList, partLocList, partCostList, 
                        partPriceList, partWeightList);
                break;
            case 6:
                printEntireInvenory(numParts, partIDList, 
                        partQuantList, partDescList, partLocList, partCostList, 
                        partPriceList, partWeightList);
                break;
            case 7: // quit
                break;
            default:
                System.out.println("Invalid Number");
                break;
        }
            
        return numParts;
    }
    
    public static void lookUpPart(int numParts, int [] partIDList, 
            int [] partQuantList, String [] partDescList, String [] partLocList,
            double [] partCostList, double [] partPriceList, 
            double [] partWeightList){
        Scanner kbd;
        int idSearch;
        int cnt;
        //the values for the 
        int partID, partQuant;
        String partDesc, partLoc;
        double partCost, partPrice, partWeight;
        
        kbd = new Scanner(System.in);
        System.out.println("Search");
        System.out.print("Part ID:");
        idSearch = kbd.nextInt();
        
        cnt = 0;
        while(cnt < numParts && idSearch != partIDList[cnt]){
            cnt++;
        }
        if(cnt < numParts){
            partID = partIDList[cnt];
            partQuant = partQuantList[cnt];
            partDesc = partDescList[cnt];
            partLoc = partLocList[cnt];
            partCost = partCostList[cnt];
            partPrice = partPriceList[cnt];
            partWeight = partWeightList[cnt];
            System.out.printf("\nID: %10d\n", partID);
            System.out.println(partDesc);
            System.out.printf( "    Location: %10s\n", partLoc);
            System.out.printf( "    Stock on Hand: %10d\n", partQuant );
            System.out.printf( "    Price: %10f\n", partPrice);
            System.out.printf( "    Cost: %10f\n", partCost);
            System.out.printf( "    Weight: %10f\n", partWeight);
        } else{
            System.out.println("\n\nPart Not Found\n");
        }
        
    }
    
    public static int addNewPart(int numParts, int [] partIDList, 
            int [] partQuantList, String [] partDescList, String [] partLocList,
            double [] partCostList, double [] partPriceList, 
            double [] partWeightList){
        Scanner kbd = new Scanner(System.in);
        int  partID; 
        int  partQuant; 
        String  partDesc; 
        String  partLoc;
        double  partCost; 
        double  partPrice; 
        double  partWeight;
        
        //prevents against over loading
        if(numParts < partIDList.length){
            System.out.println("Add Part");
            System.out.print("ID: ");
            partID = kbd.nextInt();
            System.out.print("\nQuantity: ");
            partQuant = kbd.nextInt();
            kbd.nextLine();
            System.out.println("\nDescription: ");
            partDesc = kbd.nextLine();
            System.out.println("\nLocation: ");
            partLoc = kbd.nextLine();
            System.out.println("\nCost: ");
            partCost = kbd.nextDouble();
            System.out.println("\nPrice: ");
            partPrice = kbd.nextDouble();
            System.out.println("\nWeight: ");
            partWeight = kbd.nextDouble();


            partIDList[numParts] = partID;
            partQuantList[numParts] = partQuant;
            partDescList[numParts] = partDesc;
            partLocList[numParts] = partLoc;
            partCostList[numParts] = partCost;
            partPriceList[numParts] = partPrice;
            partWeightList[numParts] = partWeight;
            numParts++;
        } else {
            System.out.println("The inventory is full. ");
        }
        return numParts;
        
    }
    
    public static int deletePart(int numParts, int [] partIDList, 
            int [] partQuantList, String [] partDescList, String [] partLocList,
            double [] partCostList, double [] partPriceList, 
            double [] partWeightList){
        Scanner kbd;
        kbd = new Scanner(System.in);
        int deletedPartID;
        int cnt;
        
        //prompt for ID
        System.out.println("\nDelete");
        System.out.print("Deleted Item ID: ");
        deletedPartID = kbd.nextInt();
        //find the ID
        cnt = 0;
        while(cnt < numParts && deletedPartID != partIDList[cnt])
            cnt++;
        
        //remove the item
        if (cnt < numParts){
            //brings the last item up, so it "empty"
            partIDList[cnt] = partIDList[numParts - 1];
            partQuantList[cnt] = partQuantList[numParts - 1];
            partDescList[cnt] = partDescList[numParts - 1];
            partLocList[cnt] = partLocList[numParts - 1];
            partCostList[cnt] = partCostList[numParts - 1];
            partPriceList[cnt] = partPriceList[numParts - 1];
            partWeightList[cnt] = partWeightList[numParts - 1];
            //decrement num tools
            numParts--;
        } else {
            System.out.println("Part not Found");
        }
       
        return numParts;
    }
    
    public static void printSalesSlip(int numParts, int [] partIDList, 
            int [] partQuantList, String [] partDescList, String [] partLocList,
            double [] partCostList, double [] partPriceList, 
            double [] partWeightList){
        Scanner kbd;
        kbd = new Scanner(System.in);
        
        int quantSold;
        double salePrice;
        
        int idSearch;
        int cnt;
        
        System.out.println("Sale");
        System.out.print("Sold Item ID: ");
        idSearch = kbd.nextInt();
        
        cnt = 0;
        while(cnt < numParts && idSearch != partIDList[cnt]){
            cnt++;
        }
        if(cnt < numParts){
            //get quantity sold
            System.out.print("\nQuantity Sold: ");
            quantSold = kbd.nextInt();
            //calc total
            salePrice = quantSold * partPriceList[cnt];
            
            //display the sale slip
            System.out.println("\nSales Reciept");
            System.out.printf("Item Sold: %s\n", partDescList[cnt]);
            System.out.printf("Quantity Sold: %d\n", quantSold);
            System.out.printf("Total: %10.2f\n", salePrice);
            //subtract the sold items from the total items
            partQuantList[cnt] = partQuantList[cnt] - quantSold;
            
        } else{
            System.out.println("\n\nPart Not Found\n");
        }
        
    }
    
    public static void recieveShipment(int numParts, int [] partIDList, 
            int [] partQuantList, String [] partDescList, String [] partLocList,
            double [] partCostList, double [] partPriceList, 
            double [] partWeightList){
        Scanner kbd;
        kbd = new Scanner(System.in);
        
        int quantRec;
        double salePrice;
        
        int idSearch;
        int cnt;
        
        System.out.println("Recieving");
        System.out.print("Item ID: ");
        idSearch = kbd.nextInt();
        
        cnt = 0;
        while(cnt < numParts && idSearch != partIDList[cnt]){
            cnt++;
        }
        if(cnt < numParts){
            //get quantity sold
            System.out.print("\nQuantity Recieved: ");
            quantRec = kbd.nextInt();
            //calc total
            salePrice = quantRec * partCostList[cnt];
            
            //display the sale slip
            System.out.println("\nInvoice");
            System.out.printf("Item Recieved: %s\n", partDescList[cnt]);
            System.out.printf("Quantity Recieved: %d\n", quantRec);
            System.out.printf("Total: %10.2f\n", salePrice);
            //subtract the sold items from the total items
            partQuantList[cnt] = partQuantList[cnt] + quantRec;
            
        } else{
            System.out.println("\n\nPart Not Found\n");
        }
        
    }
    
    public static void printEntireInvenory(int numParts, int [] partIDList, 
            int [] partQuantList, String [] partDescList, String [] partLocList,
            double [] partCostList, double [] partPriceList, 
            double [] partWeightList){
        Scanner kbd;
        int cnt;
        int partID, partQuant;
        String partDesc, partLoc;
        double partCost, partPrice, partWeight;
        
       
        cnt = 0;
        while(cnt < numParts){
            partID = partIDList[cnt];
            partQuant = partQuantList[cnt];
            partDesc = partDescList[cnt];
            partLoc = partLocList[cnt];
            partCost = partCostList[cnt];
            partPrice = partPriceList[cnt];
            partWeight = partWeightList[cnt];
            System.out.printf("\nID: %10d\n", partID);
            System.out.println(partDesc);
            System.out.printf( "    Location: %10s\n", partLoc);
            System.out.printf( "    Stock on Hand: %10d\n", partQuant );
            System.out.printf( "    Price: %10f\n", partPrice);
            System.out.printf( "    Cost: %10f\n", partCost);
            System.out.printf( "    Weight: %10f\n", partWeight);
            cnt++;
        }
        
            
    }
}
