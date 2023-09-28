//Auto
//Generar una clase Auto que tenga velocidad, tipo de turbo (A, B o C) y modelo.
//Generar un método que reciba una cantidad de minutos y muestre cuantos Kilómetros recorre en ese tiempo.
//Generar un método que retorne cual es la velocidad que alcanza con turbo. (Los tipo A son un 20% más rápidos con turbo, los tipo B un 32% y los tipo C un 51%).
//Generar un método que reciba una cantidad de kilómetros y retorne en cuantos minutos los recorrería con turbo.

//Una vez hecho esto, crear un Main donde se carguen tres autos y cuantos minutos van a andar.
//Mostrar que tan lejos llegó cada auto, y cuanto hubiera tardado cada uno en recorrer esa distancia con turbo.

public class Auto {
	
	private double velocidadKmph;
	private char tipoTurbo;
	private String modelo;
	
	Auto(String modelo, double velocidadKmph, char tipoTurbo){
		this.modelo = modelo;
		this.velocidadKmph = velocidadKmph;
		this.tipoTurbo = tipoTurbo;
	}
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getVelocidadKmph() {
		return velocidadKmph;
	}

	public void setVelocidadKmph(double velocidadKmph) {
		this.velocidadKmph = velocidadKmph;
	}

	public char getTipoTurbo() {
		return tipoTurbo;
	}

	public void setTipoTurbo(char tipoTurbo) {
		this.tipoTurbo = tipoTurbo;
	}

    public double kilometroRecorridoPorMinutos(int minutos) {
//    	Generar un método que reciba una cantidad de minutos y muestre cuantos Kilómetros recorre en ese tiempo.
    	
    	double kilometroRecorrido = 0;
    	if(minutos > 0) {    		
    		double minutosDeHoras = minutos / 60.0;
    		kilometroRecorrido = this.getVelocidadKmph() * minutosDeHoras; 
    	}
        return kilometroRecorrido;
    }
	
    public double carcularTiempoConTurbo(double distanciaKm) {
//    	Generar un método que reciba una cantidad de kilómetros y retorne en cuantos minutos los recorrería con turbo.
   
    	double min = 0;
    	if(distanciaKm > 0) {    		
    		double tiempoHoras = distanciaKm / this.velocidadConTurbo();
    		min = tiempoHoras * 60;
    	}
    	return min;
    }

	public double velocidadConTurbo() {
//		Generar un método que retorne cual es la velocidad que alcanza con turbo. 
//		(Los tipo A son un 20% más rápidos con turbo, los tipo B un 32% y los tipo C un 51%).
		
    	double turbo = 0;

    	if( tipoTurbo == 'A') {
    		turbo = (20 / 100.0) * this.getVelocidadKmph();
    	}else if( tipoTurbo == 'B') {
    		turbo = (32 / 100.0) * this.getVelocidadKmph();
    	}else if( tipoTurbo == 'C') {
    		turbo = (51 / 100.0) * this.getVelocidadKmph();
    	}
    	
    	return this.getVelocidadKmph() + turbo;
    }  
}
