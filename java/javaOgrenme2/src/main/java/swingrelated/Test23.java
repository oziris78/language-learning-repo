package swingrelated;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test23 {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();


        JButton btn1 = new JButton();
        btn1.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {

            }
        });
        panel1.add(btn1);

        JButton btn2 = new JButton();
        btn2.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {

        }});
        panel1.add(btn2);



        frame.setVisible(true);
    }
}
