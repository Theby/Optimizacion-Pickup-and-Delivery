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
	private
		int t;
		int coste_solucion_inicial;

	public
		static void setRequerimientos(GrafoTabla Grafico, ArrayList <Requerimiento> ListaRequerimientos, ArrayList <Camion> Camiones){
			int nodo_carga_aux=0;
			int posicion;

			while(Grafico.setNumeroDisponiblesCarga()>0){
				for(int i=0;i<Camiones.size();i++){
					//Obtiene el nodo de donde parte
					nodo_carga_aux = Camiones.getDestinoUltimoRequerimiento();

					//Busca un el punto de carga mas cercano al punto donde parte
					posicion = Grafico.getMenorDistanciaCargaDisponible(nodo_carga_aux);

					//Si la posicion es diferente significa que encontro un nuevo nodo
					if(posicion != nodo_carga_aux){
						//Obtiene el requerimiento que tiene como cargador, o nodo inicial, el indicado en la posicion
						Requerimiento req_aux;
						for(int j=0;j<ListaRequerimientos.size();j++){
							if(ListaRequerimientos[j].getNodoInicial().getPosicion()==posicion){
								req_aux = ListaRequerimientos[j];
								break;
							}							
						}

						//Agrega el requerimiento encontrado a la lista de requerimientos del camión
						Camiones[i].setListaRequerimientos(req_aux);

						//Obtiene la distancia del nodo inicial al nodo destino del requerimiento
						Camiones[i].setDistanciaRequerimientos(Grafico.getDistancia(req_aux.getNodoInicial().getPosicion(),req_aux.getNodoDestino().getPosicion()));

						//Asigna la disponibilidad correspondiente al nodo de cargador encontrado
						Grafico.setDisponibilidadNodo(posicion);
					}				
				}
			}
		}

		static void setSolucionVecina(GrafoTabla grafico, ArrayList<Camion> camiones);

		static int heuristica(GrafoTabla grafico, ArrayList<Camion> camiones){
			//valor inicial alto para t
			//coste_solucion_inicial elegida arbitrariamente
			ArrayList<NodoTabla> Tabla = grafico.getArray();
                        
                      
		}

		static int getResultadoSolucionObjetivo(ArrayList<Camion> camiones){
			int size = camiones.size();
			int solucion = 0;

			for(int i=0;i<size;i++){
				solucion += camiones.getDistanciaTotal();
			}

			return solucion;
		}
}


