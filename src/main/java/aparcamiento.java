import java.util.concurrent.Semaphore;

/**
 * Clase Aparcamiento
 * Simula un aparcamiento con plazas limitadas usando semáforos para controlar el acceso concurrente.
 */
public class aparcamiento {

    // Número de plazas actualmente ocupadas
    private int ocupadas;

    // Semáforo que controla el acceso a las plazas disponibles
    private Semaphore plazas;

    /**
     * Constructor de Aparcamiento
     * @param plazasTotal Número total de plazas disponibles en el aparcamiento
     */
    public aparcamiento(int plazasTotal) {
        plazas = new Semaphore(plazasTotal); // Inicializa el semáforo con el número de plazas
        ocupadas = 0; // Inicialmente no hay coches aparcados
    }

    /**
     * Método entrar
     * Gestiona la entrada de un coche al aparcamiento. Bloquea si no hay plazas disponibles.
     * @param coche Nombre identificativo del coche que intenta entrar
     * @throws InterruptedException Si el hilo es interrumpido mientras espera una plaza
     */
    public void entrar(String coche) throws InterruptedException {
        plazas.acquire(); // Solicita un permiso del semáforo (bloqueante si no hay plazas)
        System.out.println(coche + " esta esperando..."); // Mensaje de espera antes de entrar

        synchronized (this) {
            ocupadas++; // Incrementa el contador de plazas ocupadas
            System.out.println(coche + " ha entrado, plazas ocupadas: " + ocupadas);
        }
    }

    /**
     * Método salir
     * Libera una plaza del aparcamiento cuando un coche sale.
     * @param coche Nombre identificativo del coche que sale
     */
    public void salir(String coche) {
        synchronized (this) {
            ocupadas--; // Decrementa el contador de plazas ocupadas
            System.out.println(coche + " ha salido, plazas ocupadas: " + ocupadas);
        }
        plazas.release(); // Libera el permiso en el semáforo para que otro coche pueda entrar
    }
}