import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SumDifference {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sum and Difference Calculator");
        frame.setLayout(new GridLayout(0, 1));
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel num1Label = new JLabel("First Number:");
        JTextField num1Text = new JTextField(10);

        JLabel num2Label = new JLabel("Second Number:");
        JTextField num2Text = new JTextField(10);

        JLabel resultLabel = new JLabel("Result:");
        JLabel resultValue = new JLabel("Press or release mouse here");

        resultValue.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Text.getText());
                    double num2 = Double.parseDouble(num2Text.getText());
                    resultValue.setText("Sum: " + (num1 + num2));
                } catch (NumberFormatException ex) {
                    resultValue.setText("Invalid input");
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Text.getText());
                    double num2 = Double.parseDouble(num2Text.getText());
                    resultValue.setText("Difference: " + (num1 - num2));
                } catch (NumberFormatException ex) {
                    resultValue.setText("Invalid input");
                }
            }
        });

        frame.add(num1Label);
        frame.add(num1Text);
        frame.add(num2Label);
        frame.add(num2Text);
        frame.add(resultLabel);
        frame.add(resultValue);

        frame.setVisible(true);
    }
}