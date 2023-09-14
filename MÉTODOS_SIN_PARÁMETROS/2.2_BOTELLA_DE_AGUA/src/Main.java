
public class Main {
//Botella de Agua
//Crear una clase BotellaDeAgua que tenga un peso de recipiente y una cantidad de agua en litros y una capacidad máxima.
//Crear un método que retorne el peso total de la botella sabiendo que cada litro de agua pesa un kilo.
//Crear un método que retorne que porcentaje de la botella está lleno.
//Crear un método que retorne que porcentaje de la botella está vacío.
//Crear un método que retorne si la botella llena (Booleano, si no están cómodos con ese tipo de dato, pueden retornar S o N).
//Una vez hecho esto, crear un Main donde se carguen tres botellas y se muestre:
//El porcentaje en que se encuentra llena la primera botella, el porcentaje vacío de la segunda botella y si la tercera botella está llena.
	public static void main(String[] args) {
		
		BotellaDeAgua primerBotella = new BotellaDeAgua();
		primerBotella.capacidadMaxima = 2;
		primerBotella.litrosContenidos = 1.2;
		primerBotella.pesoRecipiente = 0.5;
		
		BotellaDeAgua segundaBotella = new BotellaDeAgua();
		segundaBotella.capacidadMaxima = 2;
		segundaBotella.litrosContenidos = 0.2;
		segundaBotella.pesoRecipiente = 0.5;
		
		BotellaDeAgua tercerBotella = new BotellaDeAgua();
		tercerBotella.capacidadMaxima = 3;
		tercerBotella.litrosContenidos = 3;
		tercerBotella.pesoRecipiente = 0.5;
		
		
		System.out.println("El porcentaje en que se encuentra llena la primera botella : ");
		System.out.println(primerBotella.porcentajeLleno() + " %");
		
		System.out.println("El porcentaje vacío de la segunda botella : ");
		System.out.println(segundaBotella.porcentajeVacio() + " %");
		
		System.out.println("La tercera botella está llena : ");
		if(tercerBotella.botellaLLena()) {
			System.out.println("si");
		}else {
			System.out.println("no");
		}

		
	}

}
