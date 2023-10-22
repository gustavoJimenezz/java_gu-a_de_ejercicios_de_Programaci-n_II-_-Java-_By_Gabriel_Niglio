package main;

import java.util.ArrayList;
import java.util.Scanner;

import menuDisco.MenuDiscos;
import model.Disco;

//cargar
//mostrar
//buscar max/min
//buscar grupo de ..

public class MainDiscos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Disco> arrayDiscos = new ArrayList<>();
		MenuDiscos menuDiscos = new MenuDiscos(sc, arrayDiscos);		
		menuDiscos.iniciar();
		System.out.println("Programa finalizado !\n");
		sc.close();
	}
}
