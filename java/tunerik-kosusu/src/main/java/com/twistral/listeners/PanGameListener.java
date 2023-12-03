package com.twistral.listeners;


import com.twistral.utils.*;
import com.twistral.consts.*;
import com.twistral.main.*;
import java.awt.event.*;

public class PanGameListener implements MouseListener {

    public static int cutsceneNo = 2;

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == Application.btnCutscenes){
            if(cutsceneNo == 999999){
                System.exit(0);
            }

            if(cutsceneNo % 5 == 2 ){
                BtnStartTheGameListener.worker1.cancel(true);
                Application.lbDown.setText("");
                BtnStartTheGameListener.worker2.execute();
                cutsceneNo++;
            }
            else if(cutsceneNo % 5 == 3 ){
                ClipUtils.playClip(Sounds.clipBetiBulma);
                BtnStartTheGameListener.worker2.cancel(true);
                Application.lbDown.setText("");
                BtnStartTheGameListener.worker3.execute();
                cutsceneNo++;
            }
            else if(cutsceneNo % 5 == 4 ){
                BtnStartTheGameListener.worker3.cancel(true);
                Application.lbDown.setText("");
                BtnStartTheGameListener.worker4.execute();
                cutsceneNo++;
            }
            else if(cutsceneNo % 5 == 0 ){
                BtnStartTheGameListener.worker4.cancel(true);
                Application.lbDown.setText("");
                BtnStartTheGameListener.worker5.execute();
                cutsceneNo++;
            }
            else if(cutsceneNo % 5 == 1 ){
                BtnStartTheGameListener.worker5.cancel(true);
                Application.lbDown.setText("");
                Application.lbRight.setVisible(true);
                Application.lbLeft.setVisible(true);
                Application.lbMiddle.setVisible(false);
                Application.btnMelee.setVisible(true);
                Application.btnRanged.setVisible(true);
                Application.btnDefend.setVisible(true);
                Application.btnItems.setVisible(true);
                Application.lbLeft.setIcon(Application.getPlayer().getCharacterImage());

                // barlari gunceller
                Application.updateAllBars();

                // add battle music here
                Application.btnCutscenes.setVisible(false); //next butonu kapatilir
                Application.showAllStats();
                Application.updateStats();
                Application.showAllBars();


                Application.setCurrentMonster(Algorithms.zorlugaGoreCanArttir(Application.getCurrentMonster()));
                Application.updateAllBars();
                cutsceneNo++;
            }
        }
        else if(e.getSource() == Application.btnMelee)  { Algorithms.meleeButton(); }
        else if(e.getSource() == Application.btnRanged) { Algorithms.rangedButton();}
        else if(e.getSource() == Application.btnDefend) { Algorithms.defenseButton();}
        else if(e.getSource() == Application.btnItems)  { Algorithms.itemsButton();}
    } // end of mouseClicked()

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == Application.btnCutscenes)
            Application.btnCutscenes.setBackground(Colors.gray2);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == Application.btnCutscenes)
            Application.btnCutscenes.setBackground(Colors.gray);
    }

    @Override public void mousePressed(MouseEvent e) { }
    @Override public void mouseReleased(MouseEvent e) { }

}
