package oop;

public abstract class Hayvan {

    private float x,y;
    private String species;
    private boolean isHungry;

    public Hayvan(float x, float y, String species, boolean isHungry){
       this.x = x;
       this.y = y;
       this.species = species;
       this.isHungry = isHungry;
    }

    public abstract void eatFood();

    public float getX() { return x; }
    public void setX(float x) { this.x = x; }
    public float getY() { return y; }
    public void setY(float y) { this.y = y; }
    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }
    public boolean isHungry() { return isHungry; }
    public void setHungry(boolean hungry) { isHungry = hungry; }

}
