package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class PanelImagen extends JPanel {
    BufferedImage image;
    String path;
    @Override
    public void paintComponent(Graphics G){
        super.paintComponent(G); 
    }
    

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getPath() {
        return path;
    }
}
