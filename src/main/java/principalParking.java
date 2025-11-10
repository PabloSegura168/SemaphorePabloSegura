/**
 * Clase PrincipalParking
 * Punto de entrada de la aplicación. Crea el aparcamiento y lanza los hilos de los coches.
 */
public class principalParking {

    /**
     * Método main
     * Inicializa el aparcamiento con 3 plazas y lanza 7 coches como hilos concurrentes.
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        aparcamiento parking = new aparcamiento(3); // Aparcamiento con capacidad para 3 coches
        int totalCoches = 7;

        // Crea y lanza 7 hilos, cada uno representando un coche
        for (int i = 1; i <= totalCoches; i++) {
            Thread hiloCoche = new Thread(new coche("Coche-" + i, parking));
            hiloCoche.start();
        }
    }
}
