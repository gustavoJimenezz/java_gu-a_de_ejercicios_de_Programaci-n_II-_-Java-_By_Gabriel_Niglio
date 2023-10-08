package model;

import java.util.ArrayList;
import java.util.Scanner;

//cargar
//mostrar
//buscar
//max/min
//buscar grupo de ..
//eliminar

public class MenuDiscos {
	public int opciones(Scanner sc) {
		System.out.println("** Biblioteca de discos **");
		System.out.println("1 - Agregar nuevo Disco");
		System.out.println("2 - mostrar discos");
		System.out.println("3 - buscar disco por titulo");
		System.out.println("4 - Disco con menos pistas");
		System.out.println("5 - Disco con mas pistas");
		System.out.println("6 - Grupo de discos por autor");
		System.out.println("7 - Eliminar disco");
		System.out.println("0 - salir");
		System.out.print("Ingrese : ");
		int opcionElegida = sc.nextInt();
		return opcionElegida;
	}

	public void menuPrincipal(Scanner sc, ArrayList<Disco> arrayDiscos) {
		boolean seguir = true;
		while (seguir) {
			int opcionElegida = this.opciones(sc);
			switch (opcionElegida) {
			case 1:
				Disco nuevodisco = this.crearDisco(sc);
				arrayDiscos.add(nuevodisco);
				break;
			case 2:
				this.mostrarDiscos(arrayDiscos);
				break;
			case 3:
				Disco discoABuscar = this.buscarDiscoPorTitulo(arrayDiscos, sc);
				if (discoABuscar != null) {
					this.mostrarDisco(discoABuscar);
				} else {
					System.out.println();
					System.out.println("No se encontro el titulo ingresado. ");
					System.out.println();
				}
				break;
			case 4:
				Disco discoConMenosPistas = this.buscarDiscoConMenosPistas(arrayDiscos);
				if (discoConMenosPistas != null) {
					this.mostrarDisco(discoConMenosPistas);
				} else {
					System.out.println();
					System.out.println("No hay discos que mostra !");
					System.out.println();
				}
				break;
			case 5:
				Disco discoConMasPistas = this.buscarDiscoConMasPistas(arrayDiscos);
				if (discoConMasPistas != null) {
					this.mostrarDisco(discoConMasPistas);
					;
				} else {
					System.out.println();
					System.out.println("No hay discos que mostra !");
					System.out.println();
				}
				break;
			case 6:
				System.out.print("Ingrese autor : ");
				String autor = sc.next();
				ArrayList<Disco> DiscosDeAutor = this.grupoDiscosPorAutor(arrayDiscos, autor);
				if (DiscosDeAutor != null) {
					this.mostrarDiscos(DiscosDeAutor);
				} else {
					System.out.println();
					System.out.println("No se encotro ningun disco de " + autor);
					System.out.println();
				}
				break;
			case 7:
				if (this.borrarDisco(arrayDiscos, sc)) {
					System.out.println();
					System.out.println("Disco borrado con exito !");
					System.out.println();
				} else {
					System.out.println();
					System.out.println("No se encotro ningun disco !");
					System.out.println();
				}
				break;
			case 0:
				seguir = false;
				System.out.println("Hasta pronto !");
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
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

	public boolean borrarDisco(ArrayList<Disco> arrayDiscos, Scanner sc) {
		boolean discoBorrado = false;
		Disco auxDisc = this.buscarDiscoPorTitulo(arrayDiscos, sc);
		if (auxDisc != null) {
			arrayDiscos.remove(auxDisc);
			discoBorrado = true;
		}
		return discoBorrado;
	}

	public void mostrarDisco(Disco discoActual) {
		System.out.println();
		System.out.println("Titulo : " + discoActual.getTitulo());
		System.out.println("Autor : " + discoActual.getAutor());
		System.out.println("Numero de pistas : " + discoActual.getNumeroDePistas());
		System.out.println();
	}

	public void mostrarDiscos(ArrayList<Disco> arrayDiscos) {

		if (this.arrayVacio(arrayDiscos)) {
			for (Disco disco : arrayDiscos) {
				System.out.println();
				this.mostrarDisco(disco);
				System.out.println();
			}
		} else {
			System.out.println();
			System.out.println("No hay discos que mostra !");
			System.out.println();
		}

	}

	public boolean arrayVacio(ArrayList<Disco> arrayDiscos) {
		return arrayDiscos.size() > 0;
	}

	public Disco buscarDiscoPorTitulo(ArrayList<Disco> arrayDiscos, Scanner sc) {
//		Si no encuentra el disco devuelve null
		Disco auxdisc = null;
		System.out.print("Ingrese titulo ; ");
		String tituloBuscado = sc.next();
		for (Disco disco : arrayDiscos) {
			String tituloActual = disco.getTitulo();
			if (tituloActual.equals(tituloBuscado)) {
				auxdisc = disco;
			}
		}
		return auxdisc;
	}

	public Disco buscarDiscoConMenosPistas(ArrayList<Disco> arrayDiscos) {
//		si el ArrayList esta vacio devulve null
		Disco discAux = null;
		if (this.arrayVacio(arrayDiscos)) {
			discAux = arrayDiscos.get(0);
			for (Disco disco : arrayDiscos) {
				if (disco.getNumeroDePistas() < discAux.getNumeroDePistas()) {
					discAux = disco;
				}
			}
		}
		return discAux;
	}

	public Disco buscarDiscoConMasPistas(ArrayList<Disco> arrayDiscos) {
//		si el ArrayList esta vacio devulve null
		Disco discAux = null;
		if (this.arrayVacio(arrayDiscos)) {
			discAux = arrayDiscos.get(0);
			for (Disco disco : arrayDiscos) {
				if (disco.getNumeroDePistas() > discAux.getNumeroDePistas()) {
					discAux = disco;
				}
			}
		}
		return discAux;
	}

	public ArrayList<Disco> grupoDiscosPorAutor(ArrayList<Disco> arrayDiscos, String autor) {
//		si no hay un disco del autor devuelve null
		ArrayList<Disco> DiscosDeAutor = new ArrayList<>();
		if (this.arrayVacio(arrayDiscos)) {
			for (Disco disco : arrayDiscos) {
				if (disco.getAutor().equals(autor)) {
					DiscosDeAutor.add(disco);
				}
			}
		}
		if (DiscosDeAutor.size() == 0) {
			DiscosDeAutor = null;
		}

		return DiscosDeAutor;
	}
}
