package Vista;

import Modelo.Bola;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class BolaCanvas extends JPanel {
    private ArrayList bolas = new ArrayList();

    public void add(Bola b) {
        bolas.add(b);
    }

    public void paintComponent(Graphics g) { 
        setBackground(Color.black);
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < bolas.size(); i++) {
            Bola b = (Bola) bolas.get(i);
            b.draw(g2);
        }
    }
} 