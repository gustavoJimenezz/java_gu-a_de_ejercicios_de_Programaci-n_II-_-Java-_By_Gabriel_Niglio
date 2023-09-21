import java.util.Scanner;
import java.util.ArrayList;

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

//		seleccionar producto
//		ingresar cantidad
//		ingresar dinero si es efectivo
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Producto prod1 = new Producto(15, 10, "guantes");
		Producto prod2 = new Producto(10, 15, "gorra");
		ArrayList<Venta> carrito = new ArrayList<Venta>();
		
		double total = 0;
		double porcentajeDescuento = 0;
		double dineroCliente = 0;
		int cantidadCompras;
		int cantidadProductos; 
		int opcionTipoPago = 0;
		int opcionProducto = 0;

		
		System.out.print("Cuantas compras desea realizar? : ");
		cantidadCompras = sc.nextInt();
		
		for (int i = 0; i < cantidadCompras ; i++) {
//			VENTA
			Venta ventaActual = new Venta();
			System.out.println("** Metodo de pago producto " + (i + 1) + "**");
			System.out.println("1 - Efectivo");
			System.out.println("2 - Tarjeta");
			System.out.print("Seleccione :");
			opcionTipoPago = sc.nextInt();

			if (opcionTipoPago == 1) {
				ventaActual.setTipoDePago(Venta.EFECTIVO);
			} else {
				ventaActual.setTipoDePago(Venta.TARJETA);
			}
			
			System.out.println("\n");
			System.out.println("** Seleccione Producto **");
			System.out.println("1 - " + prod1.getNombre() + " " + prod1.getPrecio() + " $");
			System.out.println("2 - " + prod2.getNombre() + " " + prod2.getPrecio() + " $");
			System.out.print("Seleccione :");
			opcionProducto = sc.nextInt();
			
			if (opcionProducto == 1) {
				ventaActual.setProductoActual(prod1);
			} else {
				ventaActual.setProductoActual(prod2);
			}
			
			System.out.println("\n");
			System.out.print("Cantidad :");
			cantidadProductos = sc.nextInt();
			ventaActual.setCantidad(cantidadProductos);
			
//			COBRO
			Producto auxProd = ventaActual.getProductoActual();
			porcentajeDescuento = ventaActual.calcularPorcentajeDeDescuento(cantidadProductos);
			if(porcentajeDescuento != 0 ) {
				total = auxProd.precioConDescuentoCantidad(porcentajeDescuento, cantidadProductos);								
			}else {
				total = auxProd.precioSinDescuentoCantidad(cantidadProductos);	
			}
			ventaActual.setTotal(total);
			
			if(ventaActual.getTipoDePago() == Venta.EFECTIVO) {
				System.out.print("Cuanto dinero dispone?   : ");
				dineroCliente = sc.nextDouble();
				ventaActual.pagoEfectivo(dineroCliente);
			}else if(ventaActual.getTipoDePago() == Venta.TARJETA) {
				ventaActual.pagoTarjeta();
			} 
			
			System.out.println("\n");
			carrito.add(ventaActual);

		}
		
		System.out.println("\n\n");
		
		for (Venta ventaActual: carrito) {
//			INFORME
			Producto auxProd = ventaActual.getProductoActual();
			int unidades = ventaActual.getCantidad();
		
			System.out.println("Producto: " + auxProd.getNombre());
			System.out.println("Tipo de pago : " + ventaActual.getTipoDePago());
			System.out.println("Total : " + ventaActual.getTotal());
			System.out.println("Ganancia de " + ventaActual.getCantidad() + " unidades: " + auxProd.gananciaPorCantidad(unidades) + " $ :");			
			System.out.println("\n\n");
		}
//		Ganancia de 20 unidades: -100.0 $ :
		sc.close();
	}

}
