/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingex;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.SMALL_ICON;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuEx extends JFrame{
    
    public MenuEx(){
        
        initUI();
    }

    private void initUI() {

        createMenuBar();

        setTitle("Mnemonics and accelerators");
        setSize(360, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void createMenuBar() {
        
        JMenuBar menubar = new JMenuBar();
        
        ImageIcon iconNew = new ImageIcon("new.png");
        ImageIcon iconOpen = new ImageIcon("open.png");
        ImageIcon iconSave = new ImageIcon("save.png");
        ImageIcon iconExit = new ImageIcon("exit.png");
    //the menu goes into the menu bar
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem newMi = new JMenuItem(new MenuItemAction("New", iconNew, 
                KeyEvent.VK_N));

        JMenuItem openMi = new JMenuItem(new MenuItemAction("Open", iconOpen, 
                KeyEvent.VK_O));

        JMenuItem saveMi = new JMenuItem(new MenuItemAction("Save", iconSave, 
                KeyEvent.VK_S));

        JMenuItem exitMi = new JMenuItem("Exit", iconExit);
        exitMi.setMnemonic(KeyEvent.VK_E);
        exitMi.setToolTipText("Exit application");
        exitMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
            ActionEvent.CTRL_MASK));

        exitMi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        fileMenu.add(newMi);
        fileMenu.add(openMi);
        fileMenu.add(saveMi);
        fileMenu.addSeparator();
        fileMenu.add(exitMi);

        menubar.add(fileMenu);

        setJMenuBar(menubar);        
    }
    
    private class MenuItemAction extends AbstractAction {
        
        public MenuItemAction(String text, ImageIcon icon, 
                Integer mnemonic) {
            super(text);
            
            putValue(SMALL_ICON, icon);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.out.println(e.getActionCommand());
        }
    }

    
}
