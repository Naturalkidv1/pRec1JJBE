/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static practica.LecturaMatriz.calcularColumna;
import static practica.LecturaMatriz.calcularFila;

/**
 *
 * @author ajbazan01
 */
public class EscrituraMatrizEspejo {

    public static List<String> datosEscrituraMatrizEspejo(String nombreFichero) {

        String[] tokens;
        String linea;
        String[][] matriz;
        int i = 0;

        String idFichero = nombreFichero;

        matriz = new String[calcularFila(idFichero)][calcularColumna(idFichero)];

        List<String> datos = new ArrayList<>();

        System.out.println("Leyendo el fichero: " + idFichero);

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

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        for (int l = 0; l < matriz.length; l++) {
            for (int k = 0; k < matriz[l].length; k++) {

                datos.add(matriz[l][k]);

            }

        }
        return datos;
    }

    public static void escribirMatrizEspejo(String nombreFichero, List<String> datos) {
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero))) {
            for (String string : datos) {
                
                if (string.equals(LecturaMatriz.matriz.length - 1)) {
                    bw.write(string);
                } else {
                    //Para separar
                    bw.write(string + "\t");
                }

                //bw.newLine();
            }

            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
