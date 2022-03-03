package Elementos;

import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Servidor {

    private ServerSocket servidor;
    private Socket serverIn, serverOut;
    private InputStream is;
    private DataInputStream dis;
    private OutputStream os;
    private DataOutputStream dos;
    private BufferedReader delTeclado;

    public Servidor() {
        try {
            servidor = new ServerSocket(5051);
            System.out.println("Servidor en espera de conversacion ......");

            //se conecta el cliente
            serverIn = servidor.accept();
            System.out.println("Conversacion  iniciada......");
            
            //crear los flujos de comunicacion con el cliente
            crearFlujos();
        } catch (IOException e) {
            System.out.println("Error: No se pudo crear el Servidor");
        }
    }

    private void crearFlujos() {
        try {
            //flujos para leer desde el cliente
            is = serverIn.getInputStream();
            dis = new DataInputStream(is);

            //flujos para escribirle al cliente
            serverOut = new Socket(serverIn.getInetAddress(), 5052);
            os = serverOut.getOutputStream();
            dos = new DataOutputStream(os);
        } catch (IOException ex) {
            System.out.println("Error: No se pudo crear los flujos");
        }

        //activar la lectura de la consola
        delTeclado = new BufferedReader(new InputStreamReader(System.in));

        //iniciar la charla
        charlar();
    }

    /**
     * Cerrar todos los flujos y sockets
     */
    private void cerrarSockets() {
        try {
            dis.close();
            dos.close();
            serverIn.close();
            serverOut.close();
            servidor.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: no se pudo cerrar los sockets");
        }
    }

    private void charlar() {
        String teclado = null, delCliente = "";
        String[] palabras = new String[2];
        palabras[1] = "";
        try {
            //validar que no sea la despedida
            while (!palabras[1].equalsIgnoreCase("chao")) {
                //se lee el mensaje del cliente
                delCliente = dis.readUTF();
                System.out.print("\n" + delCliente);
                palabras = delCliente.split(">>");
                //si el cliente aun no se despide
                if (!palabras[1].equalsIgnoreCase("Chao")) {
                    //se lee el mensaje a enviar al cliente
                    System.out.print("\nMensaje: ");
                    teclado = delTeclado.readLine();
                    dos.writeUTF("Servidor >>" + teclado);
                    //si el servidor se despide
                    if (teclado.equalsIgnoreCase("chao")) {
                        palabras[1] = "chao";
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: no se pudo leer desde el socket");
        }

        System.out.println("\nSe termino la conversacion");
        //se cierran todos los canales y los sockets
        cerrarSockets();
    }

    public static void main(String[] args) {
        new Servidor();
    }
}