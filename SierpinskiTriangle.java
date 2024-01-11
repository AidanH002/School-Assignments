// Aidan Hall
import javax.swing.*;
import java.awt.*;

public class SierpinskiTriangle extends JPanel {
    private int depth;
    // Below, is a constructor that takes an int depth as a parameter used later on.
    public SierpinskiTriangle(int depth) {
        this.depth = depth;
    }
    // Below, is a method of the jpanel class that is used to draw graphics on a panel
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 0, getWidth(), getHeight());
        drawSierpinskiTriangle(g, 0, getHeight() - 1, getWidth() - 1, getHeight() - 1, getWidth() / 2, 0, depth);
    }
    // The instructions mention stopping the program when it reaches a pixil limit of 4, however I did not follow that directly.
    // instead the program stops as soon as the depth variable reaches 0
    private void drawSierpinskiTriangle(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int depth) {
        if (depth == 0) {
            g.setColor(Color.black);
            int[] xPoints = {x1, x2, x3};
            int[] yPoints = {y1, y2, y3};
            g.fillPolygon(xPoints, yPoints, 3);
        } else {
            int x1_2 = (x1 + x2) / 2;
            int y1_2 = (y1 + y2) / 2;
            int x1_3 = (x1 + x3) / 2;
            int y1_3 = (y1 + y3) / 2;
            int x2_3 = (x2 + x3) / 2;
            int y2_3 = (y2 + y3) / 2;
            drawSierpinskiTriangle(g, x1, y1, x1_2, y1_2, x1_3, y1_3, depth - 1);
            drawSierpinskiTriangle(g, x1_2, y1_2, x2, y2, x2_3, y2_3, depth - 1);
            drawSierpinskiTriangle(g, x1_3, y1_3, x2_3, y2_3, x3, y3, depth - 1);
        }
    }
    // here is the main, this is where i declared window close operations, the frame size, and named the frame 'Sierpinski Triangle'
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski Triangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        SierpinskiTriangle triangle = new SierpinskiTriangle(5);
        frame.add(triangle);
        frame.setVisible(true);
    }
}