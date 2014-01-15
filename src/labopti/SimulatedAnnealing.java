/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labopti;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Luis y Esteban Gaete
 */


/**
 * Esta clase contiene metodos estaticos para las funcionalidades más importantes
 * de la metaheúristica
 * @author Esteban
 */
public class SimulatedAnnealing{
    
    /**
     * Asigna la lista de requerimientos a los camiones según que tan cercan
     * esten de un requerimiento, luego avanza al nodo destino de ese
     * requerimiento y vuelve a calcular cual requerimiento le queda más cerca
     * hasta que no hay mas requerimientos. Esto lo hace cada camion mediante Round Robin
     * @param Grafico Grafico que tiene todos los nodos y distancias entre ellos
     * @param ListaRequerimientos Todos los requerimientos del problema
     * @param Camiones Lista completa de camiones
     */
    public static void setRequerimientos(GrafoTabla Grafico, ArrayList <Requerimiento> ListaRequerimientos, ArrayList <Camion> Camiones){
        int nodo_carga_aux;
        int posicion;
        Requerimiento req_aux;

        while(Grafico.getNumeroDisponiblesCarga()>0){
            for(int i=0;i<Camiones.size();i++){
                //Obtiene el nodo de donde parte
                nodo_carga_aux = Camiones.get(i).getDestinoUltimoRequerimiento();

                //Busca un el punto de carga mas cercano al punto donde parte
                posicion = Grafico.getMenorDistanciaCargaDisponible(nodo_carga_aux);
                
                //Si la posicion es diferente significa que encontro un nuevo nodo
                if(posicion != nodo_carga_aux){
                    //Obtiene el requerimiento que tiene como cargador, o nodo inicial, el indicado en la posicion
                    req_aux = new Requerimiento();
                    for(int j=0;j<ListaRequerimientos.size();j++){                        
                        if(ListaRequerimientos.get(j).getNodoInicial().getPosicion()==posicion){
                                req_aux = ListaRequerimientos.get(j);
                                break;
                        }							
                    }

                    //Agrega el requerimiento encontrado a la lista de requerimientos del camiÃ³n
                    Camiones.get(i).setListaRequerimientos(req_aux);
                    
                    //Obtiene la distancia del nodo inicial al nodo destino del requerimiento
                    Camiones.get(i).setDistanciaRequerimientos(Grafico.getDistancia(req_aux.getNodoInicial().getPosicion(), req_aux.getNodoDestino().getPosicion()));

                    //Asigna la disponibilidad correspondiente al nodo de cargador encontrado
                    Grafico.setDisponibilidadNodo(posicion);           
                }				
            }
        }
    }

    /**
     * Crea las rutas para cada camion segun sus requerimientos
     * @param Grafico Grafico que tiene todos los nodos y distancias entre ellos
     * @param Camiones Lista completa de camiones
     */
    public static void setRutas(GrafoTabla Grafico, ArrayList <Camion> Camiones){
        int pos_nodo_aux = 0;
        
        //Por cada camión
        for(int i=0;i<Camiones.size();i++){
            //Por cada Requisito
            for(int j=0;j<Camiones.get(i).getListaRequerimientosSize();j++){
                Camiones.get(i).setDistanciaCargador(Grafico.getDistancia(pos_nodo_aux, Camiones.get(i).getListaRequerimientos().get(j).getNodoInicial().getPosicion()));
                pos_nodo_aux = Camiones.get(i).getListaRequerimientos(j).getNodoDestino().getPosicion();
            }
        }
    }

    /**
     * Crea las rutas para un camion segun sus requerimientos
     * @param Grafico Grafico que tiene todos los nodos y distancias entre ellos
     * @param camiones camion al que se le asignaran las rutas
     */
    public static void setRutas(GrafoTabla Grafico, Camion camiones){
        int pos_nodo_aux = 0;

        for(int j=0;j<camiones.getListaRequerimientosSize();j++){
            camiones.setDistanciaCargador(Grafico.getDistancia(pos_nodo_aux, camiones.getListaRequerimientos(j).getNodoInicial().getPosicion()));
            pos_nodo_aux = camiones.getListaRequerimientos(j).getNodoDestino().getPosicion();
        }
    }

