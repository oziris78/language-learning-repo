package com.twistral.physicssim.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Button extends Rectangle {
    public Color c;
    public boolean down;



    public Button(float x, float y, float width, float height, Color c){
        super(x,y,width,height);
        this.c = c;
    }

    public void update(float x, float y){
        down = Gdx.input.isTouched(0) ? contains(x,y) : false;
    }

    public void render(ShapeRenderer sr){
        if(down){
            sr.setColor(Color.YELLOW);
            sr.rect(x-1, y-1, width+2, height+2);
        }
        sr.setColor(c);
        sr.rect(x,y,width,height);
    }

}
