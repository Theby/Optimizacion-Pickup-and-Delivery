/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labopti;

import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class LabOpti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GrafoTabla G = null;
        ArrayList <Requerimiento> LReq;
        try{
            MyReader myreader = new MyReader();
            G = myreader.AnalisarArchivo();
            LReq = myreader.LReq;
            
            
            G.mostrarNodos();
            G.mostrarTabla();
        }
        catch(Exception e){
            System.out.println("EXCEPTION!!!!");
        }

        
    }
}
