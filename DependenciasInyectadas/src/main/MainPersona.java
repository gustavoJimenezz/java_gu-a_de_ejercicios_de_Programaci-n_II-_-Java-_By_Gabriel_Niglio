package main;

import java.util.Scanner;
import model.Persona;
import model.Sube;

//math
//collecciones
//menu
//25 examen
//cargar
//mostrar
//buscar max min
//buscar grupo de ..
//criterio especifico 
//inyeccion de dependencia constructor/set
//objetos anidados

public class MainPersona {
	public static void main(String[] args) {
		Sube s1 = new Sube(2467, 30.0);
		Scanner celular = new Scanner(System.in);
		
		Persona pepe = new Persona("Pepe", 30, s1, celular);
		Persona mari = new Persona("Mari", 28, s1, celular);
		
		pepe.getMiSube().modificarSaldo(500);
		
		System.out.println("saldo de Mari" + mari.getMiSube().getSaldo());
		
		pepe.preguntarEstadoDeAnimo();
		
	}
//	crear sube 2 personas 
//	descontar sube
	
}
