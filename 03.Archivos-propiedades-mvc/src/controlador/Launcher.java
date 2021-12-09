/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;

import vista.Vista;

/**
 *
 * @author Jean Carlos Santoya Cabrera
 */
public class Launcher {
    public static void main (String[] args) {
        Vista vista = new Vista();
        new Control(vista);
    }
}
