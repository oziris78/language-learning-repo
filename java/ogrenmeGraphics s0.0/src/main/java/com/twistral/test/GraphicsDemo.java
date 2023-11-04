package com.twistral.test;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

class DrawingComponent extends JComponent {

    private int width, height;
    public DrawingComponent(int w, int h){ this.width = w; this.height = h; }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        Rectangle2D.Double r = new Rectangle2D.Double(50,75,100,250);
        g2d.setColor(new Color(203, 93, 93));
        g2d.fill(r);

        Ellipse2D.Double e = new Ellipse2D.Double(150,175,100,250);
        g2d.setColor(new Color(23, 93, 93));
        g2d.fill(e);

        Line2D.Double line = new Line2D.Double(100,250,300,75);
        g2d.setColor(new Color(17, 17, 17));
        g2d.draw(line);

        Cloud c1 = new Cloud();
        c1.drawCloud(g2d);

        Path2D.Double p = new Path2D.Double();
        p.moveTo(130,300); // kalemi kaldırıp git
        p.lineTo(180,200); // yazarak git
        p.lineTo(180,250); // yazarak git
        p.lineTo(380,250); // yazarak git
        p.lineTo(580,350); // yazarak git
        g2d.setColor(Color.RED);
        g2d.draw(p);

        Path2D.Double p3 = new Path2D.Double();
        p3.moveTo(250,400);
        p3.curveTo(350,300,500,300,600,400);
        g2d.setColor(Color.GREEN);
        g2d.draw(p3);

        Path2D.Double p2 = new Path2D.Double();
        p2.moveTo(328,256);
        p2.curveTo(329,204,397,199,401,252);
        p2.curveTo(413,201,468,198,466,250);
        p2.curveTo(465,304,415,345,402,350);
        p2.curveTo(388,346,328,308,328,256);
        g2d.setColor(new Color(24, 105, 202));
        g2d.fill(p2);

        AffineTransform af = g2d.getTransform(); // şu anki anı saklar

        Rectangle2D.Double rec = new Rectangle2D.Double(0,0,100,100);
        g2d.setColor(Color.PINK);
        g2d.translate(480,100);
        g2d.fill(rec);
        g2d.translate(100,100); // yığılgandır
        g2d.setTransform(af);

        AffineTransform af2 = g2d.getTransform();

        Rectangle2D.Double rr = new Rectangle2D.Double(250,100,50,50);
        g2d.rotate(Math.toRadians(35), rr.getX(), rr.getY());
        g2d.rotate(Math.toRadians(10), rr.getX(), rr.getY()); // bu da yığılgandır
        g2d.setColor(Color.orange);
        g2d.fill(rr);

        g2d.setTransform(af2); // resets rotation too

    }
}


// ------------------------------------------------------ //


class Cloud {
    public Cloud(){}
    public void drawCloud(Graphics2D g2d){
        Ellipse2D.Double e1 = new Ellipse2D.Double(200,75,100,100);
        Ellipse2D.Double e2 = new Ellipse2D.Double(235,55,175,140);
        Ellipse2D.Double e3 = new Ellipse2D.Double(350,90,90,90);
        Ellipse2D.Double e4 = new Ellipse2D.Double(380, 80, 30, 30);
        g2d.setColor(Color.blue);
        g2d.fill(e1);
        g2d.fill(e2);
        g2d.fill(e3);
        g2d.fill(e4);
    }
}


// ------------------------------------------------------ //


public class GraphicsDemo {
    public static void main(String[] args) {
        int w = 640;
        int h = 480;
        JFrame frame = new JFrame();
        frame.setSize(w,h);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DrawingComponent(w,h));
        frame.setVisible(true);
    }
}


