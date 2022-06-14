package practica;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ajbazan01
 */
public class Aplicacion {

    public static void main(String[] args) {

        Scanner entradaTeclado = new Scanner(System.in);
        int opcion = 0;
        boolean continuar = true;

        System.out.println("Iniciando aplicación...");

        do {

            System.out.println("\n-------------------------");
            System.out.println("1. Leer Matriz");
            System.out.println("2. Leer Matriz Espejo");
            System.out.println("3. Escribir Matriz Espejo");
            System.out.println("4. Leer Matriz de Mayor a Menor");
            System.out.println("5. Salir de la Aplicación");
            System.out.println("-------------------------");

            do {
                try {
                    System.out.println("Elija una opción: ");
                    opcion = entradaTeclado.nextInt();
                    continuar = false;
                } catch (InputMismatchException ime) {
                    System.out.println("Introduce un número entero.");
                    entradaTeclado.nextLine();
                }
            } while (continuar);

            switch (opcion) {
                case 1:
                    //System.out.println(LecturaMatriz.calcularColumna("matrizP.txt"));
                    //System.out.println(LecturaMatriz.calcularFila("matrizP.txt"));
                    LecturaMatriz.lectura("matrizP.txt");
                    break;
                case 2:
                    //System.out.println(LecturaMatriz.calcularColumna("matrizP.txt"));
                    //System.out.println(LecturaMatriz.calcularFila("matrizP.txt"));
                    LecturaMatrizEspejo.lecturaEspejo("matrizP.txt");
                    break;
                case 3:
                    System.out.println("Escriba el nombre del archivo: ");
                    String nombreArchivo = entradaTeclado.next();
                    //System.out.println(EscrituraMatrizEspejo.datosEscrituraMatrizEspejo("matrizP.txt"));
                    EscrituraMatrizEspejo.escribirMatrizEspejo(nombreArchivo, EscrituraMatrizEspejo.datosEscrituraMatrizEspejo("matrizP.txt"));
                    break;
                case 5:
                    System.out.println("Finalizando aplicación.");
                    break;
                default:
                    System.out.println("Opción inválida, vuelva a seleccionar una adecuada, por favor.");
                    break;
            }
        } while (opcion != 5);

    }

}
