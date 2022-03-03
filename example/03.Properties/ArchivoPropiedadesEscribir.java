
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ArchivoPropiedadesEscribir {

    public static void main(String[] args) {
        Properties propiedades = new Properties();
        OutputStream salida = null;
        try {
            salida = new FileOutputStream("C:\\Users\\Jhon\\Documents\\NetBeansProjects\\ArchivoPropiedades\\src\\configuracion.properties");
            propiedades.setProperty("basedatos", "codehero");
            propiedades.setProperty("usuario", "carlos");
            propiedades.setProperty("clave", "123456");
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

}
