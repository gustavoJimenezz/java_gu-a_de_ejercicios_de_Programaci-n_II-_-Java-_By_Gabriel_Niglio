package ingredientes;

public class Ingrediente {
	private String nombre;
	private char unidad;
	private double porcion;
	
	public Ingrediente(String nombre, char unidad, double porcion) {
		this.nombre = nombre;
		this.unidad = unidad;
		this.porcion = porcion;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public char getUnidad() {
		return unidad;
	}
	public void setUnidad(char unidad) {
		this.unidad = unidad;
	}
	public double getPorcion() {
		return porcion;
	}
	public void setPorcion(double porcion) {
		this.porcion = porcion;
	}

}
