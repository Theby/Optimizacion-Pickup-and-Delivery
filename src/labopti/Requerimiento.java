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
    private
        MyNodo NodoInicial;
        MyNodo NodoDestino;
        int tiempoInicialCarga;
        int tiempoFinalCarga;
        int tiempoInicialEntrega;
        int tiempoFinalEntrega;
    
    public
        Requerimiento(MyNodo ic, MyNodo ice, int tic, int tfc, int tie, int tfe){
            NodoInicial = ic;
            NodoDestino = ice;
            tiempoInicialCarga = tic;
            tiempoFinalCarga = tfc;
            tiempoInicialEntrega = tie;
            tiempoFinalEntrega = tfe;
        }

        MyNodo getNodoInicial(){
            return NodoInicial;
        }

        MyNodo getNodoDestino(){
            return NodoDestino;
        }


}
