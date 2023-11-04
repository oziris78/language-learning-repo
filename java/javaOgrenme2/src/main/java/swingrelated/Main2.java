package swingrelated;

import javax.swing.*;
import java.awt.*;


public class Main2 {
    public static void main(String[] args) {

        JFrame fr = new JFrame();
        fr.setBounds(200,200,800,600);
        fr.setVisible(true);
        fr.setLayout(null);
        fr.setTitle("aga");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JLabel lb = new JLabel();
        lb.setBounds(100,100,300,200);
        lb.setOpaque(true);
        lb.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        lb.setHorizontalAlignment(SwingConstants.CENTER);
        lb.setVerticalAlignment(SwingConstants.CENTER);
        lb.setHorizontalTextPosition(SwingConstants.CENTER);
        lb.setVerticalTextPosition(SwingConstants.CENTER);


        fr.add(lb);

        fr.getContentPane().setVisible(false);
        fr.getContentPane().setVisible(true);

    }
}