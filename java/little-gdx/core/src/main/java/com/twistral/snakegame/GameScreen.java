package com.twistral.snakegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;


class GameScreen implements Screen {

    public static final float GRID_SIZE = 20f;

    // core game stuff (terrible idea to have these in a big game, memory leaks)
    SnakeGameMain game;

    // timing stuff
    float timePassedForMovement = 0;
    float timeIntervalForMovement = 0.450f;
    float timePassedForDirection = 0;
    float timeIntervalForDirection = 0.420f;
    float timePassedForApple = 0;
    float timeIntervalForApple = timeIntervalForMovement;
    private float speedIncrease = 0.010f;


    // screen stuff
    private Camera camera;
    private Viewport viewport;

    // world stuff
    public static final int WORLD_WIDTH = 400;
    public static final int WORLD_HEIGHT = 400;

    // graphics stuff
    SpriteBatch batch;
    TextureAtlas textureAtlas;
    TextureRegion texRegSnakeTail;
    TextureRegion texRegSnakeHead;
    TextureRegion texRegApple;
    BitmapFont font;

    // game objects
    private int appleCount;
    boolean isGameOver = false;
    Direction snakeDir;
    Snake snake;
    Apple apple;

    // HUD stuff



    public GameScreen(SnakeGameMain game){
        // core
        this.game = game;

        // screen
        camera = new OrthographicCamera();
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        // graphics
        batch = new SpriteBatch();
        textureAtlas = new TextureAtlas("snakeGame/images.atlas");
        texRegSnakeTail = textureAtlas.createSprite("tail");
        texRegSnakeHead = textureAtlas.createSprite("head");
        texRegApple = textureAtlas.createSprite("apple");

        font = new BitmapFont();
        font.setColor(1f,1f,1f,1f);
        font.getData().setScale(2f);

        // game objects
        snake = new Snake(40, 40, 60, 40, 80, 40, texRegSnakeHead, texRegSnakeTail);
        snake.addPartToTheEnd(20, 40, texRegSnakeTail);
        snakeDir = Direction.RIGHT;

        apple = Apple.generateApple(texRegApple);
    }


    @Override
    public void render(float deltaTime) {

        checkGameOver();

        if(!isGameOver){
            Gdx.gl20.glClearColor(0,0,0,1);
            Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

            handleInputs(deltaTime);
            moveTheSnake(snake, snakeDir, deltaTime);
            checkCollision(snake, apple, deltaTime);


            batch.begin();

            drawTheApple(batch, apple);

            drawTheSnake(batch, snake);

            batch.end();

            updateSpeed();
        }
        else{
            Gdx.gl20.glClearColor(0,0,0,1);
            Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

            batch.begin();
            font.draw(batch, "GAME OVER", (WORLD_WIDTH - 100)/2, WORLD_HEIGHT/2, 100, Align.center, true);
            batch.end();
        }

    }

