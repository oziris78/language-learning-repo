package com.twistral;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.Buffer;

public class MyPanel extends JPanel {

    public MyPanel(){
        this.setPreferredSize(new Dimension(500,500));
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.red);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(0, 0, 50, 50);
        g2d.drawRect(70,70,100,100);
        g2d.fillRect(270,270,100,100);
        g2d.setPaint(Color.pink);
        g2d.drawOval(400,50,90,90);
        g2d.fillOval(400,0,90,90);
        g2d.setPaint(Color.blue);
        g2d.drawArc(50, 250, 100, 100, 0, 90);
        g2d.fillArc(150, 250, 100, 100, 0, 90);

        g2d.drawPolygon( new int[]{100, 250, 20}, new int[]{100, 250, -20}, 3);
        g2d.fillPolygon( new int[]{100, 250, 20}, new int[]{100, 250, -20}, 3);

        // g2d.setFont( new Font(...) );
        g2d.drawString("ANNEN\u0130 S\u0130KER\u0130M", 50, 350);

        g2d.drawImage( new ImageIcon( "src/main/resources/images/foto.png" ).getImage(), 50,50,null);
    }

    private static BufferedImage img(String fn){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(fn));
        }
        catch (Exception e){e.printStackTrace();}
        return img;
    }


}
