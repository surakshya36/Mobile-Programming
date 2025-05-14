import javax.swing.*;
import java.awt.*;

public class ButtonLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Layout Managers Demo");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1)); // Main frame layout

        // 1. FlowLayout
        JPanel flowPanel = new JPanel(new FlowLayout());
        flowPanel.add(new JButton("Flow 1"));
        flowPanel.add(new JButton("Flow 2"));
        flowPanel.add(new JButton("Flow 3"));
        flowPanel.add(new JButton("Flow 4"));
        flowPanel.add(new JButton("Flow 5"));
        frame.add(new JLabel("FlowLayout:"));
        frame.add(flowPanel);

        // 2. BorderLayout
        JPanel borderPanel = new JPanel(new BorderLayout());
        borderPanel.add(new JButton("North"), BorderLayout.NORTH);
        borderPanel.add(new JButton("South"), BorderLayout.SOUTH);
        borderPanel.add(new JButton("East"), BorderLayout.EAST);
        borderPanel.add(new JButton("West"), BorderLayout.WEST);
        borderPanel.add(new JButton("Center"), BorderLayout.CENTER);
        frame.add(new JLabel("BorderLayout:"));
        frame.add(borderPanel);

        // 3. GridLayout
        JPanel gridPanel = new JPanel(new GridLayout(2, 3));
        gridPanel.add(new JButton("Grid 1"));
        gridPanel.add(new JButton("Grid 2"));
        gridPanel.add(new JButton("Grid 3"));
        gridPanel.add(new JButton("Grid 4"));
        gridPanel.add(new JButton("Grid 5"));
        frame.add(new JLabel("GridLayout:"));
        frame.add(gridPanel);

        // 4. BoxLayout
        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
        boxPanel.add(new JButton("Box 1"));
        boxPanel.add(new JButton("Box 2"));
        boxPanel.add(new JButton("Box 3"));
        boxPanel.add(new JButton("Box 4"));
        boxPanel.add(new JButton("Box 5"));
        frame.add(new JLabel("BoxLayout:"));
        frame.add(boxPanel);

        // 5. GridBagLayout
        JPanel gridBagPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 0; gbc.gridy = 0;
        gridBagPanel.add(new JButton("GBC 1"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 0;
        gridBagPanel.add(new JButton("GBC 2"), gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        gridBagPanel.add(new JButton("GBC 3"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 1;
        gridBagPanel.add(new JButton("GBC 4"), gbc);
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        gridBagPanel.add(new JButton("GBC 5"), gbc);
        
        frame.add(new JLabel("GridBagLayout:"));
        frame.add(gridBagPanel);

        frame.setVisible(true);
    }
}