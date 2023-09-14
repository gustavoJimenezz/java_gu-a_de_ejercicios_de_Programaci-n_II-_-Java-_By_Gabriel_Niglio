//calcular porcentaje de descueto
//validar pago efectivo y tarjeta

public class Venta {
	
	private Producto productoActual;
	private String tipoDePago;
	private double dineroCliente;
	private double vueltoCliente;
	private double total;
	private int cantidad;
	
	public static final String EFECTIVO = "Efectivo";
	public static final String TARJETA = "tarjeta";

	public String getTipoDePago() {
		return tipoDePago;
	}

	public void setTipoDePago(String tipoDePago) {
		this.tipoDePago = tipoDePago;
	}

	public double getdineroCliente() {
		return this.dineroCliente;
	}

	public void setdineroCliente(double dineroCliente) {
		this.dineroCliente = dineroCliente;
	}

	public Producto getProductoActual() {
		return this.productoActual;
	}

	public void setProductoActual(Producto productoActual) {
		this.productoActual = productoActual;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public double getVueltoCliente() {
		return this.vueltoCliente;
	}

	public void setVueltoCliente(double vueltoCliente) {
		this.vueltoCliente = vueltoCliente;
	}

	public double calcularPorcentajeDeDescuento(int cantidad) {
		double porcentajeDescuento = 0;
		if(cantidad >= 300 ) {
			porcentajeDescuento = 30;
		}else if(cantidad >= 200 ) {
			porcentajeDescuento = 20;
		}else if(cantidad >= 100 ) {
			porcentajeDescuento = 10;
		}
		return porcentajeDescuento;
	}
	
	public void pagoEfectivo(double dineroCliente) {
		
		double vuelto = dineroCliente - this.getTotal();

		if (vuelto <= 0) {
			System.out.println("El cliente no tiene suficiente dinero");
		} else {
			System.out.println("El vuelto es : " + vuelto);
			this.setVueltoCliente(vuelto);
		}
	}
	
	public void pagoTarjeta() {
		System.out.println("Se realizo un pago con tarjeta");
		System.out.println("Monto : " + this.getTotal() + " $");
	}
}
