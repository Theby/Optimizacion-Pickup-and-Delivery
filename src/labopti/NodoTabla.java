/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labopti;

/**
 *
 * @author Luis
 */
public class NodoTabla {
    int coordX;
    int coordY;

    NodoTabla(int x, int y){
        coordX = x;
        coordY = y;
    }
    
    public double distancia(NodoTabla Nodo){
        double distanciaX = this.coordX-Nodo.coordX;
        double distanciaY = this.coordY-Nodo.coordY;
        return Math.sqrt((distanciaX*distanciaX) + (distanciaY*distanciaY));
    }
}
