package pictureLab;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private BufferedImage image;
    private int x;
    private int y;

    public ImagePanel(String imagename, int x, int y) {
       this.x = x;
       this.y = y;
    	try {                
          image = ImageIO.read(new File(imagename));
       } catch (IOException ex) {
            System.out.println("IO Exception");
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, x, y, this); 
    }
}