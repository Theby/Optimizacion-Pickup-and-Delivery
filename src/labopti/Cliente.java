/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labopti;

/**
 *
 * @author Luis
 */
public class Cliente {
    int indiceCliente;
    int indiceClienteEntrega;
    int tiempoInicialCarga;
    int tiempoFinalCarga;
    int tiempoInicialEntrega;
    int tiempoFinalEntrega;
    
    
    Cliente(int ic, int ice, int tic, int tfc, int tie, int tfe){
        indiceCliente = ic;
        indiceClienteEntrega = ice;
        tiempoInicialCarga = tic;
        tiempoFinalCarga = tfc;
        tiempoInicialEntrega = tie;
        tiempoFinalEntrega = tfe;
    }
}
