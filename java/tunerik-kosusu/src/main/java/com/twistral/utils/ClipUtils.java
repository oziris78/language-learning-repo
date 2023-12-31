package com.twistral.utils;


import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class ClipUtils {

    /* No Constructor */
    private ClipUtils(){}


    /* PLAYING CLIPS */

    public static void playClip(Clip clip) {
        clip.setMicrosecondPosition(0);
        clip.start();
    }

    public static void loopClipForever(Clip clip) {
        clip.setMicrosecondPosition(0);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();
    }

    public static void loopClip(Clip clip, int n) {
        clip.setMicrosecondPosition(0);
        clip.loop(n);
        clip.start();
    }



    /* STOPPING OR RESETING CLIPS */

    public static void resetClipPositionToZero(Clip clip) {clip.setMicrosecondPosition(0); }

    public static void stopClip(Clip clip) {clip.stop(); }



    /* SETTING VOLUME */

    public static void setVolumeToClip(Clip c, double d) {
        FloatControl volume = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
        float dB = (float) (Math.log(d) / Math.log(10.0) * 20.0);
        volume.setValue(dB);
    }

    public static void setVolumeToClips(Clip[] clips, double d){
        for(Clip clip : clips)
            setVolumeToClip(clip, d);
    }

}

