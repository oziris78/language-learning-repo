package com.twistral.gui;

import com.twistral.consts.*;
import com.twistral.listeners.BtnBuyTheWeaponListener;
import com.twistral.listeners.BtnContinueListener;
import com.twistral.listeners.BtnStartTheGameListener;
import com.twistral.main.Application;
import com.twistral.components.*;
import com.twistral.utils.TKUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Buttons {

    /* these are typical buttons that this app uses
    other specific buttons will be defined using these buttons
    */

    private static JButton tkButtonSoundless(Rectangle r, String text, float size, Color fgColor){
        return new TKButton()
                .setBounds(r)
                .setText(text)
                .setForeground(fgColor)
                .setFont(Fonts.cusFont.deriveFont(size))
                .setLayout(null)
                .setBorder(null)
                .setRolloverEnabled(true)
                .setOpaque(true)
                .setVisible(true)
                .setEnabled(true)
                .setContentAreaFilled(false)
                .setFocusable(false)
                .getButton();
    }

    private static JButton tkCenteredSoundless(Rectangle r, String text, float size, Color fgColor){
        return new TKButton(tkButtonSoundless(r, text, size, fgColor))
                .setHorizontalAlignment(JButton.CENTER)
                .setVerticalAlignment(JButton.CENTER)
                .setHorizontalTextPosition(JButton.CENTER)
                .setVerticalTextPosition(JButton.CENTER)
                .getButton();
    }


    private static JButton tkButton(Rectangle r, String text, float size, Color fgColor){
        return new TKButton(tkButtonSoundless(r, text, size, fgColor))
                .addActionListener(e ->
                        TKUtils.playClipMod(Sounds.clipMenuClick1, Sounds.clipMenuClick2, Sounds.clipMenuClick3)
                )
                .getButton();
    }


    private static JButton tkCentered(Rectangle r, String text, float size, Color fgColor){
        return new TKButton(tkCenteredSoundless(r, text, size, fgColor))
                .addActionListener(e ->
                        TKUtils.playClipMod(Sounds.clipMenuClick1, Sounds.clipMenuClick2, Sounds.clipMenuClick3)
                )
                .getButton();
    }


    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////


    private static JButton battleOption(Rectangle r, float size, String text){
        return new TKButton(tkCenteredSoundless(r, text, size, Colors.white))
                .setBackground(Colors.gray)
                .setIcon(Images.btnMenu)
                .setPressedIcon(Images.btnMenuClick)
                .setRolloverIcon(Images.btnMenuHover)
                .setBorderPainted(false)
                .addMouseListener(Application.panGame.getMouseListeners()[0])
                .getButton();
    }


    public static JButton battleOptionMelee(){
        return battleOption(new Rectangle(56,603,250,80), 30f, Strings.meleeAttack);
    }

    public static JButton battleOptionRanged(){
        return battleOption(new Rectangle(362,603,250,80), 30f, Strings.rangedAttack);
    }

    public static JButton battleOptionDefend(){
        return battleOption(new Rectangle(668,603,250,80), 40f, Strings.defend);
    }

    public static JButton battleOptionItems(){
        return battleOption(new Rectangle(974,603,250,80), 40f, Strings.items);
    }


    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////



    private static JButton menuChanger(Rectangle r, String text, float size, ActionListener listener){
        return new TKButton(tkButton(r, text, size, Colors.white))
                .setBackground(Colors.gray)
                .setOpaque(true)
                .setHorizontalAlignment(JButton.CENTER)
                .setVerticalAlignment(JButton.CENTER)
                .setHorizontalTextPosition(JButton.CENTER)
                .setVerticalTextPosition(JButton.CENTER)
                .setBorderPainted(false)
                .setIcon(Images.btnMenu)
                .setPressedIcon(Images.btnMenuClick)
                .setRolloverIcon(Images.btnMenuHover)
                .addActionListener(listener)
                .getButton();
    }


    public static JButton creditsToMain(){
        return menuChanger(new Rectangle(100,585,250,80), Strings.strBack, 40f, e -> {
            Application.panCredits.setVisible(false);
            Application.panMain.setVisible(true);
        });
    }

    public static JButton newGameToMain(){
        return menuChanger(new Rectangle(100,585,250,80), Strings.strBack, 40f, e -> {
            Application.panNewGame.setVisible(false);
            Application.panMain.setVisible(true);
            Application.rbtnTekin.setSelected(true);
            Application.rbtnKnight.setSelected(true);
            Application.rbtnEasy.setSelected(true);
            Application.lbCharacterImage.setIcon(Images.tekin);
        });
    }

    public static JButton settingsToMain(){
        return menuChanger(new Rectangle(100,585,250,80), Strings.strBack, 40f, e -> {
            Application.panSettings.setVisible(false);
            Application.panMain.setVisible(true);
        });
    }

    public static JButton invToGame(){
        return menuChanger(new Rectangle(100,585,250,80), Strings.strBack, 40f, e -> {
            Application.panGame.setVisible(true);
            Application.panInventoryFromGame.setVisible(false);
            Application.invGuncelle();
        });
    }

    public static JButton gamesSettingsToGame(){
        return menuChanger(new Rectangle(100,585,250,80), Strings.strBack, 40f, e -> {
            Application.panGamesSettings.setVisible(false);
            Application.panGame.setVisible(true);
        });
    }

    public static JButton shopToInv(){
        return new TKButton(
                menuChanger(new Rectangle(504,610,250,80), Strings.inventory, 35f, e -> {
                    Application.panShop.setVisible(false);
                    Application.panInventoryFromShop.setVisible(true);
                }))
                .setBackground(null)
                .getButton();
    }

    public static JButton invToShop(){
        return menuChanger(new Rectangle(504,610,250,80), Strings.strBack, 40f, e -> {
            Application.panShop.setVisible(true);
            Application.panInventoryFromShop.setVisible(false);
        });
    }

    public static JButton gameToSettings(){
        JButton btn = menuChanger(new Rectangle(1190,528,32,32), "", Fonts.DEF_SIZE, e -> {
            Application.panGame.setVisible(false);
            Application.panGamesSettings.setVisible(true);
        });
        btn.setIcon(Images.cog);
        btn.setPressedIcon(Images.cogKara);
        btn.setRolloverIcon(Images.cogKara);
        return btn;
    }


    public static JButton mainToNew(){
        return menuChanger(new Rectangle(340,300,250,80), Strings.strNewGame, 32f, e -> {
            Application.panMain.setVisible(false);
            Application.panNewGame.setVisible(true);
        });
    }


    public static JButton mainToSettings(){
        return menuChanger(new Rectangle(690,300,250,80), Strings.strSettings, 40f, e -> {
            Application.panMain.setVisible(false);
            Application.panSettings.setVisible(true);
        });
    }


    public static JButton mainToCredits(){
        return menuChanger(new Rectangle(340,460,250,80), Strings.strCredits, 40f, e -> {
            Application.panMain.setVisible(false);
            Application.panCredits.setVisible(true);
        });
    }


    public static JButton deadToMain(){
        return menuChanger(new Rectangle(515,400,250,80), Strings.goToMainMenu, 25f, e -> {
            Application.panGame.setVisible(false);
            Application.panGameOver.setVisible(false);
            Application.panMain.setVisible(true);
            Application.btnDeadToMain.setVisible(false);
        });
    }



    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////


    public static JButton quit(){
        return new TKButton(tkCentered(new Rectangle(690,460,250,80), Strings.strQuit, 50f, Colors.white)).setLayout(null)
                .setIcon(Images.btnMenu)
                .setPressedIcon(Images.btnMenuClick)
                .setRolloverIcon(Images.btnMenuHover)
                .setBorderPainted(false)
                .addActionListener(e -> {
                    System.exit(0);
                })
                .getButton();
    }

    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////

    public static JButton cutscenes(){
        return new TKButton(tkCenteredSoundless(new Rectangle(1048,528,100,40), Strings.next, 25f, Colors.white))
                .setBackground(Colors.gray)
                .setBorder(BorderFactory.createMatteBorder(2,2,0,2, Colors.gray3))
                .setBorderPainted(true)
                .setContentAreaFilled(true)
                .addMouseListener(Application.panGame.getMouseListeners()[0])
                .getButton();
    }


    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////


    public static JButton startTheGame(){
        return new TKButton(tkCenteredSoundless(new Rectangle(930,585,250,80), Strings.start, 40f, Colors.white))
                .setBackground(Colors.gray)
                .setIcon(Images.btnMenu)
                .setPressedIcon(Images.btnMenuClick)
                .setRolloverIcon(Images.btnMenuHover)
                .addActionListener(new BtnStartTheGameListener())
                .getButton();
    }


    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////


    public static JButton buyTheWeapon(){
        return new TKButton(tkCenteredSoundless(new Rectangle(959,610,250,80), Strings.strBuyTheWeapon, 45f, Colors.white))
                .setBackground(Colors.gray)
                .setIcon(Images.btnMenu)
                .setPressedIcon(Images.btnMenuClick)
                .setRolloverIcon(Images.btnMenuHover)
                .addActionListener(new BtnBuyTheWeaponListener())
                .getButton();
    }


    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////


    public static JButton continueBtn(){
        return new TKButton(tkCenteredSoundless(new Rectangle(50,610,250,80), Strings.strContinue, 35f, Colors.white))
                .setBackground(Colors.gray)
                .setIcon(Images.btnMenu)
                .setPressedIcon(Images.btnMenuClick)
                .setRolloverIcon(Images.btnMenuHover)
                .addActionListener(new BtnContinueListener())
                .getButton();
    }


}
