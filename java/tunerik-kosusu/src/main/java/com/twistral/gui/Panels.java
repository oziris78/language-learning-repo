package com.twistral.gui;

import com.twistral.consts.Colors;
import com.twistral.components.*;
import com.twistral.utils.TKUtils;

import javax.swing.*;

public class Panels {

    public static JPanel tkPanel(){
        return new TKPanel()
                .setBounds(TKUtils.screenWideRect())
                .setBackground(Colors.gray)
                .setLayout(null)
                .setEnabled(true)
                .setVisible(true)
                .setOpaque(true)
                .getPanel();
    }

    public static JPanel shopPanel(){
        return new TKPanel(tkPanel())
                .setBackground(Colors.black)
                .getPanel();
    }


}
