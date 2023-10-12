package model;
//Pepe

//Crear la clase Pepe, el mismo tiene que tener un número preferido (Es el 21).
//A Pepe le gusta hacer cálculos y puede recibir un número y retornar el doble del mismo.
//Pepe también puede recibir un número, elevarlo al cuadrado y retornarlo.
//Pepe también puede multiplicar el número que le brinden por su número preferido.
//Realizar un Main donde se ingrese un número por teclado y Pepe pueda presumir todas sus dotes matemáticas. (Mostrar el resultado de todos sus métodos por pantalla).

public class Pepe {
	private int numpreferido = 21;

	public int getNumpreferido() {
		return numpreferido;
	}

	public void setNumpreferido(int numpreferido) {
		this.numpreferido = numpreferido;
	}

	public double calcularDoble(double num) {
		return num * 2;
	}

	public double elevarAlCuadrado(double num) {
		return num * num;
	}

	public double multiplicarPorNumPreferido(double num) {
		return num * this.getNumpreferido();
	}

}
