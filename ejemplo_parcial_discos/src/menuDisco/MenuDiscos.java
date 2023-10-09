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
		System.out.println("3 - Buscar disco por titulo");
		System.out.println("4 - Disco con menos pistas");
		System.out.println("5 - Disco con mas pistas");
		System.out.println("6 - Grupo de discos por autor");
		System.out.println("7 - Borrar disco");
		System.out.println("0 - Salir");
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
				System.out.println("\nHasta pronto!\n");
				seguir = false;
				break;
			default:
				System.out.println("\nOpcion incorrecta!\n");
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

	public void mostrarDisco(Disco discoActual) {
		System.out.println();
		System.out.println("Titulo : " + discoActual.getTitulo());
		System.out.println("Autor : " + discoActual.getAutor());
		System.out.println("Numero de pistas : " + discoActual.getNumeroDePistas());
		System.out.println();
	}

	public void mostrarDiscos(ArrayList<Disco> arrayDiscos) {
		if(!this.noHayDiscosQueMostrar(arrayDiscos)) {			
			for (Disco disco : arrayDiscos) {
				this.mostrarDisco(disco);
			}
		}
	}
	

	public void buscarDiscoPorTitulo(ArrayList<Disco> arrayDiscos, Scanner sc) {
		Disco auxdisc = null;
		System.out.print("Ingrese titulo ; ");
		String tituloBuscado = sc.next();
		if (!this.noHayDiscosQueMostrar(arrayDiscos)) {	
			for (Disco disco : arrayDiscos) {
				String tituloActual = disco.getTitulo();
				if (tituloActual.equals(tituloBuscado)) {
					auxdisc = disco;
				}
			}
	
			if (!this.noHayDiscoQueMostrar(auxdisc)) {
				this.mostrarDisco(auxdisc);
			}
		}
	}

	public void buscarDiscoConMenosPistas(ArrayList<Disco> arrayDiscos) {
		Disco auxdisc = null;
		if (!this.noHayDiscosQueMostrar(arrayDiscos)) {
			auxdisc = arrayDiscos.get(0);
			for (Disco disco : arrayDiscos) {
				if (disco.getNumeroDePistas() < auxdisc.getNumeroDePistas()) {
					auxdisc = disco;
				}
			}
			if (!this.noHayDiscoQueMostrar(auxdisc)) {
				this.mostrarDisco(auxdisc);
			}
		}
		
	}

	public void buscarDiscoConMasPistas(ArrayList<Disco> arrayDiscos) {
		Disco auxdisc = null;
		if (!this.noHayDiscosQueMostrar(arrayDiscos)) {
			auxdisc = arrayDiscos.get(0);
			for (Disco disco : arrayDiscos) {
				if (disco.getNumeroDePistas() > auxdisc.getNumeroDePistas()) {
					auxdisc = disco;
				}
			}
			if (!this.noHayDiscoQueMostrar(auxdisc)) {
				this.mostrarDisco(auxdisc);
			}
		}
	}

	public void grupoDiscosPorAutor(ArrayList<Disco> arrayDiscos, Scanner sc) {

		System.out.print("Ingrese autor : ");
		String autor = sc.next();
		
		ArrayList<Disco> DiscosDeAutor = new ArrayList<>();
		if (!this.noHayDiscosQueMostrar(arrayDiscos)) {
			for (Disco disco : arrayDiscos) {
				if (disco.getAutor().equals(autor)) {
					DiscosDeAutor.add(disco);
				}
			}
			if (!this.noHayDiscosQueMostrar(arrayDiscos)) {
				this.mostrarDiscos(DiscosDeAutor);
			}
		}
	}
	
	public void borrarDisco(ArrayList<Disco> arrayDiscos, Scanner sc) {
		Disco auxDisc = null;
		System.out.print("Ingrese titulo ; ");
		String tituloBuscado = sc.next();
		if (!this.noHayDiscosQueMostrar(arrayDiscos)) {
			for (Disco disco : arrayDiscos) {
				String tituloActual = disco.getTitulo();
				if (tituloActual.equals(tituloBuscado)) {
					auxDisc = disco;
				}
			}
			if (!this.noHayDiscoQueMostrar(auxDisc)) {
				arrayDiscos.remove(auxDisc);
				System.out.println("\nDisco borrado con exito !\n");
			}
		}
	}
	
	private boolean noHayDiscosQueMostrar(ArrayList<Disco> arrayDiscos) {
		boolean noHayDiscos = false;
		if(arrayDiscos.size() == 0) {
			System.out.println("\nNo se encontraron Discos!\n");
			noHayDiscos = true;
		}
		return noHayDiscos;
	}
	
	private boolean noHayDiscoQueMostrar(Disco discAux) {
		boolean discoNull = false;
		if(discAux == null) {
			System.out.println("\nNo hay disco que mostrar!\n");
			discoNull = true;
		}
		return discoNull;
	}
}
