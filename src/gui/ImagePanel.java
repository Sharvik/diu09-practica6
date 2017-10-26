package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    private BufferedImage image;
    private String path;
    
    public final static int SUCCESS = 0;
    public final static int FAILURE = -1;
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
    
    public int setImage() {
        if(path == null || path.equals(""))
            return FAILURE;
        
        try {
            image = ImageIO.read(new File(this.path));
        } catch (IOException ex) {
            Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    public int setImage(String path) {
        if(path == null || path.equals(""))
            return FAILURE;
        
        this.path = path;
        try {
            image = ImageIO.read(new File(this.path));
        } catch (IOException ex) {
            Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    
}
