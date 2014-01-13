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
   
    /*
     * Constructores, metodos funcionales y practicos
     */ 
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

        void interconectar(){
            int n = ListaNodos.size();
            matriz = new double[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    matriz[i][j]=((MyNodo)ListaNodos.get(i)).distancia((MyNodo)ListaNodos.get(j));
                }
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

        /*
         * El nodo pasado como argumento representa el nodo base desde el que se calcularan las distancias, es decir
         * Por ejemplo: getMenorDistancia(1) retorna el nodo más cercano al nodo 1.
         */
        int getMenorDistanciaTotalDisponible(int nodo){
            int num_nodos = getNumeroNodos();
            int minimo = matriz[nodo][nodo];
            int posicion = nodo;

            for(int i=0;i<num_nodos;i++){
                if(i!=nodo && ListaNodos[i].getDisponible()){
                    if(getDistancia(nodo,i)<minimo){
                        minimo = getDistancia(nodo,i);
                        posicion = i;
                    }
                }
            }

            return posicion;
        }

        int getMenorDistanciaCargaDisponible(int nodo){
            int num_nodos = getNumeroNodos();
            int minimo = matriz[nodo][nodo];
            int posicion = nodo;

            for(int i=0;i<num_nodos;i++){
                if(i!=nodo && ListaNodosDeCarga[i].getDisponible()){
                    if(getDistancia(nodo,i)<minimo){
                        minimo = getDistancia(nodo,i);
                        posicion = i;
                    }
                }
            }

            return posicion;
        }

        int getMenorDistanciaCargaDisponible(int nodo){
            int num_nodos = getNumeroNodos();
            int minimo = matriz[nodo][nodo];
            int posicion = nodo;

            for(int i=0;i<num_nodos;i++){
                if(i!=nodo && ListaNodosDeDestino[i].getDisponible()){
                    if(getDistancia(nodo,i)<minimo){
                        minimo = getDistancia(nodo,i);
                        posicion = i;
                    }
                }
            }

            return posicion;
        }

    /*
     * Sobre ListaNodo y numero_nodos_totales
     */
    public
        void addNodo(NodoTabla Nodo){
            ListaNodos.add(Nodo);
            numero_nodos_totales++;
            numero_disponibles_totales++;
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

        void setDisponibilidadNodo(int posicion){
            ListaNodos[posicion].setDisponible(false);
            setNumeroDisponiblesTotales(getNumeroDisponiblesTotales()-1);
            //faltan los otros dos
            if(ListaNodosDeCarga.contains(ListaNodos[posicion])){
                setDisponibilidadNodoCarga(ListaNodosDeCarga.indexOf(ListaNodos[i]));
            }

            if(ListaNodosDeDestino.contains(ListaNodos[posicion])){
                setDisponibilidadNodoDestino(ListaNodosDeCarga.indexOf(ListaNodos[i]));
            }
        }

        bool getDisponibilidadNodo(int posicion){
            return ListaNodos[posicion].getDisponible();
        }

    /*
     * Sobre ListaNodosDeCarga y numero_nodos_carga
     */
    public
        void addNodoCarga(){
            ListaNodosDeCarga.add(Nodo);
            numero_nodos_carga++;
            numero_disponibles_carga++;
        }

        ArrayList getArrayCarga(){
            return ListaNodosDeCarga;
        }

        void setNumeroNodosCarga(int num){
            numero_nodos_carga = num;
        }

        int getNumeroNodosCarga(){
            return numero_nodos_carga;
        }

        void setNumeroDisponiblesCarga(int num){
            numero_disponibles_carga = num;
        }

        int getNumeroDisponiblesCarga(){
            return numero_disponibles_carga;
        }

        void setDisponibilidadNodoCarga(int posicion){
            ListaNodosDeCarga[posicion].setDisponible(false);
            setNumeroDisponiblesCarga(getNumeroDisponiblesCarga()-1);
        }

    /*
     * Sobre ListaNodosDeDestino y numero_nodos_destino
     */
    public
        void addNodoDestino(){
            ListaNodosDeDestino.add(Nodo);
            numero_nodos_destino++;
            numero_disponibles_destino++;
        }

        ArrayList getArrayDestino(){
            return ListaNodosDeDestino;
        }

        void setNumeroNodosDestino(int num){
            numero_nodos_destino = num;
        }

        int getNumeroNodosDestino(){
            return numero_nodos_destino;
        }

        void setNumeroDisponiblesDestino(int num){
            numero_disponibles_destino = num;
        }

        int getNumeroDisponiblesDestino(){
            return numero_disponibles_destino;
        }

        void setDisponibilidadNodoDestino(int posicion){
            ListaNodosDeDestino[posicion].setDisponible(false);
            setNumeroDisponiblesDestino(getNumeroDisponiblesDestino()-1);
        }
        
    /*
     * Sobre la matriz de distancia
     */
    public
        double [][] getMatriz(){
            return matriz;
        }

        void setDistancia(int nodo_1, int nodo_2, int distancia){
            matriz[nodo_1][nodo_2] = distancia;
            matriz[nodo_2][nodo_1] = distancia;
        }

        double getDistancia(int nodo_1, int nodo_2){
            return matriz[nodo_1][nodo_2];
        }
}
