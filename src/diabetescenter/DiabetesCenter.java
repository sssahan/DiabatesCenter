/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diabetescenter;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.LoginWindow;

/**
 *
 * @author sachithra sahan
 */
public class DiabetesCenter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(DiabetesCenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoginWindow loginWindow=new LoginWindow();
        loginWindow.setLocationRelativeTo(null);
        loginWindow.setVisible(true);
    }
    
}
