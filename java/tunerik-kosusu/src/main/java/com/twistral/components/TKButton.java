package com.twistral.components;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;


public class TKButton {

    private JButton button;

    ////////////////////
    /*  CONSTRUCTORS  */
    ////////////////////

    public TKButton(JButton button){
        this.button = button;
    }

    public TKButton(TKButton TKButton){
        this.button = TKButton.getButton();
    }

    public TKButton(){
        this.button = new JButton();
    }

    public TKButton(String text){
        this.button = new JButton(text);
    }

    public TKButton(Icon icon){
        this.button = new JButton(icon);
    }

    public TKButton(String text, Icon icon){
        this.button = new JButton(text, icon);
    }


    ///////////////
    /*  METHODS  */
    ///////////////


    public TKButton setBounds(Rectangle bounds){
        this.button.setBounds(bounds);
        return this;
    }

    public TKButton setBackground(Color bgColor){
        this.button.setBackground(bgColor);
        return this;
    }

    public TKButton setForeground(Color fgColor){
        this.button.setForeground(fgColor);
        return this;
    }

    public TKButton setCursor(Cursor cursor){
        this.button.setCursor(cursor);
        return this;
    }

    public TKButton setEnabled(boolean isEnabled){
        this.button.setEnabled(isEnabled);
        return this;
    }

    public TKButton setFont(Font font){
        this.button.setFont(font);
        return this;
    }

    public TKButton setVisible(boolean isVisible){
        this.button.setVisible(isVisible);
        return this;
    }

    public TKButton setLayout(LayoutManager layout){
        this.button.setLayout(layout);
        return this;
    }

    public TKButton setBorder(Border border){
        this.button.setBorder(border);
        return this;
    }

    public TKButton setOpaque(boolean isOpaque){
        this.button.setOpaque(isOpaque);
        return this;
    }

    public TKButton addMouseListener(MouseListener mouseListener){
        this.button.addMouseListener(mouseListener);
        return this;
    }
    public TKButton addMouseMotionListener(MouseMotionListener mouseMotionListener){
        this.button.addMouseMotionListener(mouseMotionListener);
        return this;
    }
    public TKButton addMouseWheelListener(MouseWheelListener mouseWheelListener){
        this.button.addMouseWheelListener(mouseWheelListener);
        return this;
    }
    public TKButton addActionListener(ActionListener actionListener){
        this.button.addActionListener(actionListener);
        return this;
    }
    public TKButton addChangeListener(ChangeListener changeListener){
        this.button.addChangeListener(changeListener);
        return this;
    }
    public TKButton addItemListener(ItemListener itemListener){
        this.button.addItemListener(itemListener);
        return this;
    }

    public TKButton setText(String text){
        this.button.setText(text);
        return this;
    }


    public TKButton setToolTipText(String toolTipText){
        this.button.setToolTipText(toolTipText);
        return this;
    }

    public TKButton setIcon(Icon icon){
        this.button.setIcon(icon);
        return this;
    }

    public TKButton setIconTextGap(int iconTextGap){
        this.button.setIconTextGap(iconTextGap);
        return this;
    }

    public TKButton setPressedIcon(Icon pressedIcon){
        this.button.setPressedIcon(pressedIcon);
        return this;
    }

    public TKButton setSelectedIcon(Icon selectedIcon){
        this.button.setSelectedIcon(selectedIcon);
        return this;
    }

    public TKButton setFocusable(boolean isFocusable){
        this.button.setFocusable(isFocusable);
        return this;
    }

    public TKButton setContentAreaFilled(boolean isContentAreaFilled){
        this.button.setContentAreaFilled(isContentAreaFilled);
        return this;
    }

    public TKButton setRolloverIcon(Icon rolloverIcon){
        this.button.setRolloverIcon(rolloverIcon);
        return this;
    }

    public TKButton setRolloverEnabled(boolean isRolloverEnabled){
        this.button.setRolloverEnabled(isRolloverEnabled);
        return this;
    }

    public TKButton setRolloverSelectedIcon(Icon rolloverSelectedIcon){
        this.button.setRolloverSelectedIcon(rolloverSelectedIcon);
        return this;
    }

    public TKButton setDisabledSelectedIcon(Icon disabledSelectedIcon){
        this.button.setDisabledSelectedIcon(disabledSelectedIcon);
        return this;
    }

    public TKButton setMargin(Insets margin){
        this.button.setMargin(margin);
        return this;
    }

    public TKButton setMultiClickThreshhold(long multiClickThreshhold){
        this.button.setMultiClickThreshhold(multiClickThreshhold);
        return this;
    }

    public TKButton setBorderPainted(boolean isBorderPainted){
        this.button.setBorderPainted(isBorderPainted);
        return this;
    }

    public TKButton setHorizontalAlignment(int horizontalAlignment){
        this.button.setHorizontalAlignment(horizontalAlignment);
        return this;
    }

    public TKButton setVerticalAlignment(int verticalAlignment){
        this.button.setVerticalAlignment(verticalAlignment);
        return this;
    }

    public TKButton setHorizontalTextPosition(int horizontalTextPosition){
        this.button.setHorizontalTextPosition(horizontalTextPosition);
        return this;
    }

    public TKButton setVerticalTextPosition(int verticalTextPosition){
        this.button.setVerticalTextPosition(verticalTextPosition);
        return this;
    }


    ///////////////////////////
    /*  GETTERS AND SETTERS  */
    ///////////////////////////


    public JButton getButton() {
        return button;
    }

}
