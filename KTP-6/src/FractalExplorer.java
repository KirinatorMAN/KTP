import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.geom.Rectangle2D;


public class FractalExplorer {
    private int sizeDisp;
    private JImageDisplay image;
    private FractalGenerator FGen;
    private Rectangle2D.Double range;
    private JComboBox box;
    private int rowsRemaning;
    JButton resetButton;
    JButton saveButton;

    private FractalExplorer (int sizeDisp){
        this.sizeDisp=sizeDisp;
        this.FGen = new Mandelbrot();
        this.range = new Rectangle2D.Double(0, 0, 0, 0);
        FGen.getInitialRange(this.range);
    }

    public void createAndShowGUI(){
        JFrame frame = new JFrame("Fractal Explorer");
        JPanel pan1 = new JPanel();
        JPanel pan2 = new JPanel();
        JLabel lbl = new JLabel("Fractal:");

        image = new JImageDisplay(sizeDisp, sizeDisp);
        image.addMouseListener(new MouseListener());

        box = new JComboBox();
        box.addItem(new Mandelbrot());
        box.addItem(new Tricorn());
        box.addItem(new BurningShip());
        box.addActionListener(new ActionHandler());

        resetButton = new JButton("Reset");
        resetButton.setActionCommand("Reset");
        resetButton.addActionListener(new ActionHandler());
        saveButton = new JButton("Save Image");
        saveButton.setActionCommand("Save");
        saveButton.addActionListener(new ActionHandler());

        pan1.add(lbl, java.awt.BorderLayout.CENTER);
        pan1.add(box, java.awt.BorderLayout.CENTER);
        pan2.add(resetButton, java.awt.BorderLayout.CENTER);
        pan2.add(saveButton, java.awt.BorderLayout.CENTER);

        frame.setLayout(new java.awt.BorderLayout());
        frame.add(image, java.awt.BorderLayout.CENTER);
        frame.add(pan1, BorderLayout.NORTH);
        frame.add(pan2, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Reset")) {
                FGen.getInitialRange(range);
                drawFractal();
            } else if (e.getActionCommand().equals("Save")) {
                JFileChooser chooser = new JFileChooser();
                FileFilter filter = new FileNameExtensionFilter("PNG Images", "png");
                chooser.setFileFilter(filter);
                chooser.setAcceptAllFileFilterUsed(false);
                int t = chooser.showSaveDialog(image);
                if (t == JFileChooser.APPROVE_OPTION) {
                    try {
                        ImageIO.write(image.getBufferedImage(), "png", chooser.getSelectedFile());
                    } catch (NullPointerException | IOException e1) {
                        JOptionPane.showMessageDialog(image, e1.getMessage(), "Cannot Save Image", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                FGen = (FractalGenerator) box.getSelectedItem();
                range = new Rectangle2D.Double(0, 0, 0, 0);
                FGen.getInitialRange(range);
                drawFractal();
            }
        }
    }

    public class MouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (rowsRemaning==0) {
                double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, sizeDisp, e.getX());
                double yCoord = FractalGenerator.getCoord(range.y, range.y + range.width, sizeDisp, e.getY());
                FGen.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
                drawFractal();
            }
        }
    }

private void drawFractal(){
    enableUI(false);
    rowsRemaning = sizeDisp;
    for (int i = 0; i < sizeDisp; i++)
    {
        FractalWorker rowDrawer = new FractalWorker(i);
        rowDrawer.execute();
    }
}

    private class FractalWorker extends SwingWorker<Object, Object>{
        private int yCoord;
        private int[] rgb;
        public FractalWorker(int yCoord)
        {
            this.yCoord = yCoord;
        }
        public Object doInBackground()
        {
            rgb = new int[sizeDisp];
            for (int i = 0; i < sizeDisp; i++) {
                int count = FGen.numIterations(FractalGenerator.getCoord(range.x, range.x + range.width, sizeDisp, i), FractalGenerator.getCoord(range.y, range.y + range.width, sizeDisp, yCoord));
                if (count == -1)
                    rgb[i]=0;
                else
                {
                    double hue = 0.7f + (float) count / 200f;
                    int rgbColor = Color.HSBtoRGB((float) hue, 1f, 1f);
                    rgb[i]= rgbColor;
                }
            }
            return null;
        }
        public void done()
        {
            for (int i = 0; i < sizeDisp; i++)
                image.drawPixel(i,yCoord,rgb[i]);
            image.repaint(0, 0, yCoord, sizeDisp, 1);
            rowsRemaning--;
            if (rowsRemaning==0)
                enableUI(true);
        }
    }
    public void enableUI(boolean var)
    {
        saveButton.setEnabled(var);
        resetButton.setEnabled(var);
        box.setEnabled(var);
    }
    public static void main(String[] args) {
        FractalExplorer FExp = new FractalExplorer(600);
        FExp.createAndShowGUI();
        FExp.drawFractal();
    }
}
