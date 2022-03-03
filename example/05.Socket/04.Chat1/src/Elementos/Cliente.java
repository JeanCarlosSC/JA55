package Elementos;

import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Cliente {

    private ServerSocket fromServer;
    private OutputStream os1;
    private DataOutputStream dos;
    private Socket clienteOut, clienteIn;
    private InputStream is;
    private DataInputStream dis;
    private BufferedReader delTeclado;

    public Cliente() {
        try {
            //se crea el socket que se va a comunicar con el servidor
            // se debe ubicar la direccion del servidor
            clienteOut = new Socket("localhost", 5051);
            System.out.println("Cliente Conectado al servidor ......");
            crearFlujos();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: no se encontro el servidor");
        }
    }

    private void crearFlujos() {
        try {
            //Crear el flujo de escritura hacia el servidor
            os1 = clienteOut.getOutputStream();
            dos = new DataOutputStream(os1);
            
            //se crea el socket por el que se va a escuchar el servidor
            fromServer = new ServerSocket(5052);
            
            //Crear el flujo de lectura desde el servidor
            clienteIn = fromServer.accept();
            is = clienteIn.getInputStream();
            dis = new DataInputStream(is);
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "Error: no se encontro el servidor");
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, "Error: no se pudo crear los flujos");
        }
        //activar la lectura de la consola
        delTeclado = new BufferedReader(new InputStreamReader(System.in));
        charlar();
    }

    private void cerrarSockets() {
        try {
            dis.close();
            clienteIn.close();
            clienteOut.close();
            dos.close();
            fromServer.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: no se pudo cerrar los sockets");
        }
    }

    private void charlar() {
        String teclado = null, delServidor="";
        String[] palabras= new String[2];
        palabras[1]="";
        
            try {
                do {
                System.out.print("\nMensaje: ");
                teclado = delTeclado.readLine();
                dos.writeUTF("Cliente >>"+teclado);
                if(!teclado.equalsIgnoreCase("Chao")){
                delServidor = dis.readUTF();
                palabras = delServidor.split(">>");
                System.out.print("\n" + delServidor);
                 if(palabras[1].equalsIgnoreCase("chao"))
                    teclado="Chao";
                
                 }
                } while (!teclado.equalsIgnoreCase("Chao"));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error: no se pudo leer desde el socket");
            }
        
        System.out.println("\nSe termino la conversacion");
        cerrarSockets();
    }

    public static void main(String[] x) {
         new Cliente();
    }
}