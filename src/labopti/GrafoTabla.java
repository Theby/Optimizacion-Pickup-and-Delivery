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
public class GrafoTabla {
    ArrayList<NodoTabla> ListaNodos;
    double [][] matriz;    
    GrafoTabla(){
        ListaNodos = new ArrayList();
    }
    
    public void addNodo(NodoTabla Nodo){
        ListaNodos.add(Nodo);
    }
    public void interconectar(){
        int n = ListaNodos.size();
        matriz = new double[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j>n; j++){
                matriz[i][j]=ListaNodos.get(i).distancia(ListaNodos.get(j));
            }
        }
    }
}
