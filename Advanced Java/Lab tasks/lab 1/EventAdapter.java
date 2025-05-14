import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventAdapter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Demonstration");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTextArea eventLog = new JTextArea();
        eventLog.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(eventLog);
        
        // Using Event Listener Interfaces
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eventLog.append("Mouse clicked at (" + e.getX() + ", " + e.getY() + ")\n");
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                eventLog.append("Mouse pressed at (" + e.getX() + ", " + e.getY() + ")\n");
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                eventLog.append("Mouse released at (" + e.getX() + ", " + e.getY() + ")\n");
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                eventLog.append("Mouse entered frame\n");
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                eventLog.append("Mouse exited frame\n");
            }
        });
        
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                eventLog.append("Key typed: " + e.getKeyChar() + "\n");
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                eventLog.append("Key pressed: " + KeyEvent.getKeyText(e.getKeyCode()) + "\n");
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                eventLog.append("Key released: " + KeyEvent.getKeyText(e.getKeyCode()) + "\n");
            }
        });
        
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                eventLog.append("Window opened\n");
            }
            
            @Override
            public void windowClosing(WindowEvent e) {
                eventLog.append("Window closing\n");
            }
            
            @Override
            public void windowClosed(WindowEvent e) {
                eventLog.append("Window closed\n");
            }
            
            @Override
            public void windowIconified(WindowEvent e) {
                eventLog.append("Window minimized\n");
            }
            
            @Override
            public void windowDeiconified(WindowEvent e) {
                eventLog.append("Window restored\n");
            }
            
            @Override
            public void windowActivated(WindowEvent e) {
                eventLog.append("Window activated\n");
            }
            
            @Override
            public void windowDeactivated(WindowEvent e) {
                eventLog.append("Window deactivated\n");
            }
        });
        
        // Using Adapter Classes
        JButton adapterButton = new JButton("Adapter Demo");
        adapterButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eventLog.append("Adapter: Button clicked\n");
            }
        });
        
        JTextField adapterTextField = new JTextField(20);
        adapterTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    eventLog.append("Adapter: Enter pressed in text field\n");
                }
            }
        });
        
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Type here:"));
        inputPanel.add(adapterTextField);
        inputPanel.add(adapterButton);
        
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}