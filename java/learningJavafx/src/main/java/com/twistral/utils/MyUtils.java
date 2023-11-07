package com.twistral.utils;


import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;

public final class MyUtils {

    public static void setResizableBackgroundImage(Region region, Image image){
        region.setBackground(new Background(new BackgroundFill(new ImagePattern(image), CornerRadii.EMPTY, Insets.EMPTY)));
    }

}
