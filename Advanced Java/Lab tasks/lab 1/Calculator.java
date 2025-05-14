import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Arithmetic Operations");
        frame.setLayout(new GridLayout(0, 1));
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel num1Label = new JLabel("First Number:");
        JTextField num1Text = new JTextField(10);

        JLabel num2Label = new JLabel("Second Number:");
        JTextField num2Text = new JTextField(10);

        JLabel resultLabel = new JLabel("Result:");
        JTextField resultText = new JTextField(10);
        resultText.setEditable(false);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add");
        JButton subButton = new JButton("Subtract");
        JButton mulButton = new JButton("Multiply");
        JButton divButton = new JButton("Divide");

        // Add action listeners
        addButton.addActionListener(e -> {
            try {
                double num1 = Double.parseDouble(num1Text.getText());
                double num2 = Double.parseDouble(num2Text.getText());
                resultText.setText(String.valueOf("Sum: " + (num1 + num2)));
            } catch (NumberFormatException ex) {
                resultText.setText("Invalid input");
            }
        });

        subButton.addActionListener(e -> {
            try {
                double num1 = Double.parseDouble(num1Text.getText());
                double num2 = Double.parseDouble(num2Text.getText());
                resultText.setText(String.valueOf("Difference: " + (num1 - num2)));
            } catch (NumberFormatException ex) {
                resultText.setText("Invalid input");
            }
        });

        mulButton.addActionListener(e -> {
            try {
                double num1 = Double.parseDouble(num1Text.getText());
                double num2 = Double.parseDouble(num2Text.getText());
                resultText.setText(String.valueOf("Product: " +(num1 * num2)));
            } catch (NumberFormatException ex) {
                resultText.setText("Invalid input");
            }
        });

        divButton.addActionListener(e -> {
            try {
                double num1 = Double.parseDouble(num1Text.getText());
                double num2 = Double.parseDouble(num2Text.getText());
                if (num2 == 0) {
                    resultText.setText("Cannot divide by zero");
                } else {
                    resultText.setText(String.valueOf("Quotient: "+(num1 / num2)));
                }
            } catch (NumberFormatException ex) {
                resultText.setText("Invalid input");
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);

        frame.add(num1Label);
        frame.add(num1Text);
        frame.add(num2Label);
        frame.add(num2Text);
        frame.add(resultLabel);
        frame.add(resultText);
        frame.add(buttonPanel);

        frame.setVisible(true);
    }
}