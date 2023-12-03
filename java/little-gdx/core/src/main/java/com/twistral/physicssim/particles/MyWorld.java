package com.twistral.physicssim.particles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.Collections;

public class MyWorld {

    public int width, height;

    public MyParticle[] particles;

    public MyWorld(int width, int height){
        this.width = width;
        this.height = height;

        particles = new MyParticle[width*height];
    }

    public void update(){
        ArrayList<MyParticle> arr = new ArrayList<MyParticle>();
        for (MyParticle p : particles){
            if(p!=null) arr.add(p);
        }
        Collections.shuffle(arr);
        for( MyParticle p : arr){
            p.update();
        }
    }

    public void render(ShapeRenderer sr){
        for(MyParticle p : particles){
            if(p!=null) p.render(sr);
        }
    }

    public boolean isEmpty(int x, int y){
        if(x<0 || y<0 || x>= width || y>=height){ return true; }
        return particles[x+y*width] == null;
    }

    public void addParticle(MyParticle p){
        if(p.x<0 || p.y<0 || p.x>= width || p.y>=height || !isEmpty(p.x, p.y)){ return;}
        particles[p.x + p.y * width] = p;
    }

    public void removeParticle(int x, int y){
            if(x<0 || y<0 || x>= width || y>=height){ return; }
            particles[x+y*width] = null;
    }

    public void moveParticle(int x0, int y0, int x, int y){

        int i0 = x0+y0*width;
        int i = x+y*width;
        MyParticle p = particles[i0];
        if( p == null) return;
        particles[i0] = null;
        if( !((x<0 || y<0 || x>= width || y>=height)) ){
            particles[i] = p;
            p.x = x;
            p.y = y;
        }
    }

    public MyParticle getParticle(int x, int y){
        if(x<0 || y<0 || x>= width || y>=height){ return null; }
        return particles[x+y*width];
    }

    public void swapParticles(int x1, int y1, int x2, int y2){
        MyParticle p = getParticle(x1, y1);
        MyParticle p2 = getParticle(x2, y2);
        if(p == null) return;
        p = getParticle(x2, y2);
        if(p == null) return;
        p.x = x1;
        p.y = y1;
        p2 = p;

    }

}