    /**
     * Obtiene una solucion vecina a partir de la solucion actual
     * @param Grafico Grafico que tiene todos los nodos y distancias entre ellos
     * @param Camiones Lista completa de camiones
     * @return ArrayList<Camion> con la nueva solucion
     */
    public static ArrayList<Camion> getSolucionVecina(GrafoTabla Grafico,ArrayList<Camion> Camiones){
        ArrayList<Camion> CamionesVecinos = Camiones;
        Random random = new Random();    
        int camion_ran_1 = random.nextInt()%CamionesVecinos.size();
        int camion_ran_2 = random.nextInt()%CamionesVecinos.size();
        
        if(camion_ran_1<0)
            camion_ran_1 *= -1;
        
        if(camion_ran_2<0)
            camion_ran_2 *= -1;
        
        while(camion_ran_1==camion_ran_2){
            camion_ran_2 = random.nextInt()%CamionesVecinos.size();
        }
        
        if(camion_ran_2<0)
            camion_ran_2 *= -1;
        
        int prob = random.nextInt()%100;
        if(prob<0)
            prob *= -1;
       
        int size_1 = CamionesVecinos.get(camion_ran_1).getListaRequerimientosSize();
        int size_2 = CamionesVecinos.get(camion_ran_2).getListaRequerimientosSize();
        
        //Pasar un requerimiento a otro
        if(size_1 != size_2 || (prob<50 && size_1>1 && size_2>1)){
            //Para asegurarse que el camion_ran_1 es el que tiene mÃ¡s requerimientos
            if(CamionesVecinos.get(camion_ran_1).getListaRequerimientosSize()<CamionesVecinos.get(camion_ran_2).getListaRequerimientosSize()){
                int aux = camion_ran_1;
                camion_ran_1 = camion_ran_2;
                camion_ran_2 = aux;
            }
            //System.out.println("---------"+camion_ran_1+" con "+camion_ran_2+"-------------");
            //System.out.println("Pasandole uno");
            //Añade al 2 el requerimiento exedente del 1
            CamionesVecinos.get(camion_ran_2).setListaRequerimientos(CamionesVecinos.get(camion_ran_1).getListaRequerimientos().get(CamionesVecinos.get(camion_ran_1).getListaRequerimientosSize()-1));
            CamionesVecinos.get(camion_ran_2).setDistanciaRequerimientos(CamionesVecinos.get(camion_ran_1).getDistanciaRequerimientos(CamionesVecinos.get(camion_ran_1).getDistanciaRequerimientosSize()-1));
            
            //Borra el requerimiento del 1
            CamionesVecinos.get(camion_ran_1).getListaRequerimientos().remove(CamionesVecinos.get(camion_ran_1).getListaRequerimientosSize()-1);
            CamionesVecinos.get(camion_ran_1).setListaRequerimientosSize(CamionesVecinos.get(camion_ran_1).getListaRequerimientos().size());
            CamionesVecinos.get(camion_ran_1).getDistanciaRequerimientos().remove(CamionesVecinos.get(camion_ran_1).getDistanciaRequerimientosSize()-1);
            CamionesVecinos.get(camion_ran_1).setDistanciaRequerimientosSize(CamionesVecinos.get(camion_ran_1).getDistanciaRequerimientos().size());
            //System.out.print("guardado: "+CamionesVecinos.get(camion_ran_1).getListaRequerimientosSize()+","+CamionesVecinos.get(camion_ran_1).getDistanciaRequerimientosSize());
            //System.out.println("  real: "+CamionesVecinos.get(camion_ran_1).getListaRequerimientos().size()+","+CamionesVecinos.get(camion_ran_1).getDistanciaRequerimientos().size());
        //Intercambia un requerimiento con otro
        }else{            
            int req_ran_1 = random.nextInt()%CamionesVecinos.get(camion_ran_1).getListaRequerimientosSize();
            int req_ran_2 = random.nextInt()%CamionesVecinos.get(camion_ran_2).getListaRequerimientosSize();
            
            if(req_ran_1<0)
                req_ran_1 *= -1;

            if(req_ran_2<0)
                req_ran_2 *= -1;
            
            //System.out.println("---------"+camion_ran_1+" con "+camion_ran_2+"-------------");
            //System.out.println("Intercambiandose uno");
            //System.out.println("---------"+req_ran_1+" con "+req_ran_2+"-------------");
            
            Requerimiento req_auxiliar_1 = CamionesVecinos.get(camion_ran_1).getListaRequerimientos(req_ran_1);
            Requerimiento req_auxiliar_2 = CamionesVecinos.get(camion_ran_2).getListaRequerimientos(req_ran_2);
            double dist_auxiliar_1 = CamionesVecinos.get(camion_ran_1).getDistanciaRequerimientos(req_ran_1);
            double dist_auxiliar_2 = CamionesVecinos.get(camion_ran_2).getDistanciaRequerimientos(req_ran_2);
            

            CamionesVecinos.get(camion_ran_1).replaceListaRequerimientos(req_ran_1,req_auxiliar_2);
            CamionesVecinos.get(camion_ran_2).replaceListaRequerimientos(req_ran_2,req_auxiliar_1);            
            CamionesVecinos.get(camion_ran_1).replaceDistanciaRequerimientos(req_ran_1, dist_auxiliar_2);
            CamionesVecinos.get(camion_ran_2).replaceDistanciaRequerimientos(req_ran_2, dist_auxiliar_1);
        }   

        //Ordena los nuevos requerimientos y vuelve a calcular las rutas

        CamionesVecinos.get(camion_ran_1).ordenarListaRequerimientos(Grafico);
        CamionesVecinos.get(camion_ran_1).clearListaDistanciaCargador();
        setRutas(Grafico, CamionesVecinos.get(camion_ran_1));

        CamionesVecinos.get(camion_ran_2).ordenarListaRequerimientos(Grafico);
        CamionesVecinos.get(camion_ran_2).clearListaDistanciaCargador();
        setRutas(Grafico, CamionesVecinos.get(camion_ran_2));


        return CamionesVecinos;
    }

