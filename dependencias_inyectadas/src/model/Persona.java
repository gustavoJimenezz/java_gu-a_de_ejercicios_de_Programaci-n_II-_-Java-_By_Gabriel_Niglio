package model;
import java.util.Scanner;

public class Persona {
	private String nombre;
	private int edad;
	private Rinion miRinion;
	private Sube miSube;
	private Scanner sc;
	
	public Persona(String nombre, int edad, Sube miSube, Scanner sc) {
		this.nombre = nombre;
		this.edad = edad;
		this.miRinion = new Rinion(this.getEdad());
		this.miSube = miSube;
		this.sc = sc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public Rinion getMiRinion() {
		return miRinion;
	}
	public void setMiRinion(Rinion miRinion) {
		this.miRinion = miRinion;
	}
	public Sube getMiSube() {
		return miSube;
	}
	public void setMiSube(Sube miSube) {
		this.miSube = miSube;
	}
	public Scanner getSc() {
		return this.sc;
	}
	
	public void preguntarEstadoDeAnimo() {
		String estado;
		System.out.println("Hola " + this.getNombre());
		System.out.print("Como te sentis hoy? : ");
		estado = this.getSc().next();
		System.out.println(this.getNombre() + " Tu estado de animo " + "\"" + estado + "\"");
		System.out.println("Espero que manejes bien tu estado de animo !");
	}
}
