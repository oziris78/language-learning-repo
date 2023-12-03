package com.twistral.physicssim.particles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

public class Gas extends MyParticle{

    public Gas(int x, int y, Color c, MyWorld w){
        super(x,y,c,w);
    }

    @Override
    public void update(){

        if(world.isEmpty(x, y+1)){
            world.moveParticle(x,y,x,y+1);
            return;
        }
        else if(world.getParticle(x,y+1).getClass().isAssignableFrom(Liquid.class)){
            world.swapParticles(x, y, x, y+1);
        }

        boolean right = world.isEmpty(x+1, y);
        boolean left = world.isEmpty(x-1, y);
        if(right && left){
            world.moveParticle(x,y, x+ (MathUtils.randomBoolean() ? -1 : +1) , y );
        }
        else if (left){
            world.moveParticle(x,y, x-1 , y );
        }
        else if(right){
            world.moveParticle(x,y, x+1 , y );
        }
    }
}
