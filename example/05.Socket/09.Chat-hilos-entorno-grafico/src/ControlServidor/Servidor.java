package ControlServidor;

import java.io.*;
import java.net.*;

public class Servidor {

    private ServerSocket sckEntradaServidor = null;
    private Socket sckSalidaServidor = null;
    private PrintWriter salida = null;
    private BufferedReader entrada = null;
    private int puerto, contador;

    Servidor(int puerto) {
        this.puerto = puerto;
    }

    public boolean iniciarServidor() {
        if (!escucharPuerto()) {
            return false;
        }
        if (!procesarSolicitud()) {
            return false;
        }
        detenerServidor();
        return true;
    }

    private boolean escucharPuerto() {
        try {
            sckEntradaServidor = new ServerSocket(puerto);
        } catch (IOException exc) {
            System.out.println(
                    "No fue posible abrir el puerto: " + puerto + "En el servidor...");
            return false;
        }
        System.out.println(
                "Servidor activo y escuchando en el puerto: " + puerto);
        return true;
    }

    private boolean procesarSolicitud() {
        System.out.println("Esperando por conexion del cliente...");
        try {
            while (true) {
                //crea el socket
                sckSalidaServidor = sckEntradaServidor.accept();
                System.out.println("Cliente conectado: " + sckSalidaServidor.getInetAddress().getHostAddress());
                System.out.println("Iniciando un nuevo hilo para procesar la solicitud");
                //Crea el hilo con el socket que creo anteriormente
                ServidorHilo servidorHilo = new ServidorHilo(sckSalidaServidor);
                new Thread(servidorHilo).start();
                contador++;
                System.out.println("Hilo de procesamiento para el cliente:" + contador + " ha sido iniciado");

            }
        } catch (IOException exc) {
            System.out.println(
                    "No fue posible establecer la conexion con el cliente...");
            detenerServidor();
            return false;
        }
    }

    private boolean detenerServidor() {
        try {
            if (!sckSalidaServidor.isClosed()) {
                sckSalidaServidor.close();
            }
            if (!sckEntradaServidor.isClosed()) {
                sckEntradaServidor.close();
            }

        } catch (IOException exc) {
            System.out.println("Error al cerrar puertos en el servidor...");
            return false;
        }
        System.out.println("La conexion ha sido cerrada...");
        return true;
    }
}
