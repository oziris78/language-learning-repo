package com.twistral.zexercises.particles.musical;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.twistral.tempest.utils.ScreenUtils;

class GameScreen implements Screen {

    private Stage stage;

    public GameScreen() {
        stage = new Stage(new ScreenViewport());

        Musician musician = new Musician();
        musician.setX(Gdx.graphics.getWidth() / 12);
        stage.addActor(musician);

        MusicalNote musicalNote = new MusicalNote();
        musicalNote.setPosition(Gdx.graphics.getWidth()*3/5,Gdx.graphics.getHeight()*1/5);
        musicalNote.addAction(
                repeat(-1,
                        sequence(moveTo(Gdx.graphics.getWidth()*3/5, Gdx.graphics.getHeight()*3/5,2, Interpolation.sine),
                        moveTo(Gdx.graphics.getWidth()*3/5,Gdx.graphics.getHeight()*1/5,2, Interpolation.sine)
                        )
                )
        );
        stage.addActor(musicalNote);
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear();
        stage.act();
        stage.draw();
    }




    @Override
    public void show() {}
    @Override
    public void resize(int width, int height) {}
    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void hide() {}
    @Override
    public void dispose() {
        stage.dispose();
    }


}
