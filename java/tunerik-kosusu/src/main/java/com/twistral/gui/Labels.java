package com.twistral.gui;

import com.twistral.utils.*;
import com.twistral.consts.Colors;
import com.twistral.consts.Fonts;
import com.twistral.components.*;
import com.twistral.consts.Images;
import com.twistral.consts.Strings;
import com.twistral.listeners.LbInventoryItemListener;
import com.twistral.listeners.LbShopItemListener;
import com.twistral.main.Application;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class Labels {


    /* these are typical labels that this app uses
    other specific labels will be defined using these labels
    */

    public static JLabel bgLabel(ImageIcon image){
        return new TKLabel()
                .setBounds(new Rectangle(0, 0, Application.EN, Application.BOY))
                .setVisible(true)
                .setLayout(null)
                .setBorder(null)
                .setOpaque(false)
                .setHorizontalAlignment(JLabel.CENTER)
                .setVerticalAlignment(JLabel.CENTER)
                .setIcon(TKUtils.stretchedImage(image, Application.EN, Application.BOY))
                .getLabel();
    }


    private static JLabel tkLabel(Rectangle r, float size, String text, Icon img, Icon disImg){
        return new TKLabel()
                .setBounds(r)
                .setText(text)
                .setFont(Fonts.cusFont.deriveFont(size))
                .setVisible(true)
                .setLayout(null)
                .setOpaque(true)
                .setIcon(img)
                .setDisabledIcon(disImg)
                .getLabel();
    }

    private static JLabel tkLabelCentered(Rectangle r, float size, String text, Icon img, Icon disImg){
        return new TKLabel(tkLabel(r, size, text, img, disImg))
                .setHorizontalAlignment(JLabel.CENTER)
                .setVerticalAlignment(JLabel.CENTER)
                .setHorizontalTextPosition(JLabel.CENTER)
                .setVerticalTextPosition(JLabel.CENTER)
                .getLabel();
    }

    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////


    public static JLabel appTitle(){
        return tkLabelCentered(new Rectangle(207,40,865,120), Fonts.DEF_SIZE, "", Images.appTitle, null);
    }

    public static JLabel version(){
        return new TKLabel(tkLabel(new Rectangle(1130,670,150,50), Fonts.DEF_SIZE, Strings.versionForLabel, null, null))
                .setBackground(Colors.gray)
                .setForeground(Colors.white)
                .setHorizontalAlignment(JButton.RIGHT)
                .setVerticalAlignment(JButton.CENTER)
                .getLabel();
    }

    public static JLabel credits(){
        return new TKLabel(tkLabel(new Rectangle(240,30,800,500), 35f, Strings.credits, null, null))
                .setHorizontalAlignment(JLabel.CENTER)
                .setVerticalAlignment(JLabel.TOP)
                .setOpaque(false)
                .setBackground(Application.panCredits.getBackground())
                .setForeground(Colors.white)
                .getLabel();
    }


    public static JLabel youHaveDied(){
        return new TKLabel(tkLabelCentered(new Rectangle(390,150,500,250), 50f, Strings.youHaveDiedUpperCase, null, null))
                .setBackground(Colors.gray)
                .setForeground(Colors.red)
                .getLabel();
    }


    public static JLabel characterImage() {
        return new TKLabel(tkLabelCentered(new Rectangle(100,100,280,320), Fonts.DEF_SIZE,
                    "", Images.tekin, Images.tekin))
                .setBackground(Colors.gray)
                .setForeground(Colors.white)
                .getLabel();
    }

    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////

    private static JLabel newGameTitle(Rectangle r, String text) {
        return new TKLabel(tkLabel(r, 42f, text, null, null))
                .setHorizontalAlignment(JLabel.LEFT)
                .setVerticalAlignment(JLabel.CENTER)
                .setHorizontalTextPosition(JLabel.LEFT)
                .setVerticalTextPosition(JLabel.CENTER)
                .setBackground(Colors.gray)
                .setForeground(Colors.red)
                .getLabel();
    }

    public static JLabel selectCharacter() { return newGameTitle(new Rectangle(500,100,200,65), Strings.selecCharacter); }
    public static JLabel selectClass() { return newGameTitle(new Rectangle(500,200,200,65), Strings.selecClass); }
    public static JLabel selectDifficulty() { return newGameTitle(new Rectangle(900,200,200,65), Strings.selecDifficulty); }
    public static JLabel selectSaveName() { return newGameTitle(new Rectangle(500,400,220,65), Strings.selecSaveName); }


    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////

    private static JLabel privStats(Rectangle r, float size, Icon icon){
        return new TKLabel(tkLabel(r, size, "", icon, icon))
                .setBackground(null)
                .setForeground(Colors.white)
                .setHorizontalAlignment(JLabel.LEFT)
                .setHorizontalTextPosition(JLabel.RIGHT)
                .setVerticalAlignment(JLabel.CENTER)
                .setVerticalTextPosition(JLabel.CENTER)
                .getLabel();
    }

    public static JLabel meleeDamage(){
        return privStats(new Rectangle(30,450,100,32), Fonts.DEF_SIZE, Images.statMeleeDamage);
    }

    public static JLabel rangedDamage(){
        return privStats(new Rectangle(30,502,100,32), Fonts.DEF_SIZE, Images.statRangedDamage);
    }

    public static JLabel meleeCrit(){
        return new TKLabel(privStats(new Rectangle(130,450,100,32), 22f, Images.statMeleeCrit))
                .setForeground(Colors.red2)
                .getLabel();
    }

    public static JLabel rangedCrit(){
        return new TKLabel(privStats(new Rectangle(130,502,100,32), 22f, Images.statRangedCrit))
                .setForeground(Colors.red2)
                .getLabel();
    }

    public static JLabel defense(){
        return new TKLabel(privStats(new Rectangle(255,450,100,32), Fonts.DEF_SIZE, Images.statDefense))
                .setForeground(Colors.green1)
                .getLabel();
    }

    public static JLabel evade(){
        return new TKLabel(privStats(new Rectangle(255,502,100,32), 22f, Images.statEvade))
                .setForeground(Colors.green1)
                .getLabel();
    }

    public static JLabel moneyShop(){
        return new TKLabel(privStats(new Rectangle(130,554,120,32), 25f, Images.statMoney))
                .setForeground(Colors.yellow)
                .setHorizontalAlignment(JLabel.CENTER)
                .getLabel();
    }

    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////

    private static ImageIcon getImageForInvItem(String id){
        if(id == "smallHP")          return Images.smallHealthPotion;
        else if(id == "mediumHP")    return Images.mediumHealthPotion;
        else if(id == "largeHP")     return Images.largeHealthPotion;
        else if(id == "smallRegen")  return Images.smallRegenerationPotion;
        else if(id == "mediumRegen") return Images.mediumRegenerationPotion;
        else if(id == "largeRegen")  return Images.largeRegenerationPotion;
        else if(id == "water")       return Images.waterBottle;
        else if(id == "strength")    return Images.strengthPotion;
        else if(id == "antivenom")   return Images.antivenom;
        else if(id == "speed")       return Images.speedPotion;
        else return null;
    }

    private static JLabel privInventoryItem(Point p, String type, String id){
        ImageIcon img = getImageForInvItem(id);
        JLabel lb = new TKLabel(tkLabel(new Rectangle(p.x, p.y, 80, 48), Fonts.DEF_SIZE, "", img, img))
                .setBackground(Colors.gray)
                .setForeground(Colors.white)
                .setHorizontalAlignment(JLabel.LEFT)
                .setVerticalAlignment(JLabel.CENTER)
                .setHorizontalTextPosition(JLabel.RIGHT)
                .setVerticalTextPosition(JLabel.CENTER)
                .getLabel();
        lb.addMouseListener(new LbInventoryItemListener(type, id, lb));
        return lb;
    }


    public static JLabel itemGame1(){ return privInventoryItem(new Point(480,175), "gameItem", "smallHP"); }
    public static JLabel itemGame2(){ return privInventoryItem(new Point(600,175), "gameItem", "mediumHP"); }
    public static JLabel itemGame3(){ return privInventoryItem(new Point(720,175), "gameItem", "largeHP"); }
    public static JLabel itemGame4(){ return privInventoryItem(new Point(480,245), "gameItem", "smallRegen"); }
    public static JLabel itemGame5(){ return privInventoryItem(new Point(600,245), "gameItem", "mediumRegen"); }
    public static JLabel itemGame6(){ return privInventoryItem(new Point(720,245), "gameItem", "largeRegen"); }
    public static JLabel itemGame7(){ return privInventoryItem(new Point(480,315), "gameItem", "water"); }
    public static JLabel itemGame8(){ return privInventoryItem(new Point(600,315), "gameItem", "strength"); }
    public static JLabel itemGame9(){ return privInventoryItem(new Point(720,315), "gameItem", "antivenom"); }
    public static JLabel itemGame10(){ return privInventoryItem(new Point(600,385), "gameItem", "speed"); }
    public static JLabel itemShop1(){ return privInventoryItem(new Point(480,175), "shopItem", "smallHP"); }
    public static JLabel itemShop2(){ return privInventoryItem(new Point(600,175), "shopItem", "mediumHP"); }
    public static JLabel itemShop3(){ return privInventoryItem(new Point(720,175), "shopItem", "largeHP"); }
    public static JLabel itemShop4(){ return privInventoryItem(new Point(480,245), "shopItem", "smallRegen"); }
    public static JLabel itemShop5(){ return privInventoryItem(new Point(600,245), "shopItem", "mediumRegen"); }
    public static JLabel itemShop6(){ return privInventoryItem(new Point(720,245), "shopItem", "largeRegen"); }
    public static JLabel itemShop7(){ return privInventoryItem(new Point(480,315), "shopItem", "water"); }
    public static JLabel itemShop8(){ return privInventoryItem(new Point(600,315), "shopItem", "strength"); }
    public static JLabel itemShop9(){ return privInventoryItem(new Point(720,315), "shopItem", "antivenom"); }
    public static JLabel itemShop10(){ return privInventoryItem(new Point(600,385), "shopItem", "speed"); }


    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////


    private static JLabel privLeftAndRight(String s){
        Rectangle r = s.equals("left") ? new Rectangle(40,50,280,320) : new Rectangle(960,50,280,320);
        Border b = BorderFactory.createMatteBorder(2,2,2,2, Colors.gray2);
        return new TKLabel(tkLabel(r, Fonts.DEF_SIZE, "", null, null))
                .setBorder(b)
                .setBackground(Colors.gray)
                .getLabel();
    }

    public static JLabel left(){ return privLeftAndRight("left"); }
    public static JLabel right(){ return privLeftAndRight("right"); }


    public static JLabel middle(){
        Rectangle rect = new Rectangle(390,75,500,400);
        ImageIcon icon = TKUtils.stretchedImage(Images.tekin, rect.width, rect.height);
        return new TKLabel(tkLabel(rect, Fonts.DEF_SIZE, "", icon, null))
                .setBorder(BorderFactory.createLoweredBevelBorder())
                .setBackground(Colors.gray)
                .getLabel();
    }


    private static JLabel privLeftAndRightShop(String s){
        Rectangle r = s.equals("left") ? new Rectangle(40,50,280,320) : new Rectangle(940,50,288,288);
        Border b = s.equals("left") ? BorderFactory.createMatteBorder(2,2,2,2, Colors.gray2) : null;
        return new TKLabel(tkLabel(r, Fonts.DEF_SIZE, "", null, null))
                .setBorder(b)
                .setBackground(Colors.black)
                .getLabel();
    }

    public static JLabel leftShop(){ return privLeftAndRightShop("left"); }
    public static JLabel rightShop(){ return privLeftAndRightShop("right"); }


    public static JLabel rightShopDesc(){
        return new TKLabel(tkLabel(new Rectangle(940,338,308,230), Fonts.DEF_SIZE, "", null, null))
            .setBackground(Colors.black)
            .setCursor(null)
            .setHorizontalAlignment(JLabel.LEFT)
            .setVerticalAlignment(JLabel.TOP)
            .setOpaque(false)
            .getLabel();
    }


    public static JLabel down(){
        Border b = BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(2,0,0,0, Colors.gray3),
                BorderFactory.createLoweredBevelBorder());
        return new TKLabel(tkLabelCentered(new Rectangle(2,568,1276,150), 25f, "", null, null))
                .setBorder(b)
                .setBackground(Colors.gray2)
                .setForeground(Colors.white)
                .setOpaque(false)
                .setHorizontalAlignment(JLabel.LEFT)
                .setVerticalAlignment(JLabel.TOP)
                .getLabel();
    }



    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////

    public static JLabel hit(){
        return new TKLabel(tkLabelCentered(new Rectangle(560,50,220,99), 55f, "", Images.hitIcon, Images.hitIcon))
                .setBackground(Colors.gray)
                .setForeground(Colors.orange)
                .setHorizontalAlignment(JLabel.LEFT)
                .setHorizontalTextPosition(JLabel.RIGHT)
                .setVisible(false)
                .getLabel();
    }


    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////

    private static final int h1 = 40, h2 = 98, h3 = 181, h4 = 239, h5 = 322, h6 = 380, h7 = 463, h8 = 521;

    private static int rowCount = 1;

    private static JLabel privShopItem(int px, int py, ImageIcon img, ImageIcon img2){
        JLabel lb = new TKLabel(tkLabelCentered(new Rectangle(px,py,48,48), Fonts.DEF_SIZE, "", img, img2))
                .setBackground(Colors.gray)
                .setForeground(Colors.white)
                .getLabel();

        lb.addMouseListener(new LbShopItemListener(lb, rowCount));
        rowCount++;

        return lb;
    }

    public static JLabel woodenclub(){return privShopItem(420, h1, Images.woodenClub, Images.woodenClubKapali);}
    public static JLabel woodensword(){return privShopItem(488, h1, Images.woodenSword, Images.woodenSwordKapali);}
    public static JLabel medievalaxe(){return privShopItem(556, h1, Images.medievalAxe, Images.medievalAxeKapali);}
    public static JLabel shortsword(){return privShopItem(624, h1, Images.shortSword, Images.shortSwordKapali);}
    public static JLabel knightssword(){return privShopItem(692, h1, Images.knightsSword, Images.knightsSwordKapali);}
    public static JLabel paladinssword(){return privShopItem(760, h1, Images.paladinsSword, Images.paladinsSwordKapali);}
    public static JLabel hellsword(){return privShopItem(420, h2, Images.hellSword, Images.hellSwordKapali);}
    public static JLabel odrokus(){return privShopItem(488, h2, Images.odrokus, Images.odrokusKapali);}
    public static JLabel vinegriand(){return privShopItem(556, h2, Images.vinegriand, Images.vinegriandKapali);}
    public static JLabel zugoron(){return privShopItem(624, h2, Images.zugoron, Images.zugoronKapali);}
    public static JLabel woodenbow(){return privShopItem(420, h3, Images.woodenBow, Images.woodenBowKapali);}
    public static JLabel shuriken(){return privShopItem(488, h3, Images.shuriken, Images.shurikenKapali);}
    public static JLabel reinforcedbow(){return privShopItem(556, h3, Images.reinforcedBow, Images.reinforcedBowKapali);}
    public static JLabel crossbow(){return privShopItem(624, h3, Images.crossbow, Images.crossbowKapali);}
    public static JLabel kunai(){return privShopItem(692, h3, Images.kunai, Images.kunaiKapali);}
    public static JLabel onzil(){return privShopItem(760, h3, Images.onzil, Images.onzilKapali);}
    public static JLabel hellbow(){return privShopItem(420, h4, Images.hellBow, Images.hellBowKapali);}
    public static JLabel alav(){return privShopItem(488, h4, Images.alav, Images.alavKapali);}
    public static JLabel vineregen(){return privShopItem(556, h4, Images.vineregen, Images.vineregenKapali);}
    public static JLabel kotperes(){return privShopItem(624, h4, Images.kotperes, Images.kotperesKapali);}
    public static JLabel leatherchestplate(){return privShopItem(420, h5, Images.leatherChestplate, Images.leatherChestplateKapali);}
    public static JLabel leatherhelmet(){return privShopItem(488, h5, Images.leatherHelmet, Images.leatherHelmetKapali);}
    public static JLabel silverchestplate(){return privShopItem(556, h5, Images.silverChestplate, Images.silverChestplateKapali);}
    public static JLabel silverhelmet(){return privShopItem(624, h5, Images.silverHelmet, Images.silverHelmetKapali);}
    public static JLabel bronzechestplate(){return privShopItem(692, h5, Images.bronzeChestplate, Images.bronzeChestplateKapali);}
    public static JLabel bronzehelmet(){return privShopItem(760, h5, Images.bronzeHelmet, Images.bronzeHelmetKapali);}
    public static JLabel obsidianchestplate(){return privShopItem(420, h6, Images.obsidianChestplate, Images.obsidianChestplateKapali);}
    public static JLabel obsidianhelmet(){return privShopItem(488, h6, Images.obsidianHelmet, Images.obsidianHelmetKapali);}
    public static JLabel darkrobe(){return privShopItem(556, h6, Images.darkRobe, Images.darkRobeKapali);}
    public static JLabel darkheart(){return privShopItem(624, h6, Images.darkHeart, Images.darkHeartKapali);}
    public static JLabel smallhealthpotion(){return privShopItem(420, h7, Images.smallHealthPotion, Images.smallHealthPotionKapali);}
    public static JLabel mediumhealthpotion(){return privShopItem(488, h7, Images.mediumHealthPotion, Images.mediumHealthPotionKapali);}
    public static JLabel largehealthpotion(){return privShopItem(556, h7, Images.largeHealthPotion, Images.largeHealthPotionKapali);}
    public static JLabel smallregenerationpotion(){return privShopItem(624, h7, Images.smallRegenerationPotion, Images.smallRegenerationPotionKapali);}
    public static JLabel mediumregenerationpotion(){return privShopItem(692, h7, Images.mediumRegenerationPotion, Images.mediumRegenerationPotionKapali);}
    public static JLabel largeregenerationpotion(){return privShopItem(760, h7, Images.largeRegenerationPotion, Images.largeRegenerationPotionKapali);}
    public static JLabel waterbucket(){return privShopItem(420, h8, Images.waterBottle, Images.waterBottleKapali);}
    public static JLabel strengthpotion(){return privShopItem(488, h8, Images.strengthPotion, Images.strengthPotionKapali);}
    public static JLabel antivenom(){return privShopItem(556, h8, Images.antivenom, Images.antivenomKapali);}
    public static JLabel speedpotion() {return privShopItem(624, h8, Images.speedPotion, Images.speedPotionKapali);}


}
