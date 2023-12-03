package com.twistral.components;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ProgressBarUI;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

public class TKProgressBar {

    private JProgressBar bar;

    ////////////////////
    /*  CONSTRUCTORS  */
    ////////////////////

    public TKProgressBar(TKProgressBar TKProgressBar){
        this.bar = TKProgressBar.getBar();
    }

    public TKProgressBar(JProgressBar bar){
        this.bar = bar;
    }

    public TKProgressBar(){
        this.bar = new JProgressBar();
    }

    public TKProgressBar(int orient) {
        this.bar = new JProgressBar(orient);
    }

    public TKProgressBar(int min, int max) {
        this.bar = new JProgressBar(min, max);
    }

    public TKProgressBar(int orient, int min, int max) {
        this.bar = new JProgressBar(orient, min, max);
    }

    ///////////////
    /*  METHODS  */
    ///////////////

    public TKProgressBar addChangeListener(ChangeListener l){
        this.bar.addChangeListener(l);
        return this;
    }
    public TKProgressBar setBorderPainted(boolean b){
        this.bar.setBorderPainted(b);
        return this;
    }
    public TKProgressBar setIndeterminate(boolean newValue){
        this.bar.setIndeterminate(newValue);
        return this;
    }
    public TKProgressBar setMaximum(int n){
        this.bar.setMaximum(n);
        return this;
    }
    public TKProgressBar setOrientation(int newOrientation){
        this.bar.setOrientation(newOrientation);
        return this;
    }
    public TKProgressBar setString(String s){
        this.bar.setString(s);
        return this;
    }
    public TKProgressBar setStringPainted(boolean b){
        this.bar.setStringPainted(b);
        return this;
    }
    public TKProgressBar setUI(ProgressBarUI ui){
        this.bar.setUI(ui);
        return this;
    }
    public TKProgressBar setValue(int n){
        this.bar.setValue(n);
        return this;
    }
    public TKProgressBar setBounds(Rectangle bounds){
        this.bar.setBounds(bounds);
        return this;
    }
    public TKProgressBar setBackground(Color bgColor){
        this.bar.setBackground(bgColor);
        return this;
    }
    public TKProgressBar setForeground(Color fgColor){
        this.bar.setForeground(fgColor);
        return this;
    }
    public TKProgressBar setCursor(Cursor cursor){
        this.bar.setCursor(cursor);
        return this;
    }
    public TKProgressBar setEnabled(boolean isEnabled){
        this.bar.setEnabled(isEnabled);
        return this;
    }
    public TKProgressBar setFont(Font font){
        this.bar.setFont(font);
        return this;
    }
    public TKProgressBar setVisible(boolean isVisible){
        this.bar.setVisible(isVisible);
        return this;
    }
    public TKProgressBar addActionListener(ChangeListener changeListener){
        this.bar.addChangeListener(changeListener);
        return this;
    }
    public TKProgressBar setLayout(LayoutManager layout){
        this.bar.setLayout(layout);
        return this;
    }
    public TKProgressBar setBorder(Border border){
        this.bar.setBorder(border);
        return this;
    }
    public TKProgressBar setOpaque(boolean isOpaque){
        this.bar.setOpaque(isOpaque);
        return this;
    }
    public TKProgressBar setToolTipText(String toolTipText){
        this.bar.setToolTipText(toolTipText);
        return this;
    }
    public TKProgressBar setMinimum(int minimum){
        this.bar.setMinimum(minimum);
        return this;
    }
    public TKProgressBar addMouseListener(MouseListener mouseListener){
        this.bar.addMouseListener(mouseListener);
        return this;
    }
    public TKProgressBar addMouseMotionListener(MouseMotionListener mouseMotionListener){
        this.bar.addMouseMotionListener(mouseMotionListener);
        return this;
    }
    public TKProgressBar addMouseWheelListener(MouseWheelListener mouseWheelListener){
        this.bar.addMouseWheelListener(mouseWheelListener);
        return this;
    }



    ///////////////////////////
    /*  GETTERS AND SETTERS  */
    ///////////////////////////

    public JProgressBar getBar() {
        return bar;
    }
}
