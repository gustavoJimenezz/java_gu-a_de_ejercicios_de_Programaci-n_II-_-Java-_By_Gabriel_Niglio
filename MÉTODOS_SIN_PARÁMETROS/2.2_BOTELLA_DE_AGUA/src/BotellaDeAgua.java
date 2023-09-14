
//Botella de Agua
//Crear una clase BotellaDeAgua que tenga un peso de recipiente y una cantidad de agua en litros y una capacidad máxima.
//Crear un método que retorne el peso total de la botella sabiendo que cada litro de agua pesa un kilo.
//Crear un método que retorne que porcentaje de la botella está lleno.
//Crear un método que retorne que porcentaje de la botella está vacío.
//Crear un método que retorne si la botella llena (Booleano, si no están cómodos con ese tipo de dato, pueden retornar S o N).
//Una vez hecho esto, crear un Main donde se carguen tres botellas y se muestre:
//El porcentaje en que se encuentra llena la primera botella, el porcentaje vacío de la segunda botella y si la tercera botella está llena.

public class BotellaDeAgua {
	
	double pesoRecipiente;
	double litrosContenidos;
	double capacidadMaxima;

	public double pesoTotal() {
		return this.litrosContenidos+ this.pesoRecipiente;
	}
	
	public double porcentajeLleno() {
		return (this.litrosContenidos / this.capacidadMaxima) * 100;
	}
	
	public double porcentajeVacio() {
		return 100 - this.porcentajeLleno();
	}
	
	public Boolean botellaLLena() {
		return this.litrosContenidos >= this.capacidadMaxima;
	}
	
}
