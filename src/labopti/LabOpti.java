/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labopti;

import java.util.ArrayList;

/**
 *
 * @author Luis y Esteban Gaete
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
            //Lee el archivo
            MyReader myreader = new MyReader();
            G = myreader.AnalisarArchivo();
            LReq = myreader.LReq;
            Camiones = myreader.Vehiculos;
            
            //G.mostrarNodos();
            //G.mostrarTabla();
            
            //Realiza los ajustes para la heuristica
            SimulatedAnnealing.setRequerimientos(G, LReq, Camiones);
            SimulatedAnnealing.setRutas(G, Camiones);
            
            //Realiza la heurstiica
            //System.out.println("Comenzando heuristica");
            Camiones = SimulatedAnnealing.heuristica(G, Camiones);
            
            //Muestra los valores
            /*for(int i=0;i<Camiones.size();i++){
                Camiones.get(i).mostrarRequerimientos();
                Camiones.get(i).mostrarRutas();
            }
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Camiones = SimulatedAnnealing.getSolucionVecina(G, Camiones);
            */
            //Muestra los valores
            for(int i=0;i<Camiones.size();i++){
                Camiones.get(i).mostrarRequerimientos();
                Camiones.get(i).mostrarRutas();
            }
            
            //Muestra el resultado
            System.out.println("Resultado con Carga: "+SimulatedAnnealing.getResultadoFuncionObjetivoConCarga(Camiones));
            System.out.println("");
            System.out.println("Resultado sin Carga: "+SimulatedAnnealing.getResultadoFuncionObjetivoSinCarga(Camiones));
            
        }
        catch(Exception e){
            System.out.println("EXCEPTION!!!!"+e);
        }

        
    }
}
