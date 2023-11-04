package oop;

public class Maymun extends Hayvan{

    private int bananaCount;

    public Maymun(float x, float y, String species, boolean isHungry, int bananaCount) {
        super(x, y, species, isHungry);
        this.bananaCount = bananaCount;
    }


    @Override
    public void eatFood() {
        System.out.println("hmmm banana mmmm");
    }

    public int getBananaCount() { return bananaCount; }

    public void setBananaCount(int bananaCount) { this.bananaCount = bananaCount; }

}
