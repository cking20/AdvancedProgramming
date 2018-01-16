/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicsex;
import javax.swing.JOptionPane;

/**
 *
 * @author Christopher
 */
public class GraphicsEx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int value;
        String temp;
        String name;
        temp = JOptionPane.showInputDialog("Int");
        name = JOptionPane.showInputDialog("Name");
        value = Integer.parseInt(temp);
        JOptionPane.showMessageDialog(null, value);
        //same thing
        //value = Integer.parseInt(JOptionPane.showInputDialog("Int"));
        // JOptionPane.showMessageDialog(null, value);
        if (value < 25)
            JOptionPane.showMessageDialog(null, "You have a low number bruh");
        if (value >= 25) {
            JOptionPane.showMessageDialog(null, "YOu have a \"HIIIIIhg\" number bru");
            JOptionPane.showMessageDialog(null, "But not too \n \thigh");
            
        }
        //(x > y?true : false)
        //
        if (name.equals("Chris")) {
                    JOptionPane.showMessageDialog(null, "Ball is life Chris");  
        }
         //(x > y?true : false) called a conditional
        
        
        if ("Christopher".equalsIgnoreCase(name)) { //IGNORES CASE BRUH
                    JOptionPane.showMessageDialog(null, "DAMN YOU FORMAL AF");  
        }
        if ("Christopher".toUpperCase().equals(name.toUpperCase())) { //IGNORES CASE BRUH
                    JOptionPane.showMessageDialog(null, "DAMN YOU FORMAL AF");  
        }
        String name1 = "Chris";
        //chars you could just use the <  or > as is
        if(name1.compareTo(name) > 0)//("Christopher" > name)
            System.out.println("Not the same");
        if(name1.toUpperCase().compareTo(name.toUpperCase()) == 0)
        

        System.exit(0);
    }
    
}
