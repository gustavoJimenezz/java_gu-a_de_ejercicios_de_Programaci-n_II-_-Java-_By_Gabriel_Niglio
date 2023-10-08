package model;

public class Disco {
	private String titulo;
	private String autor;
	private int numeroDePistas;
//	private String[] listaCanciones;

	public Disco(String titulo, String autor, int numeroDePistas) {
		this.titulo = titulo;
		this.autor = autor;
		this.numeroDePistas = numeroDePistas;
//		this.listaCanciones = listaCanciones;
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
	
}
