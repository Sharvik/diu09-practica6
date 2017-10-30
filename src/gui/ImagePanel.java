package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    private BufferedImage image;
    
    public final static int SUCCESS = 0;
    public final static int FAILURE = -1;
    
    public int setImage(File file) {
        if(file == null)
            return FAILURE;
        try {
            this.image = ImageIO.read(file);
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(
                    null, 
                    "An error ocurred when loading the image", 
                    "Image error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        this.repaint();
        return SUCCESS;
    }
    
    public int setImage(String path) {
        if(path == null || path.equals(""))
            return FAILURE;
        
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(
                    null, 
                    "An error ocurred when loading the image", 
                    "Image error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        this.repaint();
        return SUCCESS;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }
    
    @Override
    public void paintComponent(Graphics g){
        if(image != null)
            this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}
