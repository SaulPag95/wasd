package prJarras;

public class Jarra {
	
	private int capacidad, contenido;
	
	public Jarra(){
		
	}
	
	public Jarra(int cap){
		this.setCapacidad(cap);
		this.contenido=0;
	}
	
	public void setContenido(int cont){
		this.contenido=cont;
	}

	public int getContenido(){
		return this.contenido;
	}

	public int getCapacidad(){
		return capacidad;
	}

	public void setCapacidad(int cap){
		this.capacidad= cap;
	}
}
