package modelo;


import java.util.Scanner;

import contenedor.ingredientes.ContenedorIngrediente;
import ingredientes.Ingrediente;
import menu.ingredientes.menuIngredientes;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		menuIngredientes miMenu = new menuIngredientes();
		ContenedorIngrediente misIngredientes = new ContenedorIngrediente(20);
		
		Ingrediente ing1 = miMenu.crearIngrediente(sc);
		Ingrediente ing2 = miMenu.crearIngrediente(sc);
		Ingrediente ing3 = miMenu.crearIngrediente(sc);
		
		misIngredientes.add(ing1);
		misIngredientes.add(ing2);
		misIngredientes.add(ing3);
		
		for (int i = 0; i < misIngredientes.getIndice(); i++) {
			miMenu.mostrar(misIngredientes.getByPosicion(i));
		}
	}

}
