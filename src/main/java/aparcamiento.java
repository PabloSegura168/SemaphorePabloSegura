import java.util.concurrent.Semaphore;

public class aparcamiento {

        private int ocupadas;
        private Semaphore plazas;

        // Constructor
    public aparcamiento(int plazasTotal) {
        plazas = new Semaphore(plazasTotal);
        ocupadas = 0;
    }

    public void entrar(String coche) throws InterruptedException {
       System.out.println(coche + " esta esperando...");
        plazas.acquire();

        synchronized (this) {
            ocupadas ++;
            System.out.println(coche + " ha entrado, plazas ocupadas: " + ocupadas);
        }
    }

    public void salir(String coche) {
        synchronized (this) {
            ocupadas --;
            System.out.println(coche + " ha salido, plazas ocupadas: " + ocupadas);
        }
        plazas.release();
    }
}
