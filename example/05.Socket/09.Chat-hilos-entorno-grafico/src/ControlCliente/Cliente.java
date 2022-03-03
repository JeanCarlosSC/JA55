package ControlCliente;

import VistaCliente.VentanaCliente;

import java.io.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.*;

public class Cliente implements ActionListener {

    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private String mensaje = "";
    private String servidorChat;
    private Socket cliente;

    private VentanaCliente ventana;

    // inicializar servidorChat y configurar GUI
    public Cliente(String host) {

        ventana = new VentanaCliente(this);
        servidorChat = host; // establecer el servidor al que se va a conectar este cliente

        // crear campoIntroducir y registrar componente de escucha
    } // fin del constructor de Cliente

    // conectarse al servidor y procesar mensajes del servidor
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

    public void ejecutarCliente() {
        // conectarse al servidor, obtener flujos, procesar la conexión
        try {
            conectarAServidor(); // Paso 1: crear un socket para realizar la conexión
            obtenerFlujos();      // Paso 2: obtener los flujos de entrada y salida
            procesarConexion(); // Paso 3: procesar la conexión
        } // el servidor cerró la conexión
        catch (EOFException excepcionEOF) {
            System.err.println("El cliente termino la conexión");
        } // procesar los problemas que pueden ocurrir al comunicarse con el servidor
        catch (IOException excepcionES) {
            excepcionES.printStackTrace();
        } finally {
            cerrarConexion(); // Paso 4: cerrar la conexión
        }

    } // fin del método ejecutarCliente

    // conectarse al servidor
    private void conectarAServidor() throws IOException {
        ventana.mostrarMensaje("Intentando realizar conexión\n");

        // crear Socket para realizar la conexión con el servidor
        cliente = new Socket(InetAddress.getByName(servidorChat), 12345);

        // mostrar la información de la conexión
        ventana.mostrarMensaje("Conectado a: " + cliente.getInetAddress().getHostName());
    }

    // obtener flujos para enviar y recibir datos
    private void obtenerFlujos() throws IOException {
        // establecer flujo de salida para los objetos
        salida = new ObjectOutputStream(cliente.getOutputStream());
        salida.flush(); // vacíar búfer de salida para enviar información de encabezado

        // establecer flujo de entrada para los objetos
        entrada = new ObjectInputStream(cliente.getInputStream());

        ventana.mostrarMensaje("\nSe recibieron los flujos de E/S\n");
    }

    // procesar la conexión con el servidor
    private void procesarConexion() throws IOException {
        // habilitar campoIntroducir para que el usuario del cliente pueda enviar mensajes
        ventana.establecerCampoTextoEditable(true);

        do { // procesar mensajes enviados del servidor

            // leer mensaje y mostrarlo en pantalla
            try {
                mensaje = (String) entrada.readObject();
                ventana.mostrarMensaje("\n" + mensaje);
            } // atrapar los problemas que pueden ocurrir al leer del servidor
            catch (ClassNotFoundException excepcionClaseNoEncontrada) {
                ventana.mostrarMensaje("\nSe recibió un objeto de tipo desconocido");
            }

        } while (!mensaje.equals("SERVIDOR>>> TERMINAR"));

    } // fin del método procesarConexion

    // cerrar flujos y socket
    private void cerrarConexion() {
        ventana.mostrarMensaje("\nCerrando conexión");
        ventana.establecerCampoTextoEditable(false); // deshabilitar campoIntroducir

        try {
            salida.close();
            entrada.close();
            cliente.close();
        } catch (IOException excepcionES) {
            excepcionES.printStackTrace();
        }
    }

    // enviar mensaje al servidor
    private void enviarDatos(String mensaje) {
        // enviar objeto al servidor
        try {
            salida.writeObject("CLIENTE>>> " + mensaje);
            salida.flush();
            ventana.mostrarMensaje("\nCLIENTE>>> " + mensaje);
        } // procesar los problemas que pueden ocurrir al enviar el objeto
        catch (IOException excepcionES) {
            ventana.errorTextArea();
        }
    }

} // fin de la clase Cliente
