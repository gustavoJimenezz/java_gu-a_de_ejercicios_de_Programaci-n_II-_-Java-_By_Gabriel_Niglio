import java.util.Scanner;

//Pepe

//Crear la clase Pepe, el mismo tiene que tener un número preferido (Es el 21).
//A Pepe le gusta hacer cálculos y puede recibir un número y retornar el doble del mismo.
//Pepe también puede recibir un número, elevarlo al cuadrado y retornarlo.
//Pepe también puede multiplicar el número que le brinden por su número preferido.
//Realizar un Main donde se ingrese un número por teclado y Pepe pueda presumir todas sus dotes matemáticas. (Mostrar el resultado de todos sus métodos por pantalla).
public class Main {

	public static void main(String[] args) {
		
		Pepe pepito = new Pepe();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese numero para que Pepito pueda hacer calculos : ");
		double numIngresado = sc.nextDouble();
		
		
		System.out.println("El doble de " + numIngresado + " = " + pepito.calcularDoble(numIngresado));
		System.out.println("Elevarlo al cuadrado " + numIngresado + " = " + pepito.elevarAlCuadrado(numIngresado));
		System.out.println("Multiplicar " + numIngresado + " por su número preferido " + pepito.getNumpreferido() + " = " + pepito.multiplicarPorNumPreferido(numIngresado));
		
		sc.close();
	}

}
