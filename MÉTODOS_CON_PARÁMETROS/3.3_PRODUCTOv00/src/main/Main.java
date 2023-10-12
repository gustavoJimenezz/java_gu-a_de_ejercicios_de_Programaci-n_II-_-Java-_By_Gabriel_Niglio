package main;
import java.util.Scanner;

import model.Producto;

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

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double dineroCliente;
		double porcentajeDescuento = 0;
		double totalProd1;
		double vueltoProd1;
		int cantidadPrimerProducto;
		int cantidadSegundoProducto;
		
		Producto prod1 = new Producto(15, 10, "guantes");
		Producto prod2 = new Producto(10, 15, "gorra");
		
		System.out.println("cuánto dinero efectivo dispone :");
		dineroCliente = sc.nextDouble();
		
		System.out.println("\n");
		System.out.print("Cantidad :");
		cantidadPrimerProducto = sc.nextInt();
		
		if(cantidadPrimerProducto >= 300 ) {
			porcentajeDescuento = 30;
		}else if(cantidadPrimerProducto >= 200 ) {
			porcentajeDescuento = 20;
		}else if(cantidadPrimerProducto >= 100 ) {
			porcentajeDescuento = 10;
		}

		if(porcentajeDescuento != 0 ) {
			totalProd1 = prod1.precioConDescuentoCantidad(porcentajeDescuento, cantidadPrimerProducto);								
		}else {
			totalProd1 = prod1.getPrecio() * cantidadPrimerProducto;	
		}
		
		vueltoProd1 = dineroCliente - totalProd1;
		if (vueltoProd1 <= 0) {
			System.out.println("El cliente no tiene suficiente dinero");
		} else {
			System.out.println("El vuelto es : " + vueltoProd1);
		}
		
		
		System.out.println("\n");
		System.out.print("Cantidad Segundo producto :");
		cantidadSegundoProducto = sc.nextInt();
		
		System.out.println("Ganancia del segundo producto " + prod2.gananciaPorCantidad(cantidadSegundoProducto) + " $ :");
		sc.close();
	}

}
