package bruh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.ArrayList;

public class MyDrawingComponent extends JComponent implements MouseListener {
    private int w, h;
    public MyDrawingComponent(int w, int h){
        this.w = w;
        this.h = h;
        this.addMouseListener(this);
        this.points = new ArrayList<>();
    }

    private ArrayList<Point2D.Double> points;

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHints(renderingHints);

        g2d.setStroke(new BasicStroke(5));

        g2d.clearRect(0,0,this.getWidth(), this.getHeight());

        Path2D.Double path = new Path2D.Double();
        if(!points.isEmpty()){
            Point2D firstPoint = points.get(0);
            path.moveTo(firstPoint.getX(), firstPoint.getY());
            for(int i = 1; i < points.size(); i++){
                Point2D p = points.get(i);
                path.lineTo(p.getX(),p.getY());
                g2d.draw(path);
            }
        }
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        Point2D lastPoint = null;
        if(!this.points.isEmpty())
            lastPoint = this.points.get( this.points.size() - 1);
        this.points.add(new Point2D.Double(e.getX(), e.getY()));

        int x = (int) Math.min(e.getX(), lastPoint.getX());
        int y = (int) Math.min(e.getY(), lastPoint.getY());
        int w = (int) Math.abs(e.getX() - lastPoint.getX()) + 10;
        int h = (int) Math.abs(e.getY() - lastPoint.getY()) + 10;

        this.repaint(new Rectangle(x,y,w,h));

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}