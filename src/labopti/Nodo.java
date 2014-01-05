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
public abstract class Nodo {
    private ArrayList <Nodo> LSgte; //lista de grafos a los que apunta este nodo.
    private ArrayList <Integer> LCosto; //lista de costos asociados a cada transición.
    public String nombre;
    
    
    Nodo(String nom){
        LSgte = new ArrayList();
        LCosto = new ArrayList();
        nombre=nom;
    }
    
    
    public void addTransicion(Nodo A, int C){
        LSgte.add(A);
        LCosto.add(C);
    }
    
    public ArrayList get_transitions(){
        return LSgte;
    }
    
    public ArrayList get_costo(){
        return LCosto;
    }
   
    

    public void mostrar(){
        System.out.println("NODO:" + nombre);
        int n = this.LSgte.size();
        for(int i=0; i<n; i++){
            System.out.println("    ["+ nombre + " --> " + LSgte.get(i).nombre + "] Costo:" + LCosto.get(i));
        }
    }
}
