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
    
    MyNodo(int x, int y){
        coordX = x;
        coordY = y;
        disponible = true;
    }
    
    public void mostrar(){
        System.out.println("[x,y]=[" + coordX + ", " + coordY +"]");
    }
    
    public void setCoord(int X, int Y){
        coordX = X;
        coordY = Y;
    }
    public double distancia(MyNodo Nodo){
        double distanciaX = this.coordX-Nodo.coordX;
        double distanciaY = this.coordY-Nodo.coordY;
        return Math.sqrt((distanciaX*distanciaX) + (distanciaY*distanciaY));
    }

    public
        void setDisponible(bool valor) {
            disponible = valor;
        }
        bool getDisponible(){
            return disponible;
        }
}
