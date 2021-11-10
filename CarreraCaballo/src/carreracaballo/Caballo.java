package carreracaballo;

/**
 *
 * @author ewelina
 */
public class Caballo implements Runnable, Comparable<Caballo> {

    private String nombre;
    private int contador;
    private long tiempoRecorrido;

    public Caballo(String nombre, long tiempoR) {
        this.nombre = nombre;
        this.tiempoRecorrido = tiempoR;
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

                    this.tiempoRecorrido = reloj.tiempoTranscurrido();
                    System.out.println("Soy " + this.nombre + "  he terminado y he tardado  " + this.tiempoRecorrido + " ms");

                }

            }

        } catch (InterruptedException e) {
            System.out.println("No he podido terminar");

        }
    }

    @Override
    public String toString() {

        return   nombre + " " + tiempoRecorrido + " ms";
    }

    public String getNombre() {
        return nombre;
    }

    public long getTiempoRecorrido() {
        return tiempoRecorrido;
    }

    @Override
    public int compareTo(Caballo o) {
        if (this.tiempoRecorrido > o.tiempoRecorrido) {
            return 1;
        }
        if (this.tiempoRecorrido < o.tiempoRecorrido) {
            return -1;

        }
        return 0;
    }

}
