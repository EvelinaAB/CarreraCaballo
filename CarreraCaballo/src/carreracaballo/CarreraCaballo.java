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

        Caballo[] caballos = new Caballo[length];

        for (int i = 0; i < length; i++) {
            Caballo c = new Caballo("Caballo " + i);
            caballos[i] = c;
        }

        Thread[] threads = new Thread[length];
        for (int i = 0; i < length; i++) {
            Thread thread = new Thread(caballos[i]);
            threads[i] = thread;
            thread.start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Thread thread : threads) {
            thread.interrupt();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
