import java.rmi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ProductClient extends JFrame {
    private JTextField num1Field, num2Field, resultField;
    private JButton calculateButton;
    private ProductService productService;
    public ProductClient() {
        super("RMI Product Calculator");
        setLayout(new GridLayout(4, 2));
        add(new JLabel("Number 1:"));
        num1Field = new JTextField();
        add(num1Field);
        add(new JLabel("Number 2:"));
        num2Field = new JTextField();
        add(num2Field);
        add(new JLabel("Product:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);
        calculateButton = new JButton("Calculate Product");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateProduct();
            }
        });
        add(calculateButton);
        try {
            productService = (ProductService)Naming.lookup("rmi://localhost/ProductServer");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error connecting to server: " + ex.getMessage());
            System.exit(1);
        }
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void calculateProduct() {
        try {
            int num1 = Integer.parseInt(num1Field.getText());
            int num2 = Integer.parseInt(num2Field.getText());
            int product = productService.calculateProduct(num1, num2);
            resultField.setText(String.valueOf(product));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        new ProductClient();
    }
}