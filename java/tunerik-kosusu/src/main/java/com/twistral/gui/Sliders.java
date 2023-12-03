package com.twistral.gui;

import com.twistral.components.*;
import com.twistral.utils.*;
import com.twistral.consts.Colors;
import com.twistral.consts.Fonts;
import com.twistral.consts.Sounds;
import com.twistral.consts.Strings;
import com.twistral.main.Application;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Sliders {


    private static JSlider tkSlider(Rectangle rect, String borderTitle, ChangeListener listener){
        return new TKSlider()
                .setOpaque(true)
                .setMinimum(0)
                .setMaximum(100)
                .setValue(50)
                .setBackground(Colors.gray)
                .setForeground(Colors.white)
                .setPaintTrack(true)
                .setPaintLabels(true)
                .setEnabled(true)
                .setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(),
                        borderTitle, SwingConstants.CENTER, SwingConstants.TOP, Fonts.cusFont.deriveFont(30f), Colors.white))
                .setBounds(rect)
                .addChangeListener(listener)
                .setPaintTicks(true)
                .setFont(Fonts.cusFont)
                .setOrientation(SwingConstants.HORIZONTAL)
                .setVisible(true)
                .setSnapToTicks(true)
                .setLayout(null)
                .setMajorTickSpacing(50)
                .setMinorTickSpacing(10)
                .getSlider();
    }


    public static JSlider musicGame(){
        return tkSlider(new Rectangle(440,210,400,150), Strings.music, e -> {
            int val = ((JSlider) e.getSource()).getValue();
            ClipUtils.setVolumeToClips(Sounds.musicArray, (double) val / 100d);
            Application.sliderMusic.setValue(val);
        });
    }

    public static JSlider music(){
        return tkSlider(new Rectangle(440,210,400,150), Strings.music, e -> {
            int val = ((JSlider) e.getSource()).getValue();
            ClipUtils.setVolumeToClips(Sounds.musicArray, (double) val / 100d);
            Application.sliderMusicGame.setValue(val);
        });
    }


    public static JSlider sfxGame(){
        return tkSlider(new Rectangle(440,50,400,150), Strings.sfx, e -> {
            int val = ((JSlider) e.getSource()).getValue();
            ClipUtils.setVolumeToClips(Sounds.sfxArray, (double) val / 100);
            Application.sliderSFX.setValue( ((JSlider) e.getSource()).getValue() );
        });
    }

    public static JSlider sfx(){
        return tkSlider(new Rectangle(440,50,400,150), Strings.sfx, e -> {
            int val = ((JSlider) e.getSource()).getValue();
            ClipUtils.setVolumeToClips(Sounds.sfxArray, (double) val / 100);
            Application.sliderSFXGame.setValue( ((JSlider) e.getSource()).getValue() );
        });
    }



}
