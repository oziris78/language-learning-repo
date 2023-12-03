package com.twistral.physicssim.particles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MyParticle {

    public int x,y;
    public Color color;
    public MyWorld world;

    public MyParticle(int x, int y, Color c, MyWorld w){
        this.x = x;
        this.y = y;
        this.color = c;
        this.world = w;
    }

    public void update(){

    }

    public void render(ShapeRenderer sr){
        sr.setColor(color);
        sr.rect(x,y,1,1);
    }

}
