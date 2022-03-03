package mundo;

public class Empleado {

    private String nombre;
    private String apellido;
    private int sexo;
    public void inicializar(String pNombre, String pApellido, int pSexo) {
        nombre = pNombre;
        apellido = pApellido;
        sexo = pSexo;
    }
    public String darApellido() {
        return apellido;
    }
    public String darNombre() {
        return nombre;
    }
    public int darSexo() {
        return sexo;
    }
}