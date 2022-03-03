
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JFileChooser;

public class Prueba {

    Properties misPropiedades;
    File f;

    public Prueba() {
        misPropiedades = new Properties();
        misPropiedades = cargar();
    }

    public void listarArchivo() {
        misPropiedades.list(System.out);
    }

    public void mostrarDatos() {
        String nombre = misPropiedades.getProperty("user.nombre");
        String apellido = misPropiedades.getProperty("user.apellido");
        int edad = Integer.parseInt(misPropiedades.getProperty("user.edad"));
        boolean mujer = Boolean.valueOf(
                misPropiedades.getProperty("user.mujer")).booleanValue();
        System.out.println(nombre);
        System.out.println(apellido);
        System.out.println(edad);
        System.out.println(mujer);
    }

    public Properties cargar() {
        try {
            JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
            fc.showOpenDialog(fc);
            f = fc.getSelectedFile();
            FileInputStream archivo = new FileInputStream(f);
            Properties propiedades = new Properties();
            propiedades.load(archivo);
            archivo.close();
            if (!propiedades.isEmpty()) {
                return propiedades;
            }

        } catch (Exception e) {
            System.out.println("No se pudo cargar el archivo properties");
        }
        return null;
    }

    public static void main(String[] args) {
        Prueba p = new Prueba();
        p.listarArchivo();
        p.mostrarDatos();
    }
}
