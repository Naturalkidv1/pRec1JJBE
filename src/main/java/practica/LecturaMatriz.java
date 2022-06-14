package practica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author ajbazan01
 */
public class LecturaMatriz {

    private static String[] tokens;
    private static String linea;
    public static String[][] matriz; 

    public static int calcularColumna(String nombreFichero) {

        int contCol = 0;

        try ( Scanner datosFichero = new Scanner(new File(nombreFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en funciónn del carácter separador de campos

                tokens = linea.split(",");

                contCol = tokens.length;

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return contCol;

    }

    public static int calcularFila(String nombreFichero) {

        int contFila = 0;

        try ( Scanner datosFichero = new Scanner(new File(nombreFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en funciónn del carácter separador de campos

                tokens = linea.split("\n");

                for (String string : tokens) {
                    contFila++;
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return contFila;

    }

    public static void lectura(String nombreFichero) {

        // Fichero a leer con datos de ejemplo
        String idFichero = nombreFichero;
        //contador
        int i = 0;
        int j = 0;
        // Variables para guardar los datos que se van leyendo

        LecturaMatriz.matriz = new String[calcularFila(idFichero)][calcularColumna(idFichero)];

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

                for (int z = 0; z < tokens.length; z++) {

                    matriz[i][z] = tokens[z];

                }
                i++;

            }

            

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void mostrarMatriz(){
        
        //MostraMatriz
            for (int l = 0; l < matriz.length; l++) {
                System.out.println("");
                for (int k = 0; k < matriz[l].length; k++) {
                    System.out.print(matriz[l][k] + " ");
                }
            }
        
        
    }
    
    
    
}
