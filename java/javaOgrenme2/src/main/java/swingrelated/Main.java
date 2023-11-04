package swingrelated;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        PrinterDemo deneme = new PrinterDemo();
        Test test = new Test();
    }

    public static class Test implements ActionListener{


        JFrame fr;
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem item1, item2;
        JCheckBoxMenuItem citem1;
        JRadioButtonMenuItem ritem1;
        JFormattedTextField ssnField ;

        Test() throws ParseException {
            menuBar = new JMenuBar();
            menu = new JMenu("deneme1111");

            menuBar.add(menu);

            item1 = new JMenuItem("swingrelated");
            item2 = new JMenuItem("aga2");

            menu.add(item1);
            item1.addActionListener(this);

            citem1 = new JCheckBoxMenuItem("baba");
            menu.add(citem1);
            citem1.addActionListener(this);


            ritem1 = new JRadioButtonMenuItem("baba");
            menu.add(ritem1);
            ritem1.addActionListener(this);

            fr = new JFrame();
            fr.setBounds(200,200,800,600);
            fr.setVisible(true);
            fr.setLayout(null);
            fr.setTitle("denemeee");
            fr.setResizable(true);
            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fr.setJMenuBar(menuBar);

            ssnField = new JFormattedTextField(new MaskFormatter("???---UUU"));
            ssnField.setBounds(300,300,100,50);

            fr.add(ssnField);
            ssnField.addActionListener(this);
            ssnField.setValue("aga");

            menu.addMenuListener(new MenuListener() {
                @Override
                public void menuSelected(MenuEvent e) {
                    menu.setBackground(Color.blue);
                }

                @Override
                public void menuDeselected(MenuEvent e) {
                    menu.setBackground(Color.yellow);

                }

                @Override
                public void menuCanceled(MenuEvent e) {

                    menu.setBackground(Color.darkGray);
                }
            });

            menuBar.setBorder(BorderFactory.createLineBorder(Color.blue));
            menuBar.setBorderPainted(false);
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == item1){
                Color c = JColorChooser.showDialog(null, "Renk seç", Color.CYAN);
                fr.getContentPane().setBackground(c);
            }
            if(e.getSource() == citem1 && citem1.isSelected()){
                System.out.println("citem1 seçildi");
            }
            if(e.getSource() == ritem1 && ritem1.isSelected()){
                System.out.println("ritem1 seçildi");
            }
            if(e.getSource() == ritem1 && !ritem1.isSelected()){
                System.out.println("ritem1 !seçildi");
            }
            if(e.getSource() == citem1 && !citem1.isSelected()){
                System.out.println("citem1 itildi");
            }
            if(e.getSource() == ssnField){
                System.out.println(ssnField.getValue());
                ssnField.setEnabled(false);
            }
        }

    }


}
