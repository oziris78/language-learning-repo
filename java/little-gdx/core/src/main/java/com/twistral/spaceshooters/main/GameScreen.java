package com.twistral.spaceshooters.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.twistral.spaceshooters.entities.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Random;



    public class GameScreen implements Screen {

    public static Random ran = new Random();

    // screen stuff
    private Camera camera;
    private Viewport viewport;

    // graphics stuff
    private SpriteBatch batch;
    private TextureAtlas textureAtlas;
    private TextureRegion[] backgrounds;
    private TextureRegion playerShipTextReg, enemyShipTextReg, playerShieldTextReg,
            enemyShieldTextReg, enemyLaserTextReg, playerLaserTextReg;
    private Texture explosionTexture;

    // timing stuff
    private float[] backgroundOffsets = {0,0,0,0};
    private float backgroundMaxScrollingSpeed;
    private float timeBetweenEnemyShipSpawns = 2f;
    private float enemySpawnTimer = 0;

    // world stuff
    private final int WORLD_WIDTH = 72;
    private final int WORLD_HEIGHT = 128;
    private final float TOUCH_MOVEMENT_THRESHHOLD = 0.5f;

    // game objects
    private PlayerShip playerShip;
    private LinkedList<EnemyShip> enemyShipList;
    private LinkedList<Laser> playerLaserList;
    private LinkedList<Laser> enemyLaserList;
    private LinkedList<Explosion> explosionList;
    private int score = 0;

    // HUD stuff
    BitmapFont font;
    float hudVerticalMargin, hufLeftX, hudRightX, hudCentreX, hudRow1Y, hudRow2Y, hudSectionWidth;


    public GameScreen(){
        camera = new OrthographicCamera();
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        textureAtlas = new TextureAtlas("spaceShootersGame/images.atlas");

        backgrounds = new TextureRegion[4];
        backgrounds[0] = textureAtlas.findRegion("Starscape00");
        backgrounds[1] = textureAtlas.findRegion("Starscape01");
        backgrounds[2] = textureAtlas.findRegion("Starscape02");
        backgrounds[3] = textureAtlas.findRegion("Starscape03");
        backgroundMaxScrollingSpeed = (float) (WORLD_HEIGHT / 4);

        playerShipTextReg = textureAtlas.findRegion("playerShip2_blue");
        playerShieldTextReg = textureAtlas.findRegion("shield2");
        playerLaserTextReg = textureAtlas.findRegion("laserBlue03");

        enemyShipTextReg = textureAtlas.findRegion("enemyRed3");
        enemyShieldTextReg = textureAtlas.findRegion("shield1");
        enemyLaserTextReg  = textureAtlas.findRegion("laserRed03");

        enemyShieldTextReg.flip(false, true); // it should be flipped vertically

        playerShip = new PlayerShip(WORLD_WIDTH/2, WORLD_HEIGHT/4,
                10, 10, 48, 3, 0.4f, 4, 45, 0.5f,
                playerShipTextReg, playerShieldTextReg, playerLaserTextReg);

        enemyShipList = new LinkedList<EnemyShip>();


        playerLaserList = new LinkedList<>();
        enemyLaserList = new LinkedList<>();
        explosionList = new LinkedList<>();

        explosionTexture = new Texture("spaceShootersGame/explosion.png");


        batch = new SpriteBatch();

        prepareHUD();
    }

    private void prepareHUD() {
        FreeTypeFontGenerator freeTypeFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("spaceShootersGame/edgeOfTheGalaxy.otf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameters.size = 72;
        parameters.kerning = true;
        parameters.borderWidth = 3.6f;
        parameters.color = new Color(1,1,1,0.3f);
        parameters.borderColor = new Color(0,0,0,0.3f);

        font = freeTypeFontGenerator.generateFont(parameters);
        font.getData().setScale(0.071f);
        hudVerticalMargin = font.getCapHeight() / 2;
        hufLeftX = hudVerticalMargin;
        hudRightX = WORLD_WIDTH * 2 / 3 - hufLeftX;
        hudCentreX = WORLD_WIDTH / 3;
        hudRow1Y = WORLD_HEIGHT - hudVerticalMargin;
        hudRow2Y = hudRow1Y - hudVerticalMargin - font.getCapHeight();
        hudSectionWidth = WORLD_WIDTH / 3;

        freeTypeFontGenerator.dispose();
    }

    @Override
    public void render(float deltaTime) {
        batch.begin();

        detectInput(deltaTime);

        for(EnemyShip enemyShip : enemyShipList) moveEnemies(enemyShip, deltaTime);

        playerShip.update(deltaTime);

        spawnEnemyShip(deltaTime);

        for(EnemyShip enemyShip : enemyShipList) enemyShip.update(deltaTime);

        renderBackground(deltaTime);

        // enemy ship
        for(EnemyShip enemyShip : enemyShipList) enemyShip.draw(batch);

        // player ship
        playerShip.draw(batch);

        // lasers
        renderLasers(deltaTime);

        // collision detection
        detectCollisions();

        // explosions
        updateAndRenderExplosions(deltaTime);

        // HUD rendering
        updateAndRenderHUD();

        batch.end();
    }

    private void updateAndRenderHUD() {
        // top row
        font.draw(batch, "Score", hufLeftX, hudRow1Y, hudSectionWidth, Align.left, false);
        font.draw(batch, "Shield", hudCentreX, hudRow1Y, hudSectionWidth, Align.center, false);
        font.draw(batch, "Lives", hudRightX, hudRow1Y, hudSectionWidth, Align.right, false);
        // second row
        font.draw(batch, String.format(Locale.getDefault(), "%06d", score), hufLeftX, hudRow2Y, hudSectionWidth, Align.left, false);
        font.draw(batch, String.format(Locale.getDefault(), "%02d", playerShip.shield), hudCentreX, hudRow2Y, hudSectionWidth, Align.center, false);
        font.draw(batch, String.format(Locale.getDefault(), "%02d", playerShip.lives), hudRightX, hudRow2Y, hudSectionWidth, Align.right, false);


    }

    private void moveEnemies(EnemyShip enemyShip, float deltaTime) {

        float leftLimit, rightLimit, upLimit, downLimit;
        leftLimit = -enemyShip.boundingBox.x;
        downLimit = WORLD_HEIGHT/2 - enemyShip.boundingBox.y;
        rightLimit = WORLD_WIDTH - enemyShip.boundingBox.x - enemyShip.boundingBox.width;
        upLimit = (float) WORLD_HEIGHT - enemyShip.boundingBox.y - enemyShip.boundingBox.height;



        float xMove = enemyShip.getDirectionVector().x *  enemyShip.movementSpeed * deltaTime;
        float yMove = enemyShip.getDirectionVector().y *  enemyShip.movementSpeed * deltaTime;

        xMove = (xMove > 0) ? Math.min(xMove, rightLimit) : Math.max(xMove, leftLimit);
        yMove = (yMove > 0) ? Math.min(yMove, upLimit) : Math.max(yMove, downLimit);

        enemyShip.translate(xMove, yMove);

    }

    private void spawnEnemyShip(float deltaTime){
        enemySpawnTimer += deltaTime;
        if(enemySpawnTimer > timeBetweenEnemyShipSpawns){
            enemyShipList.add(new EnemyShip(ran.nextFloat() * (WORLD_WIDTH-10) + 5, WORLD_HEIGHT - 5,
                    10, 10, 48, 1, 0.3f, 5, 50, 0.8f,
                    enemyShipTextReg, enemyShieldTextReg, enemyLaserTextReg));
            enemySpawnTimer -= timeBetweenEnemyShipSpawns;
        }

    }

    private void detectInput(float deltaTime) {

        float leftLimit, rightLimit, upLimit, downLimit;
        leftLimit = -playerShip.boundingBox.x;
        downLimit = -playerShip.boundingBox.y;
        rightLimit = WORLD_WIDTH - playerShip.boundingBox.x - playerShip.boundingBox.width;
        upLimit = WORLD_HEIGHT / 2 - playerShip.boundingBox.y - playerShip.boundingBox.height;

        if( (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) && rightLimit > 0){
            playerShip.translate( Math.min( playerShip.movementSpeed * deltaTime, rightLimit) , 0f);
        }
        if( (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP))  && upLimit > 0){
            playerShip.translate( 0f, Math.min( playerShip.movementSpeed * deltaTime, upLimit) );
        }

        if( (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) && leftLimit < 0){
            playerShip.translate(  Math.max( -playerShip.movementSpeed * deltaTime, leftLimit), 0f );
        }

        if( (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) && downLimit < 0){
            playerShip.translate(  0f, Math.max( -playerShip.movementSpeed * deltaTime, downLimit) );
        }

        if(Gdx.input.isTouched()){
            // get the position of the mouse
            float xTouchPixels = Gdx.input.getX();
            float yTouchPixels = Gdx.input.getY();

            //convert to world units
            Vector2 touchPoint = new Vector2(xTouchPixels, yTouchPixels);
            touchPoint = viewport.unproject(touchPoint);

            // calculate the x and y dif
            Vector2 playerShipCentre = new Vector2( playerShip.boundingBox.x + playerShip.boundingBox.width/2,
                                                    playerShip.boundingBox.y + playerShip.boundingBox.height/2);
            float touchDistance = touchPoint.dst(playerShipCentre);
            if(touchDistance > TOUCH_MOVEMENT_THRESHHOLD){
                float xTouchDif = touchPoint.x - playerShipCentre.x;
                float yTouchDif = touchPoint.y - playerShipCentre.y;
                // scale to the max speed of the ship
                float xMove = (xTouchDif / touchDistance) *  playerShip.movementSpeed * deltaTime;
                float yMove = (yTouchDif / touchDistance) *  playerShip.movementSpeed * deltaTime;

                xMove = (xMove > 0) ? Math.min(xMove, rightLimit) : Math.max(xMove, leftLimit);
                yMove = (yMove > 0) ? Math.min(yMove, upLimit) : Math.max(yMove, downLimit);

                playerShip.translate(xMove, yMove);
            }

        }



    }


    private void detectCollisions() {
        // for each player laser check if it intersects an enemy ship
        ListIterator<Laser> laserListIterator = playerLaserList.listIterator();
        while (laserListIterator.hasNext()){
            Laser laser = laserListIterator.next();
            ListIterator<EnemyShip> enemyShipListIterator = enemyShipList.listIterator();
            while (enemyShipListIterator.hasNext()){
                EnemyShip enemyShip = enemyShipListIterator.next();
                if(enemyShip.intersects(laser.boundingBox)) {
                    if(enemyShip.hitAndCheckDestroyed(laser)){
                        enemyShipListIterator.remove();
                        explosionList.add(new Explosion(explosionTexture, new Rectangle(enemyShip.boundingBox), 0.7f));
                        score += 100;
                    }
                    laserListIterator.remove();
                    break;
                }
            }
        }

        // for each enemy laser check if it intersects the player ship
        laserListIterator = enemyLaserList.listIterator();
        while (laserListIterator.hasNext()){
            Laser laser = laserListIterator.next();
            if(playerShip.intersects(laser.boundingBox)) {
                if(playerShip.hitAndCheckDestroyed(laser)){
                    explosionList.add(new Explosion(explosionTexture, new Rectangle(playerShip.boundingBox), 1.6f));
                    playerShip.shield = 10;
                    if(playerShip.lives > 0) playerShip.lives--;
                }
                laserListIterator.remove();
            }
        }

    }


    private void updateAndRenderExplosions(float deltaTime) {
        ListIterator<Explosion> explosionListIterator = explosionList.listIterator();
        while (explosionListIterator.hasNext()){
            Explosion explosion = explosionListIterator.next();
            explosion.update(deltaTime);
            if(explosion.isFinished()){
                explosionListIterator.remove();
            }
            else{
                explosion.draw(batch);
            }
        }

    }


    private void renderLasers(float deltaTime) {

        // creating lasers
        if(playerShip.canFireLaser()) {
            Laser[] lasers = playerShip.fireLasers();
            for(Laser laser : lasers){ playerLaserList.add(laser);}
        }
        ListIterator<EnemyShip> enemyShipListIterator = enemyShipList.listIterator();
        while (enemyShipListIterator.hasNext()){
            EnemyShip enemyShip = enemyShipListIterator.next();
            if(enemyShip.canFireLaser()) {
                Laser[] lasers = enemyShip.fireLasers();
                for(Laser laser : lasers){ enemyLaserList.addAll(Arrays.asList(lasers));}
            }
        }


        // drawing lasers
        // removing old lasers
        ListIterator<Laser> iterator = playerLaserList.listIterator();
        while (iterator.hasNext()){
            Laser laser = iterator.next();
            laser.draw(batch);
            laser.boundingBox.y += laser.movementSpeed * deltaTime;
            if(laser.boundingBox.y > WORLD_HEIGHT) iterator.remove();
        }
        iterator = enemyLaserList.listIterator();
        while (iterator.hasNext()){
            Laser laser = iterator.next();
            laser.draw(batch);
            laser.boundingBox.y -= laser.movementSpeed * deltaTime;
            if(laser.boundingBox.y + laser.boundingBox.height < 0 ) iterator.remove();
        }


    }

    private void renderBackground(float deltaTime) {

        backgroundOffsets[0] += deltaTime * backgroundMaxScrollingSpeed / 8 ;
        backgroundOffsets[1] += deltaTime * backgroundMaxScrollingSpeed / 4 ;
        backgroundOffsets[2] += deltaTime * backgroundMaxScrollingSpeed / 2 ;
        backgroundOffsets[3] += deltaTime * backgroundMaxScrollingSpeed ;
        for(int layer = 0;  layer < backgroundOffsets.length; layer++){
            if(backgroundOffsets[layer] > WORLD_HEIGHT) {
                backgroundOffsets[layer] = 0;
            }
            batch.draw(backgrounds[layer], 0, -backgroundOffsets[layer], WORLD_WIDTH, WORLD_HEIGHT);
            batch.draw(backgrounds[layer], 0, -backgroundOffsets[layer] + WORLD_HEIGHT, WORLD_WIDTH, WORLD_HEIGHT);
        }

    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width,height, true);
        batch.setProjectionMatrix(camera.combined);
    }


    @Override
    public void dispose() {}
    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void hide() {}
    @Override
    public void show() {}

}
