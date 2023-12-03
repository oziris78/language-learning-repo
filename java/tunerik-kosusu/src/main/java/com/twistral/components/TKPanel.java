package com.twistral.components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class TKPanel {

    private JPanel panel;

    ////////////////////
    /*  CONSTRUCTORS  */
    ////////////////////

    public TKPanel(JPanel panel){
        this.panel = panel;
    }

    public TKPanel(TKPanel TKPanel){
        this.panel = TKPanel.getPanel();
    }

    public TKPanel(){
        this.panel = new JPanel();
    }

    public TKPanel(LayoutManager layoutManager){
        this.panel = new JPanel(layoutManager);
    }

    ///////////////
    /*  METHODS  */
    ///////////////

    public TKPanel setBounds(Rectangle bounds){
        this.panel.setBounds(bounds);
        return this;
    }
    public TKPanel setBackground(Color bgColor){
        this.panel.setBackground(bgColor);
        return this;
    }
    public TKPanel setForeground(Color fgColor){
        this.panel.setForeground(fgColor);
        return this;
    }
    public TKPanel setCursor(Cursor cursor){
        this.panel.setCursor(cursor);
        return this;
    }
    public TKPanel setEnabled(boolean isEnabled){
        this.panel.setEnabled(isEnabled);
        return this;
    }
    public TKPanel setFont(Font font){
        this.panel.setFont(font);
        return this;
    }
    public TKPanel setVisible(boolean isVisible){
        this.panel.setVisible(isVisible);
        return this;
    }
    public TKPanel setLayout(LayoutManager layout){
        this.panel.setLayout(layout);
        return this;
    }
    public TKPanel setBorder(Border border){
        this.panel.setBorder(border);
        return this;
    }
    public TKPanel setOpaque(boolean isOpaque){
        this.panel.setOpaque(isOpaque);
        return this;
    }
    public TKPanel setToolTipText(String toolTipText){
        this.panel.setToolTipText(toolTipText);
        return this;
    }
    public TKPanel addMouseListener(MouseListener mouseListener){
        this.panel.addMouseListener(mouseListener);
        return this;
    }
    public TKPanel addMouseMotionListener(MouseMotionListener mouseMotionListener){
        this.panel.addMouseMotionListener(mouseMotionListener);
        return this;
    }
    public TKPanel addMouseWheelListener(MouseWheelListener mouseWheelListener){
        this.panel.addMouseWheelListener(mouseWheelListener);
        return this;
    }


    ///////////////////////////
    /*  GETTERS AND SETTERS  */
    ///////////////////////////


    public JPanel getPanel() {
        return panel;
    }

}

