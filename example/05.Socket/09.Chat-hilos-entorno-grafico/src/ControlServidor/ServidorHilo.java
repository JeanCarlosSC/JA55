package ControlServidor;

// Configurar un servidor que reciba una conexión de un cliente, envíe
// una cadena al cliente y cierre la conexión.
import VistaServidor.VentanaServidor;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ServidorHilo extends Thread implements ActionListener {

    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private Socket conexion;
    private int contador = 1;

    private VentanaServidor ventana;

    // configurar GUI
    public ServidorHilo(Socket conexion) {
        ventana = new VentanaServidor(this);
        this.conexion = conexion;
    }

    public void actionPerformed(ActionEvent evento) {
        if (ventana.verificarCampo() == false) {

            if (evento.getActionCommand().equals("Enviar")) {
                enviarDatos(ventana.getCampoTexto());
                ventana.limpiarTexto();
            }
            if (evento.getActionCommand().equals("EnviarEnter")) {
                enviarDatos(ventana.getCampoTexto());
                ventana.limpiarTexto();
            }
        }
    }
    
    public void run(){
        ejecutarServidor();
    }

    public void ejecutarServidor() {
        // configurar servidor para que reciba conexiones; procesar las conexiones
        try {

            // Paso 1: crear un objeto ServerSocket.

            while (true) {

                try {
                    esperarConexion(); // Paso 2: esperar una conexión.
                    obtenerFlujos();        // Paso 3: obtener flujos de entrada y salida.
                    procesarConexion(); // Paso 4: procesar la conexión.
                } // procesar excepción EOFException cuando el cliente cierre la conexión 
                catch (EOFException excepcionEOF) {
                    System.err.println("El servidor terminó la conexión");
                } finally {
                    cerrarConexion();   // Paso 5: cerrar la conexión.
                    ++contador;
                }

            } // fin de instrucción while

        } // fin del bloque try
        // procesar problemas con E/S
        catch (IOException excepcionES) {
            excepcionES.printStackTrace();
        }

    } // fin del método ejecutarServidor

    // esperar que la conexión llegue, después mostrar información de la conexión
    private void esperarConexion() throws IOException {
        ventana.mostrarMensaje("Esperando una conexión\n");
        ventana.mostrarMensaje("Conexión " + contador + " recibida de: " + conexion.getInetAddress().getHostName());
    }

    // obtener flujos para enviar y recibir datos
    private void obtenerFlujos() throws IOException {
        // establecer flujo de salida para los objetos
        salida = new ObjectOutputStream(conexion.getOutputStream());
        salida.flush(); // vaciar búfer de salida para enviar información de encabezado

        // establecer flujo de entrada para los objetos
        entrada = new ObjectInputStream(conexion.getInputStream());

        ventana.mostrarMensaje("\nSe recibieron los flujos de E/S\n");
    }

    // procesar la conexión con el cliente
    private void procesarConexion() throws IOException {
        // enviar mensaje de conexión exitosa al cliente
        String mensaje = "Conexión exitosa";
        enviarDatos(mensaje);

        // habilitar campoIntroducir para que el usuario del servidor pueda enviar mensajes
        ventana.establecerCampoTextoEditable(true);

        do { // procesar los mensajes enviados por el cliente

            // leer el mensaje y mostrarlo en pantalla
            try {
                mensaje = (String) entrada.readObject();
                ventana.mostrarMensaje("\n" + mensaje);
            } // atrapar problemas que pueden ocurrir al tratar de leer del cliente
            catch (ClassNotFoundException excepcionClaseNoEncontrada) {
                ventana.mostrarMensaje("\nSe recibió un tipo de objeto desconocido");
            }

        } while (!mensaje.equals("CLIENTE>>> TERMINAR"));

    } // fin del método procesarConexion

    // cerrar flujos y socket
    private void cerrarConexion() {
        ventana.mostrarMensaje("\nFinalizando la conexión\n");
        ventana.establecerCampoTextoEditable(false); // deshabilitar campoIntroducir

        try {
            salida.close();
            entrada.close();
            conexion.close();
        } catch (IOException excepcionES) {
            excepcionES.printStackTrace();
        }
    }

    // enviar mensaje al cliente
    private void enviarDatos(String mensaje) {
        // enviar objeto al cliente
        try {
            salida.writeObject("SERVIDOR>>> " + mensaje);
            salida.flush();
            ventana.mostrarMensaje("\nSERVIDOR>>> " + mensaje);
        } // procesar problemas que pueden ocurrir al enviar el objeto
        catch (IOException excepcionES) {
            ventana.errorTextArea();
        }
    }
}
