/*
 * 
 */
package labopti;

import java.util.ArrayList;

/**
 * Guarda toda la informacion relacionada a los camiones
 * @author Esteban
 */
public class Camion{
	/**
         * Guarda el identificador del camion
         */
	private int identificador;

	/**
         * Para guardar numericamente la lista de requerimientos
         */
	private ArrayList <Requerimiento> ListaRequerimientos = new ArrayList();
        
        /**
         * 
         */
	private int lista_requerimientos_size;

	/**
	 * Para guardar la distancia de un requerimiento a otro
	 * distancia_requerimientos[0] corresponderia a la distancia
	 * entre los nodos de cada requerimiento
	 */
	private ArrayList <Double> ListaDistanciaRequerimientos = new ArrayList();
	private int distancia_lista_requerimientos_size;

	//Para guardar la distancia entre el nodo final de un requerimiento y el de comienzo de otro
	//Usado para las rutas
	private ArrayList <Double> ListaDistanciaCargador = new ArrayList();
	private int lista_distancia_cargador_size;
        static public int offset;

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
		this.identificador = id;
	}

	public int getIdentificador(){
		return this.identificador;
	}

	/*
	 * Para la lista de Requerimientos
	 */
	public void setListaRequerimientos(Requerimiento requerimiento){
		this.ListaRequerimientos.add(requerimiento);
		this.lista_requerimientos_size = this.ListaRequerimientos.size();
	}

	public void setListaRequerimientos(Requerimiento requerimiento,int posicion){
		if(posicion<lista_requerimientos_size){
			this.ListaRequerimientos.add(posicion,requerimiento);
			this.lista_requerimientos_size = this.ListaRequerimientos.size();
		}
	}

	public ArrayList <Requerimiento> getListaRequerimientos(){
		return this.ListaRequerimientos;
	}

	public Requerimiento getListaRequerimientos(int posicion){
		if(posicion<this.lista_requerimientos_size){
			return this.ListaRequerimientos.get(posicion);
		}
            return null;
	}

	public int getListaRequerimientosSize(){
		return lista_requerimientos_size;
	}

	public void swapListaRequerimientos(int pos_1, int pos_2){
		Requerimiento req_1 = getListaRequerimientos(pos_1);

		this.ListaRequerimientos.set(pos_1,getListaRequerimientos(pos_2));
		this.ListaRequerimientos.set(pos_2,req_1);
	}

	/*
	 * Sobre la distancia de los requerimientos
	 */
	public void setDistanciaRequerimientos(double distancia){
		this.ListaDistanciaRequerimientos.add(distancia);
		this.distancia_lista_requerimientos_size = this.ListaDistanciaRequerimientos.size();
	}

	public void setDistanciaRequerimientos(double distancia,int posicion){
		if(posicion<distancia_lista_requerimientos_size){
			this.ListaDistanciaRequerimientos.add(posicion,distancia);
			this.distancia_lista_requerimientos_size = this.ListaDistanciaRequerimientos.size();
		}
	}

	public ArrayList <Double> getDistanciaRequerimientos(){
		return this.ListaDistanciaRequerimientos;
	}

	public double getDistanciaRequerimientos(int posicion){
		if(posicion<distancia_lista_requerimientos_size){
			return this.ListaDistanciaRequerimientos.get(posicion);
		}
            return -1;
	}

	public int getDistanciaRequerimientosSize(){
		return this.distancia_lista_requerimientos_size;
	}

	public void swapDistanciaRequerimientos(int pos_1, int pos_2){
		double dis_req_1 = this.ListaDistanciaRequerimientos.get(pos_1);

		this.ListaDistanciaRequerimientos.set(pos_1,this.ListaDistanciaRequerimientos.get(pos_2));
		this.ListaDistanciaRequerimientos.set(pos_2,dis_req_1);
	}

	/*
	 * Sobre la distancia entre los requerimientos
	 */
	public void setDistanciaCargador(double distancia){
		this.ListaDistanciaCargador.add(distancia);
		this.lista_distancia_cargador_size = this.ListaDistanciaCargador.size();
	}

	public void setDistanciaCargador(double distancia,int posicion){
		if(posicion<this.lista_distancia_cargador_size){
			this.ListaDistanciaCargador.add(posicion,distancia);
			this.lista_distancia_cargador_size = this.ListaDistanciaCargador.size();
		}
	}

	public ArrayList <Double> getDistanciaCargador(){
		return this.ListaDistanciaCargador;
	}

	public double getDistanciaCargador(int posicion){
		if(posicion<this.lista_distancia_cargador_size){
			return this.ListaDistanciaCargador.get(posicion);
		}
            return -1;
	}

	public int getDistanciaCargadorSize(){
		return this.lista_distancia_cargador_size;
	}

	public void swapDistanciaCargador(int pos_1, int pos_2){
		double dis_req_1 = this.ListaDistanciaCargador.get(pos_1);

		this.ListaDistanciaCargador.set(pos_1,this.ListaDistanciaCargador.get(pos_2));
		this.ListaDistanciaCargador.set(pos_2,dis_req_1);
	}

	public void mostrarRequerimientos(){
		System.out.println("Requerimientos del Camión "+this.getIdentificador()+": "+this.getListaRequerimientosSize());
		System.out.println("   Formato: Nodo -> (distancia) -> Nodo");
		for(int i=0;i<this.lista_requerimientos_size;i++){
			System.out.print("   "+this.getListaRequerimientos(i).getNodoInicial().getPosicion());
                        System.out.print("("+this.getListaRequerimientos(i).getNodoInicial().getCoordX()+","+this.getListaRequerimientos(i).getNodoInicial().getCoordY()+")");
			System.out.print(" --> ");
			System.out.print(" ("+this.getDistanciaRequerimientos(i)+") ");
			System.out.print(" --> ");
			System.out.print(""+this.getListaRequerimientos(i).getNodoDestino().getPosicion());
                        System.out.println("("+this.getListaRequerimientos(i).getNodoDestino().getCoordX()+","+this.getListaRequerimientos(i).getNodoDestino().getCoordY()+")");
		}
	}
        
        public void setListaRequerimientosSize(int nuevo){
            this.lista_requerimientos_size = nuevo;
        }

	public void mostrarRutas(){
		System.out.println("Rutas del Camnión "+this.getIdentificador()+": "+this.getDistanciaCargadorSize());
		System.out.println("   Formato: Requerimiento(x,y) -> (distancia) -> Requerimiento(x,y)");
                
                System.out.print("   "+0);
                System.out.print("(0,0)");
                System.out.print(" --> ");
                System.out.print(" ("+this.getDistanciaCargador(0)+") ");
                System.out.print(" --> ");
                System.out.print(""+this.getListaRequerimientos(0).getNodoInicial().getPosicion());
                System.out.println("("+this.getListaRequerimientos(0).getNodoInicial().getCoordX()+","+this.getListaRequerimientos(0).getNodoDestino().getCoordY()+")");
                
		for(int i=0;i<this.lista_distancia_cargador_size-1;i++){
			System.out.print("   "+this.getListaRequerimientos(i).getNodoDestino().getPosicion());
                        System.out.print("("+this.getListaRequerimientos(i).getNodoDestino().getCoordX()+","+this.getListaRequerimientos(i).getNodoDestino().getCoordY()+")");
			System.out.print(" --> ");
			System.out.print(" ("+this.getDistanciaCargador(i+1)+") ");
			System.out.print(" --> ");
			System.out.print(""+this.getListaRequerimientos(i+1).getNodoInicial().getPosicion());
                        System.out.println("("+this.getListaRequerimientos(i+1).getNodoInicial().getCoordX()+","+this.getListaRequerimientos(i+1).getNodoDestino().getCoordY()+")");
		}
	}

	public double getDistanciaTotalRequerimientos(){
		double total=0;

		for(int i=0;i<this.distancia_lista_requerimientos_size;i++){
			total += getDistanciaRequerimientos(i);
		}

		return total;
	}

	public void swapElementos(int pos_1, int pos_2){
		swapListaRequerimientos(pos_1,pos_2);
		swapDistanciaRequerimientos(pos_1,pos_2);
		//setRutas();
	}        private double getTransporte(int offset) {
            return 500+Math.sqrt(Math.pow(offset, 2)+Math.pow(offset+Math.pow(2,7)*Math.pow(3,2)+16, 2));
        }

	public int getCargadorUltimoRequerimiento(){
		if(this.lista_requerimientos_size>0){
			return this.ListaRequerimientos.get(this.lista_requerimientos_size-1).getNodoInicial().getPosicion();
		}else{
			return 0;
		}
	}

	public int getDestinoUltimoRequerimiento(){
		if(this.lista_requerimientos_size>0){
			return this.ListaRequerimientos.get(this.lista_requerimientos_size-1).getNodoDestino().getPosicion();
		}else{
			return 0;
		}
	}
        
        public double tiempoDeCarga(){
            return this.getTransporte(offset);
        }
        
        public void clearListaDistanciaCargador(){
            this.ListaDistanciaCargador.clear();
            this.lista_distancia_cargador_size = 0;
        }
        
        public void clearListaDistanciaRequerimientos(){
            this.ListaDistanciaRequerimientos.clear();
            this.lista_requerimientos_size = 0;
        }
        
        public void clearListaRequerimientos(){
            this.ListaRequerimientos.clear();
            this.lista_requerimientos_size = 0;
        }
        
        public void ordenarListaRequerimientos(GrafoTabla Grafico){
            ArrayList <Requerimiento> ListaAuxiliar = new ArrayList();
            int nodo_aux = 0;
            
            double distancia_ref;
            double distancia;
            
            ArrayList <Integer> añadido = new ArrayList();
            int posicion = nodo_aux;
            
            //distancia = Grafico.getDistancia(nodo_aux, this.getListaRequerimientos().get(0).getNodoInicial().getPosicion());
            distancia = 100000000;
            
            for(int j=0;j<this.getListaRequerimientosSize();j++){
                for(int i=0;i<this.getListaRequerimientosSize();i++){
                    distancia_ref = Grafico.getDistancia(nodo_aux, this.getListaRequerimientos().get(i).getNodoInicial().getPosicion());
                    if(distancia>distancia_ref && !añadido.contains(i)){
                        distancia = distancia_ref;
                        posicion = i;
                    }                           
                }

                añadido.add(posicion);
                ListaAuxiliar.add(this.ListaRequerimientos.get(posicion));
                nodo_aux = this.ListaRequerimientos.get(posicion).getNodoDestino().getPosicion();
            }
            
            this.ListaRequerimientos = ListaAuxiliar;
        }
        
        public double getResultado(){
            double total = this.getDistanciaTotalRequerimientos();
            
            for(int i=0;i<this.getDistanciaCargadorSize();i++){                
                total += this.getDistanciaCargador(i);
            }
            
            return total;
        }
}