package com.twistral;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

class MyDrawingComponent extends JComponent{
    private int w, h;
    public MyDrawingComponent(int w, int h){ this.w = w; this.h = h; }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform af = new AffineTransform();


    }
}

public class MyMain {

    public static void main(String[] args) {
        int w = 600;
        int h = 600;
        JFrame frame = new JFrame();
        frame.setSize(w,h);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new MyDrawingComponent(w,h));



        frame.setVisible(true);
    }

}
