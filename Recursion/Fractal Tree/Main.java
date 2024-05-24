import java.awt.*;
import javax.swing.*;

class Main extends JFrame {

    private Canvas canvas;

    public Main() {
        super("Tree");
        this.setSize(600, 500);
        this.setVisible(true);

        canvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
                Graphics2D g2D = (Graphics2D) g;
                drawTree(g2D, 300, 500, -90, 7, 10);
            }
        };
        this.add(canvas);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void drawTree(Graphics2D g, int x1, int y1, double angle, int length, int width) {
        if(angle > 0 || angle < -180)
        {
          return;
        }
        if (length == 0) {  // base case
            return;
        }
    
        if (width < 1) width = 1;
        g.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * length * 16.0);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * length * 16.0);

        // sets the color of the line to be drawn
        int[] bloodRed = {136, 8, 8};
        int[] cherry = {210, 4, 45};
        int[] coralOrange = {255, 127, 80};
        int[] neonOrange = {255, 95, 31};
        int[] amber = {255, 191, 0};
        int[] brightOrange = {255, 172, 28};
        int[][] leafColors = {bloodRed, cherry, coralOrange, neonOrange, amber, brightOrange};

        if (length <= 3)
        {
          int randomColor = (int)(Math.random() * 6);
          int color1 = leafColors[randomColor][0];
          int color2 = leafColors[randomColor][1];
          int color3 = leafColors[randomColor][2];
          g.setColor(new Color(color1, color2, color3));
        }
        else
        {
          g.setColor(new Color(110, 38, 14));
        }
      
        // draws the line
        g.drawLine(x1, y1, x2, y2);

        // recursive calls
        drawTree(g, x2, y2, angle + (int)(Math.random()*120) - 60, length-1, width-(int)(Math.random()*2 + 1));
        drawTree(g, x2, y2, angle + (int)(Math.random()*60) - 30, length-1, width-(int)(Math.random()*2 + 1));
        drawTree(g, x2, y2, angle + (int)(Math.random()*30) - 15, length-1, width-(int)(Math.random()*2 + 1));
        drawTree(g, x2, y2, angle + (int)(Math.random()*0) + 30, length-1, width-(int)(Math.random()*2 + 1));
        drawTree(g, x2, y2, angle - (int)(Math.random()*0) + 150, length-1, width-(int)(Math.random()*2 + 1));
    }
    
    public static void main(String args[]) {
        new Main();
    }
}