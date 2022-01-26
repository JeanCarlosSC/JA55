package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends JFrame implements ActionListener {
    private final int WIDTH = 385;
    private final int HEIGHT = 300;

    private JButton btClose;
    private JLabel lText;

    public Window () {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                confirmExit();
            }
        });

        initComponents();
        setTitle("My window");
        setSize(WIDTH, HEIGHT);
        setVisible(true);
    }

    private void confirmExit() {
        int answer = JOptionPane.showConfirmDialog(this, "Do you want to exit?", "Exit notification", JOptionPane.YES_NO_OPTION);
        if (answer == 0) {
            System.exit(0);
        }
    }

    private void initComponents() {
        getContentPane().setLayout(null);

        btClose = new JButton("Close");
        btClose.setBounds(new Rectangle(250, 220, 120, 25));
        btClose.addActionListener(this);

        lText = new JLabel();
        lText.setText("Boring text");
        lText.setBounds(new Rectangle(135, 80, 120, 35));
        lText.setToolTipText("Description of this boring label");
        lText.setFont(new Font("Dialog", 1, 20));
        lText.setForeground(Color.red);

        getContentPane().add(lText);
        getContentPane().add(btClose);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btClose) {
            confirmExit();
        }
    }
}
