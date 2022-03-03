package Modelo;

public class Almacen {

    private int valor;
    private boolean valorconsumido;

    public Almacen() {
        valorconsumido = true;
    }

    public synchronized void put(int v) {
        while (!valorconsumido) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        valor = v;
        valorconsumido = false;
        notify();
    }

    public synchronized int get() {
        while (valorconsumido) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        valorconsumido = true;
        notify();
        return valor;
    }
}