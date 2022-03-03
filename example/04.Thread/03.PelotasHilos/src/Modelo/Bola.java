
package Modelo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Component;
import java.awt.GradientPaint;

import java.awt.geom.*;

public class Bola { 
    private Component canvas;
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;
    private int color;
    
    private static final Color[] colores = {
        Color.white, Color.blue, Color.cyan,
        Color.gray, Color.green, Color.magenta,
        Color.orange, Color.pink, Color.red,
        Color.darkGray, Color.yellow
    };


    public Bola(Component c) {
        canvas = c;
        color=(int) (Math.random() * colores.length);
    } 
    
    // Construimos una bola
    public void draw(Graphics2D g2) { // Dibujamos bola, posicion corriente
       g2.setPaint( new GradientPaint( 5, 30, Color.BLUE, 35, 100, Color.YELLOW, true ) );  
       g2.fill( new Ellipse2D.Double( x, y, XSIZE, YSIZE ) );
    }

    public void move() { // Movemos bola
        x += dx;
        y += dy;
        if (x < 0) {
            x = 0;
            dx = -dx;
        }
        if (x + XSIZE >= canvas.getWidth()) {
            x = canvas.getWidth() - XSIZE;
            dx = -dx;
        }
        if (y < 0) {
            y = 0;
            dy = -dy;
        }
        if (y + YSIZE >= canvas.getHeight()) {
            y = canvas.getHeight() - YSIZE;
            dy = -dy;
        }
        canvas.repaint();
    }
}