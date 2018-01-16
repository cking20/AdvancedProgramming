/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingex;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
/**
 *
 * @author Christopher
 */
public class quitButtonEx extends JFrame{
    public quitButtonEx(){
        initUI();
    }
    
    private void initUI(){
        JButton quitButton = new JButton("QUIT");
        quitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //what the button actually does
                System.exit(0);
            }
        });
        //window Stuff
        setTitle("ITS A TITLE");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        createLayout(quitButton);
        //create a tool tip
        quitButton.setToolTipText("EXITS THE PROGRAM");
        
        //creates a keyboard short cut using Alt + Q
        quitButton.setMnemonic(KeyEvent.VK_Q);
        
        setTitle("ITS A TITLE");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    private void createLayout(JComponent... arg){
        
        Container pane = getContentPane();
        GroupLayout g1 = new GroupLayout(pane);
        pane.setLayout(g1);
        
        g1.setAutoCreateContainerGaps(true);
        
        g1.setHorizontalGroup(g1.createSequentialGroup()
                .addComponent(arg[0])
               
        );

        g1.setVerticalGroup(g1.createSequentialGroup()
                .addComponent(arg[0])
        );
        //changes the size of the window to fit out stuff
        pack();
    }
    
}
