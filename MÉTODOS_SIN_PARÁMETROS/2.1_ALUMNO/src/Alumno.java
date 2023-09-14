//Alumno
//Crear una clase Alumno con peso, nombre, altura, nota y edad.
//Crear un método que retorne D (Desaprobado), A (Aprobado) o P (Promocionado) en base a su nota.
//Crear un método que retorne el índice de masa corporal del alumno.
//Crear un método que retorne cuanto le falta para jubilarse (Asumiendo que se jubilará a los 65 años).
//Una vez hecho esto, crear un Main donde se carguen dos alumnos y se muestren todos los datos de ambos.

public class Alumno {
	
	String nombre;
	int edad;
	double peso; 
	double altura; 
	double nota;
	static final int JUBILACION = 64;

	char aprobadoDesaprobado(){
		char resultado;
		if(this.nota >= 8) {
			resultado = 'P';
		}else if(this.nota >= 6) {
			resultado = 'A';
		}else {
			resultado = 'D';
		}
		return resultado;
	}
	
	double indiceDeMasaMuscular() {
        // Calcular el IMC
		
        return this.peso / (this.altura * this.altura);
	}
	
	int jubilacion() {
		return JUBILACION - this.edad;
	}
}
