package org.example.manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.model.cofradia;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONManager {
    private final ObjectMapper objectMapper;

    public JSONManager() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public void guardarEnJSON(List<cofradia> lista, String ruta) {
        if (lista == null || lista.isEmpty()) {
            System.err.println(" No hay datos para guardar. La lista está vacía.");
            return;
        }

        try {
            File archivo = new File(ruta);
            // Asegura que el directorio padre exista
            if (!archivo.getParentFile().exists()) {
                archivo.getParentFile().mkdirs();
                System.out.println("Directorio creado: " + archivo.getParentFile().getAbsolutePath());
            }

            // Imprime la lista antes de escribirla para asegurarse de que no está vacía
            System.out.println("Guardando los siguientes datos en JSON: ");
            for (cofradia c : lista) {
                System.out.println(c);
            }

            objectMapper.writeValue(archivo, lista);
            System.out.println(" JSON guardado en: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.err.println(" Error al guardar JSON: " + e.getMessage());
        }
    }


    public List<cofradia> leerDesdeJSON(String ruta) {
        try {
            return objectMapper.readValue(new File(ruta), objectMapper.getTypeFactory().constructCollectionType(List.class, cofradia.class));
        } catch (IOException e) {
            System.err.println(" Error al leer JSON: " + e.getMessage());
            return List.of();
        }
    }
}
