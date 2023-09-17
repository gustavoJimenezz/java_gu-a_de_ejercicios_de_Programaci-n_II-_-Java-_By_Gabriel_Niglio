import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;
        Boolean continuar = true;
        Persona[] vecPersona = new Persona[10];
        int indice = 0;


        while (continuar == true) {
            System.out.println("** Agenda **");
            System.out.println("1 - Registrar persona");
            System.out.println("2 - Mostrar personas");
            System.out.println("3 - Mostrar personas mayores de edad");
            System.out.println("4 - Mostrar personas menores de edad");
            System.out.println("5 - Buscar persona");
            System.out.println("6 - salir");
            System.out.print("Ingrese : ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.println("");
                System.out.println("** Registrar persona **");
                System.out.println("");
                System.out.print("Ingrese nombre : ");
                String nuevoNombre = sc.next();
                System.out.print("Ingrese dni : ");
                String nuevoDni = sc.next();
                System.out.print("Ingrese edad : ");
                int nuevaEdad = sc.nextInt();

                Persona nuevoPersona = new Persona(nuevoNombre, nuevoDni, nuevaEdad);
                vecPersona[indice] = nuevoPersona;
                indice ++;


            } else if (opcion == 2) {
                System.out.println("");
                System.out.println("** Mostrar personas **");
                for (int i = 0; i < indice; i++) {
                    Persona auxPer = vecPersona[i];
                    System.out.println("Nombre : " + auxPer.getNombre());
                    System.out.println("DNI : " + auxPer.getDni());
                    System.out.println("Edad : " + auxPer.getEdad());
                    System.out.println("--------------------");
                }
                System.out.println("");

            } else if (opcion == 3) {
                System.out.println("");
                System.out.println("** Mostrar personas mayores de edad **");
                for (int i = 0; i < indice; i++) {
                    Persona auxPer = vecPersona[i];
                    if(auxPer.getEdad() >= 18){
                        System.out.println("Nombre : " + auxPer.getNombre());
                        System.out.println("DNI : " + auxPer.getDni());
                        System.out.println("Edad : " + auxPer.getEdad());
                        System.out.println("--------------------");
                    }
                }
                System.out.println("");


            } else if (opcion == 4) {
                System.out.println("");
                System.out.println("** Mostrar personas menores de edad **");
                for (int i = 0; i < indice; i++) {
                    Persona auxPer = vecPersona[i];
                    if( auxPer.getEdad() < 18){
                        System.out.println("Nombre : " + auxPer.getNombre());
                        System.out.println("DNI : " + auxPer.getDni());
                        System.out.println("Edad : " + auxPer.getEdad());
                        System.out.println("--------------------");
                    }
                }
                System.out.println("");


            } else if (opcion == 5) {
                System.out.println("");
                System.out.println("** Buscar por dni**");
                System.out.print("Ingrese DNI : ");
                String dniIngresado = sc.next();

                    for (int i = 0; i < indice; i++) {
                        Persona auxPer = vecPersona[i];
                        String dniActual = auxPer.getDni();
                        if(dniActual == dniIngresado){
                            System.out.println("Nombre : " + auxPer.getNombre());
                            System.out.println("DNI : " + auxPer.getDni());
                            System.out.println("Edad : " + auxPer.getEdad());
                            System.out.println("--------------------");
                        }
                    }
                System.out.println("");

            } else if (opcion == 6) {
                continuar = false;
            } else {
                System.out.println("");
                System.out.println("Opcion Incorrecto !");
                System.out.println("");
            }
        }

    }
}