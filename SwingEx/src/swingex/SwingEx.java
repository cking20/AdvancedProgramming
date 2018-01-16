/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingex;
import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
/**
 *
 * @author Christopher
 */
public class SwingEx {

   
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                //just a window
                basicWindow ex = new basicWindow();
                ex.setVisible(true);
                //window with a button
                quitButtonEx quitEx = new quitButtonEx();
                quitEx.setVisible(true);
                
                //window with a menu
                MenuEx menu = new MenuEx();
                menu.setVisible(true);
            }
        });
    }
    
}
