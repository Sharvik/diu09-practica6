package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.BorderFactory;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

public class ScrollPane extends JScrollPane {
    private ImagePanel panel;
    private JViewport view;
    private JScrollBar hBar;
    private JScrollBar vBar;
    private Point origin;
    
    public ScrollPane() {
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
            System.out.println(origin.toString());
        };
    }

    private void showPaint() {
        if(panel != null) {
            hBar.setValues(0, 10, 0, panel.getWidth());
            vBar.setValues(0, 10, 0, panel.getHeight());
            view.add(panel);
        }
        
        this.setViewportBorder(
                BorderFactory.createLineBorder(Color.black));
        this.setAutoscrolls(true);
        this.setEnabled(true);
        this.setPreferredSize(new Dimension(450, 400));
    }

    public ImagePanel getPanel() {
        return panel;
    }

    public void setPanel(ImagePanel panel) {
        this.panel = panel;
        showPaint();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

}
