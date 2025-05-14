import javax.swing.*;

class EmptyFrame extends JFrame {
    public EmptyFrame() {
        setTitle("Empty Frame - Inheritance Concept");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
public class Concepts {
    public static void main(String[] args) {
        JFrame frameObject = new JFrame("Empty Frame - Object");
        frameObject.setSize(400, 300);
        frameObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameObject.setLocationRelativeTo(null);
        frameObject.setVisible(true);
        EmptyFrame frame = new EmptyFrame();
        frame.setVisible(true);
    }
}