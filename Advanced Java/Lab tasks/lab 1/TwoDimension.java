import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class TwoDimension extends JFrame {
    public TwoDimension() {
        setTitle("2D Shapes Drawing");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        add(new DrawingPanel());
    }
    
    class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D)g;
            
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                                RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.RED);
            g2d.draw(new Line2D.Double(50, 50, 150, 50));
            
            g2d.setColor(Color.BLUE);
            g2d.draw(new Rectangle2D.Double(50, 70, 100, 60));
            
            g2d.setColor(new Color(0, 100, 0));
            g2d.fill(new Rectangle2D.Double(180, 70, 100, 60));
            
            g2d.setColor(Color.MAGENTA);
            g2d.draw(new RoundRectangle2D.Double(310, 70, 100, 60, 20, 20));
            
            g2d.setColor(Color.ORANGE);
            g2d.draw(new Ellipse2D.Double(50, 150, 100, 100));
            
            g2d.setColor(new Color(100, 0, 100));
            g2d.fill(new Ellipse2D.Double(180, 150, 100, 60));
            
            g2d.setColor(Color.CYAN);
            g2d.draw(new Arc2D.Double(310, 150, 100, 100, 45, 270, Arc2D.OPEN));
            
            g2d.setColor(new Color(150, 150, 0));
            g2d.fill(new Arc2D.Double(50, 270, 100, 80, 0, 120, Arc2D.PIE));
            
            g2d.setColor(new Color(0, 150, 150));
            g2d.fill(new Arc2D.Double(180, 270, 100, 80, 0, 120, Arc2D.CHORD));
            
            g2d.setColor(Color.BLACK);
            g2d.draw(new QuadCurve2D.Double(310, 270, 360, 200, 410, 270));
            
            g2d.setColor(Color.DARK_GRAY);
            g2d.draw(new CubicCurve2D.Double(50, 370, 100, 300, 150, 400, 200, 370));
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TwoDimension().setVisible(true);
        });
    }
}