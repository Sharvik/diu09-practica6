package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;

public class ScrollPane extends JScrollPane {
    private ImagePanel panel;
    private JViewport view;
    private JScrollBar hBar;
    private JScrollBar vBar;
    private Point origin;
    private EstadisticasImagen stats;
    private MainWindow main;
    
    public ScrollPane() {
        stats = new EstadisticasImagen();
        panel = new ImagePanel();
        
        hBar = this.getHorizontalScrollBar();
        vBar = this.getVerticalScrollBar();
        view = this.getViewport();
        origin = new Point(0, 0);
        
        hBar.addAdjustmentListener(barListener());
        vBar.addAdjustmentListener(barListener());
        
        showPaint();
    }
    
    private AdjustmentListener barListener() {
        return (AdjustmentEvent e) -> {
            origin = view.getViewPosition();
            Point end = new Point(origin.x + view.getWidth(),
                                origin.y + view.getHeight());
            
            if(panel.getImage() != null)
                stats.calculaEstadisticas(panel.getImage(), 
                                            origin, 
                                            end);
            
            for (Component component : main.getContentPane().getComponents()) {
                if(component instanceof JTextField) {
                    switch(((JTextField) component).getName()) {
                        case "redMinValue":
                            ((JTextField) component).setText(
                                    Integer.toString(stats.minimo[stats.ROJO]));
                            break;
                        case "redMaxValue":
                            ((JTextField) component).setText(
                                    Integer.toString(stats.maximo[stats.ROJO]));
                            break;
                        case "redMeanValue":
                            ((JTextField) component).setText(
                                    Integer.toString(stats.promedio[stats.ROJO]));
                            break;
                        case "greenMinValue":
                            ((JTextField) component).setText(
                                    Integer.toString(stats.minimo[stats.VERDE]));
                            break;
                        case "greenMaxValue":
                            ((JTextField) component).setText(
                                    Integer.toString(stats.maximo[stats.VERDE]));
                            break;
                        case "greenMeanValue":
                            ((JTextField) component).setText(
                                    Integer.toString(stats.promedio[stats.VERDE]));
                            break;
                        case "blueMinValue":
                            ((JTextField) component).setText(
                                    Integer.toString(stats.minimo[stats.AZUL]));
                            break;
                        case "blueMaxValue":
                            ((JTextField) component).setText(
                                    Integer.toString(stats.maximo[stats.AZUL]));
                            break;
                        case "blueMeanValue":
                            ((JTextField) component).setText(
                                    Integer.toString(stats.promedio[stats.AZUL]));
                            break;
                        default:
                            break;
                    }
                }
            }
        };
    }

    private void showPaint() {
        if(panel.getImage() != null) {
            hBar.setValues(0, 10, 0, panel.getWidth());
            vBar.setValues(0, 10, 0, panel.getHeight());
            view.add(panel);
        }
        
        this.setViewportBorder(
                BorderFactory.createLineBorder(Color.black));
        this.setAutoscrolls(true);
        this.setEnabled(true);
        this.setPreferredSize(new Dimension(450, 400));
        this.repaint();
        panel.repaint();
    }

    public ImagePanel getPanel() {
        return panel;
    }

    public void setPanel(ImagePanel panel) {
        this.panel = panel;
        showPaint();
    }
    
    public int setPanel(File file) {
        if(panel.setImage(file) == ImagePanel.FAILURE)
            return ImagePanel.FAILURE;
        
        showPaint();
        return ImagePanel.SUCCESS;
    }

    public EstadisticasImagen getStats() {
        return stats;
    }

    public void setStats(EstadisticasImagen stats) {
        this.stats = stats;
    }

    public MainWindow getMain() {
        return main;
    }

    public void setMain(MainWindow main) {
        this.main = main;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
