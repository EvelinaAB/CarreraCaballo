package carreracaballo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import sun.reflect.annotation.AnnotationParser;

/**
 *
 * @author ewelina
 */
public class CarreraCaballo {

    public static void main(String[] args) throws InterruptedException {
        /*Creamos ventana*/
        JFrame ventana = new JFrame("Ejemplo de manejo de eventos");
        ventana.setLayout(new FlowLayout());
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*Creamos etiqueta+botón*/
        final JLabel etiqueta = new JLabel("¡¡Empezar carrera!!");
        JButton botón = new JButton("¡Pulsa INTRO!");
        ventana.add(etiqueta);
        ventana.add(botón);
        /*Recoger por pantalla el número de caballos*/
        System.out.println("Introduzca el número de caballos:");
        int entradaTeclado = 0;
        Scanner entradaEscaner = new Scanner(System.in); //Creación de un objeto Scanner
        entradaTeclado = entradaEscaner.nextInt(); //Invocamos un método sobre un objeto Scanner

        int length = entradaTeclado;
        long tiempo = 0;
        /*Creamos array de caballos*/
        Caballo[] caballos = new Caballo[length];
        /*Recorremos la longitud del array y le asignamos los caballos*/
        for (int i = 0;
                i < length;
                i++) {
            Caballo c = new Caballo("Caballo " + i, tiempo);
            caballos[i] = c;
        }
        /*Propiedades de la ventana*/
        ventana.setSize(
                300, 100);
        ventana.setVisible(
                true);
        ventana.setAlwaysOnTop(true);
        ventana.setLocationRelativeTo(null);
        /*Agregamos un KeyListener al botón para capturar la tecla intro*/
        botón.addKeyListener(
                new KeyListener() {
            @Override
            public void keyTyped(KeyEvent d
            ) {

            }

            @Override
            public void keyPressed(KeyEvent d
            ) {
                if (d.getKeyCode() == KeyEvent.VK_ENTER) {

                    ventana.setVisible(false);
                    /*Creamos la misma cantidad de hilos que de caballos*/
                    Thread[] threads = new Thread[length];
                    for (int i = 0;
                            i < length;
                            i++) {
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
                        System.out.println("\n");
                        System.out.println("Lista de calificaciones y tiempos:");
                        Arrays.sort(caballos);
                        for (Caballo c : caballos) {

                            System.out.println(c);
                        }

                        System.exit(0);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void keyReleased(KeyEvent e
            ) {

            }

        }
        );
    }
}
