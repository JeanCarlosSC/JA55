package Modelo;

import Modelo.Almacen;

public class Productor extends Thread {

    private Almacen almacen;

    public Productor(Almacen a) {
        almacen = a;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Productor produce -->  " + i);
            almacen.put(i);
            try {
                sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        }
    }
}
