/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labopti;

/**
 *
 * @author Luis
 */
public class Requerimiento {
    MyNodo NodoInicial;
    MyNodo NodoDestino;
    int tiempoInicialCarga;
    int tiempoFinalCarga;
    int tiempoInicialEntrega;
    int tiempoFinalEntrega;
    
    
    Requerimiento(int ic, int ice, int tic, int tfc, int tie, int tfe){
        NodoInicial = ic;
        NodoDestino = ice;
        tiempoInicialCarga = tic;
        tiempoFinalCarga = tfc;
        tiempoInicialEntrega = tie;
        tiempoFinalEntrega = tfe;
    }
}
