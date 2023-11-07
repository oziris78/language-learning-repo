package com.twistral.utils.resources;


import com.twistral.Main;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.HashMap;


public class Resources {

    private final ResLoader resLoader;

    private final HashMap<String, ImageResource> images;
    private final HashMap<String, MediaResource> medias;


    public Resources(){
        resLoader = new ResLoader();
        images = new HashMap<>();
        medias = new HashMap<>();

        // images
        images.put("cookieClickerCookie", new ImageResource(resLoader, "images/cookieClickerCookie.png"));
        images.put("cookieClickerBackground", new ImageResource(resLoader, "images/cookieClickerBackground.png"));
        images.put("mineSweeperOkFace", new ImageResource(resLoader, "images/mineSweeperOkFace.png"));
        images.put("mineSweeperSadFace", new ImageResource(resLoader, "images/mineSweeperSadFace.png"));
        images.put("mineSweeperCoolFace", new ImageResource(resLoader, "images/mineSweeperCoolFace.png"));

        // medias
        medias.put("button", new MediaResource(resLoader, "media/button.wav"));
        medias.put("vid", new MediaResource(resLoader, "media/vid.mp4"));

    }

    public Image getImage(String ID){
        if(!this.images.containsKey(ID))
            System.out.println("This image for this ID doesn't exist: " + ID);
        return this.images.get(ID).get();
    }

    public Media getMedia(String ID){
        if(!this.medias.containsKey(ID))
            System.out.println("This media for this ID doesn't exist: " + ID);
        return this.medias.get(ID).get();
    }








}
