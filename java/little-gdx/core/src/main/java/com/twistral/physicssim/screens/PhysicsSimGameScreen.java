package com.twistral.physicssim.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.twistral.physicssim.PhysicsSimMain;
import com.twistral.physicssim.particles.Acid;
import com.twistral.physicssim.particles.Dirt;
import com.twistral.physicssim.particles.MyWorld;
import com.twistral.physicssim.particles.Stone;
import com.twistral.physicssim.particles.Water;
import com.twistral.physicssim.ui.Button;
import com.twistral.physicssim.PhysicsSimMain;


public class PhysicsSimGameScreen implements Screen {

    public static final int CLEAR = 0;
    public static final int STONE = 1;
    public static final int DIRT = 2;
    public static final int WATER = 3;
    public static final int ACID = 4;

    public PhysicsSimMain game;
    public ShapeRenderer sr;
    public Viewport viewport;
    public MyWorld world;
    private float timer;
    private int curParticle;
    private Button[] buttons;

    public PhysicsSimGameScreen(PhysicsSimMain game){
        this.game = game;
    }

    @Override
    public void show() {
        viewport = new FitViewport(100,75);
        viewport.apply();

        viewport.getCamera().translate(50, 37.5f, 0);
        viewport.getCamera().update();

        sr = new ShapeRenderer();
        sr.setProjectionMatrix(viewport.getCamera().combined);

        world = new MyWorld(100,60);
        buttons = new Button[5];
        buttons[0] = new Button(5, 65, 5, 5, Color.WHITE);
        buttons[1] = new Button(25, 65, 5, 5, Color.DARK_GRAY);
        buttons[2] = new Button(45, 65, 5, 5, Color.BROWN);
        buttons[3] = new Button(65, 65, 5, 5, Color.CYAN);
        buttons[4] = new Button(85, 65, 5, 5, Color.GREEN);
    }

    private void update(float delta){

        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)){ curParticle = CLEAR; }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)){ curParticle = STONE; }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)){ curParticle = DIRT; }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)){ curParticle = WATER; }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_5)){ curParticle = ACID; }

        if(Gdx.input.isTouched(0)){
            Vector3 input = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            viewport.unproject(input);
            addParticles((int) input.x, (int) input.y, 4);
            for(Button b : buttons){ b.update(input.x, input.y); }
        }
        else{ for(Button b : buttons){ b.update(0,0); } }

        for(int i= 0; i<buttons.length; i++){
            if (buttons[i].down) {
                curParticle = i;
            }
        }

        timer += delta;
        if(timer>=0) {timer = 0; world.update();}


    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(Color.GRAY);
        sr.rect(0,0,100,75);
        world.render(sr);
        for(Button b : buttons){ b.render(sr); }
        sr.end();
        sr.begin(ShapeRenderer.ShapeType.Line);
        sr.setColor(Color.YELLOW);
        sr.line(0,60,100,60);
        sr.end();

    }

    private void addParticles(int x, int y, int r){
        for(int y2 = -r; y2 < r; y2++){
            for(int x2 = -r; x2 < r; x2++){
                if(x2*x2 + y2*y2 < r*r){
                    switch (curParticle){
                        case CLEAR: {
                            world.removeParticle(x+x2, y+y2);
                        }break;
                        case STONE: {
                            world.addParticle(new Stone(x+x2, y+y2, world));
                        }break;
                        case DIRT: {
                            world.addParticle(new Dirt(x+x2, y+y2, world));
                        }break;
                        case WATER: {
                            world.addParticle(new Water(x+x2, y+y2, world));
                        }break;
                        case ACID: {
                            world.addParticle(new Acid(x+x2, y+y2, world));
                        }break;
    } } } } }

    @Override
    public void resize(int width, int height) { viewport.update(width,height); }

    @Override
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void hide() { }

    @Override
    public void dispose() { }

}
