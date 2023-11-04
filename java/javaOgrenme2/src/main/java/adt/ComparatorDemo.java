package adt;

import java.io.*;

public class ComparatorDemo {

    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();

        for(int i = 0; i < 99999; i++)
            ranThem();

        long timeTaken = System.nanoTime() - startTime;

        try{ writeTheResults(timeTaken); }
        catch (Exception e){ }

    }

    public static void ranMine(){
        tryMine((int) (Math.random() * 1000), (int) (Math.random() * 1000));
    }

    public static void ranThem(){
        tryTheir((int) (Math.random() * 1000), (int) (Math.random() * 1000));
    }

    public static void writeTheResults(long timeTaken) throws IOException {
        File file = new File("stringTest.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        String content = "";
        while( (line = br.readLine()) != null){ content += line + "\n"; }
        content += timeTaken;
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(content);
        bw.flush();
        br.close();
        bw.close();
    }

    // O(n)
    public static int gcd(int a, int b) {
        if (a == 0) return b;
        while (b != 0) {
            if (a > b) a -= b;
            else b -= a;
        }
        return a;
    }

    // O(n)
    public static int myGcd(int a, int b) {
        int x0 = Math.min(a,b);
        int x1 = Math.max(a,b);
        int x3 = (int) (x0 - x1 * Math.floor((double) x0/x1));
        while(true){
            if(x3 == 0) break;
            x0 = x3;
            x3 = (int) (x1 - x0 * Math.floor((double) x1/x0));
        }
        return x0;
    }

    public static void tryMine(int x, int y){
        System.out.println( myGcd(x,y) );
    }

    public static void tryTheir(int x, int y){
        System.out.println( gcd(x,y) );
    }


}