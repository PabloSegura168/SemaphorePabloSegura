import java.util.Random;

/**
 * Clase Coche
 * Representa un vehículo que intenta acceder al aparcamiento. Cada coche se ejecuta como un hilo independiente.
 */
public class coche implements Runnable {

    // Identificador único del coche (ej. "Coche-1")
    private final String idCoche;

    // Referencia al aparcamiento compartido
    private final aparcamiento parking;

    /**
     * Constructor de Coche
     * @param idCoche Nombre identificativo del coche
     * @param parking Referencia al objeto Aparcamiento compartido
     */
    public coche(String idCoche, aparcamiento parking) {
        this.idCoche = idCoche;
        this.parking = parking;
    }

    /**
     * Método run
     * Define el comportamiento del hilo: espera su turno, entra al aparcamiento, permanece aparcado un tiempo aleatorio y luego sale.
     */
    @Override
    public void run() {
        try {
            System.out.println(idCoche + " está esperando...");
            parking.entrar(idCoche);
            Thread.sleep(1000 + new Random().nextInt(3000)); // Simula tiempo aleatorio entre 1 y 4 segundos
            parking.salir(idCoche);
        } catch (InterruptedException e) {
            System.out.println(idCoche + " fue interrumpido.");
            Thread.currentThread().interrupt();
        }
    }
}
