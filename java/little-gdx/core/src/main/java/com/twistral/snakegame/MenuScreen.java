package com.twistral.snakegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;


public class MenuScreen implements Screen {

    // core game stuff
    SnakeGameMain game;

    // graphics stuff
    SpriteBatch batch;
    BitmapFont font;


    public MenuScreen(SnakeGameMain game){
        this.game = game;

        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(1f,1f,1f,1f);
        font.getData().setScale(2f);
    }


    @Override
    public void render(float deltaTime) {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        handleInput();

        // Drawing graphics
        batch.begin();

        fontDrawings(batch);

        batch.end();
    }


    private void fontDrawings(SpriteBatch batch) {
        font.draw(batch, "PRESS R TO START THE GAME", 100, 300, 400, Align.center, false);
    }

    private void handleInput() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.R)){
            game.setScreen(new GameScreen(game));
        }
    }


    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }


    /* NOT USED METHODS OF THE SCREEN INTERFACE */

    @Override
    public void resize(int width, int height) { }
    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void hide() {}
    @Override
    public void show() {}

}
