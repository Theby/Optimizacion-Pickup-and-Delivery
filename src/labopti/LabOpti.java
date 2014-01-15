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
        ArrayList <Camion> Camiones; 
        try{
            MyReader myreader = new MyReader();
            G = myreader.AnalisarArchivo();
            LReq = myreader.LReq;
            Camiones = myreader.Vehiculos;
            
            //G.mostrarNodos();
            //G.mostrarTabla();
            
            SimulatedAnnealing.setRequerimientos(G, LReq, Camiones);
            SimulatedAnnealing.setRutas(G, Camiones);
            
            
            System.out.println("Comenzando heuristica");
            Camiones = SimulatedAnnealing.heuristica(G, Camiones);
            
            for(int i=0;i<Camiones.size();i++){
                Camiones.get(i).mostrarRequerimientos();
                Camiones.get(i).mostrarRutas();
            }
            
            System.out.println("FIN: "+SimulatedAnnealing.getResultadoFuncionObjetivo(Camiones));
            
        }
        catch(Exception e){
            System.out.println("EXCEPTION!!!!"+e);
        }

        
    }
}
