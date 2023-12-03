package com.twistral.gui;

import com.twistral.components.*;
import com.twistral.consts.Colors;
import com.twistral.consts.Fonts;
import com.twistral.main.Application;
import javax.swing.*;
import java.awt.*;

public class Bars {


    private static JProgressBar tkBar(Rectangle r, Color bg, Color fg, int min, int val, int max, int ori){
        return new TKProgressBar()
                .setBounds(r)
                .setBackground(bg)
                .setFont(Fonts.cusFont)
                .setStringPainted(true)
                .setForeground(fg)
                .setIndeterminate(false)
                .setBorderPainted(false)
                .setLayout(null)
                .setMinimum(min)
                .setValue(val)
                .setMaximum(max)
                .setOrientation(ori)
                .getBar();
    }


    public static JProgressBar health(){
        return tkBar(new Rectangle(40,370,280,30), Colors.red3, Colors.red2,
                0, Application.getPlayer().getCurHealth(), Application.getPlayer().getMaxHealth(),
                SwingConstants.HORIZONTAL);
    }

    public static JProgressBar level(){
        return tkBar(new Rectangle(40,400,280,30), Colors.green2, Colors.green1,
                0, Application.getPlayer().getExperience(), 1000,
                SwingConstants.HORIZONTAL);
    }

    public static JProgressBar monster(){
        return tkBar(new Rectangle(960,370,280,30), Colors.red3, Colors.red2,
                0, Application.getCurrentMonster().getHealth(), Application.getCurrentMonster().getMaxHealth(),
                SwingConstants.HORIZONTAL);
    }






}
