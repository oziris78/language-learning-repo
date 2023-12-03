package com.twistral.utils;

import com.twistral.main.Application;
import com.twistral.utils.*;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.util.List;


public class TKUtils {

    public static SwingWorker<Void, String> animas_TK(String[] arr, JLabel lb, int waitTimeBetweenWordsMilisec, int waitTimeBeginningMilisec) {
        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() {
                sleepMilisecs(waitTimeBeginningMilisec);
                for(String s : arr) {
                    publish(s);
                    sleepMilisecs(waitTimeBetweenWordsMilisec);
                }
                return null;
            }
            @Override
            protected void process(List<String> dzl) {
                lb.setText(dzl.get(dzl.size()-1));
            }
        };
        return worker;
    }


    public static SwingWorker<Void, String> cutsceneTK(String[] wordHTML, ImageIcon icon, int waitTimeBetweenWordsMilisec, int waitTimeBeginningMilisec) {
        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() {
                Application.lbMiddle.setIcon(icon);
                sleepMilisecs(waitTimeBeginningMilisec);
                for(String s : wordHTML) {
                    publish(s);
                    sleepMilisecs(waitTimeBetweenWordsMilisec);
                }
                return null;
            }
            @Override
            protected void process(List<String> dzl) {
                if(!this.isCancelled()){
                    Application.lbDown.setText(dzl.get(dzl.size()-1));
                }
            }
        };
        return worker;
    }

    public static Rectangle screenWideRect(){
        return new Rectangle(0,0, Application.EN, Application.BOY);
    }


    public static int soundPlayingIndex = 0;
    public static void playClipMod(Clip... clips){
        ClipUtils.playClip(clips[soundPlayingIndex % clips.length]);
        soundPlayingIndex++;
    }

    public static void sleepSecs(int seconds){
        sleepMilisecs(seconds * 1000);
    }

    public static void sleepMilisecs(int miliseconds){
        try {
            Thread.sleep(miliseconds);
        }
        catch(Exception e) {
            e.getStackTrace();
        }
    }

    public static ImageIcon stretchedImage(ImageIcon icon, int width, int height) {
        return new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }


    public static void hideAll(Component... components) {
        for(Component c : components) c.setVisible(false);
    }

    public static void showAll(Component... components) {
        for(Component c : components) c.setVisible(true);
    }

    public static void disableAll(Component... components) {
        for(Component c : components) c.setEnabled(false);
    }

    public static void enableAll(Component... components) {
        for(Component c : components) c.setEnabled(true);
    }

    public static void addAllToPanel(JPanel pan, JComponent... components) {
        for(JComponent c : components) pan.add(c);
    }

    public static void addAllToGroup(ButtonGroup group, AbstractButton... buttons) {
        for(AbstractButton btn : buttons) group.add(btn);
    }

    public static void addAllToLayeredPane(JLayeredPane laypan, JPanel... panels){
        for(JPanel p : panels) laypan.add(p);
    }

}
