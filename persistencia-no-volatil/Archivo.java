package Taller.Secuencial;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
/**
 * Clase que lee y escribe en un archivo secuencial
 * @author Jhon
 */
public class Archivo {
        //Puntero al archivo
	File f;
        //Ventana Selectora
	JFileChooser fc;
	
	public Archivo(){
                //confirguracion de la ventana selectora
		fc=new JFileChooser(System.getProperty("user.dir"));   
		fc.showOpenDialog(fc);
		f=fc.getSelectedFile(); 
	}
        /**
         * Metodo para leer lines de texto escritas en un archivo secuencial
         */
	public void leer(){
		try{
                    //Se coloca un puntero al archivo
			FileInputStream f1 =new FileInputStream(f);
                        //se crea el cana de lectura de flujo
			InputStreamReader f2= new InputStreamReader(f1);
                        // Se crea el bloque de memoria para cargar cada lectura
			BufferedReader linea= new BufferedReader(f2);
                        //Se valida que el archivo exista
			if (f.exists())	{
	  	          System.out.println("El fichero " + f + " existe \nSu contenido es: \n");
	  	          String linea_arch=linea.readLine();
                          //se lee el archivo mientras tenga lineas de texto
	  	          while (linea_arch != null) {
	  	        	  System.out.println(linea_arch);
	  	        	  linea_arch = linea.readLine();
	  	          }
                          //se cierra el enlace d electura
	  	          linea.close();
			}
			else{System.out.println("archivo no existe");}
		}catch(IOException e){System.out.println("No se pudo leer del archivo");}
	}
	
	public void Escribir(){
		try{
                    //se crea el canal de salida --> escritura al archivo
			InputStreamReader isr= new InputStreamReader(System.in);
                        //Se va a escribir por bloques de memoria
			BufferedReader linea= new BufferedReader(isr);
			System.out.println("Digite la nueva linea: \t");
                        //se lee la linea a escribir
			String linea_arch=linea.readLine();
                        //se crea el escritor
			FileWriter linea_tx= new FileWriter(f,true);
                        //se escribe la linea
			linea_tx.write(linea_arch+"\r\n");
			linea_tx.close();
		}catch(IOException e){System.out.print("No se pudo escribir");} 
	}
	
	public static void main(String [] args){
		Archivo arch=new Archivo();
		arch.leer();
		arch.Escribir();
	}
}