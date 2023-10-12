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
	private Scanner sc;
	private ArrayList<Disco> arrayDiscos;
	private boolean activo;

	public MenuDiscos(Scanner sc, ArrayList<Disco> arrayDiscos) {
		this.sc = sc;
		this.arrayDiscos = arrayDiscos;
		this.activo = true;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void finalizar() {
		this.activo = false;
	}

	public Scanner getSc() {
		return sc;
	}

	public ArrayList<Disco> getArrayDiscos() {
		return arrayDiscos;
	}

	public int menuPrincipal(Scanner sc) {
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

	public void iniciar() {

		while (this.isActivo()) {
			int opcionElegida = this.menuPrincipal(sc);
			switch (opcionElegida) {
			case 1:
				this.crearDisco();
				break;
			case 2:
				this.mostrarDiscos();
				break;
			case 3:
				this.buscarDiscoPorTitulo();
				break;
			case 4:
				this.buscarDiscoConMenosPistas();
				break;
			case 5:
				this.buscarDiscoConMasPistas();
				break;
			case 6:
				this.grupoDiscosPorAutor();
				break;
			case 7:
				this.borrarDisco();
				break;
			case 0:
				System.out.print("¿Desea salir? (Sí/No) : ");
				String salir = this.getSc().next();
				if (salir.equalsIgnoreCase("si")) {
					System.out.println("\nHasta pronto!\n");
					this.finalizar();
				}
				break;
			default:
				System.out.println("\nOpcion incorrecta!\n");
				break;
			}

		}
	}

	public void crearDisco() {
		System.out.print("Titulo ; ");
		String titulo = this.getSc().next();
		System.out.print("Autor ; ");
		String autor = this.getSc().next();
		System.out.print("Numero de pistas ; ");
		int pistas = this.getSc().nextInt();

		Disco nuevoDisco = new Disco(titulo, autor, pistas);
		this.getArrayDiscos().add(nuevoDisco);
	}

	public void mostrarDisco(Disco discoActual) {
		System.out.println();
		System.out.println("Titulo : " + discoActual.getTitulo());
		System.out.println("Autor : " + discoActual.getAutor());
		System.out.println("Numero de pistas : " + discoActual.getNumeroDePistas());
		System.out.println();
	}

	public void mostrarDiscos() {
		this.mostrarArrayDeDiscos(this.getArrayDiscos());
	}

	public void buscarDiscoPorTitulo() {
		Disco auxDisc = null;
		System.out.print("Ingrese titulo ; ");
		String tituloABuscar = this.getSc().next();

		if (!this.noHayDiscosQueMostrar(this.getArrayDiscos())) {
			for (Disco disco : this.getArrayDiscos()) {
				String tituloActual = disco.getTitulo();
				if (tituloActual.equals(tituloABuscar)) {
					auxDisc = disco;
				}
			}

			if (!this.noHayDiscoQueMostrar(auxDisc)) {
				this.mostrarDisco(auxDisc);
			}
		}
	}

	public void buscarDiscoConMenosPistas() {

		Disco auxDisc = null;
		if (!this.noHayDiscosQueMostrar(this.getArrayDiscos())) {
			auxDisc = this.getArrayDiscos().get(0);
			for (Disco disco : this.getArrayDiscos()) {
				if (disco.getNumeroDePistas() < auxDisc.getNumeroDePistas()) {
					auxDisc = disco;
				}
			}
			
			this.mostrarDisco(auxDisc);
		}
	}

	public void buscarDiscoConMasPistas() {

		if (!this.noHayDiscosQueMostrar(this.getArrayDiscos())) {
			Disco auxDisc = null;
			auxDisc = this.getArrayDiscos().get(0);
			for (Disco disco : this.getArrayDiscos()) {
				if (disco.getNumeroDePistas() > auxDisc.getNumeroDePistas()) {
					auxDisc = disco;
				}
			}
			this.mostrarDisco(auxDisc);
		}
	}

	public void grupoDiscosPorAutor() {

		if (!this.noHayDiscosQueMostrar(this.getArrayDiscos())) {
			System.out.print("Ingrese autor : ");
			String autor = this.getSc().next();
			ArrayList<Disco> discosDeAutor = new ArrayList<>();

			for (Disco disco : this.getArrayDiscos()) {
				if (disco.getAutor().equals(autor)) {
					discosDeAutor.add(disco);
				}
			}
			if (!this.noHayDiscosQueMostrar(this.getArrayDiscos())) {
				this.mostrarArrayDeDiscos(discosDeAutor);
			}
		}
	}

	public void borrarDisco() {

		if (!this.noHayDiscosQueMostrar(this.getArrayDiscos())) {
			Disco auxDisc = null;
			System.out.print("Ingrese titulo ; ");
			String tituloBuscado = this.getSc().next();

			for (Disco disco : this.getArrayDiscos()) {
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

	public void mostrarArrayDeDiscos(ArrayList<Disco> arrayDiscos) {
		if (!this.noHayDiscosQueMostrar(arrayDiscos)) {
			for (Disco disco : arrayDiscos) {
				this.mostrarDisco(disco);
			}
		}
	}

	private boolean noHayDiscosQueMostrar(ArrayList<Disco> arrayDiscos) {
		boolean noHayDiscos = false;
		if (arrayDiscos.size() == 0) {
			System.out.println("\nNo se encontraron Discos!\n");
			noHayDiscos = true;
		}
		return noHayDiscos;
	}

	private boolean noHayDiscoQueMostrar(Disco discAux) {
		boolean discoNull = false;
		if (discAux == null) {
			System.out.println("\nNo hay disco que mostrar!\n");
			discoNull = true;
		}
		return discoNull;
	}
}
