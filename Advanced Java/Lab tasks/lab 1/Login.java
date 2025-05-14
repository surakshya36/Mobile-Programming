import javax.swing.*;
import java.awt.*;

public class Login {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Form");
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel userLabel = new JLabel("Username:");
        JTextField userText = new JTextField(15);

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passText = new JPasswordField(15);

        JButton loginButton = new JButton("Login");
        JButton cancelButton = new JButton("Cancel");

        frame.add(userLabel);
        frame.add(userText);
        frame.add(passLabel);
        frame.add(passText);
        frame.add(loginButton);
        frame.add(cancelButton);

        frame.setVisible(true);
    }
}