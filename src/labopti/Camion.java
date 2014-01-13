/*
 * 
 */
package labopti;

import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class Camion{
	//Para identificar este camion
	private int identificador;

	//Para guardar numericamente la lista de requerimientos
	private ArrayList <Requerimiento> ListaRequerimientos;
	private int lista_requerimientos_size;

	/*
	 * Para guardar la distancia de un requerimiento a otro
	 * distancia_requerimientos[0] corresponderia a la distancia
	 * entre los nodos de cada requerimiento
	 */
	private ArrayList <Double> ListaDistanciaRequerimientos;
	private int distancia_lista_requerimientos_size;

	//Para guardar la distancia entre el nodo final de un requerimiento y el de comienzo de otro
	//Usado para las rutas
	private ArrayList <Double> ListaDistanciaCargador;
	private int lista_distancia_cargador_size;

	public Camion(){
		identificador = 0;
		lista_requerimientos_size = ListaRequerimientos.size();
		distancia_lista_requerimientos_size = ListaDistanciaRequerimientos.size();
	}

	public Camion(int id){
		identificador = id;
		lista_requerimientos_size = ListaRequerimientos.size();
		distancia_lista_requerimientos_size = ListaDistanciaRequerimientos.size();
	}

	/*
	 * Para el identificador
	 */
	public void setIdentificador(int id){
		identificador = id;
	}

	public int getIdentificador(){
		return identificador;
	}

	/*
	 * Para la lista de Requerimientos
	 */
	public void setListaRequerimientos(Requerimiento requerimiento){
		ListaRequerimientos.add(requerimiento);
		lista_requerimientos_size = ListaRequerimientos.size();
	}

	public void setListaRequerimientos(Requerimiento requerimiento,int posicion){
		if(posicion<lista_requerimientos_size){
			ListaRequerimientos.add(posicion,requerimiento);
			lista_requerimientos_size = ListaRequerimientos.size();
		}
	}

	public ArrayList <Requerimiento> getListaRequerimientos(){
		return ListaRequerimientos;
	}

	public Requerimiento getListaRequerimientos(int posicion){
		if(posicion<lista_requerimientos_size){
			return ListaRequerimientos.get(posicion);
		}
            return null;
	}

	public int getListaRequerimientosSize(){
		return lista_requerimientos_size;
	}

	public void swapListaRequerimientos(int pos_1, int pos_2){
		Requerimiento req_1 = getListaRequerimientos(pos_1);

		ListaRequerimientos.set(pos_1,getListaRequerimientos(pos_2));
		ListaRequerimientos.set(pos_2,req_1);
	}

	/*
	 * Sobre la distancia de los requerimientos
	 */
	public void setDistanciaRequerimientos(double distancia){
		ListaDistanciaRequerimientos.add(distancia);
		distancia_lista_requerimientos_size = ListaDistanciaRequerimientos.size();
	}

	public void setDistanciaRequerimientos(double distancia,int posicion){
		if(posicion<distancia_lista_requerimientos_size){
			ListaDistanciaRequerimientos.add(posicion,distancia);
			distancia_lista_requerimientos_size = ListaDistanciaRequerimientos.size();
		}
	}

	public ArrayList <Double> getDistanciaRequerimientos(){
		return ListaDistanciaRequerimientos;
	}

	public double getDistanciaRequerimientos(int posicion){
		if(posicion<distancia_lista_requerimientos_size){
			return ListaDistanciaRequerimientos.get(posicion);
		}
            return -1;
	}

	public int getDistanciaRequerimientosSize(){
		return distancia_lista_requerimientos_size;
	}

	public void swapDistanciaRequerimientos(int pos_1, int pos_2){
		double dis_req_1 = ListaDistanciaRequerimientos.get(pos_1);

		ListaDistanciaRequerimientos.set(pos_1,ListaDistanciaRequerimientos.get(pos_2));
		ListaDistanciaRequerimientos.set(pos_2,dis_req_1);
	}

	/*
	 * Sobre la distancia entre los requerimientos
	 */
	public void setDistanciaCargador(double distancia){
		ListaDistanciaCargador.add(distancia);
		lista_distancia_cargador_size = ListaDistanciaCargador.size();
	}

	public void setDistanciaCargador(double distancia,int posicion){
		if(posicion<lista_distancia_cargador_size){
			ListaDistanciaCargador.add(posicion,distancia);
			lista_distancia_cargador_size = ListaDistanciaCargador.size();
		}
	}

	public ArrayList <Double> getDistanciaCargador(){
		return ListaDistanciaCargador;
	}

	public double getDistanciaCargador(int posicion){
		if(posicion<lista_distancia_cargador_size){
			return ListaDistanciaCargador.get(posicion);
		}
            return -1;
	}

	public int getDistanciaCargadorSize(){
		return lista_distancia_cargador_size;
	}

	public void swapDistanciaCargador(int pos_1, int pos_2){
		double dis_req_1 = ListaDistanciaCargador.get(pos_1);

		ListaDistanciaCargador.set(pos_1,ListaDistanciaCargador.get(pos_2));
		ListaDistanciaCargador.set(pos_2,dis_req_1);
	}

	public void mostrarRequerimientos(){
		System.out.println("Requerimientos del Camión "+getIdentificador()+":");
		System.out.println("   Formato: Nodo -> (distancia) -> Nodo");
		for(int i=0;i<lista_requerimientos_size;i++){
			System.out.print("   "+getListaRequerimientos(i).getNodoInicial());
			System.out.print(" --> ");
			System.out.print(" ("+getDistanciaRequerimientos(i)+") ");
			System.out.print(" --> ");
			System.out.println(""+getListaRequerimientos(i).getNodoDestino());
		}
	}

	public void mostrarRutas(){
		System.out.println("Rutas del Camnión "+getIdentificador()+":");
		System.out.println("   Formato: Requerimiento -> (distancia) -> Requerimiento");
		for(int i=0;i<lista_distancia_cargador_size;i++){
			System.out.print("   "+getListaRequerimientos(i).getNodoDestino());
			System.out.print(" --> ");
			System.out.print(" ("+getDistanciaCargador(i)+") ");
			System.out.print(" --> ");
			System.out.println(""+getListaRequerimientos(i+1).getNodoInicial());
		}
	}

	public int getDistanciaTotal(){
		int total=0;

		for(int i=0;i<distancia_lista_requerimientos_size;i++){
			total += getDistanciaRequerimientos(i);
		}

		return total;
	}

	public void swapElementos(int pos_1, int pos_2){
		swapListaRequerimientos(pos_1,pos_2);
		swapDistanciaRequerimientos(pos_1,pos_2);
		//setRutas();
	}

	public int getCargadorUltimoRequerimiento(){
		if(lista_requerimientos_size>0){
			return ListaRequerimientos.get(lista_requerimientos_size-1).getNodoInicial().getPosicion();
		}else{
			return 0;
		}
	}

	public int getDestinoUltimoRequerimiento(){
		if(lista_requerimientos_size>0){
			return ListaRequerimientos.get(lista_requerimientos_size-1).getNodoDestino().getPosicion();
		}else{
			return 0;
		}
	}
        
        public void clearListaDistanciaCargador(){
            ListaDistanciaCargador.clear();
            lista_distancia_cargador_size = 0;
        }
        
        public void clearListaDistanciaRequerimientos(){
            ListaDistanciaRequerimientos.clear();
            lista_requerimientos_size = 0;
        }
        
        public void clearListaRequerimientos(){
            ListaRequerimientos.clear();
            lista_requerimientos_size = 0;
        }
        
        public void ordenarListaRequerimientos(GrafoTabla Grafico){
            ArrayList <Requerimiento> ListaAuxiliar = new ArrayList();
            int nodo_aux = 0;
            double distancia_ref;
            double distancia;
            
            distancia = Grafico.getDistancia(0, this.getListaRequerimientos().get(0).getNodoInicial().getPosicion());
            
            for(int i=0;i<this.getListaRequerimientosSize();i++){
                distancia_ref = Grafico.getDistancia(nodo_aux, this.getListaRequerimientos().get(i).getNodoInicial().getPosicion());
                if(distancia>distancia_ref){
                    distancia = distancia_ref;
                }                           
            }
            
        }

}