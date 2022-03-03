
package model;
import view.ClientGUI;
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
public class Client extends Thread{
    private Socket SocketCliente;
    private DataInputStream entrada;
    private ClientGUI cliente;
    private ObjectInputStream entradaObjeto;
    
    public Client(Socket SocketCliente,ClientGUI cliente){
        this.SocketCliente = SocketCliente;
        this.cliente =cliente; 
    }
    
    public void run(){/*
        while(true){
            try{
                entrada = new DataInputStream(SocketCliente.getInputStream());
                //cliente.mensajeria(entrada.readUTF());
                
                //entradaObjeto=new ObjectInputStream(SocketCliente.getInputStream());
//                cliente.actualizarLista((DefaultListModel) entradaObjeto.readObject());
             
            }catch(ClassNotFoundException ex){
                Logger.getLogger(HiloClient.class.getName()).log(Level.SEVERE,null,ex);
                
            } catch (IOException ex) {
                Logger.getLogger(HiloClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }*/
    }
}
