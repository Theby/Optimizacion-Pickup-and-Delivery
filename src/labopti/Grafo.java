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
public class Grafo {
    private ArrayList<Nodo> LNodos;

    Grafo(){
    LNodos = new ArrayList();
}
    
    /**
     * Agrega la transición entre el nodo A y el B, asumiendo un costo 0.
     * @param A Nodo donde comienza la transición.
     * @param B Nodo donde termina la transición.
     */
    void add(Nodo A, Nodo B){
        if(!this.has(A)){   //si el nodo A no está en la lista de nodos lo agrega.
            LNodos.add(A);
        }
        if(!this.has(B)){   //si el nodo B no está en la lista de nodos lo agrega.
            LNodos.add(B);
        }
        A.addTransicion(B, 0);
    }
    
     /**
     * Agrega la transición entre el nodo A y el B, asumiendo un costo 0.
     * @param A Nodo donde comienza la transición.
     * @param B Nodo donde termina la transición.
     * @param C costo de la transición.
     */
    void add(Nodo A, Nodo B, int costo){
        if(!this.has(A)){   //si el nodo A no está en la lista de nodos lo agrega.
            LNodos.add(A);
        }
        if(!this.has(B)){   //si el nodo B no está en la lista de nodos lo agrega.
            LNodos.add(B);
        }
        A.addTransicion(B, costo);
    }
    
    /**
     * Verifica si un nodo pertenece o no a un grafo
     * @param A Nodo a buscar
     * @return true si está el no, false en caso contrario.
     */
    public boolean has(Nodo A){ 
        int n = this.LNodos.size();
        for(int i=0; i<n; i++){
            if(LNodos.get(i).equals(A)){
                return true;
            }
        }
        return false;
    }


    public void mostrar(){
        int n = LNodos.size();
        for(int i=0; i<n; i++){
            LNodos.get(i).mostrar();
        }
    }

    public  ArrayList get_nodos(){
        return LNodos;
    }
}

