package Modelo;

import Modelo.Almacen;

public class Consumidor extends Thread {

    private Almacen almacen;

    public Consumidor(Almacen a) {
        almacen = a;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Consumidor consume --> "+ almacen.get()
            );
try {
                sleep((long) (Math.random() * 200));
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        }
    }
}
