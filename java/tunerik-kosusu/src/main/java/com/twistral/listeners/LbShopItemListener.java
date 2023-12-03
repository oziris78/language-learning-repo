package com.twistral.listeners;

import com.twistral.consts.Images;
import com.twistral.utils.*;
import com.twistral.consts.Sounds;
import com.twistral.consts.Strings;
import com.twistral.main.Application;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LbShopItemListener implements MouseListener {

    final JLabel lb;
    final int x;

    public LbShopItemListener(JLabel lb, int x){
        this.lb = lb;
        this.x = x;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        ClipUtils.playClip(Sounds.clipSwitch1);

        if(x == 1) {
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.woodenClub, 288, 288));
            Application.lbRightShopDescription.setText(Strings.woodenClubD);
        }
        else if(x == 2) {
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.woodenSword, 288, 288));
            Application.lbRightShopDescription.setText(Strings.woodenSwordD);
        }
        else if(x == 3) {
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.medievalAxe, 288, 288));
            Application.lbRightShopDescription.setText(Strings.medievalAxeD);
        }
        else if(x == 4) {
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.shortSword, 288, 288));
            Application.lbRightShopDescription.setText(Strings.shortSwordD);
        }
        else if(x == 5) {
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.knightsSword, 288, 288));
            Application.lbRightShopDescription.setText(Strings.knightsSwordD);
        }
        else if(x == 6) {
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.paladinsSword, 288, 288));
            Application.lbRightShopDescription.setText(Strings.paladinsSwordD);
        }
        else if(x == 7) {
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.hellSword, 288, 288));
            Application.lbRightShopDescription.setText(Strings.hellSwordD);
        }
        else if(x == 8) {
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.odrokus, 288, 288));
            Application.lbRightShopDescription.setText(Strings.odrokusD);
        }
        else if(x == 9) {
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.vinegriand, 288, 288));
            Application.lbRightShopDescription.setText(Strings.vinegriandD);
        }
        else if(x == 10){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.zugoron, 288, 288));
            Application.lbRightShopDescription.setText(Strings.zugoronD);
        }
        else if(x == 11){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.woodenBow, 288, 288));
            Application.lbRightShopDescription.setText(Strings.woodenBowD);
        }
        else if(x == 12){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.shuriken, 288, 288));
            Application.lbRightShopDescription.setText(Strings.shurikenD);
        }
        else if(x == 13){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.reinforcedBow, 288, 288));
            Application.lbRightShopDescription.setText(Strings.reinforcedBowD);
        }
        else if(x == 14){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.crossbow, 288, 288));
            Application.lbRightShopDescription.setText(Strings.crossbowD);
        }
        else if(x == 15){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.kunai, 288, 288));
            Application.lbRightShopDescription.setText(Strings.kunaiD);
        }
        else if(x == 16){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.onzil, 288, 288));
            Application.lbRightShopDescription.setText(Strings.onzilD);
        }
        else if(x == 17){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.hellBow, 288, 288));
            Application.lbRightShopDescription.setText(Strings.hellBowD);
        }
        else if(x == 18){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.alav, 288, 288));
            Application.lbRightShopDescription.setText(Strings.alavD);
        }
        else if(x == 19){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.vineregen, 288, 288));
            Application.lbRightShopDescription.setText(Strings.vineregenD);
        }
        else if(x == 20){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.kotperes, 288, 288));
            Application.lbRightShopDescription.setText(Strings.kotperesD);
        }
        else if(x == 21){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.leatherChestplate, 288, 288));
            Application.lbRightShopDescription.setText(Strings.leatherChestplateD);
        }
        else if(x == 22){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.leatherHelmet, 288, 288));
            Application.lbRightShopDescription.setText(Strings.leatherHelmetD);
        }
        else if(x == 23){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.silverChestplate, 288, 288));
            Application.lbRightShopDescription.setText(Strings.silverChestplateD);
        }
        else if(x == 24){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.silverHelmet, 288, 288));
            Application.lbRightShopDescription.setText(Strings.silverHelmetD);
        }
        else if(x == 25){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.bronzeChestplate, 288, 288));
            Application.lbRightShopDescription.setText(Strings.bronzeChestplateD);
        }
        else if(x == 26){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.bronzeHelmet, 288, 288));
            Application.lbRightShopDescription.setText(Strings.bronzeHelmetD);
        }
        else if(x == 27){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.obsidianChestplate, 288, 288));
            Application.lbRightShopDescription.setText(Strings.obsidianChestplateD);
        }
        else if(x == 28){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.obsidianHelmet, 288, 288));
            Application.lbRightShopDescription.setText(Strings.obsidianHelmetD);
        }
        else if(x == 29){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.darkRobe, 288, 288));
            Application.lbRightShopDescription.setText(Strings.darkRobeD);
        }
        else if(x == 30){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.darkHeart, 288, 288));
            Application.lbRightShopDescription.setText(Strings.darkHeartD);
        }
        else if(x == 31){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.smallHealthPotion, 288, 288));
            Application.lbRightShopDescription.setText(Strings.smallHealthPotionD);
        }
        else if(x == 32){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.mediumHealthPotion, 288, 288));
            Application.lbRightShopDescription.setText(Strings.mediumHealthPotionD);
        }
        else if(x == 33){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.largeHealthPotion, 288, 288));
            Application.lbRightShopDescription.setText(Strings.largeHealthPotionD);
        }
        else if(x == 34){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.smallRegenerationPotion, 288, 288));
            Application.lbRightShopDescription.setText(Strings.smallRegenerationPotionD);
        }
        else if(x == 35){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.mediumRegenerationPotion, 288, 288));
            Application.lbRightShopDescription.setText(Strings.mediumRegenerationPotionD);
        }
        else if(x == 36){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.largeRegenerationPotion, 288, 288));
            Application.lbRightShopDescription.setText(Strings.largeRegenerationPotionD);
        }
        else if(x == 37){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.waterBottle, 288, 288));
            Application.lbRightShopDescription.setText(Strings.waterBottleD);
        }
        else if(x == 38){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.strengthPotion, 288, 288));
            Application.lbRightShopDescription.setText(Strings.strengthPotionD);
        }
        else if(x == 39){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.antivenom, 288, 288));
            Application.lbRightShopDescription.setText(Strings.antivenomD);
        }
        else if(x == 40){
            Application.lbRightShop.setIcon(TKUtils.stretchedImage(Images.speedPotion, 288, 288));
            Application.lbRightShopDescription.setText(Strings.speedPotionD);
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if(x == 1)      {lb.setIcon(Images.woodenClubAcik);}
        else if(x == 2) {lb.setIcon(Images.woodenSwordAcik);}
        else if(x == 3) {lb.setIcon(Images.medievalAxeAcik);}
        else if(x == 4) {lb.setIcon(Images.shortSwordAcik);}
        else if(x == 5) {lb.setIcon(Images.knightsSwordAcik);}
        else if(x == 6) {lb.setIcon(Images.paladinsSwordAcik);}
        else if(x == 7) {lb.setIcon(Images.hellSwordAcik);}
        else if(x == 8) {lb.setIcon(Images.odrokusAcik);}
        else if(x == 9) {lb.setIcon(Images.vinegriandAcik);}
        else if(x == 10){lb.setIcon(Images.zugoronAcik);}
        else if(x == 11){lb.setIcon(Images.woodenBowAcik);}
        else if(x == 12){lb.setIcon(Images.shurikenAcik);}
        else if(x == 13){lb.setIcon(Images.reinforcedBowAcik);}
        else if(x == 14){lb.setIcon(Images.crossbowAcik);}
        else if(x == 15){lb.setIcon(Images.kunaiAcik);}
        else if(x == 16){lb.setIcon(Images.onzilAcik);}
        else if(x == 17){lb.setIcon(Images.hellBowAcik);}
        else if(x == 18){lb.setIcon(Images.alavAcik);}
        else if(x == 19){lb.setIcon(Images.vineregenAcik);}
        else if(x == 20){lb.setIcon(Images.kotperesAcik);}
        else if(x == 21){lb.setIcon(Images.leatherChestplateAcik);}
        else if(x == 22){lb.setIcon(Images.leatherHelmetAcik);}
        else if(x == 23){lb.setIcon(Images.silverChestplateAcik);}
        else if(x == 24){lb.setIcon(Images.silverHelmetAcik);}
        else if(x == 25){lb.setIcon(Images.bronzeChestplateAcik);}
        else if(x == 26){lb.setIcon(Images.bronzeHelmetAcik);}
        else if(x == 27){lb.setIcon(Images.obsidianChestplateAcik);}
        else if(x == 28){lb.setIcon(Images.obsidianHelmetAcik);}
        else if(x == 29){lb.setIcon(Images.darkRobeAcik);}
        else if(x == 30){lb.setIcon(Images.darkHeartAcik);}
        else if(x == 31){lb.setIcon(Images.smallHealthPotionAcik);}
        else if(x == 32){lb.setIcon(Images.mediumHealthPotionAcik);}
        else if(x == 33){lb.setIcon(Images.largeHealthPotionAcik);}
        else if(x == 34){lb.setIcon(Images.smallRegenerationPotionAcik);}
        else if(x == 35){lb.setIcon(Images.mediumRegenerationPotionAcik);}
        else if(x == 36){lb.setIcon(Images.largeRegenerationPotionAcik);}
        else if(x == 37){lb.setIcon(Images.waterBottleAcik);}
        else if(x == 38){lb.setIcon(Images.strengthPotionAcik);}
        else if(x == 39){lb.setIcon(Images.antivenomAcik);}
        else if(x == 40){lb.setIcon(Images.speedPotionAcik);}
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if(x == 1)      {lb.setIcon(Images.woodenClub);}
        else if(x == 2) {lb.setIcon(Images.woodenSword);}
        else if(x == 3) {lb.setIcon(Images.medievalAxe);}
        else if(x == 4) {lb.setIcon(Images.shortSword);}
        else if(x == 5) {lb.setIcon(Images.knightsSword);}
        else if(x == 6) {lb.setIcon(Images.paladinsSword);}
        else if(x == 7) {lb.setIcon(Images.hellSword);}
        else if(x == 8) {lb.setIcon(Images.odrokus);}
        else if(x == 9) {lb.setIcon(Images.vinegriand);}
        else if(x == 10){lb.setIcon(Images.zugoron);}
        else if(x == 11){lb.setIcon(Images.woodenBow);}
        else if(x == 12){lb.setIcon(Images.shuriken);}
        else if(x == 13){lb.setIcon(Images.reinforcedBow);}
        else if(x == 14){lb.setIcon(Images.crossbow);}
        else if(x == 15){lb.setIcon(Images.kunai);}
        else if(x == 16){lb.setIcon(Images.onzil);}
        else if(x == 17){lb.setIcon(Images.hellBow);}
        else if(x == 18){lb.setIcon(Images.alav);}
        else if(x == 19){lb.setIcon(Images.vineregen);}
        else if(x == 20){lb.setIcon(Images.kotperes);}
        else if(x == 21){lb.setIcon(Images.leatherChestplate);}
        else if(x == 22){lb.setIcon(Images.leatherHelmet);}
        else if(x == 23){lb.setIcon(Images.silverChestplate);}
        else if(x == 24){lb.setIcon(Images.silverHelmet);}
        else if(x == 25){lb.setIcon(Images.bronzeChestplate);}
        else if(x == 26){lb.setIcon(Images.bronzeHelmet);}
        else if(x == 27){lb.setIcon(Images.obsidianChestplate);}
        else if(x == 28){lb.setIcon(Images.obsidianHelmet);}
        else if(x == 29){lb.setIcon(Images.darkRobe);}
        else if(x == 30){lb.setIcon(Images.darkHeart);}
        else if(x == 31){lb.setIcon(Images.smallHealthPotion);}
        else if(x == 32){lb.setIcon(Images.mediumHealthPotion);}
        else if(x == 33){lb.setIcon(Images.largeHealthPotion);}
        else if(x == 34){lb.setIcon(Images.smallRegenerationPotion);}
        else if(x == 35){lb.setIcon(Images.mediumRegenerationPotion);}
        else if(x == 36){lb.setIcon(Images.largeRegenerationPotion);}
        else if(x == 37){lb.setIcon(Images.waterBottle);}
        else if(x == 38){lb.setIcon(Images.strengthPotion);}
        else if(x == 39){lb.setIcon(Images.antivenom);}
        else if(x == 40){lb.setIcon(Images.speedPotion);}
    }



    @Override
    public void mousePressed(MouseEvent e) { }
    @Override
    public void mouseReleased(MouseEvent e) { }


}

