package com.twistral.planegame;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class Kaya {

    Vector2 pozisyon = new Vector2();
    TextureRegion resim;
    boolean gecildi;
    Rectangle kayaCerceve = new Rectangle();
    boolean isDown;

    public Kaya(float x, float y, TextureRegion resim, boolean isDown) {

        this.pozisyon.x = x;
        this.pozisyon.y = y;
        this.resim = resim;
        this.isDown = isDown;

    }
}