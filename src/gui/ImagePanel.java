package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    private BufferedImage image;
    private String path;
    
    public final static int SUCCESS = 0;
    public final static int FAILURE = -1;
    
    public int setImage() {
        if(path == null || path.equals(""))
            return FAILURE;
        
        try {
            image = ImageIO.read(new File(this.path));
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
    
    public int setImage(File file) {
        if(file == null)
            return FAILURE;
        try {
            this.image = ImageIO.read(file);
            this.setSize(image.getWidth(), image.getHeight());
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
        
        this.path = path;
        try {
            image = ImageIO.read(new File(this.path));
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}
