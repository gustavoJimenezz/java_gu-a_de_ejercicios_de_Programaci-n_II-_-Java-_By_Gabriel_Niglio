package archivo;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		String[] nombres = {"Juan", "María", "Pedro", "Luisa", "Carlos", "Ana", "Marta", "David", "Elena", "Sergio"};
        String rutaEscritorio = System.getProperty("user.home") + "/Desktop/";
        String nombreArchivo = "nombres_random.csv";
        String rutaCompleta = rutaEscritorio + nombreArchivo;

        
        try {

            FileWriter writer = new FileWriter(rutaCompleta);
            writer.write("Nombre,");
            for(String nombre:nombres) {
            	writer.write(nombre + ",");
            }
            writer.close();

            System.out.println("Archivo creado.");
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
        
        
        try {
        	FileReader read = new FileReader(rutaCompleta);
        	BufferedReader csvReader = new BufferedReader(read);
        	String linea;
        	System.out.println("lista de nombres !");
            while ((linea = csvReader.readLine()) != null) {          		
        		System.out.println(linea);
            }
            
        }catch (IOException e) {
        	System.err.println("Error al leer el archivo: " + e.getMessage());
		}

	}

}
