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
    private 
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
            for(int j=0; j<n; j++){
                matriz[i][j]=((MyNodo)ListaNodos.get(i)).distancia((MyNodo)ListaNodos.get(j));
            }
        }
    }
    
    public ArrayList getArray(){
        return ListaNodos;
    }
    
    public int ArraySize(){
        return ListaNodos.size();
    }
    
    public void mostrarNodos(){
        int n = ListaNodos.size();
        for(int i =0; i<n; i++){
            System.out.print(i +": ");
            ListaNodos.get(i).mostrar();
        }
    }
    
    public void mostrarTabla(){
        int n = ListaNodos.size();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(matriz[i][j] + ", ");
            }
            System.out.println("");
        }
    }
}
