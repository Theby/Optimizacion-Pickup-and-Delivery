/*
 * 
 */
package labopti;

import java.util.ArrayList;
import java.util.Vector; 

/**
 *
 * @author Esteban
 */
public class Camion{
	private
		//Para identificar este camion
		int identificador;

		//Para guardar numericamente la lista de requerimientos
		vector<int> requerimientos;
		int requerimientos_size;

		/*
		 * Para guardar la distancia de un requerimiento a otro
		 * distancia_requerimientos[0] corresponderia a la distancia
		 * entre requerimientos[0] y requerimientos[1]
		 */
		vector<int> distancia_requerimientos;
		int distancia_requerimientos_size;

	public
		Camion(){
			identificador = 0;
			requerimientos.push_back(0);
			requerimientos_size = requerimientos.size();
			distancia_requerimientos_size = distancia_requerimientos.size();
		}

		Camion(int id){
			identificador = id;
			requerimientos.push_back(0);
			requerimientos_size = requerimientos.size();
			distancia_requerimientos_size = distancia_requerimientos.size();
		}

		/*
		 * Para el identificador
		 */
			void setIdentificador(int id){
				identificador = id;
			}

			int getIdentificador(){
				return identificador;
			}

		/*
		 * Para los requerimientos
		 */
			void setRequerimientos(int requerimiento){
				requerimientos.push_back(requerimiento);
				requerimientos_size = requerimientos.size();
			}

			void setRequerimientos(int requerimiento,int posicion){
				if(posicion<requerimientos_size){
					requerimientos[posicion] = requerimiento;
				}
			}

			vector<int> getRequerimientos(){
				return requerimientos;
			}

			int getRequerimientos(int posicion){
				if(posicion<requerimientos_size){
					return requerimientos[posicion];
				}
			}

			int getRequerimientosSize(){
				return requerimientos_size;
			}

			void swapRequerimientos(int pos_1, int pos_2){
				int req_1 = requerimientos[pos_1];

				requerimientos[pos_1] = requerimientos[pos_2];
				requerimientos[pos_2] = req_1;
			}

		/*
		 * Sobre la distancia de los requerimientos
		 */
			void setDistanciaRequerimientos(int distancia){
				distancia_requerimientos.push_back(distancia);
				distancia_requerimientos_size = distancia_requerimientos.size();
			}

			void setRequerimientos(int distancia,int posicion){
				if(posicion<distancia_requerimientos_size){
					distancia_requerimientos[posicion] = distancia;
				}
			}

			vector<int> getDistanciaRequerimientos(){
				return distancia_requerimientos;
			}

			int getDistanciaRequerimientos(int posicion){
				if(posicion<distancia_requerimientos_size){
					return distancia_requerimientos[posicion];
				}
			}

			int getDistanciaRequerimientosSize(){
				return distancia_requerimientos_size;
			}

			void swapDistanciaRequerimientos(int pos_1, int pos_2){
				int dis_req_1 = distancia_requerimientos[pos_1];

				distancia_requerimientos[pos_1] = distancia_requerimientos[pos_2];
				distancia_requerimientos[pos_2] = dis_req_1;
			}

		void mostrarRequerimientos(){
			System.out.println("Requerimientos del Camnión "+getIdentificador()+":");
			System.out.println("   Formato: Nodo -> (distancia) -> Nodo -> ... -> Nodo");
			for(int i=0;i<distancia_requerimientos_size;i++){
				System.out.println("   "+getRequerimientos(i));
				System.out.println(" --> ");
				System.out.println(" ("+getDistanciaRequerimientos(i)+") ");
				System.out.println(" --> ");
				System.out.println("   "+getRequerimientos(i+1));
			}
		}

		int getDistanciaTotal(){
			int total=0;

			for(int i=0;i<distancia_requerimientos_size;i++){
				total += getDistanciaRequerimientos(i);
			}

			return total;
		}
}