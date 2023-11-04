package threads;

import java.util.ArrayList;
import java.util.List;

public class MainAga {

    static void threadAcVeBekle(Thread t){
        try{
            t.start();
            t.join();
        }
        catch (Exception e){}
    }

    public static void main(String[] args) {

        long startTime = System.nanoTime();

        List<Character> dzl = new ArrayList<>();

        MyThread thr = new MyThread(dzl, "Selam");
        MyThread thr2 = new MyThread(dzl, "Dunya");
        MyThread thr3 = new MyThread(dzl, "Aga");
        MyThread thr4 = new MyThread(dzl, "XXX");
        threadAcVeBekle(thr);
        threadAcVeBekle(thr2);
        threadAcVeBekle(thr3);
        threadAcVeBekle(thr4);


        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Geçen süre = " + elapsedTime/1000000 + " milisaniye");
    }
}
