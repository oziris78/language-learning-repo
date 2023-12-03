package com.twistral.spaceshooters.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.TextureRegion;



public abstract class Ship {

    // ship characteristics
    public float movementSpeed;
    public int shield;

    // position and dimension
    public Rectangle boundingBox;

    // graphics
    TextureRegion shipTextureRegion, shieldTextureRegion, laserTextureRegion;

    // laser info
    float laserWidth, laserHeight;
    float timeBetweenShots;
    float laserMovementSpeed;
    float timeSinceLastShot = 0;

    public Ship(float xCentre, float yCentre, float width, float height,
                float movementSpeed, int shield, float laserWidth, float laserHeight, float laserMovementSpeed,
                float timeBetweenShots,
                TextureRegion shipTexture, TextureRegion shieldTexture, TextureRegion laserTextureRegion)
    {
        this.movementSpeed = movementSpeed;
        this.shield = shield;
        this.boundingBox = new Rectangle(xCentre - width/2,yCentre - height/2,width,height);
        this.shipTextureRegion = shipTexture;
        this.shieldTextureRegion = shieldTexture;
        this.laserTextureRegion = laserTextureRegion;
        this.laserWidth = laserWidth;
        this.laserHeight = laserHeight;
        this.laserMovementSpeed = laserMovementSpeed;
        this.timeBetweenShots = timeBetweenShots;

    }

    public void update(float deltaTime){
        timeSinceLastShot += deltaTime;
    }

    public boolean canFireLaser(){
        return (timeSinceLastShot - timeBetweenShots >= 0);
    }

    public abstract Laser[] fireLasers();

    public void draw(Batch batch){
        batch.draw(shipTextureRegion, boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
        if(shield > 0)  batch.draw(shieldTextureRegion, boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
    }

    public boolean intersects(Rectangle r2){
        return boundingBox.overlaps(r2);
    }

    public boolean hitAndCheckDestroyed(Laser laser){
        if(shield > 0) {
            shield--;
            return false;
        }
        return true;
    }


    public void translate(float xChange, float yChange) {
        boundingBox.setPosition( boundingBox.x + xChange, boundingBox.y + yChange);
    }
}
