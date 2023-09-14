
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Persona primeraPersona = new Persona();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese nombre : ");
		primeraPersona.nombre = sc.next();
		
		System.out.print("Ingrese apellido : ");
		primeraPersona.apellido = sc.next();
		
		System.out.print("Ingrese edad : ");
		primeraPersona.edad = sc.nextInt();

		System.out.println("Bienvenido : " + primeraPersona.nombre + " " + primeraPersona.apellido + " de edad " + primeraPersona.edad);
		
		sc.close();
	}

}
