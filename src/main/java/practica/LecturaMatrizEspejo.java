/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static practica.LecturaMatriz.calcularColumna;
import static practica.LecturaMatriz.calcularFila;

/**
 *
 * @author ajbazan01
 */
public class LecturaMatrizEspejo {

    private static String[] tokens;
    private static String linea;
    public static String[][] matriz;

    public static void lecturaEspejo(String nombreFichero) {

        // Fichero a leer con datos de ejemplo
        String idFichero = nombreFichero;
        //contador
        int i = 0;
        int j = 0;
        // Variables para guardar los datos que se van leyendo

        matriz = new String[calcularFila(idFichero)][calcularColumna(idFichero)];

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero))) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en funciónn del carácter separador de campos
                tokens = linea.split("\n");
                tokens = linea.split(",");

                for (int z = tokens.length - 1; z >= 0; z--) {

                    //System.out.println(z);
                    matriz[i][z] = tokens[z];

                }
                i++;
            }

            //MostraMatriz
            for (int l = 0; l < matriz.length; l++) {
                System.out.println("");
                for (int k = 0; k < matriz[l].length; k++) {
                    System.out.print(matriz[l][k] + " ");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

}
