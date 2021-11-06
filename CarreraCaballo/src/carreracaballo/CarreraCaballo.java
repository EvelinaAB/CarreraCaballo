package carreracaballo;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author ewelina
 */
public class CarreraCaballo {

    public static void main(String[] args) {
        System.out.println("Por favor introduzca el número de caballos:");
        int entradaTeclado = 0;
        Scanner entradaEscaner = new Scanner(System.in); //Creación de un objeto Scanner
        entradaTeclado = entradaEscaner.nextInt(); //Invocamos un método sobre un objeto Scanner
        Lock lock = new ReentrantLock();
        int length = entradaTeclado;
    }

}
