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
        int numero_nodos;

    GrafoTabla(){
        ListaNodos = new ArrayList();
        numero_nodos=0;
    }
    
    public void addNodo(NodoTabla Nodo){
        ListaNodos.add(Nodo);
        numero_nodos++;
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

    public
        int getNumeroNodos(){
            return numero_nodos;
        }

        double [][] getMatriz(){
            return matriz;
        }

        double getDistancia(int nodo_1, int nodo_2){
            return matriz[nodo_1][nodo_2];
        }

        /*
         * El nodo pasado como argumento representa el nodo base desde el que se calcularan las distancias, es decir
         * Por ejemplo: getMenorDistancia(1) retorna el nodo más cercano al nodo 1.
         */
        int getMenorDistancia(int nodo){
            int num_nodos = getNumeroNodos();
            int minimo = matriz[nodo][nodo];
            int posicion = nodo;

            for(int i=0;i<num_nodos;i++){
                if(i!=nodo){
                    if(matriz[nodo][i]<minimo){
                        minimo = matriz[nodo][i];
                        posicion = i;
                    }
                }
            }

            return posicion;
        }
}
