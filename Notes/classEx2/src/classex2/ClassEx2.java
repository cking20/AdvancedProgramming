/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classex2;
import java.util.Scanner;

/**
 *
 * @author Christopher
 */
public class ClassEx2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        String name;
        double pIncome, pSpending;
        
        
        double a = 0;
        int b;
        
        b = (int)a; //(int) truncates
        b = (int)(a + .5);
        
       Scanner kbd = new Scanner(System.in);
       char[][] map;
       
       map = new char[][]{
           { '.', 'r', '.', 'c', 'c', 'c', '.', '.', '.', '.'},
           { '.', 'r', '.', '.', '.', '.', '.', '.', '.', '.'},
           { '.', 'r', '.', '.', '.', '.', '.', '.', '.', '.'},
           { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
           { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
           { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
        
       };
       
       boolean running = true;
       int width;
       int height; 
       
       while(running = true){
       width = 10;
       height= 10;
       
       
       for(int h = 0; h < height; h++){
           for(int w = 0; w < width; w++){
               
               System.out.print("(" + w + "," + h + ")");
           }
           
           System.out.println("");
           
       }
     
       }
      /* pIncome = 72.93;
       name = "Chirs";
       pSpending = 393.65;
       
       
        System.out.println("Name           Income      Spending");
       //chris        72.56           393.56
       System.out.format("%-10s%11s%14s    \n", "Name", "Income", "Spending"); 
       //can use the + to force the showiing of sign do - then + is want allignd
       System.out.format("%-10s%11.2f%14.2f    \n", name, pIncome, pSpending); 
        //%s is a string %f is all floating points - makes it left alligned
       // .2 sets precision of 2 
       */
       
               
    }
    
}
