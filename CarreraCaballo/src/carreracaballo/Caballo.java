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
        Reloj reloj = new Reloj();

        try {
            reloj.start();

            while (contador < 100) {

                Thread.sleep((int) (Math.random() * 41 + 10));

                contador++;

                if (contador == 100) {
                    reloj.stop();

                    System.out.println("Soy " + this.nombre + "  he terminado y he tardado  " + reloj.tiempoTranscurrido() + " ms");/*+ (System.currentTimeMillis() - initialTime) + " ms"*/
                }

            }

        } catch (InterruptedException e) {
            System.out.println("No he podido terminar");

        }
    }
}
