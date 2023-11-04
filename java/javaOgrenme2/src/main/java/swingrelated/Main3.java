package swingrelated;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main3 {

    public static void main(String[] args) {
        new Test();
    }

    public static class Test implements MouseListener{


        JFrame fr;
        JMenuItem mi1, mi2, mi3;
        JPopupMenu pm;

        Test() {
            pm = new JPopupMenu("labelDenemesi");
            pm.setLabel("aga");
            pm.setPopupSize(new Dimension(200,200));
            
            mi1 = new JMenuItem("mi1");
            mi2 = new JMenuItem("mi2");
            mi3 = new JMenuItem("mi3");

            mi1.addActionListener(e -> {
                System.out.println("aaaaaa1");
                System.out.println("aaaaaa2");
            });
            mi2.addActionListener(e -> System.out.println("bbbbbb"));
            mi3.addActionListener(e -> System.out.println("cccccc"));

            pm.add(mi1);
            pm.add(mi2);
            pm.add(mi3);


            fr = new JFrame();
            fr.setBounds(200,200,800,600);
            fr.setVisible(true);
            fr.setLayout(null);
            fr.setTitle("denemeee");
            fr.setResizable(true);
            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fr.addMouseListener(this);

        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON3) {
                pm.show(fr, e.getX()+10, e.getY()+10);
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
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


}
