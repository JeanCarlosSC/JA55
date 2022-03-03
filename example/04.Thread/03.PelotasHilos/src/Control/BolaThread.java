package Control;


import Modelo.Bola;

public class BolaThread extends Thread {

    private Bola b;

    public BolaThread(Bola aBall) {
        b = aBall;
    }

    public void run() {
        try {
            for (int i = 1; i <= 10000; i++) {
                b.move();
                sleep(5);
            }
        } catch (InterruptedException exception) {
        }
    }
} 