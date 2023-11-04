package adt;

import java.io.*;

public class StringClassesDemo {

    private static final int doProccess = 5;
    private static final int repeatTime = 300_000;
    private static final String strToAdd = "agaaga";

    private static final String fileName = "stringtest"+ (int) Math.ceil(Math.random() * 10000) +".txt";

    public static void main(String[] args) throws IOException {
        for(int i = 0; i < doProccess; i++) insideMain();
        return;
    }

    private static void insideMain() {
        String s = "";
        StringBuffer s1 = new StringBuffer();
        StringBuilder s2 = new StringBuilder();
        long startTime = 0;
        long timeTakenStr = 0;
        long timeTakenBuf = 0;
        long timeTakenBuild = 0;

        startTime = System.nanoTime();
        stringEkle(s);
        timeTakenStr = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        bufferEkle(s1);
        timeTakenBuf = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        builderEkle(s2);
        timeTakenBuild = System.nanoTime() - startTime;


        writeTheResults("\nrepeatTime: " + repeatTime + " length: " + strToAdd.length() + "\n"
                +  "string: " + timeTakenStr * 0.000000001 +  "\n" +   "buffer: " + timeTakenBuf * 0.000000001 + "\n"+
                "builder: " + timeTakenBuild * 0.000000001 + "\n");
    }

    public static void writeTheResults(String add){
        try{
            File file = new File(fileName);
            if(!file.exists()) file.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            String content = "";
            while( (line = br.readLine()) != null){ content += line + "\n"; }

            content += add;

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(content);
            bw.flush();
            br.close();
            bw.close();
        }
        catch (Exception e){}
    }

    /*
    repeatTime: 250000
string: 20.370637000000002
buffer: 0.0071774000000000004
builder: 0.0054161

repeatTime: 250000
string: 3.4420325000000003
buffer: 0.0053727
builder: 0.0042097

     */

    public static void stringEkle(String s){
        for(int i = 0; i < repeatTime; i++)
            s += strToAdd;
    }
    public static void bufferEkle(StringBuffer s){
        for(int i = 0; i < repeatTime; i++)
            s.append(strToAdd);
    }
    public static void builderEkle(StringBuilder s){
        for(int i = 0; i < repeatTime; i++)
            s.append(strToAdd);
    }

}