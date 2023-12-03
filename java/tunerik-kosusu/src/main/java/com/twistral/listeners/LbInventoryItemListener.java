package com.twistral.listeners;

import com.twistral.consts.Images;
import com.twistral.utils.*;
import com.twistral.consts.Sounds;
import com.twistral.main.Application;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LbInventoryItemListener implements MouseListener {

    private String type, id;
    private JLabel label;

    public LbInventoryItemListener(String type, String id, JLabel label){
        this.id = id;
        this.type = type;
        this.label = label;
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        if(id == "smallHP")         { label.setIcon(Images.smallHealthPotionAcik); }
        else if(id == "mediumHP")   { label.setIcon(Images.mediumHealthPotionAcik); }
        else if(id == "largeHP")    { label.setIcon(Images.largeHealthPotionAcik); }
        else if(id == "smallRegen") { label.setIcon(Images.smallRegenerationPotionAcik); }
        else if(id == "mediumRegen"){ label.setIcon(Images.mediumRegenerationPotionAcik); }
        else if(id == "largeRegen") { label.setIcon(Images.largeRegenerationPotionAcik); }
        else if(id == "water")      { label.setIcon(Images.waterBottleAcik); }
        else if(id == "strength")   { label.setIcon(Images.strengthPotionAcik); }
        else if(id == "antivenom")  { label.setIcon(Images.antivenomAcik); }
        else if(id == "speed")      { label.setIcon(Images.speedPotionAcik); }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if     (id == "smallHP")    { label.setIcon(Images.smallHealthPotion); }
        else if(id == "mediumHP")   { label.setIcon(Images.mediumHealthPotion); }
        else if(id == "largeHP")    { label.setIcon(Images.largeHealthPotion); }
        else if(id == "smallRegen") { label.setIcon(Images.smallRegenerationPotion); }
        else if(id == "mediumRegen"){ label.setIcon(Images.mediumRegenerationPotion); }
        else if(id == "largeRegen") { label.setIcon(Images.largeRegenerationPotion); }
        else if(id == "water")      { label.setIcon(Images.waterBottle); }
        else if(id == "strength")   { label.setIcon(Images.strengthPotion); }
        else if(id == "antivenom")  { label.setIcon(Images.antivenom); }
        else if(id == "speed")      { label.setIcon(Images.speedPotion); }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.type == "shopItem"){
            shopItem(e);
        }
        else{
            gameItem(e);
        }
    }


    public void shopItem(MouseEvent e) {
        if(id == "smallHP"){ // +%20
            if(Integer.parseInt(Application.lbItem1.getText()) > 0){
                ClipUtils.playClip(Sounds.clipPotIcme);
                Application.getPlayer().setCurHealth(Application.getPlayer().getCurHealth() + Application.getPlayer().getMaxHealth() / 5);
                if (Application.getPlayer().getCurHealth() > Application.getPlayer().getMaxHealth()) {
                    Application.getPlayer().setCurHealth(Application.getPlayer().getMaxHealth());
                }
                // sozlukten 1 azalt
                Application.getPlayer().getInventory().put("smallHealthPotion", Application.getPlayer().getInventory().get("smallHealthPotion") - 1);
                Application.nesneTuketimiSonrasi();
            }
        }
        else if(id == "mediumHP"){ // +%40
            if(Integer.parseInt(Application.lbItem2.getText()) > 0){
                ClipUtils.playClip(Sounds.clipPotIcme);
                Application.getPlayer().setCurHealth(Application.getPlayer().getCurHealth() + (Application.getPlayer().getMaxHealth() * 4) / 10);
                if (Application.getPlayer().getCurHealth() > Application.getPlayer().getMaxHealth()) {
                    Application.getPlayer().setCurHealth(Application.getPlayer().getMaxHealth());
                }
                // sozlukten 1 azalt
                Application.getPlayer().getInventory().put("mediumHealthPotion", Application.getPlayer().getInventory().get("mediumHealthPotion") - 1);
                Application.nesneTuketimiSonrasi();
            }
        }
        else if(id == "largeHP"){
            if(Integer.parseInt(Application.lbItem3.getText()) > 0){
                ClipUtils.playClip(Sounds.clipPotIcme);
                Application.getPlayer().setCurHealth( Application.getPlayer().getCurHealth()  +  (Application.getPlayer().getMaxHealth() * 3) / 4 );
                if(Application.getPlayer().getCurHealth() > Application.getPlayer().getMaxHealth()){
                    Application.getPlayer().setCurHealth(Application.getPlayer().getMaxHealth());
                }
                // sozlukten 1 azalt
                Application.getPlayer().getInventory().put("largeHealthPotion", Application.getPlayer().getInventory().get("largeHealthPotion") - 1 );
                Application.nesneTuketimiSonrasi();
            }
        }
        else if(id == "smallRegen"){
            if(Integer.parseInt(Application.lbItem4.getText()) > 0){
                ClipUtils.playClip(Sounds.clipPotIcme);
                Application.getPlayer().getCurrentEffects().put("regen1", Application.getPlayer().getCurrentEffects().get("regen1") + 2);
                // sozlukten 1 azalt
                Application.getPlayer().getInventory().put("smallRegenerationPotion", Application.getPlayer().getInventory().get("smallRegenerationPotion") - 1 );
                Application.nesneTuketimiSonrasi();
            }
        }
        else if(id == "mediumRegen"){
            if(Integer.parseInt(Application.lbItem5.getText()) > 0){
                ClipUtils.playClip(Sounds.clipPotIcme);
                Application.getPlayer().getCurrentEffects().put("regen2", Application.getPlayer().getCurrentEffects().get("regen2") + 2);
                // sozlukten 1 azalt
                Application.getPlayer().getInventory().put("mediumRegenerationPotion", Application.getPlayer().getInventory().get("mediumRegenerationPotion") - 1 );
                Application.nesneTuketimiSonrasi();
            }

        }
        else if(id == "largeRegen"){
            if(Integer.parseInt(Application.lbItem6.getText()) > 0){
                ClipUtils.playClip(Sounds.clipPotIcme);
                Application.getPlayer().getCurrentEffects().put("regen3", Application.getPlayer().getCurrentEffects().get("regen3") + 2);
                // sozlukten 1 azalt
                Application.getPlayer().getInventory().put("largeRegenerationPotion", Application.getPlayer().getInventory().get("largeRegenerationPotion") - 1 );
                Application.nesneTuketimiSonrasi();
            }
        }
        else if(id == "water"){
            if(Integer.parseInt(Application.lbItem7.getText()) > 0){
                ClipUtils.playClip(Sounds.clipPotIcme);
                Application.getPlayer().getCurrentEffects().put("burning1", 0);
                Application.getPlayer().getCurrentEffects().put("burning2", 0);
                Application.getPlayer().getCurrentEffects().put("burning3", 0);
                // sozlukten 1 azalt
                Application.getPlayer().getInventory().put("waterBottle", Application.getPlayer().getInventory().get("waterBottle") - 1 );
                Application.nesneTuketimiSonrasi();
            }
        }
        else if(id == "strength"){
            if(Integer.parseInt(Application.lbItem8.getText()) > 0){
                ClipUtils.playClip(Sounds.clipPotIcme);
                Application.getPlayer().getCurrentEffects().put("strength", Application.getPlayer().getCurrentEffects().get("strength") + 2);
                // sozlukten 1 azalt
                Application.getPlayer().getInventory().put("strengthPotion", Application.getPlayer().getInventory().get("strengthPotion") - 1 );
                Application.nesneTuketimiSonrasi();
            }
        }
        else if(id == "antivenom"){
            if(Integer.parseInt(Application.lbItem9.getText()) > 0){
                ClipUtils.playClip(Sounds.clipPotIcme);
                Application.getPlayer().getCurrentEffects().put("bleeding1", 0);
                Application.getPlayer().getCurrentEffects().put("bleeding2", 0);
                // sozlukten 1 azalt
                Application.getPlayer().getInventory().put("antivenom", Application.getPlayer().getInventory().get("antivenom") - 1 );
                Application.nesneTuketimiSonrasi();
            }
        }
        else if(id == "speed"){
            if(Integer.parseInt(Application.lbItem10.getText()) > 0){
                ClipUtils.playClip(Sounds.clipPotIcme);
                Application.getPlayer().getCurrentEffects().put("slowness1", 0);
                Application.getPlayer().getCurrentEffects().put("slowness2", 0);
                // sozlukten 1 azalt
                Application.getPlayer().getInventory().put("speedPotion", Application.getPlayer().getInventory().get("speedPotion") - 1 );
                Application.nesneTuketimiSonrasi();
            }
        }
    }

    public void gameItem(MouseEvent e) {
        if(id == "smallHP"){ // +%20
            if(Integer.parseInt(Application.lbItem1.getText()) > 0){
                ClipUtils.playClip(Sounds.clipPotIcme);
                Application.getPlayer().setCurHealth(Application.getPlayer().getCurHealth() + Application.getPlayer().getMaxHealth() / 5);
                if (Application.getPlayer().getCurHealth() > Application.getPlayer().getMaxHealth()) {
                    Application.getPlayer().setCurHealth(Application.getPlayer().getMaxHealth());
                }
                // sozlukten 1 azalt
                Application.getPlayer().getInventory().put("smallHealthPotion", Application.getPlayer().getInventory().get("smallHealthPotion") - 1);
                Application.nesneTuketimiSonrasi();
                Application.btnInvToGame.doClick();
                Algorithms.itemKullanma(id);
                Algorithms.yaratiginSirasiItemdanSonra(id);
            }
        }
        else if(id == "mediumHP"){ // +%40
            if(Integer.parseInt(Application.lbItem2.getText()) > 0){
                ClipUtils.playClip(Sounds.clipPotIcme);
                Application.getPlayer().setCurHealth(Application.getPlayer().getCurHealth() + (Application.getPlayer().getMaxHealth() * 4) / 10);
                if (Application.getPlayer().getCurHealth() > Application.getPlayer().getMaxHealth()) {
                    Application.getPlayer().setCurHealth(Application.getPlayer().getMaxHealth());
                }
                // sozlukten 1 azalt
                Application.getPlayer().getInventory().put("mediumHealthPotion", Application.getPlayer().getInventory().get("mediumHealthPotion") - 1);
                Application.nesneTuketimiSonrasi();
                Application.btnInvToGame.doClick();
                Algorithms.itemKullanma(id);
                Algorithms.yaratiginSirasiItemdanSonra(id);
            }
        }
        else if(id == "largeHP"){
            if(Integer.parseInt(Application.lbItem3.getText()) > 0){
                ClipUtils.playClip(Sounds.clipPotIcme);
                Application.getPlayer().setCurHealth( Application.getPlayer().getCurHealth()  +  (Application.getPlayer().getMaxHealth() * 3) / 4 );
                if(Application.getPlayer().getCurHealth() > Application.getPlayer().getMaxHealth()){
                    Application.getPlayer().setCurHealth(Application.getPlayer().getMaxHealth());
                }
                // sozlukten 1 azalt
                Application.getPlayer().getInventory().put("largeHealthPotion", Application.getPlayer().getInventory().get("largeHealthPotion") - 1 );
                Application.nesneTuketimiSonrasi();
                Application.btnInvToGame.doClick();
                Algorithms.itemKullanma(id);
                Algorithms.yaratiginSirasiItemdanSonra(id);
            }
        }
        else if(id == "smallRegen"){
            if(Integer.parseInt(Application.lbItem4.getText()) > 0){
                ClipUtils.playClip(Sounds.clipPotIcme);
                Application.getPlayer().getCurrentEffects().put("regen1", Application.getPlayer().getCurrentEffects().get("regen1") + 2);
                // sozlukten 1 azalt
                Application.getPlayer().getInventory().put("smallRegenerationPotion", Application.getPlayer().getInventory().get("smallRegenerationPotion") - 1 );
                Application.nesneTuketimiSonrasi();
                Application.btnInvToGame.doClick();
                Algorithms.itemKullanma(id);
                Algorithms.yaratiginSirasiItemdanSonra(id);
            }
        }
        else if(id == "mediumRegen"){
            if(Integer.parseInt(Application.lbItem5.getText()) > 0){
                ClipUtils.playClip(Sounds.clipPotIcme);
                Application.getPlayer().getCurrentEffects().put("regen2", Application.getPlayer().getCurrentEffects().get("regen2") + 2);
                // sozlukten 1 azalt
                Application.getPlayer().getInventory().put("mediumRegenerationPotion", Application.getPlayer().getInventory().get("mediumRegenerationPotion") - 1 );
                Application.nesneTuketimiSonrasi();
                Application.btnInvToGame.doClick();
                Algorithms.itemKullanma(id);
                Algorithms.yaratiginSirasiItemdanSonra(id);
            }

        }
        else if(id == "largeRegen"){
            if(Integer.parseInt(Application.lbItem6.getText()) > 0){
                ClipUtils.playClip(Sounds.clipPotIcme);
                Application.getPlayer().getCurrentEffects().put("regen3", Application.getPlayer().getCurrentEffects().get("regen3") + 2);
                // sozlukten 1 azalt
                Application.getPlayer().getInventory().put("largeRegenerationPotion", Application.getPlayer().getInventory().get("largeRegenerationPotion") - 1 );
                Application.nesneTuketimiSonrasi();
                Application.btnInvToGame.doClick();
                Algorithms.itemKullanma(id);
                Algorithms.yaratiginSirasiItemdanSonra(id);
            }
        }
        else if(id == "water"){
            if(Integer.parseInt(Application.lbItem7.getText()) > 0){
                ClipUtils.playClip(Sounds.clipPotIcme);
                Application.getPlayer().getCurrentEffects().put("burning1", 0);
                Application.getPlayer().getCurrentEffects().put("burning2", 0);
                Application.getPlayer().getCurrentEffects().put("burning3", 0);
                // sozlukten 1 azalt
                Application.getPlayer().getInventory().put("waterBottle", Application.getPlayer().getInventory().get("waterBottle") - 1 );
                Application.nesneTuketimiSonrasi();
                Application.btnInvToGame.doClick();
                Algorithms.itemKullanma(id);
                Algorithms.yaratiginSirasiItemdanSonra(id);
            }
        }
        else if(id == "strength"){
            if(Integer.parseInt(Application.lbItem8.getText()) > 0){
                ClipUtils.playClip(Sounds.clipPotIcme);
                Application.getPlayer().getCurrentEffects().put("strength", Application.getPlayer().getCurrentEffects().get("strength") + 2);
                // sozlukten 1 azalt
                Application.getPlayer().getInventory().put("strengthPotion", Application.getPlayer().getInventory().get("strengthPotion") - 1 );
                Application.nesneTuketimiSonrasi();
                Application.btnInvToGame.doClick();
                Algorithms.itemKullanma(id);
                Application.nesneTuketimiSonrasi();
                Algorithms.yaratiginSirasiItemdanSonra(id);
                Application.nesneTuketimiSonrasi();
            }
        }
        else if(id == "antivenom"){
            if(Integer.parseInt(Application.lbItem9.getText()) > 0){
                ClipUtils.playClip(Sounds.clipPotIcme);
                Application.getPlayer().getCurrentEffects().put("bleeding1", 0);
                Application.getPlayer().getCurrentEffects().put("bleeding2", 0);
                // sozlukten 1 azalt
                Application.getPlayer().getInventory().put("antivenom", Application.getPlayer().getInventory().get("antivenom") - 1 );
                Application.nesneTuketimiSonrasi();
                Application.btnInvToGame.doClick();
                Algorithms.itemKullanma(id);
                Algorithms.yaratiginSirasiItemdanSonra(id);
            }
        }
        else if(id == "speed"){
            if(Integer.parseInt(Application.lbItem10.getText()) > 0){
                ClipUtils.playClip(Sounds.clipPotIcme);
                Application.getPlayer().getCurrentEffects().put("slowness1", 0);
                Application.getPlayer().getCurrentEffects().put("slowness2", 0);
                // sozlukten 1 azalt
                Application.getPlayer().getInventory().put("speedPotion", Application.getPlayer().getInventory().get("speedPotion") - 1 );
                Application.nesneTuketimiSonrasi();
                Application.btnInvToGame.doClick();
                Algorithms.itemKullanma(id);
                Algorithms.yaratiginSirasiItemdanSonra(id);
            }
        }
    }


    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

}
