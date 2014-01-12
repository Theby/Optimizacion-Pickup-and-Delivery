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
		static void setRequerimientos(GrafoTabla grafico, ArrayList <Requerimiento> requerimientos, ArrayList <Camion> camiones){
			double [][] matriz = grafico.getMatriz();
			int posicion;
			int num_camiones = camiones.size();
			int ult_req;

			while(grafico.getDisponibilidadNodo()>0){
				for(int i=0;i<camiones;i++){
					ult_req = camiones[i].getRequerimientos().back();
					posicion = grafico.getMenorDistanciaDisponible(ult_req);
					if(posicion != ult_req){
						camiones[i].setRequerimientos(posicion);
						camiones[i].setDistanciaRequerimientos(ult_req,posicion);
						grafico.setDisponibilidadNodo(posicion);
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


