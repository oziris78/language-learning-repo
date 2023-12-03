package com.twistral.listeners;

import com.twistral.consts.Images;
import com.twistral.utils.*;
import com.twistral.consts.Sounds;
import com.twistral.consts.Strings;
import com.twistral.entities.Player;
import com.twistral.main.Application;
import com.twistral.utils.TKUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnStartTheGameListener implements ActionListener {

    public static SwingWorker<Void, String> worker1, worker2, worker3, worker4, worker5;

    @Override
    public void actionPerformed(ActionEvent e) {
        TKUtils.playClipMod(Sounds.clipMenuClick1, Sounds.clipMenuClick2, Sounds.clipMenuClick3);
        Player player = Application.getPlayer();

        // gorsel
        if(Application.rbtnTekin.isSelected()){
            player.setCharacterImage(Images.tekin);
        }
        else{
            player.setCharacterImage(Images.ayca);
        }

        // class, health, meleeDamage, rangedDamage, evade, defense belirlenmeli
        if(Application.rbtnKnight.isSelected()){
            player.setChClass("knight");
            player.setMaxHealth(35);
            player.setCurHealth(player.getMaxHealth());
            player.setMeleeDamage(12);
            player.setRangedDamage(4);
            player.setEvade(5);
            player.setDefense(8);
            player.setMeleeCrit(35);
            player.setRangedCrit(10);
            player.setMoney(10);
        }
        else if(Application.rbtnArcher.isSelected()){
            player.setChClass("archer");
            player.setMaxHealth(50);
            player.setCurHealth(player.getMaxHealth());
            player.setMeleeDamage(6);
            player.setRangedDamage(10);
            player.setEvade(15);
            player.setDefense(5);
            player.setMeleeCrit(10);
            player.setRangedCrit(35);
            player.setMoney(10);
        }
        else if(Application.rbtnSwordsman.isSelected()){
            player.setChClass("swordsman");
            player.setMaxHealth(50);
            player.setCurHealth(player.getMaxHealth());
            player.setMeleeDamage(10);
            player.setRangedDamage(6);
            player.setEvade(10);
            player.setDefense(6);
            player.setMeleeCrit(20);
            player.setRangedCrit(10);
            player.setMoney(10);
        }
        else{
            player.setChClass("assassin");
            player.setMaxHealth(35);
            player.setCurHealth(Application.getPlayer().getMaxHealth());
            player.setMeleeDamage(4);
            player.setRangedDamage(12);
            player.setEvade(65);
            player.setDefense(2);
            player.setMeleeCrit(10);
            player.setRangedCrit(20);
            player.setMoney(10);
        }


        if(Application.rbtnEasy.isSelected()){ Application.getPlayer().setDifficulty("easy"); }
        else if(Application.rbtnHard.isSelected()){ Application.getPlayer().setDifficulty("hard"); }
        else if(Application.rbtnMedium.isSelected()){ Application.getPlayer().setDifficulty("medium"); }
        else{ Application.getPlayer().setDifficulty("ultra"); }


        // --------------------------- //
        // panel degis
        Application.panNewGame.setVisible(false);
        Application.panGame.setVisible(true);


        // shop icin gorsel atanmasi
        if(Application.rbtnTekin.isSelected()){ Application.lbLeftShop.setIcon(Images.tekin); }
        else{ Application.lbLeftShop.setIcon(Images.ayca); }

        Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.smallHealthPotion, 288, 288));
        Application.lbRightShopDescription.setText(Strings.smallHealthPotionD);


        // cutscene tanimlari
        worker1 = TKUtils.cutsceneTK(Strings.cutscene1, Images.cut1, 250, 300);
        worker2 = TKUtils.cutsceneTK(Strings.cutscene2, Images.cut2, 250, 300);
        worker3 = TKUtils.cutsceneTK(Strings.cutscene3, Images.cut3, 250, 300);
        worker4 = TKUtils.cutsceneTK(Strings.cutscene4, Images.cut4, 250, 300);
        worker5 = TKUtils.cutsceneTK(Strings.cutscene5, Images.cut5, 250, 300);

        worker1.execute();

        Application.rbtnEasy.setSelected(true);
        Application.rbtnTekin.setSelected(true);
        Application.rbtnKnight.setSelected(true);

        Application.lbMiddle.setVisible(true);
        Application.btnCutscenes.setVisible(true);
        Application.lbDown.setVisible(true);
    }
}