    /**
     * Realiza la heuristica Simulated Annealing
     * @param Grafico Grafico que tiene todos los nodos y distancias entre ellos
     * @param Camiones Lista completa de camiones
     * @return Lista con la solucion cercana al optimo
     */
    public static ArrayList<Camion> heuristica(GrafoTabla Grafico, ArrayList<Camion> Camiones){
        ArrayList<Camion> Solucion = Camiones;
        ArrayList<Camion> SolucionVecina = new ArrayList();
        double gama = 0.0;
        Random random = new Random();    
        double poison = 0.0;

        for(double t=50000.0;t>10.0;t=0.99*t){
            for(int i=45;i>0;i--){
                SolucionVecina = getSolucionVecina(Grafico, Solucion);
       
                //System.out.println(""+getResultadoFuncionObjetivo(SolucionVecina)+"/"+getResultadoFuncionObjetivo(Solucion));
                if(getResultadoFuncionObjetivo(SolucionVecina)<getResultadoFuncionObjetivo(Solucion)){
               
                    Solucion = SolucionVecina;
                }else{
       
                    gama =  getResultadoFuncionObjetivo(SolucionVecina) - getResultadoFuncionObjetivo(Solucion);
                    poison = random.nextInt()%100;
                    
                    if(poison<0)
                        poison *= -1;
                    
                    if(poison/100<Math.exp(-gama/t)){
                        Solucion = SolucionVecina;
                    }
                }
            }
        }
        return Solucion;
    }

    /**
     * Realiza la suma de los valores para obtener el resultado de la funcion objetivo
     * @param Camiones Lista completa de camiones
     * @return Valor resultante
     */
    public static double getResultadoFuncionObjetivo(ArrayList<Camion> Camiones){
        double solucion = 0;

        for(int i=0;i<Camiones.size();i++){

            solucion += Camiones.get(i).getResultado();
 
        }
        //solucion -= Camiones.get(0).tiempoDeCarga();


        return solucion;
    }
}
