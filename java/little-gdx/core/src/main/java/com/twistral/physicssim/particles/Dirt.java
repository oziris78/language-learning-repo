package com.twistral.physicssim.particles;

import com.badlogic.gdx.graphics.Color;

public class Dirt extends MyParticle {

    public Dirt(int x, int y, MyWorld w) {
        super(x, y, Color.BROWN, w);
    }

    @Override
    public void update(){
        if(world.isEmpty(x,y-1)){
            world.moveParticle(x,y,x,y-1);
        }

    }



}
