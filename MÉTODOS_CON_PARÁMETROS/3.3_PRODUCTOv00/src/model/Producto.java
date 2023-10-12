//PRODUCTO

//Generar una clase Producto que tenga precio, costo y nombre.
//Generar un método para calcular la ganancia unitaria.
//Generar un método que reciba una cantidad de unidades y retorne cuanto se ganaría si se
//vendiera esa cantidad.
//Generar un método que reciba un porcentaje de descuento y retorne cuanto saldría el
//producto si se le aplicara ese descuento.
//Generar un método que reciba un descuento y una cantidad de unidades y retorne cuanto le
//costaría al cliente comprar dicha cantidad aplicando el descuento.

//Realizar un programa donde se carguen dos productos, luego se ingrese cuánto dinero en
//efectivo dispone el cliente. Una vez hecho esto, que se elija la cantidad que va a comprar del
//primer producto (el mismo recibe un descuento del 10% por cada 100 unidades compradas
//(Con un máximo del 30%).
//Si el cliente tiene el dinero suficiente mostrar cuanto le sobrará después de la compra, en caso
//contrario mostrar un mensaje que diga “El cliente no tiene suficiente dinero”.
//Luego el cliente selecciona la cantidad que va a comprar del segundo producto (pero esta vez
//con tarjeta de crédito, por ende no se debe validar si tiene suficiente efectivo), una vez cargada
//la cantidad se tiene que mostrar cuanto ganó la tienda por esta última venta.
package model;

public class Producto {

	private double precio;
	private double costo;
	private String nombre;
	
	public Producto(double precio, double costo, String nombre){
		this.precio = precio;
		this.costo = costo;
		this.nombre = nombre;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double gananciaUnitaria() {
//	Generar un método para calcular la ganancia unitaria.
		return this.precio - this.costo;
	}

	public double gananciaPorCantidad(int cantidad) {
//		Generar un método que reciba una cantidad de unidades y retorne cuanto se ganaría si se
//		vendiera esa cantidad.
		return this.gananciaUnitaria() * cantidad;
	}

	public double precioConDescuento(double porcentajeDescuento) {
//	Generar un método que reciba un porcentaje de descuento y retorne cuanto saldría el
//	producto si se le aplicara ese descuento.
		return this.getPrecio() * (porcentajeDescuento / 100.0);
	}

	public double precioConDescuentoCantidad(double porcentajeDescuento, int unidades) {
//	Generar un método que reciba un descuento y una cantidad de unidades y retorne cuanto le
//	costaría al cliente comprar dicha cantidad aplicando el descuento.
		return this.precioConDescuento(porcentajeDescuento) * unidades;
	}

}
