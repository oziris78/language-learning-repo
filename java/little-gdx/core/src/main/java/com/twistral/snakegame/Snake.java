package com.twistral.snakegame;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;

public class Snake {

    private ArrayList<SnakePart> arrTail;
    private SnakePart head;

    public Snake(float tailX1, float tailY1,
                 float tailX2, float tailY2,
                 float headX, float headY,
                 TextureRegion headSkin, TextureRegion tailSkin)
    {
        // creating the tail
        arrTail = new ArrayList<SnakePart>();
        addPartToTheEnd(tailX1, tailY1, tailSkin);
        addPartToTheEnd(tailX2, tailY2, tailSkin);

        // creating the head
        head = createPart(headX, headY, headSkin);

    }

    private void moveHead(float xChange, float yChange){
        this.head.boundingBox.x += xChange;
        this.head.boundingBox.y += yChange;
    }

    private void moveTail(int indexOfTailArrayList, float xChange, float yChange){
        SnakePart selectedTail = this.arrTail.get(indexOfTailArrayList);
        selectedTail.boundingBox.x += xChange;
        selectedTail.boundingBox.y += yChange;
    }

    private SnakePart createPart(float x, float y, TextureRegion tailSkin){
        return new SnakePart(new Rectangle(x,y,SnakePart.PART_SIZE, SnakePart.PART_SIZE), tailSkin);
    }

    public void addPartToTheEnd(float x, float y, TextureRegion tailSkin){
        arrTail.add( createPart(x,y,tailSkin) );
    }

    private void addPartToTheBeginning(float x, float y, TextureRegion tailSkin){
        arrTail.add( 0, createPart(x,y,tailSkin) );
    }


    /* Template class for tail and head */

    public class SnakePart {

        public static final float PART_SIZE = GameScreen.GRID_SIZE;
        private Rectangle boundingBox;
        private TextureRegion skin;

        public SnakePart(Rectangle boundingBox, TextureRegion skin){
            this.boundingBox = boundingBox;
            this.skin = skin;
        }

        public Rectangle getBoundingBox() { return boundingBox; }
        public void setBoundingBox(Rectangle boundingBox) { this.boundingBox = boundingBox; }
        public TextureRegion getSkin() { return skin; }
        public void setSkin(TextureRegion skin) { this.skin = skin; }

    }

    /* GETTER AND SETTERS */
    public ArrayList<SnakePart> getArrTail() { return arrTail; }
    public void setArrTail(ArrayList<SnakePart> arrTail) { this.arrTail = arrTail; }
    public SnakePart getHead() { return head; }
    public void setHead(SnakePart head) { this.head = head; }

}
