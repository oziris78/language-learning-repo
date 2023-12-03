package com.twistral.components;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;


public class TKSlider {

    private JSlider slider;

    ////////////////////
    /*  CONSTRUCTORS  */
    ////////////////////
    public TKSlider(JSlider slider){
        this.slider = slider;
    }

    public TKSlider(TKSlider TKSlider){
        this.slider = TKSlider.getSlider();
    }

    public TKSlider() {
        this.slider = new JSlider();
    }


    public TKSlider(int orientation) {
        this.slider = new JSlider(orientation);
    }


    public TKSlider(int min, int max) {
        this.slider = new JSlider(min, max);
    }

    public TKSlider(int min, int max, int value) {
        this.slider = new JSlider(min, max, value);
    }

    public TKSlider(int orientation, int min, int max, int value) {
        this.slider = new JSlider(orientation, min, max, value);
    }


    ///////////////
    /*  METHODS  */
    ///////////////

    public TKSlider setBounds(Rectangle bounds){
        this.slider.setBounds(bounds);
        return this;
    }
    public TKSlider setBackground(Color bgColor){
        this.slider.setBackground(bgColor);
        return this;
    }
    public TKSlider setForeground(Color fgColor){
        this.slider.setForeground(fgColor);
        return this;
    }
    public TKSlider setCursor(Cursor cursor){
        this.slider.setCursor(cursor);
        return this;
    }
    public TKSlider setEnabled(boolean isEnabled){
        this.slider.setEnabled(isEnabled);
        return this;
    }
    public TKSlider setFont(Font font){
        this.slider.setFont(font);
        return this;
    }
    public TKSlider setVisible(boolean isVisible){
        this.slider.setVisible(isVisible);
        return this;
    }
    public TKSlider addActionListener(ChangeListener changeListener){
        this.slider.addChangeListener(changeListener);
        return this;
    }
    public TKSlider setLayout(LayoutManager layout){
        this.slider.setLayout(layout);
        return this;
    }
    public TKSlider setBorder(Border border){
        this.slider.setBorder(border);
        return this;
    }
    public TKSlider setOpaque(boolean isOpaque){
        this.slider.setOpaque(isOpaque);
        return this;
    }
    public TKSlider setToolTipText(String toolTipText){
        this.slider.setToolTipText(toolTipText);
        return this;
    }
    public TKSlider setMinimum(int minimum){
        this.slider.setMinimum(minimum);
        return this;
    }
    public TKSlider setMaximum(int maximum){
        this.slider.setMaximum(maximum);
        return this;
    }
    public TKSlider setValue(int value){
        this.slider.setValue(value);
        return this;
    }
    public TKSlider addMouseListener(MouseListener mouseListener){
        this.slider.addMouseListener(mouseListener);
        return this;
    }
    public TKSlider addMouseMotionListener(MouseMotionListener mouseMotionListener){
        this.slider.addMouseMotionListener(mouseMotionListener);
        return this;
    }
    public TKSlider addMouseWheelListener(MouseWheelListener mouseWheelListener){
        this.slider.addMouseWheelListener(mouseWheelListener);
        return this;
    }
    public TKSlider setOrientation(int orientation){
        this.slider.setOrientation(orientation);
        return this;
    }
    public TKSlider setPaintLabels(boolean isPaintLabels){
        this.slider.setPaintLabels(isPaintLabels);
        return this;
    }
    public TKSlider setPaintTicks(boolean isPaintTicks){
        this.slider.setPaintTicks(isPaintTicks);
        return this;
    }
    public TKSlider setPaintTrack(boolean isPaintTracks){
        this.slider.setPaintTrack(isPaintTracks);
        return this;
    }
    public TKSlider setMajorTickSpacing(int majorTickSpacing){
        this.slider.setMajorTickSpacing(majorTickSpacing);
        return this;
    }
    public TKSlider setMinorTickSpacing(int minorTickSpacing){
        this.slider.setMinorTickSpacing(minorTickSpacing);
        return this;
    }
    public TKSlider addChangeListener(ChangeListener changeListener){
        this.slider.addChangeListener(changeListener);
        return this;
    }
    public TKSlider setInverted(boolean isInverted){
        this.slider.setInverted(isInverted);
        return this;
    }
    public TKSlider setSnapToTicks(boolean isSnapToTicks){
        this.slider.setSnapToTicks(isSnapToTicks);
        return this;
    }


    ///////////////////////////
    /*  GETTERS AND SETTERS  */
    ///////////////////////////


    public JSlider getSlider() {
        return slider;
    }
}
