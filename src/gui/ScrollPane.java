package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

public class ScrollPane extends JScrollPane {
    private ImagePanel panel;
    private JViewport view;
    private JScrollBar hBar;
    private JScrollBar vBar;
    private Point origin;

    public ScrollPane(ImagePanel panel) {
        this.panel = panel;
        
        view = this.getViewport();
        hBar = new JScrollBar(JScrollBar.HORIZONTAL);
        vBar = new JScrollBar(JScrollBar.VERTICAL);
        origin = new Point(0, 0);
        
        this.setAutoscrolls(true);
        this.setEnabled(true);
        this.setPreferredSize(new Dimension(400, 400));
        this.setHorizontalScrollBar(hBar);
        this.setVerticalScrollBar(vBar);
        
        showPaint();
    }
    
    public ScrollPane() {
        view = this.getViewport();
        hBar = new JScrollBar(JScrollBar.HORIZONTAL);
        vBar = new JScrollBar(JScrollBar.VERTICAL);
        origin = new Point(0, 0);
        
        this.setAutoscrolls(true);
        this.setEnabled(true);
        this.setPreferredSize(new Dimension(400, 400));
        this.setHorizontalScrollBar(hBar);
        this.setVerticalScrollBar(vBar);
    }

    private void showPaint() {
        view.add(panel);
        this.setViewport(view);
        this.setVisible(true);
        repaint();
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
