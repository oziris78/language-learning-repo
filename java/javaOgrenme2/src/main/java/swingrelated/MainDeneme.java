package swingrelated;

import oop.Hayvan;
import oop.Kedi;
import oop.Maymun;

import java.util.ArrayList;

public class MainDeneme {

    public static void main(String[] args) {

        ArrayList<Hayvan> arrayList = new ArrayList<>();
        arrayList.add(new Maymun(1,1,"a",true,0));
        arrayList.add(new Kedi(1,1,"a",true,0));
        arrayList.add(new Maymun(1,1,"a",true,0));
        arrayList.add(new Kedi(1,1,"a",true,0));
        arrayList.add(new Maymun(1,1,"a",true,0));
        arrayList.add(new Kedi(1,1,"a",true,0));

        for(Hayvan hayvan : arrayList){
            hayvan.eatFood();
        }


    }

}
