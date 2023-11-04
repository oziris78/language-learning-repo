package swingrelated;

import java.awt.*;
import javax.swing.*;

public class TabDemo {
    final static int extraWindowWidth = 100;


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("TabDemo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                TabDemo demo = new TabDemo();
                JTabbedPane tabbedPane = new JTabbedPane();

                JPanel card1 = new JPanel() {
                    public Dimension getPreferredSize() {
                        Dimension size = super.getPreferredSize();
                        size.width += extraWindowWidth;
                        return size;
                    }
                };
                card1.add(new JButton("Button 1"));
                card1.add(new JButton("Button 2"));
                card1.add(new JButton("Button 3"));

                JPanel card2 = new JPanel();
                card2.add(new JTextField("TextField", 20));

                tabbedPane.addTab("Tab with JButtons", card1);
                tabbedPane.addTab("Tab with JTextField", card2);

                frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);


                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}