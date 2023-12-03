package com.twistral.snakegame;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Apple {

    public static final float PART_SIZE = GameScreen.GRID_SIZE;
    private Rectangle boundingBox;
    private TextureRegion skin;


    public Apple(float x, float y, TextureRegion texRegApple){
        this.skin = texRegApple;
        this.boundingBox = new Rectangle(x, y, PART_SIZE, PART_SIZE);
    }

    /* GETTER AND SETTERS */
    public Rectangle getBoundingBox() { return boundingBox; }
    public void setBoundingBox(Rectangle boundingBox) { this.boundingBox = boundingBox; }
    public TextureRegion getSkin() { return skin; }
    public void setSkin(TextureRegion skin) { this.skin = skin; }


    public static Apple generateApple(TextureRegion texRegApple) {
        float ran1 = GameScreen.GRID_SIZE * MathUtils.random(0, (int) ( (GameScreen.WORLD_WIDTH - GameScreen.GRID_SIZE) / GameScreen.GRID_SIZE ) );
        float ran2 = GameScreen.GRID_SIZE * MathUtils.random(0, (int) ( (GameScreen.WORLD_HEIGHT - GameScreen.GRID_SIZE) / GameScreen.GRID_SIZE ) );
        return new Apple(ran1, ran2, texRegApple);
    }
}




