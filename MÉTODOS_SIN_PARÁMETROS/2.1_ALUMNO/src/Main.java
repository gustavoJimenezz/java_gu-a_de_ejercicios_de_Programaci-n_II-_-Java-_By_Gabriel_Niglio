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
		ArrayList<Alumno> listaAlumnos = new ArrayList<>();
		Alumno primerAlumno = new Alumno();
		listaAlumnos.add(primerAlumno);
		Alumno segundoAlumno = new Alumno();
		listaAlumnos.add(segundoAlumno);
		
		int contador1 = 0;		
		for (Alumno alumno : listaAlumnos) {
			contador1 ++;
			System.out.println("ALUMNO "+ contador1);
			System.out.print("Ingrese nombre : ");
			alumno.nombre = sc.next();
			
			System.out.print("Ingrese edad : ");
			alumno.edad = sc.nextInt();
			
			System.out.print("Ingrese altura : ");
			alumno.altura = sc.nextDouble();
			
			System.out.print("Ingrese peso : ");
			alumno.peso = sc.nextDouble();
			
			System.out.print("Ingrese nota : ");
			alumno.nota = sc.nextDouble();
			
			System.out.println("\n");

		}

		System.out.println("\n\n\n");
		int contador2 = 0;			

		for (Alumno alumno : listaAlumnos) {
			contador2 ++;
			DecimalFormat df = new DecimalFormat("#.####");
			System.out.println("ALUMNO "+ contador2);
			System.out.println("Nombre : " + alumno.nombre);
			System.out.println("Eedad : "+ alumno.edad);
			System.out.println("Altura : "+ alumno.altura);
			System.out.println("Peso : "+ alumno.peso);
			System.out.println("Nota : "+ alumno.nota);
			System.out.println("Resultado de Nota: "+ alumno.aprobadoDesaprobado());
			System.out.println("Masa muscular: "+ df.format(alumno.indiceDeMasaMuscular()));
			
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
