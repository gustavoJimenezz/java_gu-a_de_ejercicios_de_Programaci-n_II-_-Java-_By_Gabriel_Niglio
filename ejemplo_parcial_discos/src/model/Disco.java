package model;
import java.util.Objects;

public class Disco {
	private String titulo;
	private String autor;
	private int numeroDePistas;

	public Disco(String titulo, String autor, int numeroDePistas) {
		this.titulo = titulo;
		this.autor = autor;
		this.numeroDePistas = numeroDePistas;
	}
	
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public int getNumeroDePistas() {
		return numeroDePistas;
	}

	public void setNumeroDePistas(int numeroDePistas) {
		this.numeroDePistas = numeroDePistas;
	}
	
	@Override
	public String toString() {
		return  " \n" + 
				"Titulo : " + this.titulo + " \n" + 
				"Autor : " + this.autor + "\n" + 
				"Numero de piestas : " + numeroDePistas
				 + " \n";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
//			aca compara que sea la misma instancia
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
//			valida si es una instancia del mismo objeto
			return false;
		
		Disco other = (Disco) obj;
		
		return Objects.equals(this.autor, other.getAutor()) &&
				Objects.equals(this.titulo, other.getTitulo()) && // compara que el atributo patente sean iguales
				this.numeroDePistas == other.getNumeroDePistas(); // compara los doubles
	}
	
}
