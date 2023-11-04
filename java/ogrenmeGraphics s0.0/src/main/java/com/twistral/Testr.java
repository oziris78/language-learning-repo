package com.twistral;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Testr {

    public static void main(String[] args) {

        BufferedImage img = fimg.getExistingImage("C:\\Users\\oguzh\\Desktop\\test\\dababy.jpg");

        long startTime = System.nanoTime();

        ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
        images.add(fimg.getBluefulImage(img));
        images.add(fimg.getBluelessImage(img));
        images.add(fimg.getRedfulImage(img));
        images.add(fimg.getRedlessImage(img));
        images.add(fimg.getGreenfulImage(img));
        images.add(fimg.getGreenlessImage(img));
        images.add(fimg.getGrayscaledImage(img));
        images.add(fimg.getGrayscaledImage(img, 50, true, Color.BLACK));
        images.add(fimg.getGrayscaledImage(img, 100, true, Color.BLACK));
        images.add(fimg.getGrayscaledImage(img, 150, true, Color.BLACK));
        images.add(fimg.getGrayscaledImage(img, 200, true, Color.BLACK));
        images.add(fimg.getGrayscaledImage(img, 250, true, Color.BLACK));
        images.add(fimg.getGrayscaledImage(img,  50, false, Color.WHITE));
        images.add(fimg.getGrayscaledImage(img, 100, false, Color.WHITE));
        images.add(fimg.getGrayscaledImage(img, 150, false, Color.WHITE));
        images.add(fimg.getGrayscaledImage(img, 200, false, Color.WHITE));
        images.add(fimg.getGrayscaledImage(img, 250, false, Color.WHITE));
        images.add(fimg.getBlurredImage(img, 2, 0.2 ));
        images.add(fimg.getBlurredImage(img, 2, 0.4 ));
        images.add(fimg.getBlurredImage(img, 2, 0.75));
        images.add(fimg.getBlurredImage(img, 2, 1   ));
        images.add(fimg.getBlurredImage(img, 4, 0.2 ));
        images.add(fimg.getBlurredImage(img, 4, 0.4 ));
        images.add(fimg.getBlurredImage(img, 4, 0.75));
        images.add(fimg.getBlurredImage(img, 4, 1   ));
        images.add(fimg.getBlurredImage(img, 8, 0.2 ));
        images.add(fimg.getBlurredImage(img, 8, 0.4 ));
        images.add(fimg.getBlurredImage(img, 8, 0.75));
        images.add(fimg.getBlurredImage(img, 8, 1   ));


        int id = 0;
        for(BufferedImage myImg : images) {
            fimg.exportImage(myImg, "C:\\Users\\oguzh\\Desktop\\test\\dababy" + (++id) + ".jpg", "JPG");
        }

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Program ended in  " + elapsedTime/1000000 + "  ms.");
    }


}
