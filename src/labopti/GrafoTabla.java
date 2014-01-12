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
        ArrayList<MyNodo> ListaNodosDeCarga;
        ArrayList<MyNodo> ListaNodosDeDestino;
        double [][] matriz;
        int numero_nodos_totales;
        int numero_nodos_carga;
        int numero_nodos_destino;
        int numero_disponibles_totales;
        int numero_disponibles_carga;
        int numero_disponibles_destino;
    
    public
        GrafoTabla(){
            ListaNodos = new ArrayList();
            ListaNodosDeCarga = new ArrayList();
            ListaNodosDeDestino = new ArrayList();
            numero_nodos_totales = 0;
            numero_nodos_carga = 0;
            numero_nodos_destino = 0;
            numero_disponibles_totales = 0;
            numero_disponibles_carga = 0;
            numero_disponibles_destino = 0;
        }

        void addNodo(NodoTabla Nodo){
            ListaNodos.add(Nodo);
            numero_nodos_totales++;
            numero_disponibles_totales++;
        }

        void addNodoCarga(){
            ListaNodosDeCarga.add(Nodo);
            numero_nodos_carga++;
            numero_disponibles_carga++;
        }

        void addNodoDestino(){
            ListaNodosDeDestino.add(Nodo);
            numero_nodos_destino++;
            numero_disponibles_destino++;
        }

        void interconectar(){
            int n = ListaNodos.size();
            matriz = new double[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    matriz[i][j]=((MyNodo)ListaNodos.get(i)).distancia((MyNodo)ListaNodos.get(j));
                }
            }
        }
        
        ArrayList getArray(){
            return ListaNodos;
        }
        
        int ArraySize(){
            return ListaNodos.size();
        }
        
        void mostrarNodos(){
            int n = ListaNodos.size();
            for(int i =0; i<n; i++){
                System.out.print(i +": ");
                ListaNodos.get(i).mostrar();
            }
        }
        
        void mostrarTabla(){
            int n = ListaNodos.size();
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(matriz[i][j] + ", ");
                }
                System.out.println("");
            }
        }

        void setNumeroNodosTotales(int num){
            numero_nodos_totales = num;
        }

        int getNumeroNodosTotales(){
            return numero_nodos_totales;
        }

        void setNumeroDisponiblesTotales(int num){
            numero_disponibles_totales = num;
        }

        int getNumeroDisponiblesTotales(){
            return numero_disponibles_totales;
        }

        double [][] getMatriz(){
            return matriz;
        }

        double getDistancia(int nodo_1, int nodo_2){
            return matriz[nodo_1][nodo_2];
        }

        void setDisponibilidadNodo(int posicion){
            ListaNodos[posicion].setDisponible(false);
            setNumeroDisponibles(getNumeroDisponibles()-1);
        }

        /*
         * El nodo pasado como argumento representa el nodo base desde el que se calcularan las distancias, es decir
         * Por ejemplo: getMenorDistancia(1) retorna el nodo más cercano al nodo 1.
         */
        int getMenorDistanciaDisponible(int nodo){
            int num_nodos = getNumeroNodos();
            int minimo = matriz[nodo][nodo];
            int posicion = nodo;

            for(int i=0;i<num_nodos;i++){
                if(i!=nodo && ListaNodos[i].getDisponible()){
                    if(matriz[nodo][i]<minimo){
                        minimo = matriz[nodo][i];
                        posicion = i;
                    }
                }
            }

            return posicion;
        }
}
