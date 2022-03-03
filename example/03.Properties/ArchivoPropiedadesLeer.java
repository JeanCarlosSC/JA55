
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ArchivoPropiedadesLeer {

    public static void main(String[] args) {
        Properties propiedades = new Properties();
        InputStream entrada = null;
        try {
            entrada = new FileInputStream("C:\\Users\\Jhon\\Documents\\NetBeansProjects\\ArchivoPropiedades\\src\\configuracion.properties");
            propiedades.load(entrada);
            System.out.println(propiedades.getProperty("basedatos"));
            System.out.println(propiedades.getProperty("usuario"));
            System.out.println(propiedades.getProperty("clave"));
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
}
