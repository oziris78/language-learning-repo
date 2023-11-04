package adt;


public class Deneme112324 {

    public static void main(String[] args) {
        double angle = Math.acos(1);
        System.out.println(angle);

        double angle2 = myCos(1,10);
        System.out.println(angle2);

    }


    static double myCos(double angle, int iterationCount){
        double result = 1;
        double addValue;

        for(int i=2, iter=1; iter <= iterationCount; i+=2, iter++){
            double x = myPow(angle,i);
            double y = myFactorial(i);
            System.out.println("\nx: " + x);
            System.out.println("\ny: " + y);
            addValue = x / y;
            if(iter % 2 != 0) result -= addValue;
            else result += addValue;
        }

        return result;
    }


    static double myFactorial(int x) {
        if(x<0) return -1;
        if(x==0) return 1;
        int result = 1;
        for(int i=1; i<=x; i++) result *= i;
        return result;
    }

    static double myPow(double x, int iterCount){
        double result = 1;
        for(int i=1; i<=iterCount; i++) result *= x;
        return result;
    }



}


