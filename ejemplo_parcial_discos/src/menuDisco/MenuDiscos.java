package menuDisco;

import java.util.ArrayList;
import java.util.ListIterator;
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


	public int menuPrincipal() {
		System.out.println("** Biblioteca de discos **");
		System.out.println("1 - Agregar nuevo Disco");
		System.out.println("2 - mostrar discos");
		System.out.println("3 - Buscar disco por titulo");
		System.out.println("4 - Disco con menos pistas");
		System.out.println("5 - Disco con mas pistas");
		System.out.println("6 - Grupo de discos por autor");
		System.out.println("7 - Borrar disco");
		System.out.println("0 - Salir");
		int opcionElegida = this.obtenerIntValido("Ingrese : ");
		return opcionElegida;
	}

	public void iniciar() {

		while (this.isActivo()) {
			int opcionElegida = this.menuPrincipal();
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
				this.mostrarDiscosPorAutor();
				break;
			case 7:
				this.borrarDisco();
				break;
			case 0:
				this.salir();
				break;
			default:
				System.out.println("\nOpcion incorrecta!\n");
				break;
			}

		}
	}

	public void crearDisco() {
		System.out.print("Titulo ; ");
		String titulo = this.sc.next();
		System.out.print("Autor ; ");
		String autor = this.sc.next();
		int pistas = this.obtenerIntValido("Cantida de pistas ; ");

		Disco nuevoDisco = new Disco(titulo, autor, pistas);
		this.arrayDiscos.add(nuevoDisco);			

	}
	
//    public int obtenerIntValido(String mensaje) {
//    	System.out.print(mensaje);
//    	this.sc.nextLine();
//    	return !this.sc.hasNextInt()?this.sc.nextInt():0;
//    }
    public int obtenerIntValido(String mensaje) {
        int numero;
        System.out.print(mensaje);
        this.sc.nextLine();
        while (!this.sc.hasNextInt()) {
            System.out.print("Error." + mensaje);
            this.sc.nextLine(); // Limpiar el búfer de entrada
        }

        numero = this.sc.nextInt();
        return numero;
    }

	public void mostrarDisco(Disco discoActual) {
		if(!(discoActual == null)) {			
			System.out.println(discoActual);
		}else {
			System.out.println("\nDisco null ! \n");
		}
	}

	public void mostrarDiscos() {
		if (!this.arrayVacioONull(arrayDiscos)) {
			for (Disco disco : arrayDiscos) {
				this.mostrarDisco(disco);
			}
		}
	}

	public void buscarDiscoPorTitulo() {
		if (!this.arrayVacioONull(this.arrayDiscos)) {
			boolean noSeEncontraronDiscos = true;
			System.out.print("Ingrese titulo ; ");
			String tituloABuscar = this.sc.next();

			for (Disco disco : this.arrayDiscos) {
				String tituloActual = disco.getTitulo();
				if (tituloActual.equals(tituloABuscar)) {
					this.mostrarDisco(disco);
					noSeEncontraronDiscos = false;
				}
			}
			if(noSeEncontraronDiscos)
				System.out.println("\nNo se encontreron discos de del titulo " + tituloABuscar + "\n");
		}
	}

	public void buscarDiscoConMenosPistas() {

		if (!this.arrayVacioONull(this.arrayDiscos)) {
			Disco auxDisc = null;
			for (Disco disco : this.arrayDiscos) {
				if (auxDisc == null || disco.getNumeroDePistas() < auxDisc.getNumeroDePistas()) {
					auxDisc = disco;
				}
			}
			this.mostrarDisco(auxDisc);
		}
	}

	public void buscarDiscoConMasPistas() {

		if (!this.arrayVacioONull(this.arrayDiscos)) {
			Disco auxDisc = null;
			for (Disco disco : this.arrayDiscos) {
				if (auxDisc == null || disco.getNumeroDePistas() > auxDisc.getNumeroDePistas()) {
					auxDisc = disco;
				}
			}
			this.mostrarDisco(auxDisc);
		}
	}

	public void mostrarDiscosPorAutor() {

		if (!this.arrayVacioONull(this.arrayDiscos)) {
			boolean noSeEncontraronDiscos = true;
			System.out.print("Ingrese autor : ");
			String autor = this.sc.next();

			for (Disco disco : this.arrayDiscos) {
				if (disco.getAutor().equals(autor)) {
					this.mostrarDisco(disco);
					noSeEncontraronDiscos = false;
				}
			}
			if(noSeEncontraronDiscos)
				System.out.println("No se encontraron discos");
			
		}
	}

	public void borrarDisco() {

		if (!this.arrayVacioONull(this.arrayDiscos)) {
			boolean noSeEncontraronDiscos = true;
			System.out.print("Ingrese titulo ; ");
			String tituloBuscado = this.sc.next();
			
			ListIterator<Disco> iterador = this.arrayDiscos.listIterator();
			while(iterador.hasNext()) {
				Disco discoActual = iterador.next();
				if (discoActual.getTitulo().equals(tituloBuscado)) {
					iterador.remove();
					System.out.println("\nDisco borrado con exito !\n");
					noSeEncontraronDiscos = false;
				}
				
			}
			if(noSeEncontraronDiscos)
				System.out.println("\nNo se encontro el disco de titulo "+ tituloBuscado +"\n");
		}
	}
	
	public void salir() {
		System.out.print("¿Desea salir? (Sí/No) : ");
		String salir = this.sc.next();
		if (salir.equalsIgnoreCase("si")) {
			System.out.println("\nHasta pronto!\n");
			this.finalizar();
		}
	}
	
	private boolean arrayVacioONull(ArrayList<Disco> arrayDiscos) {
		boolean vacioONull = false;
		if(arrayDiscos == null) {
			System.out.println("\nArray de discos - null\n");
			vacioONull = true;			
		}else if(arrayDiscos.isEmpty()) {			
			System.out.println("\nArray de discos - vacio\n");
			vacioONull = true;
		}

		return vacioONull;
	}
}
