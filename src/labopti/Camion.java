/*
 * 
 */
package labopti;

import java.util.ArrayList;

/**
 * Guarda toda la informacion relacionada a los camiones
 * @author Luis y Esteban
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
         * Para el tamaño de ListaRequerimientos
         */
	private int lista_requerimientos_size;

	/**
	 * Para guardar la distancia de un requerimiento a otro
	 * distancia_requerimientos[0] corresponderia a la distancia
	 * entre los nodos de cada requerimiento
	 */
	private ArrayList <Double> ListaDistanciaRequerimientos = new ArrayList();
        
        /**
         * Para guardar el tamaño de la lista de distancias de requerimiento
         */
	private int distancia_lista_requerimientos_size;

	/**
         * Para guardar la distancia entre el nodo final de un requerimiento y el de comienzo de otro
	 * Usado para las rutas
         */
	private ArrayList <Double> ListaDistanciaCargador = new ArrayList();
        
        /**
         * Para el tamaño de ListaDistanciaCargador
         */
	private int lista_distancia_cargador_size;
        
        /**
         * Offset indicativo del transporte
         */
        static public int offset;
        
        /**
         * Inicializa el Camion por defecto
         */
	public Camion(){
		identificador = 0;
		lista_requerimientos_size = ListaRequerimientos.size();
		distancia_lista_requerimientos_size = ListaDistanciaRequerimientos.size();
	}

        /**
         * Inicializa el camion con un id
         * @param id identificador del camion
         */
	public Camion(int id){
		identificador = id;
		lista_requerimientos_size = ListaRequerimientos.size();
		distancia_lista_requerimientos_size = ListaDistanciaRequerimientos.size();
	}

	/**
	 * Para darle valor al identificador
         * @param id valor a asignar
	 */
	public void setIdentificador(int id){
		this.identificador = id;
	}

        /**
         * Para obtener el valor del identificador
         * @return int con el valor del identificador del camion
         */
	public int getIdentificador(){
		return this.identificador;
	}

	/*
	 * Para la lista de Requerimientos, asigna un requerimiento
         * @param requerimiento requerimiento a asignar
	 */
	public void setListaRequerimientos(Requerimiento requerimiento){
		this.ListaRequerimientos.add(requerimiento);
		this.lista_requerimientos_size = this.ListaRequerimientos.size();
	}
        
        /**
         * Asigna un requerimiento en la posicion dada
         * @param requerimiento requerimiento a asignar
         * @param posicion posicion donde se colocara
         */
	public void setListaRequerimientos(Requerimiento requerimiento,int posicion){
		if(posicion<lista_requerimientos_size){
			this.ListaRequerimientos.add(posicion,requerimiento);
			this.lista_requerimientos_size = this.ListaRequerimientos.size();
		}
	}
        
        /**
         * Reemplaza el valor en la posicion dada por el valor dado para la 
         * lista de requerimientos
         * @param posicion posicion del ojeto a reemplazar
         * @param requerimiento tipo de dato que tomará su lugar
         */
        public void replaceListaRequerimientos(int posicion, Requerimiento requerimiento){
            if(posicion<lista_requerimientos_size){
                    this.ListaRequerimientos.set(posicion,requerimiento);
            }
        }
        
        /**
         * Reemplaza el valor en la posicion dada por el valor dado para la 
         * lista de requerimientos
         * @param posicion posicion del ojeto a reemplazar
         * @param distancia tipo de dato que tomará su lugar
         */
        public void replaceDistanciaRequerimientos(int posicion, double distancia){
            if(posicion<distancia_lista_requerimientos_size){
                    this.ListaDistanciaRequerimientos.set(posicion,distancia);
            }
        }
        
        /**
         * Obtiene la lista completa de requerimientos del camion
         * @return ArrayList <Requerimiento>
         */
	public ArrayList <Requerimiento> getListaRequerimientos(){
		return this.ListaRequerimientos;
	}

        /**
         * Obtiene un requerimiento en especifico de la Lista de requerimientos
         * @param posicion posicion del arreglo que se desea
         * @return Requerimiento deseado
         */
	public Requerimiento getListaRequerimientos(int posicion){
		if(posicion<this.lista_requerimientos_size){
			return this.ListaRequerimientos.get(posicion);
		}
            return null;
	}

        /**
         * Obtiene el tamaño de la lista de requerimientos
         * @return int con el tamaño
         */
	public int getListaRequerimientosSize(){
		return lista_requerimientos_size;
	}

        /**
         * Permite intercambiar lo que hay en la posicion 1 con la posicion 2
         * @param pos_1 posicion 1
         * @param pos_2 posicion 2
         */
	public void swapListaRequerimientos(int pos_1, int pos_2){
		Requerimiento req_1 = getListaRequerimientos(pos_1);

		this.ListaRequerimientos.set(pos_1,getListaRequerimientos(pos_2));
		this.ListaRequerimientos.set(pos_2,req_1);
	}

	/**
         * Asigna la distancia del requerimiento
         * @param distancia distancia a asignar
         */
	public void setDistanciaRequerimientos(double distancia){
		this.ListaDistanciaRequerimientos.add(distancia);
		this.distancia_lista_requerimientos_size = this.ListaDistanciaRequerimientos.size();
	}

        /**
         * Asigna la distancia de un requerimiento en la posicion dada
         * @param distancia distancia a asignar
         * @param posicion posicion a asignar
         */
	public void setDistanciaRequerimientos(double distancia,int posicion){
		if(posicion<distancia_lista_requerimientos_size){
			this.ListaDistanciaRequerimientos.add(posicion,distancia);
			this.distancia_lista_requerimientos_size = this.ListaDistanciaRequerimientos.size();
		}
	}

        /**
         * obtiene el arreglo de la distancia de los requerimientos
         * @return ArrayList <Double>
         */
	public ArrayList <Double> getDistanciaRequerimientos(){
		return this.ListaDistanciaRequerimientos;
	}

        /**
         * Obtiene una distancia en particular
         * @param posicion posicion deseada
         * @return double, valor de la distancia
         */
	public double getDistanciaRequerimientos(int posicion){
       
            if(posicion<distancia_lista_requerimientos_size){
                
                    return this.ListaDistanciaRequerimientos.get(posicion);
            }
            
            return -1;
	}

        /**
         * Obtiene el tamaño del arreglo distancia de requerimientos
         * @return int
         */
	public int getDistanciaRequerimientosSize(){
		return this.distancia_lista_requerimientos_size;
	}

        /**
         * Intercambia lo que hay en la posicion 1 con lo de la posicion 2
         * @param pos_1 posicion 1
         * @param pos_2 posicion 2
         */
	public void swapDistanciaRequerimientos(int pos_1, int pos_2){
		double dis_req_1 = this.ListaDistanciaRequerimientos.get(pos_1);

		this.ListaDistanciaRequerimientos.set(pos_1,this.ListaDistanciaRequerimientos.get(pos_2));
		this.ListaDistanciaRequerimientos.set(pos_2,dis_req_1);
	}

	/**
         * Asigna la distancia del cargador
         * @param distancia valora a asignar
         */
	public void setDistanciaCargador(double distancia){
		this.ListaDistanciaCargador.add(distancia);
		this.lista_distancia_cargador_size = this.ListaDistanciaCargador.size();
	}

        /**
         * Asigna la distacia en una posicion en especial
         * @param distancia valor a asignar
         * @param posicion  posicion a elegir
         */
	public void setDistanciaCargador(double distancia,int posicion){
		if(posicion<this.lista_distancia_cargador_size){
			this.ListaDistanciaCargador.add(posicion,distancia);
			this.lista_distancia_cargador_size = this.ListaDistanciaCargador.size();
		}
	}

        /**
         * obtiene el arreglo de distancias del cargador
         * @return ArrayList <Double>
         */
	public ArrayList <Double> getDistanciaCargador(){
		return this.ListaDistanciaCargador;
	}

        /**
         * Obtiene un valor de distancia especifico del arreglo de distancias del cargador
         * @param posicion posicion deseada
         * @return double, valor deseado
         */
	public double getDistanciaCargador(int posicion){
		if(posicion<this.lista_distancia_cargador_size){
			return this.ListaDistanciaCargador.get(posicion);
		}
            return -1;
	}

        /**
         * Obtiene el tamaño del arreglo de distancia del cargador
         * @return int
         */
	public int getDistanciaCargadorSize(){
		return this.lista_distancia_cargador_size;
	}

        /**
         * Intercambia lo que hay en la posicion 1 con lo de la posicion 2
         * @param pos_1 posicion 1
         * @param pos_2 posicion 2
         */
	public void swapDistanciaCargador(int pos_1, int pos_2){
		double dis_req_1 = this.ListaDistanciaCargador.get(pos_1);

		this.ListaDistanciaCargador.set(pos_1,this.ListaDistanciaCargador.get(pos_2));
		this.ListaDistanciaCargador.set(pos_2,dis_req_1);
	}

        /**
         * Muestra todos los requerimientos de este camion
         */
	public void mostrarRequerimientos(){
		System.out.println("Requerimientos del Camión "+this.getIdentificador());
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
        
        /**
         * Asigna un nuevo valor al tamño de la lista de requerimientos
         * @param nuevo nuevo valor
         */
        public void setListaRequerimientosSize(int nuevo){
            this.lista_requerimientos_size = nuevo;
        }
        
        /**
         * Asigna un nuevo valor al tamño de la lista de distancias
         * @param nuevo nuevo valor
         */
        public void setDistanciaRequerimientosSize(int nuevo){
            this.distancia_lista_requerimientos_size = nuevo;
        }        

        /**
         * Muestra todas las rutas de este camion
         */
	public void mostrarRutas(){
		System.out.println("Rutas del Camnión "+this.getIdentificador());
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
                System.out.println("");
	}

        /**
         * Obtiene la distancia total de los requerimientos
         * @return double con el valor
         */
	public double getDistanciaTotalRequerimientos(){
		double total=0;
               
		for(int i=0;i<this.distancia_lista_requerimientos_size;i++){
			total += getDistanciaRequerimientos(i);
		}
                
		return total;
	}
        
        /**
         * Intercambia lo que hay en la posicion 1 con lo de la posicion 2
         * @param pos_1 posicion 1
         * @param pos_2 posicion 2
         */
	public void swapElementos(int pos_1, int pos_2){
		swapListaRequerimientos(pos_1,pos_2);
		swapDistanciaRequerimientos(pos_1,pos_2);
		//setRutas();
	}        private double getTransporte(int offset) {
            return 500+Math.sqrt(Math.pow(offset, 2)+Math.pow(offset+Math.pow(2,7)*Math.pow(3,2)+16, 2));
        }
        
        /**
         * Obtiene la posicion global del nodo ubicado en el ultimo requerimiento como cargador
         * @return posicion
         */
	public int getCargadorUltimoRequerimiento(){
		if(this.lista_requerimientos_size>0){
			return this.ListaRequerimientos.get(this.lista_requerimientos_size-1).getNodoInicial().getPosicion();
		}else{
			return 0;
		}
	}

        /**
         * Obtiene la posicion global del nodo ubicado en el ultimo requerimiento como destino
         * @return posicion
         */
	public int getDestinoUltimoRequerimiento(){
		if(this.lista_requerimientos_size>0){
			return this.ListaRequerimientos.get(this.lista_requerimientos_size-1).getNodoDestino().getPosicion();
		}else{
			return 0;
		}
	}
        
        /**
         * Obtiene el transporte
         * @return transporte
         */
        public double tiempoDeCarga(){
            return this.getTransporte(offset);
        }
        
        /**
         * Limpia el arreglo de distancia del cargador
         */
        public void clearListaDistanciaCargador(){
            this.ListaDistanciaCargador.clear();
            this.lista_distancia_cargador_size = 0;
        }
        
        /**
         * Limpia el arreglo de la lista de la distancia de requerimientos
         */
        public void clearListaDistanciaRequerimientos(){
            this.ListaDistanciaRequerimientos.clear();
            this.lista_requerimientos_size = 0;
        }
        
        /**
         * Limpia la lista de requerimientos
         */
        public void clearListaRequerimientos(){
            this.ListaRequerimientos.clear();
            this.lista_requerimientos_size = 0;
        }
        
        /**
         * Ordena los requerimientos desde el mas cercano al mas lejano segun 
         * suposicion relativa al ultimo punto de entrega
         * @param Grafico grafico que tiene todas las distancias y la matriz
         */
        public void ordenarListaRequerimientos(GrafoTabla Grafico){
            ArrayList <Requerimiento> ListaAuxiliar = new ArrayList();
            ArrayList <Double> ListaAuxiliarDouble = new ArrayList();
            int nodo_aux = 0;
            
            double distancia_ref;
            double distancia;
            
            ArrayList <Integer> añadido = new ArrayList();
            int posicion = nodo_aux;
            
            //distancia = Grafico.getDistancia(nodo_aux, this.getListaRequerimientos().get(0).getNodoInicial().getPosicion());
            distancia = Grafico.getDistancia(nodo_aux, this.getListaRequerimientos(0).getNodoInicial().getPosicion());
            
            for(int j=0;j<this.getListaRequerimientosSize();j++){
                for(int i=0;i<this.getListaRequerimientosSize();i++){
                    if(!añadido.contains(this.getListaRequerimientos(i).getNodoInicial().getPosicion())){
                        distancia_ref = Grafico.getDistancia(nodo_aux, this.getListaRequerimientos(i).getNodoInicial().getPosicion());
                        if(distancia_ref<=distancia){
                            distancia = distancia_ref;
                            posicion = i;
                        }   
                    }
                }
                
                añadido.add(this.ListaRequerimientos.get(posicion).getNodoInicial().getPosicion());
                ListaAuxiliar.add(this.ListaRequerimientos.get(posicion));
                ListaAuxiliarDouble.add(this.getDistanciaRequerimientos(posicion));
                nodo_aux = this.ListaRequerimientos.get(posicion).getNodoDestino().getPosicion();
                
                for(int k=0;k<this.getListaRequerimientosSize();k++){
                    if(!añadido.contains(this.getListaRequerimientos(k).getNodoInicial().getPosicion())){
                        distancia = Grafico.getDistancia(nodo_aux, this.getListaRequerimientos(k).getNodoInicial().getPosicion());
                        break;
                    }
                }
            }
            
            this.ListaRequerimientos = ListaAuxiliar;
            this.ListaDistanciaRequerimientos = ListaAuxiliarDouble;
        }
        
        /**
         * Obtiene el valor totald e sus requerimientos y rutas
         * @return suma total
         */
        public double getResultado(){
            double total = this.getDistanciaTotalRequerimientos();
            
            for(int i=0;i<this.getDistanciaCargadorSize();i++){                
                total += this.getDistanciaCargador(i);
            }
            
            return total;
        }
}