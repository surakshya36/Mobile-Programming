import javax.swing.*;
import java.awt.*;

public class SimpleInterest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Interest Calculator");
        frame.setLayout(new GridLayout(0, 1));
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel principalLabel = new JLabel("Principal:");
        JTextField principalText = new JTextField(10);

        JLabel rateLabel = new JLabel("Rate (%):");
        JTextField rateText = new JTextField(10);

        JLabel timeLabel = new JLabel("Time (years):");
        JTextField timeText = new JTextField(10);

        JLabel resultLabel = new JLabel("Simple Interest:");
        JLabel resultValue = new JLabel("");

        JButton calculateButton = new JButton("Calculate");

        calculateButton.addActionListener(e -> {
            try {
                double principal = Double.parseDouble(principalText.getText());
                double rate = Double.parseDouble(rateText.getText());
                double time = Double.parseDouble(timeText.getText());
                
                double interest = (principal * rate * time) / 100;
                resultValue.setText(String.format("%.2f", interest));
            } catch (NumberFormatException ex) {
                resultValue.setText("Invalid input");
            }
        });

        frame.add(principalLabel);
        frame.add(principalText);
        frame.add(rateLabel);
        frame.add(rateText);
        frame.add(timeLabel);
        frame.add(timeText);
        frame.add(resultLabel);
        frame.add(resultValue);
        frame.add(calculateButton);

        frame.setVisible(true);
    }
}
