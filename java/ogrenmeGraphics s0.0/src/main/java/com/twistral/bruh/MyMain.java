package bruh;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

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
