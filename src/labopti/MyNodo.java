/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labopti;

/**
 *
 * @author Luis
 */
public class MyNodo extends NodoTabla{
    public
        int coordX;
        int coordY;
    private 
        bool disponible;
        int posicion;

    public
        MyNodo(int x, int y){
            coordX = x;
            coordY = y;
            disponible = true;
        }

        void setDisponible(bool valor) {
            disponible = valor;
        }

        bool getDisponible(){
            return disponible;
        }

        void mostrar(){
            System.out.println("[x,y]=[" + coordX + ", " + coordY +"]");
        }
        
        void setCoord(int X, int Y){
            coordX = X;
            coordY = Y;
        }
        double distancia(MyNodo Nodo){
            double distanciaX = this.coordX-Nodo.coordX;
            double distanciaY = this.coordY-Nodo.coordY;
            return Math.sqrt((distanciaX*distanciaX) + (distanciaY*distanciaY));
        }

        void setPosicion(int pos){
            posicion = pos;
        }

        void getPosicion(){
            return posicion;
        }
}
