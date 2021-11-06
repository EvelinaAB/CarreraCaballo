/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreracaballo;

/**
 *
 * @author ewelina
 */
public class Caballo implements Runnable {

    String nombre;
    int contador;

    public Caballo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {

                while (contador < 100) {
                    long initialTime = System.currentTimeMillis();

                    Thread.sleep((int) (Math.random() * 41 + 10));

                    contador++;

                    if (contador == 100) {
                        System.out.println("Soy " + this.nombre + " he terminado");
                    }

                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

            }

        } catch (InterruptedException e) {
            System.out.println("No he podido terminar");
        }
    }
}