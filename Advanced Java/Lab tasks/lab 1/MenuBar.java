import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuBar {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Test");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem exitItem = new JMenuItem("Exit");
        
        exitItem.addActionListener(e -> System.exit(0));
        
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
      
        JMenu optionsMenu = new JMenu("Options");
        JCheckBoxMenuItem readOnlyItem = new JCheckBoxMenuItem("Read-only");
        JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Insert", true);
        JRadioButtonMenuItem overtypeItem = new JRadioButtonMenuItem("Overtype");
        
        ButtonGroup modeGroup = new ButtonGroup();
        modeGroup.add(insertItem);
        modeGroup.add(overtypeItem);
        
        optionsMenu.add(readOnlyItem);
        optionsMenu.addSeparator();
        optionsMenu.add(insertItem);
        optionsMenu.add(overtypeItem);
        
        editMenu.addSeparator();
        editMenu.add(optionsMenu);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        frame.setJMenuBar(menuBar);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        ActionListener menuAction = e -> {
            JMenuItem source = (JMenuItem)e.getSource();
            textArea.append("Selected: " + source.getText() + "\n");
        };
        
        newItem.addActionListener(menuAction);
        openItem.addActionListener(menuAction);
        cutItem.addActionListener(menuAction);
        copyItem.addActionListener(menuAction);
        pasteItem.addActionListener(menuAction);
        aboutItem.addActionListener(menuAction);
        readOnlyItem.addActionListener(menuAction);
        insertItem.addActionListener(menuAction);
        overtypeItem.addActionListener(menuAction);

        frame.setVisible(true);
    }
}