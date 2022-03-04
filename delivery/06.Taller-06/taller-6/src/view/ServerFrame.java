package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import control.server.Server;

public class ServerFrame extends JFrame{
    //constant
    private final int WIDTH = 400;
    private final int HEIGHT = 500;
    
    // reference
    private Server server;
    
    // component
    JTextArea taChat;
    
    public ServerFrame(Server server) {
        this.server = server;
        
        initComponents();
        initGUI();
        initProperties();
    }
    
    public void printMessage(String message) {
        taChat.append(message + ".\n"); // every message ends with dot
    }
    
    private void initComponents() {
        taChat = new JTextArea();
        taChat.setBounds(16, 16, WIDTH-48, HEIGHT-120);
        taChat.setBackground(new Color(230,230,230));
        taChat.setEditable(false);
    }
    
    private void initGUI() {
        JPanel header = new JPanel();
        header.setSize(WIDTH-16, 48);
        header.setLocation(0, 0);
        header.setBackground(new Color(57,255,90));
        header.setLayout(null);
        
        JLabel lTitle = new JLabel("Server", SwingConstants.CENTER);
        lTitle.setBounds(0, 0, WIDTH-16, 48);
        header.add(lTitle);
        
        JPanel chatContainer = new JPanel();
        chatContainer.setLayout(null);
        chatContainer.setBounds(16, 64, WIDTH-48, HEIGHT-120);
        
        JLabel lLog = new JLabel("Log");
        lLog.setBounds(16, 16, 100, 16);
        chatContainer.add(lLog);
        
        JScrollPane scroll = new JScrollPane(taChat);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(16, 48, WIDTH-80, HEIGHT-186);
        chatContainer.add(scroll);
        
        add(chatContainer);
        add(header);
    }
    
    private void initProperties() {
        setResizable(false);
        getContentPane().setBackground(new Color(174,185,204));
        setLayout(null);
        setTitle("Server");
        setSize(WIDTH, HEIGHT);
        setLocation(32, 32);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}
