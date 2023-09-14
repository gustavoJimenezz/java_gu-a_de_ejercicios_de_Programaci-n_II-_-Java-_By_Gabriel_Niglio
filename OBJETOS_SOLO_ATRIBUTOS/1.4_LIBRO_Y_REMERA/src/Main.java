import java.util.Scanner;

//Libro y Remera
//Crear las clases:
//-Libro: Con precio, cantidad de hojas y título.
//-Remera: Con precio, color y talle.
//Una vez hecho esto, cargar ambos por teclado y luego mostrar todos los datos del más caro.
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Libro miLibro = new Libro();
		Remera miRemera = new Remera();

		System.out.print("Ingrese Titulo del libro : ");
		miLibro.título = sc.next();

		System.out.print("Ingrese precio del libro : ");
		miLibro.precio = sc.nextDouble();

		System.out.print("Ingrese cantidad de hojas : ");
		miLibro.cantidadDeHojas = sc.nextInt();

		System.out.print("Ingrese precio de la remera : ");
		miRemera.precio = sc.nextDouble();

		System.out.print("Ingrese color de la remera : ");
		miRemera.color = sc.next();

		System.out.print("Ingrese talle : ");
		miRemera.talle = sc.next();

		if (miLibro.precio > miRemera.precio) {
			System.out.println("Titulo " + miLibro.título + " Cantidad de hojas " + miLibro.cantidadDeHojas
					+ " Precio " + miLibro.precio);
		}

		sc.close();

	}

}
