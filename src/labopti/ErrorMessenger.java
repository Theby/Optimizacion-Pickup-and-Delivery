package labopti;

import javax.swing.JOptionPane;

/**
 * Se encarga de manejar errores y mostrarlos usando JOptionPane
 * @author Luis y Esteban
 */
public abstract class ErrorMessenger {
    
    /**
     * Muestra los distintos errores que puede tener el programa usando JOptionPane
     * @param e número del error.
     */
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
