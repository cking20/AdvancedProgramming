/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import javax.swing.JOptionPane;

public class Swing {

   
    public static void main(String[] args) {
        //nothign wrong with abstract windowing tool kit, swing is 
        //just more uniform on every OS
        //
        String name = "Chris";
        
        name = JOptionPane.showInputDialog("Name:");
      
        JOptionPane.showMessageDialog(null, name + " is wow" );
        //terminates any proccesses that have to do with this program
        System.exit(0);
    }
    
}
