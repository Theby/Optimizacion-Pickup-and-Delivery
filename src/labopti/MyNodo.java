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
        super(x,y); //constructor de clase superior.
    }
    
    public void setCoord(int X, int Y){
        coordX = X;
        coordY = Y;
    }
    
}
