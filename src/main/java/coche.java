import java.util.Random;

public class coche implements Runnable{

    private String idCoche;
    private aparcamiento parking;

    public coche(String idCoche, aparcamiento parking) {
        this.idCoche = idCoche;
        this.parking = parking;
    }

    @Override
    public void run() {
        try {
            parking.entrar(this.idCoche);
            Thread.sleep(1000 + new Random().nextInt(3000));
            parking.salir(this.idCoche);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
