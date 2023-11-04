package swingrelated;

public class Animal{

    static enum EatingHabit {OTOBUR, OTCUL, HEPCIL}

    private String family;
    private int footCount;
    private int eyeCount;
    private EatingHabit eatingHabit;

    public Animal(String family, int footCount, int eyeCount, EatingHabit eatingHabit){
        this.family = family;
        this.footCount = footCount;
        this.eyeCount = eyeCount;
        this.eatingHabit = eatingHabit;
    }

    public void setFamily(String family){this.family = family;}
    public void setFootCount(int footCount){this.footCount = footCount;}
    public void setEyeCount(int eyeCount){this.eyeCount = eyeCount;}
    public void setEatingHabit(EatingHabit eatingHabit){this.eatingHabit = eatingHabit;}
    public String  getFamily(){return this.family;}
    public int getFootCount(){return this.footCount;}
    public int getEyeCount(){return this.eyeCount;}
    public EatingHabit getEatingHabit(){return this.eatingHabit;}


}
