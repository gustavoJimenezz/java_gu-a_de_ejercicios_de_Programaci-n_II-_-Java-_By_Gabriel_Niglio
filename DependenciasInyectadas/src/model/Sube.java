package model;

public class Sube {
	private int id;
	private double saldo;
	
	public Sube(int id, double saldo) {
		this.id = id;
		this.saldo = saldo;
	}
	
	public int getId() {
		return id;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void modificarSaldo(double variacion) {
		this.saldo += variacion;
	}
}
