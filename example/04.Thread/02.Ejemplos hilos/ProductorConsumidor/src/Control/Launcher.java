package Control;

import Modelo.Productor;
import Modelo.Consumidor;
import Modelo.Almacen;

public class Launcher {

    public static void main(String args[]) {
        Almacen a = new Almacen();
        Productor p = new Productor(a);
        Consumidor c = new Consumidor(a);
        p.start();
        c.start();
    }
}