/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;
import modelo.User;
import vista.Vista;

/**
 *
 * @author Jean Carlos Santoya Cabrera
 */
public class Control implements ActionListener {

    private Vista vista;
    private Properties propiedades;
    private ArrayList<User> users;
    RandomAccessFile archivo;
    File fl;

    public Control(Vista vista) {
        this.vista = vista;
        
        try {
            fl = new File("archivoAccesoAleatorio.dat");
            archivo = new RandomAccessFile(fl, "rw");
        } catch (FileNotFoundException fnfe) {/* Archivo no encontrado */
        }
        
        //cargar propiedades
        propiedades = new Properties();
        InputStream entrada = null;
        try {
            entrada = new FileInputStream("src/Configuracion.properties");
            propiedades.load(entrada);

            users = new ArrayList();

            try {
                int i = 1;
                while (true) {
                    User usuario = new User();
                    usuario.setNombre(propiedades.getProperty("user" + i + ".nombre"));
                    usuario.setIdioma(propiedades.getProperty("user" + i + ".idioma"));
                    usuario.setEdad(Integer.parseInt(propiedades.getProperty("user" + i + ".edad")));
                    usuario.setSexo(propiedades.getProperty("user" + i + ".mujer"));

                    users.add(usuario);
                    i++;
                }
            } catch (Exception e) {
            }

            //Action listeners
            vista.getLimpiar().addActionListener(this);
            vista.getAñadir().addActionListener(this);
            vista.getGuardar().addActionListener(this);
            vista.getGuardarAleatorio().addActionListener(this);

            vista.setLocationRelativeTo(null);
            vista.setVisible(true);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getLimpiar()) {
            vista.getNombre().setText("");
            vista.getIdioma().setText("");
            vista.getEdad().setText("");
            vista.getSexo().setText("");
        }
        if (e.getSource() == vista.getAñadir()) {
            User user = new User();
            user.setNombre(vista.getNombre().getText());
            user.setEdad(Integer.parseInt(vista.getEdad().getText()));
            user.setIdioma(vista.getIdioma().getText());
            user.setSexo(vista.getSexo().getText());

            users.add(user);
        }
        if(e.getSource() == vista.getGuardar()) {
            guardarUsuarios();
        }
        if(e.getSource() == vista.getGuardarAleatorio()) {
            guardarArchivoAccesoAleatorio();
        }
    }

    private void guardarUsuarios() {
        Properties propiedades = new Properties();
        OutputStream salida = null;
        try {
            File file = new File("nuevoUsuario.properties");
            file.createNewFile();
            salida = new FileOutputStream("nuevoUsuario.properties");
            for(int i=0; i<users.size(); i++) {
                propiedades.setProperty("user"+i+".nombre", users.get(i).getNombre());
                propiedades.setProperty("user"+i+".edad", ""+users.get(i).getEdad());
                propiedades.setProperty("user"+i+".idioma", users.get(i).getIdioma());
                propiedades.setProperty("user"+i+".sexo", users.get(i).getSexo());
            }
            // guardamos el archivo de propiedades en la carpeta de aplicación
            propiedades.store(salida, null);
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private void guardarArchivoAccesoAleatorio() {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        try {
            if (users.size() <= 0) {
                JOptionPane.showMessageDialog(vista, "\nNo hay registros. Se escribira el primero.");
            }
            else{
                for (User user: users) {
                    archivo.writeChars(user.getNombre());
                    archivo.writeChars(user.getIdioma());
                    archivo.writeInt(user.getEdad());
                    archivo.writeChars(user.getSexo());
                }
            }
        } catch (FileNotFoundException fnfe) {/* Archivo no encontrado */
        } catch (IOException ioe) {
            /* Error al escribir */
        }
    }
    
}
