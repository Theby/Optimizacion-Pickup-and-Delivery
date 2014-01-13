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
		ArrayList <Requerimiento> ListaRequerimientos;
		int lista_requerimientos_size;

		/*
		 * Para guardar la distancia de un requerimiento a otro
		 * distancia_requerimientos[0] corresponderia a la distancia
		 * entre los nodos de cada requerimiento
		 */
		ArrayList <int> ListaDistanciaRequerimientos;
		int distancia_lista_requerimientos_size;

		//Para guardar la distancia entre el nodo final de un requerimiento y el de comienzo de otro
		//Usado para las rutas
		ArrayList <int> ListaDistanciaCargador;
		int lista_distancia_cargador_size;

	public
		Camion(){
			identificador = 0;
			lista_requerimientos_size = ListaRequerimientos.size();
			distancia_lista_requerimientos_size = ListaDistanciaRequerimientos.size();
		}

		Camion(int id){
			identificador = id;
			lista_requerimientos_size = ListaRequerimientos.size();
			distancia_lista_requerimientos_size = ListaDistanciaRequerimientos.size();
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
		 * Para la lista de Requerimientos
		 */
			void setListaRequerimientos(Requerimiento requerimiento){
				ListaRequerimientos.add(requerimiento);
				lista_requerimientos_size = ListaRequerimientos.size();
			}

			void setListaRequerimientos(Requerimiento requerimiento,int posicion){
				if(posicion<lista_requerimientos_size){
					ListaRequerimientos.add(posicion,requerimiento);
					lista_requerimientos_size = ListaRequerimientos.size();
				}
			}

			ArrayList <Requerimiento> getListaRequerimientos(){
				return ListaRequerimientos;
			}

			Requerimiento getListaRequerimientos(int posicion){
				if(posicion<lista_requerimientos_size){
					return ListaRequerimientos.get(posicion);
				}
			}

			int getListaRequerimientosSize(){
				return lista_requerimientos_size;
			}

			void swapListaRequerimientos(int pos_1, int pos_2){
				Requerimiento req_1 = getRequerimientos(pos_1);

				ListaRequerimientos.set(pos_1,getRequerimientos(pos_2));
				ListaRequerimientos.set(pos_2,req_1);
			}

		/*
		 * Sobre la distancia de los requerimientos
		 */
			void setDistanciaRequerimientos(int distancia){
				ListaDistanciaRequerimientos.add(distancia);
				distancia_lista_requerimientos_size = ListaDistanciaRequerimientos.size();
			}

			void setDistanciaRequerimientos(int distancia,int posicion){
				if(posicion<distancia_lista_requerimientos_size){
					ListaDistanciaRequerimientos.add(posicion,distancia);
					distancia_lista_requerimientos_size = ListaDistanciaRequerimientos.size();
				}
			}

			ArrayList <int> getDistanciaRequerimientos(){
				return ListaDistanciaRequerimientos;
			}

			int getDistanciaRequerimientos(int posicion){
				if(posicion<distancia_lista_requerimientos_size){
					return ListaDistanciaRequerimientos.get(posicion);
				}
			}

			int getDistanciaRequerimientosSize(){
				return distancia_lista_requerimientos_size;
			}

			void swapDistanciaRequerimientos(int pos_1, int pos_2){
				int dis_req_1 = ListaDistanciaRequerimientos.get(pos_1);

				ListaDistanciaRequerimientos.set(pos_1,ListaDistanciaRequerimientos.get(pos_2));
				ListaDistanciaRequerimientos.set(pos_2,dis_req_1);
			}

		/*
		 * Sobre la distancia entre los requerimientos
		 */
			void setDistanciaCargador(int distancia){
				ListaDistanciaCargador.add(distancia);
				lista_distancia_cargador_size = ListaDistanciaCargador.size();
			}

			void setDistanciaCargador(int distancia,int posicion){
				if(posicion<lista_distancia_cargador_size){
					ListaDistanciaCargador.add(posicion,distancia);
					lista_distancia_cargador_size = ListaDistanciaCargador.size();
				}
			}

			ArrayList <int> getDistanciaCargador(){
				return ListaDistanciaCargador;
			}

			int getDistanciaCargador(int posicion){
				if(posicion<lista_distancia_cargador_size){
					return ListaDistanciaCargador.get(posicion);
				}
			}

			int getDistanciaCargadorSize(){
				return lista_distancia_cargador_size;
			}

			void swapDistanciaCargador(int pos_1, int pos_2){
				int dis_req_1 = ListaDistanciaCargador.get(pos_1);

				ListaDistanciaCargador.set(pos_1,ListaDistanciaCargador.get(pos_2));
				ListaDistanciaCargador.set(pos_2,dis_req_1);
			}

		void mostrarRequerimientos(){
			System.out.println("Requerimientos del Camnión "+getIdentificador()+":");
			System.out.println("   Formato: Nodo -> (distancia) -> Nodo");
			for(int i=0;i<lista_requerimientos_size;i++){
				System.out.print("   "+getRequerimientos(i).getNodoInicial());
				System.out.print(" --> ");
				System.out.print(" ("+getDistanciaRequerimientos(i)+") ");
				System.out.print(" --> ");
				System.out.println(""+getRequerimientos(i).getNodoDestino());
			}
		}

		void mostrarRutas(){
			System.out.println("Rutas del Camnión "+getIdentificador()+":");
			System.out.println("   Formato: Requerimiento -> (distancia) -> Requerimiento");
			for(int i=0;i<lista_distancia_cargador_size;i++){
				System.out.print("   "+getRequerimientos(i).getNodoDestino());
				System.out.print(" --> ");
				System.out.print(" ("+getDistanciaCargador(i)+") ");
				System.out.print(" --> ");
				System.out.println(""+getRequerimientos(i+1).getNodoInicial());
			}
		}

		int getDistanciaTotal(){
			int total=0;

			for(int i=0;i<distancia_lista_requerimientos_size;i++){
				total += getDistanciaRequerimientos(i);
			}

			return total;
		}

		void swapElementos(int pos_1, int pos_2){
			swapRequerimientos(pos_1,pos_2);
			swapDistanciaRequerimientos(pos_1,pos_2);
			golosoRutas();
		}

		int getCargadorUltimoRequerimiento(){
			if(lista_requerimientos_size>0){
				return ListaRequerimientos[lista_requerimientos_size-1].getNodoInicial().getPosicion();
			}else{
				return 0;
			}
		}

		int getDestinoUltimoRequerimiento(){
			if(lista_requerimientos_size>0){
				return ListaRequerimientos[lista_requerimientos_size-1].getNodoDestino().getPosicion();
			}else{
				return 0;
			}
		}


}