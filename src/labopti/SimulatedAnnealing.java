/*
 * 
 */
package labopti;

import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class SimulatedAnnealing{
	private int t;
	private int coste_solucion_inicial;

	
	public static void setRequerimientos(GrafoTabla Grafico, ArrayList <Requerimiento> ListaRequerimientos, ArrayList <Camion> Camiones){
		int nodo_carga_aux=0;
		int posicion;

		while(Grafico.getNumeroDisponiblesCarga()>0){
			for(int i=0;i<Camiones.size();i++){
				//Obtiene el nodo de donde parte
				nodo_carga_aux = Camiones.get(i).getDestinoUltimoRequerimiento();

				//Busca un el punto de carga mas cercano al punto donde parte
				posicion = Grafico.getMenorDistanciaCargaDisponible(nodo_carga_aux);

				//Si la posicion es diferente significa que encontro un nuevo nodo
				if(posicion != nodo_carga_aux){
					//Obtiene el requerimiento que tiene como cargador, o nodo inicial, el indicado en la posicion
					Requerimiento req_aux = new Requerimiento();
					for(int j=0;j<ListaRequerimientos.size();j++){
						if(ListaRequerimientos.get(j).getNodoInicial().getPosicion()==posicion){
							req_aux = ListaRequerimientos.get(j);
							break;
						}							
					}

					//Agrega el requerimiento encontrado a la lista de requerimientos del camión
					Camiones.get(i).setListaRequerimientos(req_aux);

					//Obtiene la distancia del nodo inicial al nodo destino del requerimiento
					Camiones.get(i).setDistanciaRequerimientos(Grafico.getDistancia(req_aux.getNodoInicial().getPosicion(), req_aux.getNodoDestino().getPosicion()));

					//Asigna la disponibilidad correspondiente al nodo de cargador encontrado
					Grafico.setDisponibilidadNodo(posicion);
				}				
			}
		}
	}

	public static void setSolucionVecina(GrafoTabla grafico, ArrayList<Camion> camiones){
            
        }

	public static int heuristica(GrafoTabla grafico, ArrayList<Camion> camiones){
		//valor inicial alto para t
		//coste_solucion_inicial elegida arbitrariamente
		//ArrayList<NodoTabla> Tabla = grafico.getArray();
                    
                return 0;
	}

	public static int getResultadoSolucionObjetivo(ArrayList<Camion> camiones){
		int size = camiones.size();
		int solucion = 0;

		for(int i=0;i<size;i++){
			solucion += camiones.get(i).getDistanciaTotal();
		}

		return solucion;
	}
}


