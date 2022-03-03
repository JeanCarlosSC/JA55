package CajaColores;

import javax.swing.*;
import java.awt.*;

class CajaColor extends JPanel implements Runnable {

    private Thread t;
    private int pause;
    private static final Color[] colors = {
        Color.black, Color.blue, Color.cyan,
        Color.darkGray, Color.gray, Color.green,
        Color.lightGray, Color.magenta,
        Color.orange, Color.pink, Color.red,
        Color.white, Color.yellow
    };
    private Color colorCaja = pintarColor();

    private static final Color pintarColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(colorCaja);
        Dimension s = getSize();
        g.fillRect(0, 0, s.width, s.height);
    }

    public CajaColor(int pause) {
        this.pause = pause;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        while (true) {
            colorCaja = pintarColor();
            repaint();
            try {
                t.sleep((int) (Math.random() * pause));
            } catch (InterruptedException e) {
            }
        }
    }
}
