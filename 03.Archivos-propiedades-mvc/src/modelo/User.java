/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 *
 * @author Jean Carlos Santoya Cabrera
 */
public class User {
    private String nombre;
    private String idioma;
    private int edad;
    private String sexo;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getIdioma() {
        return idioma;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }
    
}
