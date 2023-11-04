package adt;

public class Test {

    static String repeatedString(int repeatCount, String str){
        String repeated = "";
        for (int i = 0; i < repeatCount; i++) {
            repeated += str;
        }
        return repeated;
    }

    static void rush(int width, int height){
        String sb = "";

        sb += "A" + repeatedString(width-2, "B") + "C" + "\n";
        for (int i = 0; i < height-2; i++)
            sb += 'B' + repeatedString(width-2, " ") + "B" + "\n";
        sb +=  "C" + repeatedString(width-2, "B") + "A" + "\n";

        System.out.println(sb); // yazdırma
        System.out.println(); // boşluk bırakma
    }

    public static void main(String[] args) {
        rush(2,2);
        rush(2,3);
        rush(3,2);
        rush(3,3);
        rush(3,4);
        rush(4,3);
    }

}
