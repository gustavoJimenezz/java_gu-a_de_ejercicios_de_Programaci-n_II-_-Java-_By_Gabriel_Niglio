

public class Main {

	public static void main(String[] args) {

		Auto primerAuto = new Auto();
		Auto segundoAuto = new Auto();
		
		primerAuto.modelo = "Golf";
		primerAuto.velocidad = 270;
		
		segundoAuto.modelo ="Pointer";
		segundoAuto.velocidad = 180;
		
		if(primerAuto.velocidad > segundoAuto.velocidad) {
			System.out.println("El modelo del más rápido de ambos es : " + primerAuto.modelo);
		}else {
			System.out.println("El modelo del más rápido de ambos es : " + segundoAuto.modelo);
		}

	}

}
