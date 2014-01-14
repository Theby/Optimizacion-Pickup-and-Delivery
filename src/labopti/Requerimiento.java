package labopti;

/**
 * Representa los requerimientos del PDP (Pick and Delivery Problem)
 * @author Luis y Esteban
 */
public class Requerimiento {
    private MyNodo NodoInicial;
    private MyNodo NodoDestino;
    private int tiempoInicialCarga;
    private int tiempoFinalCarga;
    private int tiempoInicialEntrega;
    private int tiempoFinalEntrega;
    
    /**
     * Inicializa los atributos con valores nulos y ceros.
     */
    public Requerimiento(){
        NodoInicial = new MyNodo();
        NodoDestino = new MyNodo();
        tiempoInicialCarga = 0;
        tiempoFinalCarga = 0;
        tiempoInicialEntrega = 0;
        tiempoFinalEntrega = 0;
    }
    
    /**
     * Inicializa los atributos según los parametros indicados.
     * @param ni Nodo inicial.
     * @param nd Nodo destino.
     * @param tic Tiempo inicial de carga.
     * @param tfc Tiempo final de carga.
     * @param tie Tiempo inicial de entrega.
     * @param tfe Tiempo final de entrega.
     */
    public Requerimiento(MyNodo ni, MyNodo nd, int tic, int tfc, int tie, int tfe){
        NodoInicial = ni;
        NodoDestino = nd;
        tiempoInicialCarga = tic;
        tiempoFinalCarga = tfc;
        tiempoInicialEntrega = tie;
        tiempoFinalEntrega = tfe;
    }

    /**
     * Obtiene el nodo inicial del requerimiento.
     * @return Nodo Inicial.
     */
    public MyNodo getNodoInicial(){
        return NodoInicial;
    }
    
    /**
     * Obtiene el nodo de destino del requerimiento.
     * @return Nodo Destino.
     */
    public MyNodo getNodoDestino(){
        return NodoDestino;
    }

}
