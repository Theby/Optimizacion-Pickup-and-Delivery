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
    private boolean disponible;
    private int posicion;    
    private int coordX;
    private int coordY;
    
    public MyNodo(){
            coordX = 0;
            coordY = 0;
            disponible = true;
    }
    
    public MyNodo(int x, int y){
            coordX = x;
            coordY = y;
            disponible = true;
    }

    public void setDisponible(boolean valor) {
            disponible = valor;
    }
    public void setPosicion(int pos){
            posicion = pos;
    }
    public void setCoord(int X, int Y){
            coordX = X;
            coordY = Y;
    }
    
    public boolean getDisponible(){
            return disponible;
    }
    public int getPosicion(){
            return posicion;
    }
    public int getCoordX(){
        return coordX;
    } 
    public int getCoordY(){
        return coordY;
    }
    
    @Override
    public void mostrar(){
            System.out.println("(Pos)[x,y]=("+posicion+")[" + coordX + ", " + coordY +"]");
        }
    
    public double distancia(MyNodo Nodo){
            double distanciaX = this.coordX-Nodo.coordX;
            double distanciaY = this.coordY-Nodo.coordY;
            return Math.sqrt((distanciaX*distanciaX) + (distanciaY*distanciaY));
        }
}
