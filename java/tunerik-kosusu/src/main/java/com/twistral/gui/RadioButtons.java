package com.twistral.gui;

import com.twistral.consts.*;
import com.twistral.main.Application;
import com.twistral.components.*;
import com.twistral.utils.TKUtils;
import javax.swing.*;
import java.awt.*;


public class RadioButtons {

    private static JRadioButton tkRadioButton(Rectangle r, float size, String text){
        return new TKRadioButton()
                .setBounds(r)
                .setFont(Fonts.cusFont.deriveFont(size))
                .setText(text)
                .setBackground(Colors.gray)
                .setForeground(Colors.white)
                .setLayout(null)
                .setBorder(null)
                .setRolloverEnabled(true)
                .setEnabled(true)
                .setVisible(true)
                .setOpaque(true)
                .setContentAreaFilled(false)
                .setFocusable(false)
                .setSelectedIcon(Images.radioSelected)
                .setIcon(Images.radio)
                .setRolloverIcon(Images.radioHover)
                .addActionListener(e ->
                    TKUtils.playClipMod(Sounds.clipSwitch1, Sounds.clipSwitch2, Sounds.clipSwitch3, Sounds.clipSwitch4)
                )
                .getButton();
    }


    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////


    public static JRadioButton knight() {
        return tkRadioButton(new Rectangle(500, 280, 120, 40), 30f, Strings.knight);
    }

    public static JRadioButton archer() {
        return tkRadioButton(new Rectangle(500, 330, 120, 40), 30f, Strings.archer);
    }

    public static JRadioButton swordsman(){
        return tkRadioButton(new Rectangle(650,280,175,40),28f,Strings.swordsman);
    }

    public static JRadioButton assassin(){
        return tkRadioButton(new Rectangle(650,330,150,40),30f,Strings.assassin);
    }

    public static JRadioButton tekin(){
        return new TKRadioButton(tkRadioButton(new Rectangle(770,115,120,40),30f,Strings.tekin))
                .addActionListener(e -> {
                    Application.lbCharacterImage.setIcon(Images.tekin);
                })
                .getButton();
    }

    public static JRadioButton ayca(){
        return new TKRadioButton(tkRadioButton(new Rectangle(920,115,100,40),30f,Strings.ayca))
                .addActionListener(e -> {
                    Application.lbCharacterImage.setIcon(Images.ayca);
                })
                .getButton();
    }

    public static JRadioButton easy(){
        return tkRadioButton(new Rectangle(900,280,100,40),28f,Strings.easy);
    }

    public static JRadioButton hard(){
        return tkRadioButton(new Rectangle(900,330,100,40),28f,Strings.hard);
    }

    public static JRadioButton medium(){
        return tkRadioButton(new Rectangle(1020,280,130,40),28f,Strings.medium);
    }

    public static JRadioButton ultra(){
        return tkRadioButton(new Rectangle(1020,330,100,40), 28f, Strings.ultra);
    }


}
