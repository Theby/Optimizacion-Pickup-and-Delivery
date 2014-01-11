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
    int coordX;
    int coordY;
    
    MyNodo(int x, int y){
        coordX = x;
        coordY = y;
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
}
