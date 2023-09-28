package menu.ingredientes;

import java.util.Scanner;

import ingredientes.Ingrediente;

//crear y agregar metodo
//mostrar
public class menuIngredientes {
	public void mostrar(Ingrediente ingredienteActual) {
		char unidadDeMedida = ingredienteActual.getUnidad();
		System.out.println("Nombre : " + ingredienteActual.getNombre());
		System.out.println("Unidad : " + this.unidadDeMedidaCompleta(unidadDeMedida));
		System.out.println("porcion : " + ingredienteActual.getPorcion());
	}
	
	public String unidadDeMedidaCompleta(char unidad) {
		String medidaCompleta = " ";
		if(unidad == 'K') {
			medidaCompleta = "Kilo";
		}else if(unidad == 'G') {
			medidaCompleta = "Gramo";
		}else if(unidad == 'L') {
			medidaCompleta = "Litro";
		}
		return medidaCompleta;
	}
	
	public Ingrediente crearIngrediente(Scanner sc) {
		System.out.print("Ingrese nombre ;");
		String nombre = sc.next();
		System.out.print("Ingrese unidad (K,G,L) ;");
		char unidad = sc.next().charAt(0);
		char unidadMayus = Character.toUpperCase(unidad);
		System.out.print("Ingrese porcion ;");
		double porcion = sc.nextDouble();
		Ingrediente nuevoIngrediente = new Ingrediente(nombre, unidadMayus, porcion);
		return nuevoIngrediente;
	}
}
