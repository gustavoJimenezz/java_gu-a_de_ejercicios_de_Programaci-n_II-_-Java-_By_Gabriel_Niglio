//Auto
//Generar una clase Auto que tenga velocidad, tipo de turbo (A, B o C) y modelo.
//Generar un método que reciba una cantidad de minutos y muestre cuantos Kilómetros recorre en ese tiempo.
//Generar un método que retorne cual es la velocidad que alcanza con turbo. (Los tipo A son un 20% más rápidos con turbo, los tipo B un 32% y los tipo C un 51%).
//Generar un método que reciba una cantidad de kilómetros y retorne en cuantos minutos los recorrería con turbo.

//Una vez hecho esto, crear un Main donde se carguen tres autos y cuantos minutos van a andar.
//Mostrar que tan lejos llegó cada auto, y cuanto hubiera tardado cada uno en recorrer esa distancia con turbo.
package main;

import model.Auto;

public class Main {

	public static void main(String[] args) {
		Auto primerAuto = new Auto("Corolla", 180, 'A');
		Auto segundoAuto = new Auto("Mustang", 250, 'B');
		Auto tercerAuto = new Auto("Model S", 250, 'C');
//		double?
		double minutos = 5;
		
		double kilometrosRecorridos1 = primerAuto.kilometroRecorridoPorMinutos(minutos);
		double kilometrosRecorridos2 = segundoAuto.kilometroRecorridoPorMinutos(minutos);
		double kilometrosRecorridos3 = tercerAuto.kilometroRecorridoPorMinutos(minutos);
		
		System.out.println("Mostrar que tan lejos llegó cada auto");
		System.out.println(primerAuto.getModelo() + " recorre " + kilometrosRecorridos1 + " Kilometros en " + minutos + " minutos");
		System.out.println(segundoAuto.getModelo() + " recorre " + kilometrosRecorridos2 + " Kilometros en " + minutos + " minutos");
		System.out.println(tercerAuto.getModelo() + " recorre " + kilometrosRecorridos3 + " Kilometros en " + minutos + " minutos");
		System.out.println("");
		System.out.println(primerAuto.getModelo() + " con turbo recorre " + kilometrosRecorridos1 + " Kilometros en " + primerAuto.carcularTiempoConTurbo(kilometrosRecorridos1) + " minutos");
		System.out.println(segundoAuto.getModelo() + " con turbo recorre " + kilometrosRecorridos2 + " Kilometros en " + segundoAuto.carcularTiempoConTurbo(kilometrosRecorridos2) + " minutos");
		System.out.println(tercerAuto.getModelo() + " con turbo recorre " + kilometrosRecorridos3 + " Kilometros en " + tercerAuto.carcularTiempoConTurbo(kilometrosRecorridos3) + " minutos");
		
	}
}
