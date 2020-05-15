import javax.swing.JComponent;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends JComponent {
    private BufferedImage image;
    public JImageDisplay(int width,int height) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Dimension dim = new Dimension(width, height);
        super.setPreferredSize(dim);
    }
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(image,0,0, image.getWidth(), image.getHeight(), null);
    }
    public void clearImage (){
        for(int i =0; i<image.getWidth(); i++)
            for(int j =0; j<image.getHeight(); j++)
                image.setRGB(i,j,0);
    }
    public void drawPixel(int x, int y, int rgbColor){
        image.setRGB(x,y,rgbColor);
    }
}





