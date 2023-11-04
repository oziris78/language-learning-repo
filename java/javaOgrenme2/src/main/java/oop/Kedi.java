package oop;

public class Kedi extends Hayvan{

    int meowCount;

    public Kedi(float x, float y, String species, boolean isHungry, int meowCount) {
        super(x, y, species, isHungry);
        this.meowCount = meowCount;
    }

    @Override
    public void eatFood() {
        System.out.println("miyavvvvvvvvvv");
    }

    public int getMeowCount() { return meowCount; }

    public void setMeowCount(int meowCount) { this.meowCount = meowCount; }

}
