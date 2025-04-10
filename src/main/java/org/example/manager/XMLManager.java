package org.example.manager;

import org.example.model.CofradiaWrapper;
import org.example.model.cofradia;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLManager {

    public void guardarEnXML(List<cofradia> cofradias, String rutaArchivo) {
        try {
            FileManager.crearDirectorioDatos();
            CofradiaWrapper lista = new CofradiaWrapper(cofradias);
            JAXBContext context = JAXBContext.newInstance(CofradiaWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(lista, new File(rutaArchivo));
            System.out.println("Archivo XML guardado correctamente en: " + rutaArchivo);
        } catch (Exception e) {
            System.err.println("Error al guardar en XML: " + e.getMessage());
        }
    }

    public List<cofradia> leerDesdeXML(String rutaArchivo) {
        List<cofradia> lista = new ArrayList<>();
        try {
            File archivo = new File(rutaArchivo);
            if (!archivo.exists()) {
                System.err.println("Archivo XML no encontrado.");
                return lista;
            }

            JAXBContext context = JAXBContext.newInstance(CofradiaWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            CofradiaWrapper listaCofradias = (CofradiaWrapper) unmarshaller.unmarshal(archivo);
            lista = listaCofradias.getCofradias();
            System.out.println("Archivo XML leído correctamente.");
        } catch (Exception e) {
            System.err.println("Error al leer desde XML: " + e.getMessage());
        }
        return lista;
    }
}


