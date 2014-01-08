/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labopti;

import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class MyReader extends Reader{
    int numClientes;
    int numVehiculos;
    int coordXInit;
    int coordYInit;
    
    ArrayList<Cliente> ListaCliente;
    
    MyReader(String path) throws Exception{
        super(path);
    }
    
    MyReader() throws Exception{
        super();
    }
    
    public GrafoTabla AnalisarArchivo(){
        GrafoTabla G = new GrafoTabla();
        ArrayList<Cliente> LCliente = new ArrayList();
        String Line = this.readLine();
        String[] auxS = Line.split(" ");
        numClientes = Integer.parseInt(auxS[0]);
        numVehiculos = Integer.parseInt(auxS[1]);
        Line = this.readLine();
        auxS = Line.split(" ");
        coordXInit = Integer.parseInt(auxS[0]);
        coordYInit = Integer.parseInt(auxS[1]);
        while(this.HasNextLine()){
            Line = this.readLine();
            auxS = Line.split(" ");
            if(auxS.length == 2){//Caso de linea con 2 valores.
                NodoTabla auxNodo = new NodoTabla(Integer.parseInt(auxS[0]), Integer.parseInt(auxS[1])); //crear nodo.
                G.addNodo(auxNodo); //agregar nodo.
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
                    Cliente auxC = new Cliente(a,b,c,d,e,f);//crear cliente
                    LCliente.add(auxC);//agregar cliente.
                }
            }
        }
        G.interconectar();
        this.ListaCliente = LCliente; 
        return G;
    }
}
