package com.twistral.components;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class TKRadioButton {


    private JRadioButton button;


    ////////////////////
    /*  CONSTRUCTORS  */
    ////////////////////

    public TKRadioButton(JRadioButton button){
        this.button = button;
    }

    public TKRadioButton(TKRadioButton TKRadioButton){
        this.button = TKRadioButton.getButton();
    }

    public TKRadioButton(){
        this.button = new JRadioButton();
    }

    public TKRadioButton(String text){
        this.button = new JRadioButton(text);
    }

    public TKRadioButton(Icon icon){
        this.button = new JRadioButton(icon);
    }

    public TKRadioButton(String text, Icon icon){
        this.button = new JRadioButton(text, icon);
    }


    ///////////////
    /*  METHODS  */
    ///////////////


    public TKRadioButton setBounds(Rectangle bounds){
        this.button.setBounds(bounds);
        return this;
    }

    public TKRadioButton setBackground(Color bgColor){
        this.button.setBackground(bgColor);
        return this;
    }

    public TKRadioButton setForeground(Color fgColor){
        this.button.setForeground(fgColor);
        return this;
    }

    public TKRadioButton setCursor(Cursor cursor){
        this.button.setCursor(cursor);
        return this;
    }

    public TKRadioButton setEnabled(boolean isEnabled){
        this.button.setEnabled(isEnabled);
        return this;
    }

    public TKRadioButton setFont(Font font){
        this.button.setFont(font);
        return this;
    }

    public TKRadioButton setVisible(boolean isVisible){
        this.button.setVisible(isVisible);
        return this;
    }

    public TKRadioButton setLayout(LayoutManager layout){
        this.button.setLayout(layout);
        return this;
    }

    public TKRadioButton setBorder(Border border){
        this.button.setBorder(border);
        return this;
    }

    public TKRadioButton setOpaque(boolean isOpaque){
        this.button.setOpaque(isOpaque);
        return this;
    }

    public TKRadioButton addMouseListener(MouseListener mouseListener){
        this.button.addMouseListener(mouseListener);
        return this;
    }
    public TKRadioButton addMouseMotionListener(MouseMotionListener mouseMotionListener){
        this.button.addMouseMotionListener(mouseMotionListener);
        return this;
    }
    public TKRadioButton addMouseWheelListener(MouseWheelListener mouseWheelListener){
        this.button.addMouseWheelListener(mouseWheelListener);
        return this;
    }
    public TKRadioButton addActionListener(ActionListener actionListener){
        this.button.addActionListener(actionListener);
        return this;
    }
    public TKRadioButton addChangeListener(ChangeListener changeListener){
        this.button.addChangeListener(changeListener);
        return this;
    }
    public TKRadioButton addItemListener(ItemListener itemListener){
        this.button.addItemListener(itemListener);
        return this;
    }

    public TKRadioButton setText(String text){
        this.button.setText(text);
        return this;
    }


    public TKRadioButton setToolTipText(String toolTipText){
        this.button.setToolTipText(toolTipText);
        return this;
    }

    public TKRadioButton setIcon(Icon icon){
        this.button.setIcon(icon);
        return this;
    }

    public TKRadioButton setIconTextGap(int iconTextGap){
        this.button.setIconTextGap(iconTextGap);
        return this;
    }

    public TKRadioButton setPressedIcon(Icon pressedIcon){
        this.button.setPressedIcon(pressedIcon);
        return this;
    }

    public TKRadioButton setSelectedIcon(Icon selectedIcon){
        this.button.setSelectedIcon(selectedIcon);
        return this;
    }

    public TKRadioButton setFocusable(boolean isFocusable){
        this.button.setFocusable(isFocusable);
        return this;
    }

    public TKRadioButton setContentAreaFilled(boolean isContentAreaFilled){
        this.button.setContentAreaFilled(isContentAreaFilled);
        return this;
    }

    public TKRadioButton setRolloverIcon(Icon rolloverIcon){
        this.button.setRolloverIcon(rolloverIcon);
        return this;
    }

    public TKRadioButton setRolloverEnabled(boolean isRolloverEnabled){
        this.button.setRolloverEnabled(isRolloverEnabled);
        return this;
    }

    public TKRadioButton setRolloverSelectedIcon(Icon rolloverSelectedIcon){
        this.button.setRolloverSelectedIcon(rolloverSelectedIcon);
        return this;
    }

    public TKRadioButton setDisabledSelectedIcon(Icon disabledSelectedIcon){
        this.button.setDisabledSelectedIcon(disabledSelectedIcon);
        return this;
    }

    public TKRadioButton setMargin(Insets margin){
        this.button.setMargin(margin);
        return this;
    }

    public TKRadioButton setMultiClickThreshhold(long multiClickThreshhold){
        this.button.setMultiClickThreshhold(multiClickThreshhold);
        return this;
    }

    public TKRadioButton setBorderPainted(boolean isBorderPainted){
        this.button.setBorderPainted(isBorderPainted);
        return this;
    }

    public TKRadioButton setHorizontalAlignment(int horizontalAlignment){
        this.button.setHorizontalAlignment(horizontalAlignment);
        return this;
    }

    public TKRadioButton setVerticalAlignment(int verticalAlignment){
        this.button.setVerticalAlignment(verticalAlignment);
        return this;
    }

    public TKRadioButton setHorizontalTextPosition(int horizontalTextPosition){
        this.button.setHorizontalTextPosition(horizontalTextPosition);
        return this;
    }

    public TKRadioButton setVerticalTextPosition(int verticalTextPosition){
        this.button.setVerticalTextPosition(verticalTextPosition);
        return this;
    }


    ///////////////////////////
    /*  GETTERS AND SETTERS  */
    ///////////////////////////


    public JRadioButton getButton() {
        return button;
    }

}