    private void checkGameOver() {
        if(isGameOver){
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    game.setScreen(new MenuScreen(game));
                }
            }, 3);
        }
    }

    private void updateSpeed() {
        if(appleCount > 0){
            timeIntervalForDirection -= speedIncrease;
            timeIntervalForMovement  -= speedIncrease;
            timeIntervalForDirection = timeIntervalForMovement - 0.3f;
            timeIntervalForApple = timeIntervalForMovement;
            appleCount--;
        }
    }

    private void checkCollision(Snake snake, Apple apple, float deltaTime) {
        // the snake hits the borders and dies
        if(snake.getHead().getBoundingBox().x >= WORLD_WIDTH || snake.getHead().getBoundingBox().x < 0 ||
           snake.getHead().getBoundingBox().y >= WORLD_HEIGHT || snake.getHead().getBoundingBox().y < 0
        ) {isGameOver = true; return;}

        // snake hits itself and dies
        for(Snake.SnakePart part : snake.getArrTail()){
            if( part.getBoundingBox().x == snake.getHead().getBoundingBox().x &&
                part.getBoundingBox().y == snake.getHead().getBoundingBox().y
            ) {isGameOver = true; return;}
        }

        timePassedForApple += deltaTime;
        // snake eats an apple
        if( apple.getBoundingBox().x == snake.getHead().getBoundingBox().x && apple.getBoundingBox().y == snake.getHead().getBoundingBox().y){
            Snake.SnakePart enSon = snake.getArrTail().get(snake.getArrTail().size()-1);
            Snake.SnakePart birOnceki = snake.getArrTail().get(snake.getArrTail().size()-2);

            if(enSon.getBoundingBox().x + GRID_SIZE == birOnceki.getBoundingBox().x && enSon.getBoundingBox().y == birOnceki.getBoundingBox().y){
                // en sondaki saga dogru gidecek
                if(timePassedForApple >= timeIntervalForApple) {
                    snake.addPartToTheEnd(enSon.getBoundingBox().x - GRID_SIZE, enSon.getBoundingBox().y, texRegSnakeTail);
                    timePassedForApple = 0;
                }
            }
            else if(enSon.getBoundingBox().x - GRID_SIZE == birOnceki.getBoundingBox().x && enSon.getBoundingBox().y == birOnceki.getBoundingBox().y){
                // en sondaki sola dogru gidecek
                if(timePassedForApple >= timeIntervalForApple) {
                    snake.addPartToTheEnd(enSon.getBoundingBox().x + GRID_SIZE, enSon.getBoundingBox().y, texRegSnakeTail);
                    timePassedForApple = 0;
                }
            }
            else if(enSon.getBoundingBox().x == birOnceki.getBoundingBox().x && enSon.getBoundingBox().y + GRID_SIZE == birOnceki.getBoundingBox().y){
                // en sondaki yukari dogru gidecek
                if(timePassedForApple >= timeIntervalForApple) {
                    snake.addPartToTheEnd(enSon.getBoundingBox().x, enSon.getBoundingBox().y - GRID_SIZE, texRegSnakeTail);
                    timePassedForApple = 0;
                }
            }
            else if(enSon.getBoundingBox().x == birOnceki.getBoundingBox().x && enSon.getBoundingBox().y - GRID_SIZE == birOnceki.getBoundingBox().y){
                // en sondaki asagi dogru gidecek
                if(timePassedForApple >= timeIntervalForApple) {
                    snake.addPartToTheEnd(enSon.getBoundingBox().x, enSon.getBoundingBox().y + GRID_SIZE, texRegSnakeTail);
                    timePassedForApple = 0;
                }
            }
            this.apple = Apple.generateApple(texRegApple);
            appleCount++;
        }
    }

    private void handleInputs(float deltaTime) {
        timePassedForDirection += deltaTime;
            if(Gdx.input.isKeyJustPressed(Input.Keys.W) || Gdx.input.isKeyJustPressed(Input.Keys.UP)){
                if(timePassedForDirection >= timeIntervalForDirection){
                    if(snakeDir != Direction.DOWN){ snakeDir = Direction.UP; }
                    timePassedForDirection -= timeIntervalForDirection;
                }
            }
            else if(Gdx.input.isKeyJustPressed(Input.Keys.A) || Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
                if(timePassedForDirection >= timeIntervalForDirection){
                    if(snakeDir != Direction.RIGHT){ snakeDir = Direction.LEFT;}
                    timePassedForDirection -= timeIntervalForDirection;
                }
            }
            else if(Gdx.input.isKeyJustPressed(Input.Keys.D) || Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
                if(timePassedForDirection >= timeIntervalForDirection){
                    if(snakeDir != Direction.LEFT){snakeDir = Direction.RIGHT; }
                    timePassedForDirection -= timeIntervalForDirection;
                }
            }
            else if(Gdx.input.isKeyJustPressed(Input.Keys.S) || Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
                if(timePassedForDirection >= timeIntervalForDirection){
                    if(snakeDir != Direction.UP){snakeDir = Direction.DOWN; }
                    timePassedForDirection -= timeIntervalForDirection;
                }
            }
    }

    private void moveTheSnake(Snake snake, Direction dir, float deltaTime){
        timePassedForMovement += deltaTime;
        if(timePassedForMovement >= timeIntervalForMovement){
            // store head's position for moving the tails
            float xHead = snake.getHead().getBoundingBox().x;
            float yHead = snake.getHead().getBoundingBox().y;
            // head movement
            if(dir == Direction.DOWN){ snake.getHead().getBoundingBox().y -= GRID_SIZE; }
            else if(dir == Direction.UP){ snake.getHead().getBoundingBox().y += GRID_SIZE; }
            else if(dir == Direction.RIGHT){ snake.getHead().getBoundingBox().x += GRID_SIZE; }
            else if(dir == Direction.LEFT){ snake.getHead().getBoundingBox().x -= GRID_SIZE; }
            // tail movement
            float x1 = 0; float y1 = 0; float x2 = 0; float y2 = 0;
            ArrayList<Snake.SnakePart> tails = snake.getArrTail();
            for(int i = 0; i < tails.size(); i++){
                if(i == 0){
                    x1 = tails.get(0).getBoundingBox().x;
                    y1 = tails.get(0).getBoundingBox().y;
                    tails.get(0).getBoundingBox().setPosition(xHead, yHead);
                }
                else if (i%2 ==1){
                    x2 = tails.get(i).getBoundingBox().x;
                    y2 = tails.get(i).getBoundingBox().y;
                    tails.get(i).getBoundingBox().setPosition(x1, y1);
                }
                else{
                    x1 = tails.get(i).getBoundingBox().x;
                    y1 = tails.get(i).getBoundingBox().y;
                    tails.get(i).getBoundingBox().setPosition(x2,y2);
                }
            }
            // reset the timer
            timePassedForMovement -= timeIntervalForMovement;
        }
    }

    private void drawTheApple(SpriteBatch batch, Apple apple){
        batch.draw(apple.getSkin(), apple.getBoundingBox().x, apple.getBoundingBox().y, apple.getBoundingBox().width, apple.getBoundingBox().height);
    }

    private void drawTheSnake(SpriteBatch batch, Snake snake){
        // drawing the head
        drawPart(batch, snake.getHead());
        // drawing the tail
        for(int i = 0; i < snake.getArrTail().size(); i++)
            drawPart(batch, snake.getArrTail().get(i));
    }

    private void drawPart(SpriteBatch batch, Snake.SnakePart part){
        batch.draw(part.getSkin(),part.getBoundingBox().x,part.getBoundingBox().y,part.getBoundingBox().width,part.getBoundingBox().height);
    }

    @Override
    public void dispose() {
        batch.dispose();
        textureAtlas.dispose();
        font.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height, true);
        batch.setProjectionMatrix(camera.combined);
    }


    /* UNUSED METHODS */

    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void hide() {}
    @Override
    public void show() {}
}
