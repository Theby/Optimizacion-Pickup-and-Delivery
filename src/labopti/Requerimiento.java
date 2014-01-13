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
    private MyNodo NodoInicial;
    private MyNodo NodoDestino;
    private int tiempoInicialCarga;
    private int tiempoFinalCarga;
    private int tiempoInicialEntrega;
    private int tiempoFinalEntrega;

    public Requerimiento(){
        NodoInicial = new MyNodo();
        NodoDestino = new MyNodo();
        tiempoInicialCarga = 0;
        tiempoFinalCarga = 0;
        tiempoInicialEntrega = 0;
        tiempoFinalEntrega = 0;
    }
    
    public Requerimiento(MyNodo ic, MyNodo ice, int tic, int tfc, int tie, int tfe){
        NodoInicial = ic;
        NodoDestino = ice;
        tiempoInicialCarga = tic;
        tiempoFinalCarga = tfc;
        tiempoInicialEntrega = tie;
        tiempoFinalEntrega = tfe;
    }

    public MyNodo getNodoInicial(){
        return NodoInicial;
    }

    public MyNodo getNodoDestino(){
        return NodoDestino;
    }


}
