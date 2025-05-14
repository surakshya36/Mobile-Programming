import javax.swing.*;
import java.awt.*;

public class Factorial {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Factorial Calculator");
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel numberLabel = new JLabel("Enter a number:");
        JTextField numberText = new JTextField(10);
        JButton calculateButton = new JButton("Calculate Factorial");

        calculateButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(numberText.getText());
                if (num < 0) {
                    JOptionPane.showMessageDialog(frame, "Please enter a non-negative integer", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    long factorial = 1;
                    for (int i = 1; i <= num; i++) {
                        factorial *= i;
                    }
                    JOptionPane.showMessageDialog(frame, 
                        "Factorial of " + num + " is " + factorial, 
                        "Result", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid integer", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        frame.add(numberLabel);
        frame.add(numberText);
        frame.add(calculateButton);
        frame.setVisible(true);
    }
}
