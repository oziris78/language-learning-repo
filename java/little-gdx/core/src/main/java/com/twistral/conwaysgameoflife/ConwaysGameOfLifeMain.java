package com.twistral.conwaysgameoflife;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.*;
import com.twistral.tempest.utils.ScreenUtils;

import java.util.Random;

import space.earlygrey.shapedrawer.*;



public class ConwaysGameOfLifeMain extends ApplicationAdapter implements InputProcessor {

    final int GRID_COUNT = 100;
    final float GRID_SIZE = 600 / GRID_COUNT; // 600: window size
    final Color ALIVE_COLOR = Color.WHITE;
    final Color DEAD_COLOR = Color.BLACK;
    int[][] grid;

    SpriteBatch batch;
    ShapeDrawer shapeDrawer;
    OrthographicCamera camera;
    Viewport viewport;

    @Override
    public void create() {
        // input
        Gdx.input.setInputProcessor(this);

        // create rendering objects
        batch = new SpriteBatch();
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.drawPixel(0, 0);
        Texture texture = new Texture(pixmap); //remember to dispose of later
        pixmap.dispose();
        TextureRegion region = new TextureRegion(texture, 0, 0, 1, 1);
        shapeDrawer = new ShapeDrawer(batch, region);

        // camera stuff
        camera = new OrthographicCamera();
        viewport = new StretchViewport(600, 600, this.camera);
        viewport.apply();
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();

        // grid
        grid = new int[GRID_COUNT][GRID_COUNT];
        for (int i = 0; i < GRID_COUNT; i++) {
            for (int j = 0; j < GRID_COUNT; j++) {
                grid[i][j] = 0;
            }
        }
    }


    private void nextGeneration() {
        int[][] nextGrid = new int[GRID_COUNT][GRID_COUNT];

        // Loop through every cell
        for (int l = 0; l < GRID_COUNT; l++) {
            for (int m = 0; m < GRID_COUNT; m++) {
                // finding no Of Neighbours that are alive
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++){
                    for (int j = -1; j <= 1; j++){
                        if ((l + i >= 0 && l + i < GRID_COUNT) && (m + j >= 0 && m + j < GRID_COUNT))
                            aliveNeighbours += grid[l + i][m + j];
                    }
                }

                aliveNeighbours -= grid[l][m];

                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                    nextGrid[l][m] = 0;
                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                    nextGrid[l][m] = 0;
                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                    nextGrid[l][m] = 1;
                else
                    nextGrid[l][m] = grid[l][m];
            }
        }

        grid = nextGrid;
    }




    @Override
    public void render() {
        ScreenUtils.clear();
        batch.begin();
        drawCurrentGeneration();
        batch.end();
    }



    private void drawCurrentGeneration() {
        for (int i = 0; i < GRID_COUNT; i++) {
            for (int j = 0; j < GRID_COUNT; j++) {
                float x = j * GRID_SIZE, y = i * GRID_SIZE;
                Color color = grid[i][j] == 1 ? ALIVE_COLOR : DEAD_COLOR;
                shapeDrawer.filledRectangle(x, y, GRID_SIZE, GRID_SIZE, color);
            }
        }
    }

    private void randomizeGrid(){
        Random random = new Random();
        for (int i = 0; i < GRID_COUNT; i++) {
            for (int j = 0; j < GRID_COUNT; j++) {
                grid[i][j] = random.nextInt(10) >= 7 ? 1 : 0;
            }
        }
    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        viewport.apply();
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.R)
            randomizeGrid();
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        if(character == 'n' || character == 'N')
            nextGeneration();
        return true;
    }



    boolean switchGridCell(int screenX, int screenY){
        Vector3 v = camera.unproject(new Vector3(screenX, screenY, 0));
        int col = (int) ((v.x - (v.x % GRID_SIZE)) / GRID_SIZE);
        int row = (int) ((v.y - (v.y % GRID_SIZE)) / GRID_SIZE);
        if(row >= GRID_COUNT)
            row = GRID_COUNT - 1;
        if(col >= GRID_COUNT)
            col = GRID_COUNT - 1;
        if(row < 0)
            row = 0;
        if(col < 0)
            col = 0;
        grid[row][col] = grid[row][col] == 1 ? 0 : 1;
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return switchGridCell(screenX, screenY);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return switchGridCell(screenX, screenY);
    }

    // UNUSED METHODS
    @Override public boolean keyUp(int keycode) { return false; }
    @Override public boolean touchUp(int screenX, int screenY, int pointer, int button) { return false; }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override public boolean mouseMoved(int screenX, int screenY) { return false; }
    @Override public boolean scrolled(float amountX, float amountY) { return false; }
}
