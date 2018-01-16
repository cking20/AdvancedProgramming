/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingex;
import javax.swing.JFrame;
import java.awt.EventQueue;
/**
 *
 * @author Christopher
 */
public class basicWindow extends JFrame{
    
    public basicWindow(){
        initUI();
        
    }
    
    private void initUI(){
        setTitle("ITS A TITLE");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
   
    
}
