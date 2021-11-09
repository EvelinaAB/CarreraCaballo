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
class Reloj {

    private final long nanoSegundosPorMilisegundos = 1000000;

    private long relojInicio = 0;
    private long relojStop = 0;
    private boolean relojEnCurso = false;

    public void start() {
        this.relojInicio = System.nanoTime();
        this.relojEnCurso = true;
    }

    public void stop() {
        this.relojStop = System.nanoTime();
        this.relojEnCurso = false;
    }

    public long tiempoTranscurrido() {
        long transcurrido;

        if (relojEnCurso) {
            transcurrido = (System.nanoTime() - relojInicio);
        } else {
            transcurrido = (relojStop - relojInicio);
        }

        return transcurrido/ nanoSegundosPorMilisegundos;
    }

}
