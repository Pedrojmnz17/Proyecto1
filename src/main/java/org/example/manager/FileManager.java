package org.example.manager;

import org.example.model.cofradia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static List<cofradia> leercofradias(String rutaArchivo) {
        List<cofradia> cofradias = new ArrayList<>();
        File archivo = new File(rutaArchivo);

        if (!archivo.exists()) {
            System.err.println("Error: El archivo " + rutaArchivo + " no existe.");
            return cofradias;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int numLinea = 0;

            while ((linea = br.readLine()) != null) {
                numLinea++;
                try {
                    String[] datos = linea.split("[,;]");

                    String nombre = datos[0].split(":")[1].trim();
                    int fundacion = Integer.parseInt(datos[1].split(":")[1].trim());
                    int numeroHermanos = Integer.parseInt(datos[2].split(":")[1].trim());
                    String ciudad = datos[3].split(":")[1].trim();

                    cofradias.add(new cofradia(nombre, numeroHermanos, fundacion, ciudad));
                } catch (Exception e) {
                    System.err.println("Error procesando línea " + numLinea + ": " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return cofradias;
    }
    public static void crearDirectorioDatos() {
        File dir = new File("datos");
        if (!dir.exists()) {
            dir.mkdirs();
            System.out.println("Directorio 'datos' creado.");
        }
    }
}
