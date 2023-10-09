package menuDisco;

import java.util.ArrayList;
import java.util.Scanner;

import model.Disco;

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
				this.crearDisco(arrayDiscos, sc);
				break;
			case 2:
				this.mostrarDiscos(arrayDiscos);
				break;
			case 3:
				this.buscarDiscoPorTitulo(arrayDiscos, sc);
				break;
			case 4:
				this.buscarDiscoConMenosPistas(arrayDiscos);
				break;
			case 5:
				this.buscarDiscoConMasPistas(arrayDiscos);
				break;
			case 6:
				this.grupoDiscosPorAutor(arrayDiscos, sc);
				break;
			case 7:
				this.borrarDisco(arrayDiscos, sc);
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

	public void crearDisco(ArrayList<Disco> arrayDiscos, Scanner sc) {
		System.out.print("Titulo ; ");
		String titulo = sc.next();
		System.out.print("Autor ; ");
		String autor = sc.next();
		System.out.print("Numero de pistas ; ");
		int pistas = sc.nextInt();

		Disco nuevoDisco = new Disco(titulo, autor, pistas);
		arrayDiscos.add(nuevoDisco);
	}

	public void borrarDisco(ArrayList<Disco> arrayDiscos, Scanner sc) {
		Disco auxDisc = null;
		System.out.print("Ingrese titulo ; ");
		String tituloBuscado = sc.next();
		
		for (Disco disco : arrayDiscos) {
			String tituloActual = disco.getTitulo();
			if (tituloActual.equals(tituloBuscado)) {
				auxDisc = disco;
			}
		}
		if (auxDisc != null) {
			arrayDiscos.remove(auxDisc);
			System.out.println();
			System.out.println("Disco borrado con exito !");
			System.out.println();
		} else {
			System.out.println();
			System.out.println("No se encotro ningun disco !");
			System.out.println();
		}
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

	public void buscarDiscoPorTitulo(ArrayList<Disco> arrayDiscos, Scanner sc) {
		Disco auxdisc = null;
		System.out.print("Ingrese titulo ; ");
		String tituloBuscado = sc.next();
		for (Disco disco : arrayDiscos) {
			String tituloActual = disco.getTitulo();
			if (tituloActual.equals(tituloBuscado)) {
				auxdisc = disco;
			}
		}
		if (auxdisc != null) {
			this.mostrarDisco(auxdisc);
		} else {
			System.out.println();
			System.out.println("No se encontro el titulo ingresado. ");
			System.out.println();
		}
	}

	public void buscarDiscoConMenosPistas(ArrayList<Disco> arrayDiscos) {
		Disco discAux = null;
		if (this.arrayVacio(arrayDiscos)) {
			discAux = arrayDiscos.get(0);
			for (Disco disco : arrayDiscos) {
				if (disco.getNumeroDePistas() < discAux.getNumeroDePistas()) {
					discAux = disco;
				}
			}
		}
		if (discAux != null) {
			this.mostrarDisco(discAux);
		} else {
			System.out.println();
			System.out.println("No hay discos que mostra !");
			System.out.println();
		}
	}

	public void buscarDiscoConMasPistas(ArrayList<Disco> arrayDiscos) {
		Disco discAux = null;
		if (this.arrayVacio(arrayDiscos)) {
			discAux = arrayDiscos.get(0);
			for (Disco disco : arrayDiscos) {
				if (disco.getNumeroDePistas() > discAux.getNumeroDePistas()) {
					discAux = disco;
				}
			}
		}
		if (discAux != null) {
			this.mostrarDisco(discAux);
			;
		} else {
			System.out.println();
			System.out.println("No hay discos que mostra !");
			System.out.println();
		}
	}

	public void grupoDiscosPorAutor(ArrayList<Disco> arrayDiscos, Scanner sc) {

		System.out.print("Ingrese autor : ");
		String autor = sc.next();
		
		ArrayList<Disco> DiscosDeAutor = new ArrayList<>();
		if (this.arrayVacio(arrayDiscos)) {
			for (Disco disco : arrayDiscos) {
				if (disco.getAutor().equals(autor)) {
					DiscosDeAutor.add(disco);
				}
			}
		}
		if (DiscosDeAutor.size() == 0) {
			this.mostrarDiscos(DiscosDeAutor);
		} else {
			System.out.println();
			System.out.println("No se encotro ningun disco de " + autor);
			System.out.println();
		}
	}
}
