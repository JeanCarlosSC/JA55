
package model;
import view.ServerGUI;
import java.io.*;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.DefaultListModel;
/**
 *
 * @author curlf
 */
public class Server extends Thread{
    // reference
    private Server mainServer;
    
    private DataInputStream entrada;
    private DataOutputStream salida;
    private ServerGUI server;
    private Socket Cliente;
    public static Vector<Server> usuarioActivo=new Vector();
    private String nombre;
    private ObjectOutputStream salidaObjeto;
    
    public Server(Server mainServer) {
        this.mainServer = mainServer;
        
        this.Cliente = socketclient;
        this.server=serv;
        this.nombre =nombre;
        usuarioActivo.add(this);
        
        for (int i=0; i<usuarioActivo.size(); i++){
            usuarioActivo.get(i).enviosMensajes(nombre+" se ha conectado");
        }
    }
    
    public void run(){
        String mensaje = "";
        while(true){
            try{
                entrada = new DataInputStream(Cliente.getInputStream());
                mensaje = entrada.readUTF();
                for(int i=0;1<usuarioActivo.size();i++){
                    usuarioActivo.get(i).enviosMensajes(mensaje);
                    server.mensajeria("Mensaje enviado");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            usuarioActivo.removeElement(this);
            server.mensajeria("El usuario se ha desconectado\n");
            try{
                Cliente.close();
            }
            catch(Exception e){
               e.printStackTrace();
            }
        }
    }
    
    private void enviosMensajes(String msg)throws Exception{
        salida = new DataOutputStream(Cliente.getOutputStream());
        salida.writeUTF(msg);
        DefaultListModel modelo = new DefaultListModel();
        for(int i=0; i<usuarioActivo.size();i++){
            modelo.addElement(usuarioActivo.get(i).nombre);
        }
        salidaObjeto = new ObjectOutputStream(Cliente.getOutputStream());
        salidaObjeto.writeObject(modelo);    
    }
    
}
