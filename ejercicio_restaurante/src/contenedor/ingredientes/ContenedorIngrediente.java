package contenedor.ingredientes;

import ingredientes.Ingrediente;

public class ContenedorIngrediente {
	private Ingrediente[] vecIngredientes;
	private int indice;
	
	public ContenedorIngrediente(int tamVec) {
		this.vecIngredientes = new Ingrediente[tamVec];
		indice = 0;
	}
	
	public boolean add(Ingrediente ingredienteNuevo) {
		if(this.hayEspacio()) {
			this.vecIngredientes[this.getIndice()] = ingredienteNuevo;
			this.incrementarIndice();
			return false;
		}else {
			return true;
		}
	}
	
	private void incrementarIndice() {
		this.indice++;
	}
	
	public int getIndice() {
		return this.indice;
	}
	
	public boolean hayEspacio() {
		return this.getIndice() < this.vecIngredientes.length;
	}
	
	public Ingrediente getByPosicion(int posicion) {
//		validar que sea una posicion valida
		return this.vecIngredientes[posicion];
	}

}
