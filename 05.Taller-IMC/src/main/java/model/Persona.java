package model;

/**
 *
 * @author Jean Carlos Santoya Cabrera
 */
public class Persona {
    private int cedula;
    private String nombre;
    private String apellido;
    private double imc;
    private double peso;
    private double altura;

    public Persona(int cedula, String nombre, String apellido, double imc) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.imc = imc;
        this.peso = peso;
        this.altura = altura;
    }

    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getImc() {
        return imc;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }
    
}
