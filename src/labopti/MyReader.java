/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labopti;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class MyReader extends Reader{
    int numVehiculos;
    int numNodos;
    
    ArrayList<Requerimiento> LReq;
    
    MyReader(String path) throws Exception{
        super(path);
    }
    
    MyReader() throws Exception{
        super();
    }
    
    public GrafoTabla AnalisarArchivo(){
        GrafoTabla Grafo = new GrafoTabla();
        ArrayList<Requerimiento> LReqAux = new ArrayList();
        String Line = this.readLine();
        String[] auxS = Line.split(" ");
        numVehiculos = Integer.parseInt(auxS[0]);
        numNodos = Integer.parseInt(auxS[1]);
        while(this.HasNextLine()){//Nodo 0 = nodo central.
            Line = this.readLine();
            auxS = Line.split(" ");
            if(auxS.length == 2){//Caso de linea con 2 valores.
                MyNodo auxNodo = new MyNodo(Integer.parseInt(auxS[0]), Integer.parseInt(auxS[1])); //crear nodo.
                Grafo.addNodo(auxNodo); //agregar nodo.
            }
            else{
                if(auxS.length == 6){//caso de linea con 6 valores.
                    //obtener valores
                    int a = Integer.parseInt(auxS[0]);
                    int b = Integer.parseInt(auxS[1]);
                    int c = Integer.parseInt(auxS[2]);
                    int d = Integer.parseInt(auxS[3]);
                    int e = Integer.parseInt(auxS[4]);
                    int f = Integer.parseInt(auxS[5]);
                    Requerimiento auxC = new Requerimiento(Grafo.getArray().get(a),Grafo.getArray().get(b),c,d,e,f);//crear cliente
                    LReqAux.add(auxC);//agregar cliente.
                    Grafo.addNodoCarga(Grafo.getArray().get(a));
                    Grafo.addNodoDestino(Grafo.getArray().get(b));
                }
                else{
                    ErrorMessenger.ShowError(0);
                }
            }
        }
        Grafo.interconectar();
        this.LReq=LReqAux;
        return Grafo;
    }
}
