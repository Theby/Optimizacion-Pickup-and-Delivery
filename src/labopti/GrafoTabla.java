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
        private ArrayList<MyNodo> ListaNodos;
        private ArrayList<MyNodo> ListaNodosDeCarga;
        private ArrayList<MyNodo> ListaNodosDeDestino;
        private double [][] matriz;
        private int numero_nodos_totales;
        private int numero_nodos_carga;
        private int numero_nodos_destino;
        private int numero_disponibles_totales;
        private int numero_disponibles_carga;
        private int numero_disponibles_destino;
   
    /*
     * Constructores, metodos funcionales y practicos
     */ 
    public GrafoTabla(){
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

    public void interconectar(){
            int n = ListaNodos.size();
            matriz = new double[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    matriz[i][j]=((MyNodo)ListaNodos.get(i)).distancia((MyNodo)ListaNodos.get(j));
                }
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

    /*
     * El nodo pasado como argumento representa el nodo base desde el que se calcularan las distancias, es decir
     * Por ejemplo: getMenorDistancia(1) retorna el nodo más cercano al nodo 1.
     */
    public int getMenorDistanciaTotalDisponible(int nodo){
            int num_nodos = getNumeroNodosTotales();
            double minimo = getDistancia(nodo,nodo);
            int posicion = nodo;

            for(int i=0;i<num_nodos;i++){
                if(i!=nodo && ListaNodos.get(i).getDisponible()){
                    if(getDistancia(nodo,i)<minimo){
                        minimo = getDistancia(nodo,i);
                        posicion = i;
                    }
                }
            }

            return posicion;
        }

    public int getMenorDistanciaCargaDisponible(int nodo){
            int num_nodos = getNumeroNodosTotales();
            double minimo = getDistancia(nodo,nodo);
            int posicion = nodo;

            for(int i=0;i<num_nodos;i++){
                if(i!=nodo && ListaNodosDeCarga.get(i).getDisponible()){
                    if(getDistancia(nodo,i)<minimo){
                        minimo = getDistancia(nodo,i);
                        posicion = i;
                    }
                }
            }

            return posicion;
        }

    public int getMenorDistanciaDestinoDisponible(int nodo){
            int num_nodos = getNumeroNodosTotales();
            double minimo = getDistancia(nodo,nodo);
            int posicion = nodo;

            for(int i=0;i<num_nodos;i++){
                if(i!=nodo && ListaNodosDeDestino.get(i).getDisponible()){
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
    public void addNodo(MyNodo Nodo){
            ListaNodos.add(Nodo);
            numero_nodos_totales++;
            numero_disponibles_totales++;
        }

    public ArrayList<MyNodo> getArray(){
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

    public void setNumeroNodosTotales(int num){
            numero_nodos_totales = num;
        }

    public int getNumeroNodosTotales(){
            return numero_nodos_totales;
        }

    public void setNumeroDisponiblesTotales(int num){
            numero_disponibles_totales = num;
        }

    public int getNumeroDisponiblesTotales(){
            return numero_disponibles_totales;
        }

    public void setDisponibilidadNodo(int posicion){
            ListaNodos.get(posicion).setDisponible(false);
            setNumeroDisponiblesTotales(getNumeroDisponiblesTotales()-1);
            //faltan los otros dos
            if(ListaNodosDeCarga.contains(ListaNodos.get(posicion))){
                setDisponibilidadNodoCarga(ListaNodos.get(posicion).getPosicion());
            }

            if(ListaNodosDeDestino.contains(ListaNodos.get(posicion))){
                setDisponibilidadNodoDestino(ListaNodos.get(posicion).getPosicion());
            }
        }

    public boolean getDisponibilidadNodo(int posicion){
            return ListaNodos.get(posicion).getDisponible();
        }

    /*
     * Sobre ListaNodosDeCarga y numero_nodos_carga
     */
    public void addNodoCarga(MyNodo Nodo){
        ListaNodosDeCarga.add(Nodo);
        numero_nodos_carga++;
        numero_disponibles_carga++;
    }

    public ArrayList getArrayCarga(){
        return ListaNodosDeCarga;
    }

    public void setNumeroNodosCarga(int num){
        numero_nodos_carga = num;
    }

    public int getNumeroNodosCarga(){
        return numero_nodos_carga;
    }

    public void setNumeroDisponiblesCarga(int num){
        numero_disponibles_carga = num;
    }

    public int getNumeroDisponiblesCarga(){
        return numero_disponibles_carga;
    }

    public void setDisponibilidadNodoCarga(int posicion){
        ListaNodosDeCarga.get(posicion).setDisponible(false);
        setNumeroDisponiblesCarga(getNumeroDisponiblesCarga()-1);
    }

    /*
     * Sobre ListaNodosDeDestino y numero_nodos_destino
     */
    
    public void addNodoDestino(MyNodo Nodo){
        ListaNodosDeDestino.add(Nodo);
        numero_nodos_destino++;
        numero_disponibles_destino++;
    }

    public ArrayList getArrayDestino(){
        return ListaNodosDeDestino;
    }

    public void setNumeroNodosDestino(int num){
        numero_nodos_destino = num;
    }

    public int getNumeroNodosDestino(){
        return numero_nodos_destino;
    }

    public void setNumeroDisponiblesDestino(int num){
        numero_disponibles_destino = num;
    }

    public int getNumeroDisponiblesDestino(){
        return numero_disponibles_destino;
    }

    public void setDisponibilidadNodoDestino(int posicion){
        ListaNodosDeDestino.get(posicion).setDisponible(false);
        setNumeroDisponiblesDestino(getNumeroDisponiblesDestino()-1);
    }
        
    /*
     * Sobre la matriz de distancia
     */
    
    public double [][] getMatriz(){
        return matriz;
    }

    public void setDistancia(int nodo_1, int nodo_2, int distancia){
        matriz[nodo_1][nodo_2] = distancia;
        matriz[nodo_2][nodo_1] = distancia;
    }

    public double getDistancia(int nodo_1, int nodo_2){
        return matriz[nodo_1][nodo_2];
    }
}
