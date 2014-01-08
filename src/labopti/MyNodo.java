/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labopti;

/**
 *
 * @author Luis
 */
public class MyNodo extends Nodo{
    int coordX;
    int coordY;
    
    MyNodo(String nom){
        super(nom); //constructor de clase superior.
    }
    
    public void setCoord(int X, int Y){
        coordX = X;
        coordY = Y;
    }
    
}
