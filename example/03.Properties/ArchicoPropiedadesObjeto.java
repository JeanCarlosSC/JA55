
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JFileChooser;

public class ArchicoPropiedadesObjeto {

    Properties misPropiedades;
    File f;

    public ArchicoPropiedadesObjeto() {
        misPropiedades = new Properties();
        misPropiedades = cargar();
    }

    public void listarArchivo() {
        misPropiedades.list(System.out);
    }

    public void mostrarDatos() {
        String nombre = misPropiedades.getProperty("nombre");
        String lenguaje = misPropiedades.getProperty("lenguage");
        int edad = Integer.parseInt(misPropiedades.getProperty("edad"));
        boolean activo = Boolean.valueOf(misPropiedades.getProperty("activo")).booleanValue();
        System.out.println(nombre);
        System.out.println(lenguaje);
        System.out.println(activo);
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

}
