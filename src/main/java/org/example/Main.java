package org.example;

import org.example.model.cofradia;
import org.example.manager.FileManager;
import org.example.manager.XMLManager;
import org.example.manager.JSONManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String rutatxt = "src/main/resources/cofradias.txt";
    public static String dirdatos = "datos";
    public static String rutaxml = dirdatos + "/cofradias.xml" ;
    public static String rutajson = dirdatos + "/cofradias.json";



    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        XMLManager xmlManager = new XMLManager();
        JSONManager jsonManager = new JSONManager();
        Scanner scanner = new Scanner(System.in);

        List<cofradia> lista = new ArrayList<>();

        

        while (true) {
            System.out.println("-- Menu de Gestion de cofradias");
            System.out.println("1. Leer datos desde TXT");
            System.out.println("2. Guardar datos en XML");
            System.out.println("3. Guardar datos en JSON");
            System.out.println("4. Leer datos en XML");
            System.out.println("5. Leer datos en JSON");
            System.out.println("6. Salir");
            System.out.println("Seleccione una opcion");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcion){
                    case 1:
                        lista = FileManager.leercofradias(rutatxt);
                        for (cofradia c : lista){
                            System.out.println(c);
                        }
                        break;
                    case 2:
                        xmlManager.guardarEnXML(lista, rutaxml);
                        break;
                    case 3:
                        jsonManager.guardarEnJSON(lista, rutajson);
                        break;
                    case 4:
                        lista = xmlManager.leerDesdeXML(rutaxml);
                        lista.forEach(System.out::println);
                        break;
                    case 5:
                        lista = jsonManager.leerDesdeJSON(rutajson);
                        lista.forEach(System.out::println);

                        break;
                    case 6:
                        System.out.println("\n Saliendo......");
                        System.exit(0);
                    default:
                        System.out.println("Opcion no valida");
                }
            }catch (Exception e){
                System.err.println("Error:" +e.getMessage());
            }
        }

    }

}