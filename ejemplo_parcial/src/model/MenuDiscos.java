package model;

import java.util.ArrayList;
import java.util.Scanner;

//cargar
//mostrar
//buscar max min
//buscar grupo de ..

public class MenuDiscos {
	public void menuPrincipal(Scanner sc, ArrayList<Disco> arrayDiscos) {
		boolean seguir = true;
		while(seguir) {
			System.out.println("** Biblioteca de discos **");
			System.out.println("1 - Agregar nuevo Disco");
			System.out.println("2 - mostrar discos");
			System.out.println("3 - buscar disco por titulo");
			System.out.println("4 - Disco con menos pistas");
			System.out.println("5 - Disco con mas pistas");
			System.out.println("6 - Grupo de discos por autor");
			System.out.println("0 - salir");
			System.out.print("Ingrese : ");
			int opcionElegida = sc.nextInt();
			
			if(opcionElegida == 1) {
				Disco nuevodisco = this.crearDisco(sc);
				arrayDiscos.add(nuevodisco);

			}else if(opcionElegida == 2) {
				this.mostrarDiscos(arrayDiscos);

			}else if(opcionElegida == 3) {
				System.out.print("Ingrese Titulo a buscar : ");
				String tituloBuscado = sc.next();
				if(!this.buscarDisco(arrayDiscos, tituloBuscado)) {
					System.out.println("No se encontro el titulo ingresado. ");
				}
			}else if(opcionElegida == 4) {
				Disco discoConMenosPistas = this.buscarDiscoConMenosPistas(arrayDiscos);
				this.mostrarDisco(discoConMenosPistas);
				
			}else if(opcionElegida == 5) {
				Disco discoConMasPistas = this.buscarDiscoConMasPistas(arrayDiscos);
				this.mostrarDisco(discoConMasPistas);
				
			}else if(opcionElegida == 6) {
				System.out.print("Ingrese autor : ");
				String autor = sc.next();
				ArrayList<Disco> DiscosDeAutor = this.grupoDiscosPorAutor(arrayDiscos, autor);
				this.mostrarDiscos(DiscosDeAutor);
				
			}else if(opcionElegida == 0) {
				seguir = false;
			}
		}
	}

	public Disco crearDisco(Scanner sc) {
		System.out.print("Titulo ; ");
		String titulo = sc.next();
		System.out.print("Autor ; ");
		String autor = sc.next();
		System.out.print("Numero de pistas ; ");
		int pistas = sc.nextInt();

		Disco nuevoDisco = new Disco(titulo, autor, pistas);
		return nuevoDisco;
	}

	public void mostrarDisco(Disco discoActual) {
		System.out.println("Titulo : " + discoActual.getTitulo());
		System.out.println("Autor : " + discoActual.getAutor());
		System.out.println("Numero de pistas : " + discoActual.getNumeroDePistas());
	}

	public void mostrarDiscos(ArrayList<Disco> arrayDiscos) {
		if(arrayDiscos.size() <= 0) {
			
			for (Disco disco : arrayDiscos) {
				this.mostrarDisco(disco);
			}
		}else {
			System.out.println("Sin discos para mostrar !");
		}
	}
	
	public boolean buscarDisco(ArrayList<Disco> arrayDiscos, String tituloBuscado) {
		boolean seEncontro = false;
		for (Disco disco : arrayDiscos) {
			String tituloActual = disco.getTitulo();
			if(tituloActual.equals(tituloBuscado)) {				
				this.mostrarDisco(disco);
				seEncontro = true;
			}
		}
		return seEncontro;
	}
	
	public Disco buscarDiscoConMenosPistas(ArrayList<Disco> arrayDiscos) {
		Disco discAux = arrayDiscos.get(0);
		for (Disco disco : arrayDiscos) {
			if(disco.getNumeroDePistas() < discAux.getNumeroDePistas() ) {
				discAux = disco;
			}
		}
		return discAux;
	}
	
	public Disco buscarDiscoConMasPistas(ArrayList<Disco> arrayDiscos) {
		Disco discAux = arrayDiscos.get(0);
		for (Disco disco : arrayDiscos) {
			if(disco.getNumeroDePistas() > discAux.getNumeroDePistas() ) {
				discAux = disco;
			}
		}
		return discAux;
	}
	
	public ArrayList<Disco> grupoDiscosPorAutor(ArrayList<Disco> arrayDiscos, String autor){
		ArrayList<Disco> DiscosDeAutor = new ArrayList<>();
		for (Disco disco : arrayDiscos) {
			if(disco.getAutor().equals(autor)) {
				DiscosDeAutor.add(disco);
			}
		}
		return DiscosDeAutor;
	}
}
