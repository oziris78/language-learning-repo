package com.twistral.physicssim.particles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

public class Acid extends Liquid {

    public Acid(int x, int y, MyWorld w) {
        super(x, y, Color.GREEN, w);
    }

    @Override
    public void update(){
        boolean down = !world.isEmpty(x, y-1) &&  (world.getParticle(x,y-1).getClass() == Water.class || world.getParticle(x,y-1).getClass() == Dirt.class) ;
        boolean right = !world.isEmpty(x+1, y) && (world.getParticle(x+1,y).getClass() == Water.class || world.getParticle(x+1,y).getClass() == Dirt.class) ;
        boolean left = !world.isEmpty(x-1, y) &&  (world.getParticle(x-1,y).getClass() == Water.class || world.getParticle(x-1,y).getClass() == Dirt.class) ;
        boolean up = !world.isEmpty(x, y+1) &&  (world.getParticle(x,y+1).getClass() == Water.class || world.getParticle(x,y+1).getClass() == Dirt.class) ;

        if(down) {
            world.removeParticle(x, y);
            world.removeParticle(x, y-1);
            world.addParticle(new Gas(x, y-1, Color.LIGHT_GRAY, world));
        }
        else if(right && left){
            int i = MathUtils.randomBoolean() ? -1 : +1;
            world.removeParticle(x, y);
            world.removeParticle(x+i, y);
            world.addParticle(new Gas(x+i, y, Color.LIGHT_GRAY, world));
        }
        else if(right){
            world.removeParticle(x, y);
            world.removeParticle(x+1, y);
            world.addParticle(new Gas(x+1, y, Color.LIGHT_GRAY, world));
        }
        else if(left){
            world.removeParticle(x, y);
            world.removeParticle(x-1, y);
            world.addParticle(new Gas(x-1, y, Color.LIGHT_GRAY, world));
        }
        else if(up){
            world.removeParticle(x, y);
            world.removeParticle(x, y+1);
            world.addParticle(new Gas(x, y+1, Color.LIGHT_GRAY, world));
        }
        else{
            super.update();
        }

    }



}
