import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class FractalExplorer {
    private int sizeDisp;
    private JImageDisplay image;
    private FractalGenerator FGen;
    private Rectangle2D.Double range;

    private FractalExplorer (int sizeDisp){
        this.sizeDisp=sizeDisp;
        this.FGen = new Mandelbrot();
        this.range = new Rectangle2D.Double(0, 0, 0, 0);
        FGen.getInitialRange(this.range);
    }
    public void createAndShowGUI(){
        JFrame frame = new JFrame("Fractal Explorer");
        JButton Button = new JButton("Reset");

        image = new JImageDisplay(sizeDisp, sizeDisp);
        image.addMouseListener(new MouseListener());

        Button.addActionListener(new ActionHandler());

        frame.setLayout(new java.awt.BorderLayout());
        frame.add(image, java.awt.BorderLayout.CENTER);
        frame.add(Button, java.awt.BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
    public class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            FGen.getInitialRange(range);
            drawFractal();
        }
    }
    public class MouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            double xCoord = FractalGenerator.getCoord(range.x,
                    range.x + range.width, sizeDisp, e.getX());
            double yCoord = FractalGenerator.getCoord(range.y,
                    range.y + range.width, sizeDisp, e.getY());
            FGen.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
        }
    }
    private void drawFractal(){
        for (int x = 0; x < sizeDisp; x++) {
            for (int y = 0; y < sizeDisp; y++) {
                int count = FGen.numIterations(FractalGenerator.getCoord(range.x, range.x + range.width, sizeDisp, x), FractalGenerator.getCoord(range.y, range.y + range.width, sizeDisp, y));
                if (count == -1)
                    image.drawPixel(x, y, 0);
                else
                {
                    float hue = 0.7f + (float) count / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    image.drawPixel(x, y, rgbColor);
                }
            }
        }
        image.repaint();

    }
    public static void main(String[] args) {
        FractalExplorer FExp = new FractalExplorer(600);
        FExp.createAndShowGUI();
        FExp.drawFractal();
    }
}
