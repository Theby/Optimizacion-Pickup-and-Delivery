package labopti;

/**
 * Es una extensión de la clase NodoTabla, implementa los datos especificos para el problema.
 * @author Luis y Esteban
 */
public class MyNodo extends NodoTabla{
    private boolean disponible;
    private int posicion;    
    private int coordX;
    private int coordY;
    
    /**
     * Inicializa los atributos.
     */
    public MyNodo(){
            coordX = 0;
            coordY = 0;
            disponible = true;
    }
    
    /**
     * Inicializa los atributos con los parametros ingresados.
     * @param x coordenada X del nodo.
     * @param y coordenada Y del nodo.
     */
    public MyNodo(int x, int y){
            coordX = x;
            coordY = y;
            disponible = true;
    }

    /**
     * Setea la disponibilidad segun el booleano entregado.
     * @param valor boolean para la disponibilidad.
     */
    public void setDisponible(boolean valor) {
            disponible = valor;
    }
    
    /**
     * Setea la posición del nodo.
     * @param pos posición.
     */
    public void setPosicion(int pos){
            posicion = pos;
    }
    
    /**
     * Setea las coordenadas del nodo
     * @param X coordenada X.
     * @param Y coordenada Y.
     */
    public void setCoord(int X, int Y){
            coordX = X;
            coordY = Y;
    }
    
    /**
     * Obtiene la disponibilidad del nodo.
     * @return true si está disponible, false en caso contrario.
     */
    public boolean getDisponible(){
            return disponible;
    }
    
    /**
     * Obtiene posición del nodo.
     * @return posición
     */
    public int getPosicion(){
            return posicion;
    }
    
    /**
     * Obtiene la coordenada X del nodo.
     * @return Coordenada X.
     */
    public int getCoordX(){
        return coordX;
    } 
    
    /**
     * Obtiene coordenada Y del nodo.
     * @return Coordenada Y.
     */
    public int getCoordY(){
        return coordY;
    }
    
    /**
     * Sobreescribe el método de mostrar el nodo, para realizarlo con otro formato.
     */
    @Override
    public void mostrar(){
            System.out.println("(Pos)[x,y]=("+posicion+")[" + coordX + ", " + coordY +"]");
        }
    /**
     * Calcula la distancia desde el nodo actual hasta el nodo ingresado como parametro.
     * La distncia se calcula mediante el teorema de pitagoras.
     * @param Nodo Nodo con el cual calcular distancia.
     * @return distancia al otro nodo.
     */
    public double distancia(MyNodo Nodo){
            double distanciaX = this.coordX-Nodo.coordX;
            double distanciaY = this.coordY-Nodo.coordY;
            return Math.sqrt((distanciaX*distanciaX) + (distanciaY*distanciaY));
        }
}
