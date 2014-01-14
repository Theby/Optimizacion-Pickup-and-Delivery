/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labopti;

import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public abstract class ErrorMessenger {
    static void ShowError(int e){
        switch(e){
            case 0://Archivo de entrada con errores.
                String message = "ERROR: Archivo de entrada con errores.";
                System.out.println(message);
                JOptionPane.showMessageDialog(null, message, "ERROR!", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                break;
            case 1:
                break;
            default:
                break;
        }    
    }
}
