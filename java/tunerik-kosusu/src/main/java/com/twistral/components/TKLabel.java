package com.twistral.components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class TKLabel {

    private JLabel label;

    ////////////////////
    /*  CONSTRUCTORS  */
    ////////////////////

    public TKLabel(JLabel label){
        this.label = label;
    }

    public TKLabel(TKLabel TKLabel){
        this.label = TKLabel.getLabel();
    }

    public TKLabel(String text, Icon icon, int horizontalAlignment) {
        this.label = new JLabel(text, icon, horizontalAlignment);
    }

    public TKLabel(String text, int horizontalAlignment) {
        this.label = new JLabel(text, horizontalAlignment);
    }

    public TKLabel(String text) {
        this.label = new JLabel(text);
    }

    public TKLabel(Icon image, int horizontalAlignment) {
        this.label = new JLabel(image, horizontalAlignment);
    }

    public TKLabel(Icon image) {
        this.label = new JLabel(image);
    }

    public TKLabel() {
        this.label = new JLabel();
    }

    ///////////////
    /*  METHODS  */
    ///////////////

    public TKLabel addMouseListener(MouseListener mouseListener){
        this.label.addMouseListener(mouseListener);
        return this;
    }
    public TKLabel addMouseMotionListener(MouseMotionListener mouseMotionListener){
        this.label.addMouseMotionListener(mouseMotionListener);
        return this;
    }
    public TKLabel addMouseWheelListener(MouseWheelListener mouseWheelListener){
        this.label.addMouseWheelListener(mouseWheelListener);
        return this;
    }
    public TKLabel setBounds(Rectangle bounds){
        this.label.setBounds(bounds);
        return this;
    }
    public TKLabel setBackground(Color bgColor){
        this.label.setBackground(bgColor);
        return this;
    }
    public TKLabel setForeground(Color fgColor){
        this.label.setForeground(fgColor);
        return this;
    }
    public TKLabel setCursor(Cursor cursor){
        this.label.setCursor(cursor);
        return this;
    }
    public TKLabel setEnabled(boolean isEnabled){
        this.label.setEnabled(isEnabled);
        return this;
    }
    public TKLabel setFont(Font font){
        this.label.setFont(font);
        return this;
    }
    public TKLabel setVisible(boolean isVisible){
        this.label.setVisible(isVisible);
        return this;
    }
    public TKLabel setLayout(LayoutManager layout){
        this.label.setLayout(layout);
        return this;
    }
    public TKLabel setBorder(Border border){
        this.label.setBorder(border);
        return this;
    }
    public TKLabel setOpaque(boolean isOpaque){
        this.label.setOpaque(isOpaque);
        return this;
    }
    public TKLabel setToolTipText(String toolTipText){
        this.label.setToolTipText(toolTipText);
        return this;
    }
    public TKLabel setText(String text){
        this.label.setText(text);
        return this;
    }
    public TKLabel setDisabledIcon(Icon disabledIcon){
        this.label.setDisabledIcon(disabledIcon);
        return this;
    }
    public TKLabel setIcon(Icon icon){
        this.label.setIcon(icon);
        return this;
    }
    public TKLabel setHorizontalAlignment(int horizontalAlignment){
        this.label.setHorizontalAlignment(horizontalAlignment);
        return this;
    }
    public TKLabel setVerticalAlignment(int verticalAlignment){
        this.label.setVerticalAlignment(verticalAlignment);
        return this;
    }
    public TKLabel setHorizontalTextPosition(int horizontalTextPosition){
        this.label.setHorizontalTextPosition(horizontalTextPosition);
        return this;
    }
    public TKLabel setVerticalTextPosition(int verticalTextPosition){
        this.label.setVerticalTextPosition(verticalTextPosition);
        return this;
    }
    public TKLabel setIconTextGap(int iconTextGap){
        this.label.setIconTextGap(iconTextGap);
        return this;
    }

    ///////////////////////////
    /*  GETTERS AND SETTERS  */
    ///////////////////////////

    public JLabel getLabel() {
        return label;
    }
}
