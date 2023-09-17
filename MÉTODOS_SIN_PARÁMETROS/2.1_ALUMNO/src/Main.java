import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
//Alumno
//Crear una clase Alumno con peso, nombre, altura, nota y edad.
//Crear un método que retorne D (Desaprobado), A (Aprobado) o P (Promocionado) en base a su nota.
//Crear un método que retorne el índice de masa corporal del alumno.
//Crear un método que retorne cuanto le falta para jubilarse (Asumiendo que se jubilará a los 65 años).
//Una vez hecho esto, crear un Main donde se carguen dos alumnos y se muestren todos los datos de ambos.

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Alumno[] vecAlumnos = new Alumno[1];
		Alumno primerAlumno = new Alumno();
		Alumno segundoAlumno = new Alumno();
		vecAlumnos[0] = primerAlumno;
		vecAlumnos[1] = segundoAlumno

		for (int i = 0; i < 1; i++) {
			System.out.println("ALUMNO "+ i);
			System.out.print("Ingrese nombre : ");
			vecAlumnos[i].nombre = sc.next();

			System.out.print("Ingrese edad : ");
			vecAlumnos[i].edad = sc.nextInt();

			System.out.print("Ingrese altura : ");
			vecAlumnos[i].altura = sc.nextDouble();

			System.out.print("Ingrese peso : ");
			vecAlumnos[i].peso = sc.nextDouble();

			System.out.print("Ingrese nota : ");
			vecAlumnos[i].nota = sc.nextDouble();

			System.out.println("\n");
		}

		System.out.println("\n\n\n");


		for (int i = 0; i < 1; i++) {
			contador2 ++;
			DecimalFormat df = new DecimalFormat("#.####");
			System.out.println("ALUMNO "+ i);
			System.out.println("Nombre : " + vecAlumnos[i].nombre);
			System.out.println("Eedad : "+ vecAlumnos[i].edad);
			System.out.println("Altura : "+ vecAlumnos[i].altura);
			System.out.println("Peso : "+ vecAlumnos[i].peso);
			System.out.println("Nota : "+ vecAlumnos[i].nota);
			System.out.println("Resultado de Nota: "+ vecAlumnos[i].aprobadoDesaprobado());
			System.out.println("Masa muscular: "+ df.format(vecAlumnos[i].indiceDeMasaMuscular()));
			
			int jubilacionAlumno = alumno.jubilacion();
			if(jubilacionAlumno < 0) {
				System.out.println("Jubilado hace " + Math.abs(jubilacionAlumno) + " años");
			}else {
				System.out.println("Se jubila  : " + jubilacionAlumno + " años");				
			}
			System.out.println("\n");
		}
		
		sc.close();
	}

}
