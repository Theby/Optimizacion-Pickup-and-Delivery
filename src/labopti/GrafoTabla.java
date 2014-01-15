package labopti;

import java.util.ArrayList;

/**
 * Es un grafo que tiene distintas listas de nodos, y una matriz que representa la distancia entre cada uno de estos.
 * @author Luis y Esteban
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
   
     /// Constructores, métodos funcionales y practicos 
        
      /**
       * Constructor: instancia los atributos de la clase con valores nulos y ceros.
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

    /**
     * Usa la lista de nodos, que tiene largo n, para generar una matriz de n x n, que representa la distancia entre cada nodo. 
     */
    public void interconectar(){
            int n = this.ListaNodos.size();
            matriz = new double[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(i==j){
                        this.setDistancia(i, j, 0);
                    }else{
                        this.setDistancia(i, j, this.getArray().get(i).distancia(this.getArray().get(j)));
                    }                    
                }
            }
        }
    
    /**
     * Muestra por pantalla los valores de la tabla (Matriz) que representa las distnacias entre nodos.
     */
    public void mostrarTabla(){
            int n = ListaNodos.size();
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(matriz[i][j] + ", ");
                }
                System.out.println("");
            }
        }

    /**
     * El nodo pasado como argumento representa el nodo base desde el que se calcularan las distancias, es decir
     * Por ejemplo: getMenorDistancia(1) retorna el nodo más cercano al nodo 1.
     * @param nodo Nodo para el cual buscar la menor distancia.
     * @return menor distancia para ese nodo.
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
    
    /**
     * El nodo pasado como argumento representa el nodo base desde el que se calcularan las distancias, es decir
     * Por ejemplo: getMenorDistancia(1) retorna el nodo más cercano al nodo 1, siempre y cuando
     * este nodo sea de carga y este disponible
     * @param nodo Nodo para el cual buscar la menor distancia.
     * @return menor distancia para ese nodo.
     */
    public int getMenorDistanciaCargaDisponible(int nodo){
            double minimo = 100000;
            int posicion = nodo;
        
            for(int i=0;i<this.getNumeroNodosCarga();i++){
                if(i!=nodo && this.ListaNodosDeCarga.get(i).getDisponible()){
                    if(this.getDistancia(nodo,this.ListaNodosDeCarga.get(i).getPosicion())<minimo){
                        minimo = this.getDistancia(nodo,this.ListaNodosDeCarga.get(i).getPosicion());
                        posicion = this.ListaNodosDeCarga.get(i).getPosicion();
                    }
                }
            }

            return posicion;
        }

    /**
     * El nodo pasado como argumento representa el nodo base desde el que se calcularan las distancias, es decir
     * Por ejemplo: getMenorDistancia(1) retorna el nodo más cercano al nodo 1, siempre y cuando
     * este nodo sea de destino y este disponible
     * @param nodo Nodo para el cual buscar la menor distancia.
     * @return menor distancia para ese nodo.
     */
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

    /**
     * Agrega un nodo a ListaNodos.
     * @param Nodo Nodo a agregar.
     */
    public void addNodo(MyNodo Nodo){
            ListaNodos.add(Nodo);
            numero_nodos_totales++;
            numero_disponibles_totales++;
        }
    
    /**
     * retorna ListaNodos.
     * @return ListaNodos.
     */
    public ArrayList<MyNodo> getArray(){
            return ListaNodos;
        }
    
    /**
     * Retorna el tamaño de ListaNodos.
     * @return ListaNodos.size();
     */
    public int ArraySize(){
            return ListaNodos.size();
        }
    
    /**
     * Muestra todos los nodos de ListaNodos.
     */
    public void mostrarNodos(){
            int n = ListaNodos.size();
            for(int i =0; i<n; i++){
                System.out.print(i +": ");
                ListaNodos.get(i).mostrar();
            }
        }
    
    /**
     * Muestra todos los nodos de ListaNodosDeCarga.
     */
    public void MostrarListaNodosCarga(){
        int n = ListaNodosDeCarga.size();
        for(int i=0;i<n;i++){
            System.out.print(i+": ");
            ListaNodosDeCarga.get(i).mostrar();
        }
    }
    
    /**
     * Setea el número de nodos totales.
     * @param num número de nodos totales.
     */
    public void setNumeroNodosTotales(int num){
            numero_nodos_totales = num;
        }
    
    /**
     * Retorna número de nodos.
     * @return numero_nodos_totales.
     */
    public int getNumeroNodosTotales(){
            return numero_nodos_totales;
        }

    /**
     * Asigna el valor de nodos totales disponibles
     * @param num valor a asignar
     */
    public void setNumeroDisponiblesTotales(int num){
            numero_disponibles_totales = num;
    }
    
    /**
     * Obtiene el numero de nodos disponibles totales
     * @return numero de nodos
     */
    public int getNumeroDisponiblesTotales(){
            return numero_disponibles_totales;
        }

    /**
     * Asigna la disponibilidad del nodo dado a false y todos sus representantes
     * en cargador y destino
     * @param posicion posicion del nodo a asignar
     */
    public void setDisponibilidadNodo(int posicion){
            this.ListaNodos.get(posicion).setDisponible(false);
            this.setNumeroDisponiblesTotales(this.getNumeroDisponiblesTotales()-1);
            
            if(this.ListaNodosDeCarga.contains(this.ListaNodos.get(posicion))){
                this.setDisponibilidadNodoCarga(this.ListaNodosDeCarga.indexOf(this.ListaNodos.get(posicion)));
            }

            if(this.ListaNodosDeDestino.contains(this.ListaNodos.get(posicion))){
                this.setDisponibilidadNodoDestino(this.ListaNodosDeCarga.indexOf(this.ListaNodos.get(posicion)));
            }
        }

    /**
     * Obtiene la disponibilidad del nodo enunciado
     * @param posicion posicion del nodo
     * @return disponibilidad del nodo
     */
    public boolean getDisponibilidadNodo(int posicion){
            return ListaNodos.get(posicion).getDisponible();
        }

    /**
     * añade un nodo a la lista de cargador
     * @param Nodo nodo a asignar
     */
    public void addNodoCarga(MyNodo Nodo){
        ListaNodosDeCarga.add(Nodo);
        numero_nodos_carga++;
        numero_disponibles_carga++;
    }

    /**
     * obtiene la lista de nodos de carga
     * @return ArrayList
     */
    public ArrayList getArrayCarga(){
        return ListaNodosDeCarga;
    }

    /**
     * Asigna la cantidad de nodos de carga
     * @param num valor a asignar
     */
    public void setNumeroNodosCarga(int num){
        this.numero_nodos_carga = num;
    }

    /**
     * Obtiene la cantidad de nodos
     * @return valor
     */
    public int getNumeroNodosCarga(){
        return this.numero_nodos_carga;
    }

    /**
     * Asigna el numero de nodos cargador aun disponible
     * @param num valor
     */
    public void setNumeroDisponiblesCarga(int num){
        this.numero_disponibles_carga = num;
    }

    /**
     * Obtiene el numero de nodos de carga disponible
     * @return cantidad de nodos
     */
    public int getNumeroDisponiblesCarga(){
        return this.numero_disponibles_carga;
    }

    /**
     * Asigna la disponibilidad de los nodos de carga
     * @param posicion nodo a asignar
     */
    public void setDisponibilidadNodoCarga(int posicion){
        this.ListaNodosDeCarga.get(posicion).setDisponible(false);
        this.setNumeroDisponiblesCarga(this.getNumeroDisponiblesCarga()-1);
    }

    /*
     * Sobre ListaNodosDeDestino y numero_nodos_destino
     */
    
    /**
     * Añadir nodo de destino a la lista de nodos de destino
     * @param Nodo nodo a asignar
     */
    public void addNodoDestino(MyNodo Nodo){
        ListaNodosDeDestino.add(Nodo);
        numero_nodos_destino++;
        numero_disponibles_destino++;
    }

    /**
     * Obtiene el array con los nodos de destino
     * @return ArrayList
     */
    public ArrayList getArrayDestino(){
        return ListaNodosDeDestino;
    }

    /**
     * Asigna la cantidad de ndoos de destino
     * @param num valor
     */
    public void setNumeroNodosDestino(int num){
        numero_nodos_destino = num;
    }

    /**
     * Obtiene la cantidad de nodos de destino
     * @return valor
     */
    public int getNumeroNodosDestino(){
        return numero_nodos_destino;
    }

    /**
     * Asigna la cantidad de nodos de destino disponibles
     * @param num valor
     */
    public void setNumeroDisponiblesDestino(int num){
        numero_disponibles_destino = num;
    }

    /**
     * Obtiene la catidad de nodos de destino aun disponibles
     * @return valor
     */
    public int getNumeroDisponiblesDestino(){
        return numero_disponibles_destino;
    }

    /**
     * Asigna la disponibilidad del nodo de destino a false
     * @param posicion posicion del nodo a asignar
     */
    public void setDisponibilidadNodoDestino(int posicion){
        this.ListaNodosDeDestino.get(posicion).setDisponible(false);
        this.setNumeroDisponiblesDestino(this.getNumeroDisponiblesDestino()-1);
    }
        
    /**
     * Obtiene la matriz con todas las distancias e interconeccinoes de los nodos
     * @return double [][]
     */    
    public double [][] getMatriz(){
        return matriz;
    }

    /**
     * Asigna la distancia a la matriz en la posicion dada y e su homologo ya
     * que es una matriz diagonal
     * @param nodo_1 posicion 1
     * @param nodo_2 posicion 2
     * @param distancia distancia entre 1 y 2
     */
    public void setDistancia(int nodo_1, int nodo_2, double distancia){
        matriz[nodo_1][nodo_2] = distancia;
        matriz[nodo_2][nodo_1] = distancia;
    }

    /**
     * Obtiene la distancia entre 1 y 2
     * @param nodo_1 posicion 1
     * @param nodo_2 posicion 2
     * @return distancia
     */
    public double getDistancia(int nodo_1, int nodo_2){
        return this.matriz[nodo_1][nodo_2];
    }
}
