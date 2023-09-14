import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Gato miGato = new Gato();
		
		System.out.print("Ingrese nombre : ");
		String nombre = sc.next();
		miGato.nombre = nombre;
		
		System.out.print("Ingrese edad : ");
		int edad = sc.nextInt();
		miGato.edad = edad;

		System.out.print("Ingrese peso : ");
		double peso = sc.nextDouble();
		miGato.peso = peso;
		
		System.out.println("Mi gato se llama " + miGato.nombre + " y es un gran gato.\r\n"
				+ "Le gusta jugar aunque ya tiene " + miGato.edad + " años. Me cuesta cargarlo porque pesa " + miGato.peso + "Kg.");
		sc.close();
		
	}

}
