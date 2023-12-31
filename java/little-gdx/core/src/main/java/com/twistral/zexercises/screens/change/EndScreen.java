package com.twistral.zexercises.screens.change;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.twistral.tempest.utils.ScreenUtils;

public class EndScreen extends ScreenAdapter {

    HelloWorldGame game;

    public EndScreen(HelloWorldGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.ENTER)
                    game.setScreen(new TitleScreen(game));
                return true;
            }
        });
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.25f, 0f, 0f, 1f);

        game.batch.begin();
        game.font.draw(game.batch, "You win!", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .75f);
        game.font.draw(game.batch, "Press enter to restart.", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .25f);
        game.batch.end();

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }
}
