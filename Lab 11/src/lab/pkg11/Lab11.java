
package lab.pkg11;

import java.io.*;
import java.util.Scanner;

/**Christopher King
 * Lab 11 due December 3rd
 *
 * This program is a Radio Receiver. It gets all the greatest channels that 
 * no one has ever heard of. You can even change your band! It comes standard 
 * with options to increase or decrease the bass, treble, volume, balance and
 * even fade! Buy now for the low low price of $999999.99 and receive the 
 * Receiver class that works with the main class! BUY NOW!
 * 
 */
public class Lab11 {

    
    public static void main(String[] args) throws IOException {
        char userChoice;
        Receiver aReceiver = new Receiver();
        
        System.out.println("Press any key to turn on radio");
        do{
            userChoice = GetUserChoice();
            PerformUserChoice(userChoice, aReceiver);
            aReceiver.Display();
        }   while (userChoice != 'Q'); 
        
        aReceiver.Save();
            
        
        
    }
     public static char GetUserChoice(){
         Scanner kbrd;
         String input;
         char choice;
         kbrd = new Scanner(System.in);
         
         input = kbrd.nextLine();
         try {
             choice = input.toUpperCase().charAt(0);
         } catch (Exception e) {
             choice = '.';
         }
         
         
         return choice;
     }
     
     public static void PerformUserChoice(char userChoice, Receiver aReceiver){
         Scanner kbrd= new Scanner(System.in);
         
         int presetChoice;
         switch(userChoice){
             case 'C':
                 aReceiver.ChangeBand();
                 break;
             case '+':
                 aReceiver.IncrementFrequency();
                 break;
             case '-':
                 aReceiver.DecrementFrequency();
                 break;
             case 'S':
                 //prompt for number
                 System.out.println("Select Preset to Save to (1-5).");
                 //check to see if number is right
                 do{
                 presetChoice = kbrd.nextInt();
                 } while (presetChoice < 1 || presetChoice > 5);
                 //set the preset
                 presetChoice--;
                 aReceiver.SetPreset(presetChoice);
                 break;    
             case 'P':
                 //prompt for number
                 System.out.println("Select Preset to Tune in to (1-5).");
                 //check to see if number is right
                 do{
                 presetChoice = kbrd.nextInt();
                 } while (presetChoice < 1 || presetChoice > 5);
                 //set the preset
                 presetChoice--;
                 aReceiver.ChoosePreset(presetChoice);
                 break;
             case '<':
                 aReceiver.DecrementVolume();
                 break;
             case '>':
                 aReceiver.IncrementVolume();
                 break;
             case 'B':
                 aReceiver.DecrementBass();
                 break;    
             case 'N':
                 aReceiver.IncrementBass();
                 break;  
             case 'W':
                 aReceiver.IncrementBalance();
                 break;
             case 'E':
                 aReceiver.DecrementBalance();
                 break;
             case 'R':
                 aReceiver.IncrementFade();
                 break;
             case 'T':
                 aReceiver.DecrementFade();
                 break;
             case 'Y':
                 aReceiver.IncrementTreble();
                 break;
             case 'U':
                 aReceiver.DecrementTreble();
                 break;
             default:
                 break;
         }
     }
}
