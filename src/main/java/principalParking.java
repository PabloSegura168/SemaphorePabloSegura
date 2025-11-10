import java.util.concurrent.Semaphore;

public class principalParking {
    public static void main(String[] args) {
        aparcamiento parking = new aparcamiento(3);
        int coches = 7;

        for (int i = 1; i < coches; i++) {
            coche coche = new coche("Coche " + i, parking);
            Thread hiloCoches = new Thread(coche);
            hiloCoches.start();
        }
    }
}
