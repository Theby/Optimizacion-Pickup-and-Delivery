/*
 * 
 */
package labopti;

import java.util.ArrayList;
import java.util.Random;
import java.math.*;

/**
 *
 * @author Esteban
 */
public class SimulatedAnnealing{
    
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

    public static void setRutas(GrafoTabla Grafico, Camion camiones){
        int pos_nodo_aux = 0;

        for(int j=0;j<camiones.getListaRequerimientosSize();j++){
            camiones.setDistanciaCargador(Grafico.getDistancia(pos_nodo_aux, camiones.getListaRequerimientos(j).getNodoInicial().getPosicion()));
            pos_nodo_aux = camiones.getListaRequerimientos(j).getNodoDestino().getPosicion();
        }
    }

    public static void setSolucionVecina(GrafoTabla Grafico, ArrayList<Camion> Camiones){
        Random random = new Random();    
        int camion_ran_1 = random.nextInt()%Camiones.size();
        int camion_ran_2 = random.nextInt()%Camiones.size();

        while(camion_ran_1==camion_ran_2){
            camion_ran_2 = random.nextInt()%Camiones.size();
        }

        int prob = random.nextInt()%100;

        //Pasar un requerimiento a otro
        if(Camiones.get(camion_ran_1).getListaRequerimientosSize()!=Camiones.get(camion_ran_2).getListaRequerimientosSize() || prob<50){
            //Para asegurarse que el camion_ran_1 es el que tiene mÃ¡s requerimientos
            if(Camiones.get(camion_ran_1).getListaRequerimientosSize()<Camiones.get(camion_ran_2).getListaRequerimientosSize()){
                int aux = camion_ran_1;
                camion_ran_1 = camion_ran_2;
                camion_ran_2 = aux;
            }

            //AÃ±ade al 2 el requerimiento exedente del 1
            Camiones.get(camion_ran_2).setListaRequerimientos(Camiones.get(camion_ran_1).getListaRequerimientos().get(Camiones.get(camion_ran_1).getListaRequerimientosSize()-1));

            //Borra el requerimiento del 1
            Camiones.get(camion_ran_1).getListaRequerimientos().remove(Camiones.get(camion_ran_1).getListaRequerimientosSize()-1);

        //Intercambia un requerimiento con otro
        }else{
            int req_ran_1 = random.nextInt()%Camiones.get(camion_ran_1).getListaRequerimientosSize();
            int req_ran_2 = random.nextInt()%Camiones.get(camion_ran_2).getListaRequerimientosSize();

            Requerimiento req_auxiliar = Camiones.get(camion_ran_1).getListaRequerimientos(req_ran_1);

            Camiones.get(camion_ran_1).getListaRequerimientos().set(req_ran_1, Camiones.get(camion_ran_2).getListaRequerimientos(req_ran_2));
            Camiones.get(camion_ran_2).getListaRequerimientos().set(req_ran_2,req_auxiliar);
        }

        //Ordena los nuevos requerimientos y vuelve a calcular las rutas
        Camiones.get(camion_ran_1).ordenarListaRequerimientos(Grafico);
        Camiones.get(camion_ran_1).clearListaDistanciaCargador();
        setRutas(Grafico, Camiones.get(camion_ran_1));
        Camiones.get(camion_ran_2).ordenarListaRequerimientos(Grafico);
        Camiones.get(camion_ran_2).clearListaDistanciaCargador();
        setRutas(Grafico, Camiones.get(camion_ran_2));
    }

    public static ArrayList<Camion> getSolucionVecina(GrafoTabla Grafico,ArrayList<Camion> Camiones){
        ArrayList<Camion> CamionesVecinos = Camiones;
        Random random = new Random();    
        int camion_ran_1 = random.nextInt()%CamionesVecinos.size();
        int camion_ran_2 = random.nextInt()%CamionesVecinos.size();

        while(camion_ran_1==camion_ran_2){
            camion_ran_2 = random.nextInt()%CamionesVecinos.size();
        }
        
        if(camion_ran_1<0)
            camion_ran_1 *= -1;
        
        if(camion_ran_2<0)
            camion_ran_2 *= -1;
        
        int prob = random.nextInt()%100;
        
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
            
            //Añade al 2 el requerimiento exedente del 1
            CamionesVecinos.get(camion_ran_2).setListaRequerimientos(CamionesVecinos.get(camion_ran_1).getListaRequerimientos().get(CamionesVecinos.get(camion_ran_1).getListaRequerimientosSize()-1));
            
            //Borra el requerimiento del 1
            CamionesVecinos.get(camion_ran_1).getListaRequerimientos().remove(CamionesVecinos.get(camion_ran_1).getListaRequerimientosSize()-1);
            CamionesVecinos.get(camion_ran_1).setListaRequerimientosSize(CamionesVecinos.get(camion_ran_1).getListaRequerimientos().size());

        //Intercambia un requerimiento con otro
        }else{
            int req_ran_1 = random.nextInt()%CamionesVecinos.get(camion_ran_1).getListaRequerimientosSize();
            int req_ran_2 = random.nextInt()%CamionesVecinos.get(camion_ran_2).getListaRequerimientosSize();
            
            if(req_ran_1<0)
                req_ran_1 *= -1;

            if(req_ran_2<0)
                req_ran_2 *= -1;
            
            Requerimiento req_auxiliar = CamionesVecinos.get(camion_ran_1).getListaRequerimientos(req_ran_1);

            CamionesVecinos.get(camion_ran_1).getListaRequerimientos().set(req_ran_1, CamionesVecinos.get(camion_ran_2).getListaRequerimientos(req_ran_2));
            CamionesVecinos.get(camion_ran_2).getListaRequerimientos().set(req_ran_2,req_auxiliar);
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

    public static double getResultadoFuncionObjetivo(ArrayList<Camion> Camiones){
        double solucion = 0;

        for(int i=0;i<Camiones.size();i++){
            solucion += Camiones.get(i).getResultado();
        }
        solucion -= Camiones.get(0).tiempoDeCarga();


        return solucion;
    }
}
