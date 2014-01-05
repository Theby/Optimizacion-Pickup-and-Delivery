/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labopti;

/**
 *
 * @author Luis
 */
public class LabOpti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyNodo A = new MyNodo("A");
        MyNodo B = new MyNodo("B");
        MyNodo C = new MyNodo("C");
        
        Grafo G = new Grafo();
        G.add(A, B, 10);
        G.add(B, C, 15);
        G.add(A, C, 20);
        G.add(A, B, 100);
        G.add(C, A);
        G.add(C, B);
        
        G.mostrar();
        
        
    }
}
