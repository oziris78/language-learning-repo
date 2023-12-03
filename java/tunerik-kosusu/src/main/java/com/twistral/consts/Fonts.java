package com.twistral.consts;

import com.twistral.main.Main;
import com.twistral.utils.ResourceUtils;


import javax.swing.*;
import java.awt.*;

public class Fonts {

    public static float DEF_SIZE = 20f;
    public static Font cusFont;

    static {
        cusFont = ResourceUtils.getFont(Main.class.getResource("/res/robotoCondensedLight.ttf"), DEF_SIZE);
        if(cusFont == null) {
            JOptionPane.showMessageDialog(null, "Font couldn't be loaded, exiting the program...",
                    "ERROR #001", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }


}
