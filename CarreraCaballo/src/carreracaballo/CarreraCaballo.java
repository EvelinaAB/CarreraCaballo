package carreracaballo;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ewelina
 */
public class CarreraCaballo {

    public static void main(String[] args) throws InterruptedException {
        JFrame ventana = new JFrame("Ejemplo de manejo de eventos");
        ventana.setLayout(new FlowLayout());
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel etiqueta = new JLabel("¡¡Empezar carrera!!");
        JButton botón = new JButton("¡Puls INTRO!");
        ventana.add(etiqueta);
        ventana.add(botón);

        int cuenta = 0;
        System.out.println(
                "Introduzca el número de caballos:");
        int entradaTeclado = 0;
        Scanner entradaEscaner = new Scanner(System.in); //Creación de un objeto Scanner
        entradaTeclado = entradaEscaner.nextInt(); //Invocamos un método sobre un objeto Scanner
//        Lock lock = new ReentrantLock();
        int length = entradaTeclado;
        Caballo[] caballos = new Caballo[length];

        for (int i = 0;
                i < length;
                i++) {
            Caballo c = new Caballo("Caballo " + i);
            caballos[i] = c;
        }
        ventana.setSize(
                300, 100);
        ventana.setVisible(
                true);

        botón.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent d) {

            }

            @Override
            public void keyPressed(KeyEvent d) {
                if (d.getKeyCode() == KeyEvent.VK_ENTER) {

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
                    //Tell the players to stop
                    for (Thread thread : threads) {
                        thread.interrupt();
                    }

                    //Don't progress main thread until all players have finished
                    try {
                        for (Thread thread : threads) {
                            thread.join();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.exit(0);
            }

            @Override
            public void keyReleased(KeyEvent e
            ) {

            }

        });
    }
}
